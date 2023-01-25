package ru.evsmanko.mankoff.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserDebtDto {
    private double debt;
    private String currency;
}
