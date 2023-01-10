package ru.evsmanko.mankoff.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.evsmanko.mankoff.entity.Credit;
import ru.evsmanko.mankoff.entity.Debit;
import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.properties.AverageIncomeProperties;
import ru.evsmanko.mankoff.repository.CreditRepository;
import ru.evsmanko.mankoff.repository.DebitRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AverageIncomeServiceTest {

    @Mock
    private DebitRepository debitRepository;
    @Mock
    private CreditRepository creditRepository;
    @Mock
    private AverageIncomeProperties averageIncomeProperties;

    @InjectMocks
    private AverageIncomeService service;


    @Test
    void testAverageIncome() {

        new User().setId(1);
        when(debitRepository.findAllByUserId(eq(1L))).thenReturn(Arrays.asList(
                new Debit().setAmount(1).setId(1), new Debit().setAmount(3).setId(1)));
        when(creditRepository.findAllByUserId(eq(1L))).thenReturn(Arrays.asList(
                new Credit().setAmount(1).setId(1), new Credit().setAmount(1).setId(1)));

        when(averageIncomeProperties.getCurrentCurrency()).thenReturn("USD");
        when(averageIncomeProperties.getUsdToRub()).thenReturn(70.0);
        double average = service.averageIncome(1).getAverageIncome();
        assertEquals(0.014285714285714285, average);
    }
}