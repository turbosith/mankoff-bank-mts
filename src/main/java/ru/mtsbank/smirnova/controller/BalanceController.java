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
@AllArgsConstructor
public class BalanceController {
    private final CreditRepository creditRepository;
    private final DebitRepository debitRepository;
    private final UserRepository userRepository;

    @GetMapping("/balans/{userId}")
    public String getBalance(Model model, @PathVariable("userId") Long userId){

        List<Debit> debits = debitRepository.findAllByUserId(userId);
        List<Credit> credits = creditRepository.findAllByUserId(userId);
        double sumDebit=0;
        double sumCredit=0;
        for(int i=0; i < debits.size(); i++) {
            sumDebit+=debits.get(i).getAmount();
        }
        for(int i=0; i < credits.size(); i++) {
            sumCredit+=credits.get(i).getAmount();
        }
        double ans = sumDebit - sumCredit;
        model.addAttribute("userId", userId);
        model.addAttribute("userName", userRepository.getUserById(userId).getFirstName());
        model.addAttribute("currentBalance", ans);
        return "balans";
    }
}
