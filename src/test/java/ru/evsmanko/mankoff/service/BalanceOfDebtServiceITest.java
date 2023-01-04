package ru.evsmanko.mankoff.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ru.evsmanko.mankoff.entity.Debit;
import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.properties.BalanceOfDebtProperties;
import ru.evsmanko.mankoff.repository.DebitRepository;
import ru.evsmanko.mankoff.repository.UserRepository;

@SpringBootTest
public class BalanceOfDebtServiceITest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DebitRepository debitRepository;

    @Autowired
    private BalanceOfDebtService service;

    @Autowired
    BalanceOfDebtProperties properties;
    @Test
    void testGetBalance() {
        double expBalance = calculateCurrentBalance();
        switch (properties.getCurrentCurrency()) {
            case "EUR":
                expBalance /= properties.getEurToRub();
            case "RUB":
                expBalance /= properties.getRubToRub();
            case "USD":
                expBalance /= properties.getUsdToRub();
        }
        double balance = service.getBalance().getAmount();
        assertEquals(expBalance, balance);
    }

    /*
     * Это очень оптимистичная реализация в надежде, что все данные есть.
     * Только для примера.
     */
    private double calculateCurrentBalance() {
        return userRepository.findAll().stream()
                .map(User::getId)
                .collect(Collectors.summarizingDouble(
                        id -> debitRepository.findAllByUserId(id).stream()
                                .collect(Collectors.summarizingDouble(Debit::getAmount))
                                .getSum()))
                                .getSum();

    }
}
