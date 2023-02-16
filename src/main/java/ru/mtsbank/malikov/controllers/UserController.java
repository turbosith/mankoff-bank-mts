package ru.mtsbank.malikov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user")
    public String showUserInfo() {
        return "UserInfo";
    }
}
