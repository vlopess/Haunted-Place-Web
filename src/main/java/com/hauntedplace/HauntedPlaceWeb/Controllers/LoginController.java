package com.hauntedplace.HauntedPlaceWeb.Controllers;

import com.hauntedplace.HauntedPlaceWeb.DTOS.LoginDTO;
import com.hauntedplace.HauntedPlaceWeb.DTOS.TokenJWTData;
import com.hauntedplace.HauntedPlaceWeb.Models.AuthData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String makeLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String makeLogin(Model model, @RequestParam("login") String login, @RequestParam("password") String password) {
        String message = "";
        var logIn = new LoginDTO().builder().setEmail(login).setPassword(password).build();
        var authData = new AuthData(logIn);
        RestTemplate restTemplate = new RestTemplate();
        var result = restTemplate.postForObject("http://localhost:8080/login", authData, TokenJWTData.class);
        if(result == null) {
            message = "Login Failed: email/username or password incorrect";
            model.addAttribute("message", message);
            return "login";
        }
        return "redirect:/home";
    }
    @GetMapping("/home")
    public String home() {
        return "home";
    }
    @GetMapping("/register")
    public String register() {
        return "register";
    }
}
