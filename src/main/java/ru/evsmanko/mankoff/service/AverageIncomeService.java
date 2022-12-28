package ru.evsmanko.mankoff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.entity.Credit;
import ru.evsmanko.mankoff.entity.Debit;
import ru.evsmanko.mankoff.repository.CreditRepository;
import ru.evsmanko.mankoff.repository.DebitRepository;

import java.util.List;

@Service
public class AverageIncomeService {
    @Autowired
    private DebitRepository debitRepository;
    private CreditRepository creditRepository;
    double averageIncome;

    public double averageIncome(long id) {
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
        return averageIncome;

    }
}
