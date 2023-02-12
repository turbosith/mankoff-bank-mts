package ru.mtsbank.evdokimov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Контроллер, показывающий задолеженность клиента перед банком
 */
@Controller
public class AccountController {
    @GetMapping("/credit")
    public String getCredit(){
        return "credit";
    }

}
