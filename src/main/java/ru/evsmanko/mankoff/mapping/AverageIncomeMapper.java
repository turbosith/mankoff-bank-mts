package ru.evsmanko.mankoff.mapping;

import org.springframework.stereotype.Component;
import ru.evsmanko.mankoff.dto.AverageIncomeDTO;


@Component
public class AverageIncomeMapper {
    public AverageIncomeDTO toDto(double averageIncome, String curency) {

        return new AverageIncomeDTO().setAverageIncome(averageIncome).setCurrency(curency);
    }
}