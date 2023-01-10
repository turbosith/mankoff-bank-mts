package ru.evsmanko.mankoff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.dto.AverageIncomeDTO;
import ru.evsmanko.mankoff.entity.Credit;
import ru.evsmanko.mankoff.entity.Debit;
import ru.evsmanko.mankoff.mapping.AverageIncomeMapper;
import ru.evsmanko.mankoff.properties.AverageIncomeProperties;
import ru.evsmanko.mankoff.repository.CreditRepository;
import ru.evsmanko.mankoff.repository.DebitRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AverageIncomeService {
    private final DebitRepository debitRepository;
    private final CreditRepository creditRepository;
    private final AverageIncomeProperties averageIncomeProperties;

    private double averageIncomeConversion(double averageIncomeInRubles) {
        return switch (averageIncomeProperties.getCurrentCurrency()) {
            case "USD" -> averageIncomeInRubles /= averageIncomeProperties.getUsdToRub();
            case "RUB" -> averageIncomeInRubles;
            case "EUR" -> averageIncomeInRubles /= averageIncomeProperties.getEurToRub();
            default -> averageIncomeInRubles;
        };
    }

    public AverageIncomeDTO averageIncome(long id) {
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
        return new AverageIncomeMapper().toDto(averageIncomeConversion((sumDebits /
                debits.size()) - (sumCredits / credits.size())), averageIncomeProperties.getCurrentCurrency());

    }
}