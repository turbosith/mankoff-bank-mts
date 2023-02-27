package ru.mtsbank.smirnova.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.evsmanko.mankoff.entity.Credit;
import ru.evsmanko.mankoff.entity.Debit;
import ru.evsmanko.mankoff.repository.CreditRepository;
import ru.evsmanko.mankoff.repository.DebitRepository;
import ru.evsmanko.mankoff.repository.UserRepository;

import java.util.List;

@Controller
public class BalanceController {
    @GetMapping("/balans")
    public String getBalance(){
        return "balans";
    }
}
