package ru.evsmanko.mankoff.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.evsmanko.mankoff.dto.UserDebtDto;
import ru.evsmanko.mankoff.entity.Credit;
import ru.evsmanko.mankoff.entity.Debit;
import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.repository.CreditRepository;
import ru.evsmanko.mankoff.repository.DebitRepository;
import ru.evsmanko.mankoff.repository.UserRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserDebtServiceTest {
    @Mock
    private UserRepository repository;
    @Mock
    private DebitRepository debitRepository;
    @Mock
    private CreditRepository creditRepository;
    @InjectMocks
    private UserDebtService service;

    @Test
    void userDebt(){
        User user = new User();
        user.setId(1);
        when(debitRepository.findAllByUserId(eq(1L))).thenReturn(Arrays.asList(
                new Debit().setAmount(3), new Debit().setAmount(2)));
        when(creditRepository.findAllByUserId(eq(1L))).thenReturn(Arrays.asList(
                new Credit().setAmount(1), new Credit().setAmount(2)));
        UserDebtDto debt = service.userDebt(1);
        assertEquals(2, debt.getDebt());
    }
}
