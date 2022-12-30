package ru.evsmanko.mankoff.mapping;

import org.springframework.stereotype.Component;
import ru.evsmanko.mankoff.dto.BalanceOfDebtDTO;

@Component
public class BalanceOfDebtMapper {
    public BalanceOfDebtDTO toDto(double amount) {
        return new BalanceOfDebtDTO().setAmount(amount);
    }
}
