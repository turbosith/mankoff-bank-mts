package ru.evsmanko.mankoff.mapping;

import ru.evsmanko.mankoff.dto.BalanceOfDebtDTO;

public class BalanceOfDebtMapper {
    public BalanceOfDebtDTO toDto(double amount){
        return new BalanceOfDebtDTO().setAmount(amount);
    }
}
