package ru.evsmanko.mankoff.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evsmanko.mankoff.dto.BalanceOfDebtDTO;
import ru.evsmanko.mankoff.mapping.BalanceOfDebtMapper;
import ru.evsmanko.mankoff.service.BalanceOfDebtService;

@RestController()
@AllArgsConstructor
public class BalanceOfDebtController {

    private final BalanceOfDebtService balanceOfDebtService;

    private final BalanceOfDebtMapper balanceOfDebtMapper;

    @GetMapping("getBalanceOfDebt")
    public BalanceOfDebtDTO getBalanceOfDebt() {
        return balanceOfDebtMapper.toDto((balanceOfDebtService.getBalance()));
    }
}
