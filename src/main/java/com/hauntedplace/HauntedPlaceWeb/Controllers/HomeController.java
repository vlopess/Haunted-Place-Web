package com.hauntedplace.HauntedPlaceWeb.Controllers;

import com.hauntedplace.HauntedPlaceWeb.Models.UserDetail;
import com.hauntedplace.HauntedPlaceWeb.Services.HttpService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model, HttpServletRequest request) {

        var httpService = new HttpService();
        var token = request.getSession().getAttribute("TOKEN_USER");
        var userID = request.getSession().getAttribute("USER_ID");

        if(userID == null || token == null) {
            return "redirect:/login";
        }

        var user = httpService.get("http://localhost:8080/user?encryptedId="+userID, UserDetail.class, token.toString());
        if(user == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", user);
        return "home";
    }}
