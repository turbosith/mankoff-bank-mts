package ru.evsmanko.mankoff.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class BalanceOfDebtDTO {
    private double amount;
}
