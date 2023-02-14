package ru.mtsbank.anikin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankInfoController {
    @GetMapping("/info")
    public String showInfo(){
        return "info";
    }
}
