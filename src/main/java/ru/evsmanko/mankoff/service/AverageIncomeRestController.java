package ru.evsmanko.mankoff.service;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.evsmanko.mankoff.entity.Credit;
import ru.evsmanko.mankoff.entity.Debit;
import ru.evsmanko.mankoff.repository.CreditRepository;
import ru.evsmanko.mankoff.repository.DebitRepository;

import java.util.List;

@RestController

public class AverageIncomeRestController {


    private DebitRepository debitRepository;
    private CreditRepository creditRepository;
    double averageIncome;

    @RequestMapping(value = "/average-income-rest", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void getAverageIncome(long id) {
        List<Debit> debits = debitRepository.findAllByUserId(id);
        List<Credit> credits = creditRepository.findAllByUserId(id);
        double sumDebits = 0;
        double sumCredits = 0;
        for (Debit debit : debits) {
            sumDebits += debit.getAmount();
        }
        for (Credit credit : credits) {
            sumCredits += credit.getAmount();
        }
        averageIncome = (sumDebits / debits.size()) - (sumCredits / credits.size());

    }
}