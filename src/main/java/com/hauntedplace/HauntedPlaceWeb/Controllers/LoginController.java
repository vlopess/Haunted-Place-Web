package com.hauntedplace.HauntedPlaceWeb.Controllers;

import com.hauntedplace.HauntedPlaceWeb.DTOS.LoginDTO;
import com.hauntedplace.HauntedPlaceWeb.DTOS.TokenJWTData;
import com.hauntedplace.HauntedPlaceWeb.DTOS.UserDTO;
import com.hauntedplace.HauntedPlaceWeb.Models.AuthData;
import com.hauntedplace.HauntedPlaceWeb.Models.Enums.TagEnum;
import com.hauntedplace.HauntedPlaceWeb.Models.StringWrapper;
import com.hauntedplace.HauntedPlaceWeb.Models.Tag;
import com.hauntedplace.HauntedPlaceWeb.Models.UserDetail;
import com.hauntedplace.HauntedPlaceWeb.Services.HttpService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String makeLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String makeLogin(Model model, @RequestParam("login") String login, @RequestParam("password") String password, HttpServletRequest request){
        String message = "";
        var logIn = new LoginDTO().builder().setEmail(login).setPassword(password).build();
        var authData = new AuthData(logIn);

        var httpService = new HttpService();

        var result = httpService.post("http://localhost:8080/login", authData, TokenJWTData.class, null);
        if(result == null) {
            message = "Login Failed: email/username or password incorrect";
            model.addAttribute("message", message);
            return "login";
        }
        request.getSession().setAttribute("TOKEN_USER", result.token());
        request.getSession().setAttribute("USER_ID", new String(new Base64().encode(result.userID().toString().getBytes())));
        return "redirect:/home";
    }

    @GetMapping(value = "/register")
    public String register(Model model) {
        model.addAttribute("newUser", new UserDTO());

        var httpService = new HttpService();

        var response = Arrays.stream(httpService.get("http://localhost:8080/tags", Tag[].class, null)).toList();
        if(!response.isEmpty()) {
            List<Tag> tags = List.of(response.toArray(new Tag[0]));
            model.addAttribute("tags", tags);
        }
        return "register";
    }

    @PostMapping("/register")
    public String addUser(Model model, @Valid UserDTO user, @RequestParam(name = "tags") List<TagEnum> selectedTags, HttpServletRequest request) {
        String message = "";
        try{
            user.setTags(selectedTags);
            var httpService = new HttpService();
            if(user.getProfilePicture() != null){
                var filePath = httpService.postFile("http://localhost:8080/user/files/upload", user.getProfilePicture(), StringWrapper.class, null);
                if(filePath != null) {
                    user.setProfilePictureUrl(filePath.getValue());
                    user.setProfilePicture(null);
                }
            }
            var result = httpService.post("http://localhost:8080/user/register", user, StringWrapper.class, null);
            if(result == null) throw new Exception("Error while adding user");
            return makeLogin(model, user.getEmail(), user.getPassword(), request);
        }catch (Exception e){
            message = "Username has already been used";
            model.addAttribute("message", message);
            return register(model);
        }
    }

    private File convertToFile(MultipartFile multipartFile, String fileName) throws IOException {
        File tempFile = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(multipartFile.getBytes());
        }
        return tempFile;
    }
}
