package ru.evsmanko.mankoff.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.evsmanko.mankoff.dto.UserDebtDto;
import ru.evsmanko.mankoff.service.UserDebtService;

@RestController
@AllArgsConstructor
public class UserDebtController {

    private final UserDebtService userDebtService;

    @GetMapping("UserDebt/{id}")
    public UserDebtDto getUserDebt(@PathVariable("id") long id) {
        return userDebtService.userDebt(id);
    }

}
