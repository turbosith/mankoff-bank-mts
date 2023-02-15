package ru.mtsbank.anikin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class BankInfoController {
    @GetMapping("/info")
    public String showInfo(Model model) {
        int amountOfClients = ThreadLocalRandom.current().nextInt(0, 150000);
        model.addAttribute("amountOfClients", amountOfClients);
        return "info";
    }
}
