package ru.evsmanko.mankoff.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.evsmanko.mankoff.dto.AverageIncomeDTO;
import ru.evsmanko.mankoff.service.AverageIncomeService;

@RestController
@AllArgsConstructor
@RequestMapping(value="/averageIncome",produces="application/json")
public class AverageIncomeRestController {
    @Autowired
    private final AverageIncomeService averageIncomeService;


    @GetMapping("/{id}")
    public AverageIncomeDTO getAverageIncome(@PathVariable("id") long id) {
        return averageIncomeService.averageIncome(id);

    }
}
