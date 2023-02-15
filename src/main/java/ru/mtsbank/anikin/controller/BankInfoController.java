package ru.mtsbank.anikin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class BankInfoController {
    @GetMapping("/info")
    public String showInfo(Model model) {
        Integer amountOfClients = new Random().nextInt();
        model.addAttribute("amountOfClients", amountOfClients.toString());
        return "info";
    }
}
