package ru.evsmanko.mankoff.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.dto.BalanceOfDebtDTO;
import ru.evsmanko.mankoff.entity.Debit;
import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.mapping.BalanceOfDebtMapper;
import ru.evsmanko.mankoff.repository.DebitRepository;
import ru.evsmanko.mankoff.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BalanceOfDebtService {
    private final UserRepository userRepository;
    private final DebitRepository debitRepository;

    public BalanceOfDebtDTO getBalance() {
        double amount = 0;
        List<User> listOfUsers = userRepository.findAll();
        for (User user : listOfUsers) {
            List<Debit> listOFDebits = debitRepository.findAllByUserId(user.getId());
            for (Debit debit : listOFDebits) {
                amount += debit.getAmount();
            }
        }
        return new BalanceOfDebtMapper().toDto(amount);
    }
}
