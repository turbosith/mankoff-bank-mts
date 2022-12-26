package ru.evsmanko.mankoff.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evsmanko.mankoff.service.BalanceOfDebtService;

@RestController()
@AllArgsConstructor
public class BalanceOfDebtController {

    private final BalanceOfDebtService balanceOfDebtService;

    @GetMapping("getBalanceOfDebt")
    public double getBalanceOfDebt() {
        return balanceOfDebtService.getBalance();
    }
}
