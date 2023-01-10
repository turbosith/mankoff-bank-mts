package ru.evsmanko.mankoff.dto;

import lombok.Data;
import lombok.experimental.Accessors;


@Accessors(chain = true)
@Data
public class AverageIncomeDTO {
    private double averageIncome;
    private String currency;
}