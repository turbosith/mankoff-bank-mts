package ru.evsmanko.mankoff.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ru.evsmanko.mankoff.entity.Debit;
import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.repository.DebitRepository;
import ru.evsmanko.mankoff.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class BalanceOfDebtServiceTest {

	@Mock
	private UserRepository userRepository;
    
	@Mock
	private DebitRepository debitRepository;
	
	@InjectMocks
	private BalanceOfDebtService service;
	
	@Test
	void testGetBalance() {
		when(userRepository.findAll()).thenReturn(Arrays.asList(
				new User().setId(1), new User().setId(2)));
		when(debitRepository.findAllByUserId(eq(1L))).thenReturn(Arrays.asList(
				new Debit().setAmount(1), new Debit().setAmount(2)));
		when(debitRepository.findAllByUserId(eq(2L))).thenReturn(Arrays.asList(
				new Debit().setAmount(3), new Debit().setAmount(4)));
		
		double balance = service.getBalance().getAmount();
		
		assertEquals(10, balance);
	}
}
