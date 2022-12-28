package ru.evsmanko.mankoff.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evsmanko.mankoff.service.AverageIncomeService;

@RestController
@RequestMapping("averageIncome")
public class AverageIncomeRestController {
    private AverageIncomeService averageIncomeService;

    @GetMapping
    public double getAverageIncome(long id) {
        return averageIncomeService.averageIncome(id);
    }
}
