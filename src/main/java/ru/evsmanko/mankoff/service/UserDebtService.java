package ru.evsmanko.mankoff.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.dto.UserDebtDto;
import ru.evsmanko.mankoff.entity.Credit;
import ru.evsmanko.mankoff.entity.Debit;
import ru.evsmanko.mankoff.mapping.UserDebtMapper;
import ru.evsmanko.mankoff.properties.UserDebtProperties;
import ru.evsmanko.mankoff.repository.CreditRepository;
import ru.evsmanko.mankoff.repository.DebitRepository;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;


import java.util.List;

@Service
@AllArgsConstructor
public class UserDebtService {
    private final DebitRepository debitRepository;
    private final CreditRepository creditRepository;
    private final UserDebtProperties properties;

    public UserDebtDto userDebt(long userId){
        List<Debit> debits = debitRepository.findAllByUserId(userId);
        List<Credit> credits = creditRepository.findAllByUserId(userId);
        double sumDebit=0;
        double sumCredit=0;
        for(int i=0; i < debits.size(); i++) {
            sumDebit+=debits.get(i).getAmount();
        }
        for(int i=0; i < credits.size(); i++) {
            sumCredit+=credits.get(i).getAmount();
        }
        double ans=0;
        if (sumCredit < sumDebit)
            ans = sumDebit - sumCredit;

        String currency = properties.getCurrentCurrency();
        switch (currency) {
            case "EUR":
                ans /= properties.getEurToRub();
                break;
            case "RUB":
                ans /= properties.getRubToRub();
                break;
            case "USD":
                ans /= properties.getUsdToRub();
                break;
        }

        return new UserDebtMapper().mapUserDebtDto(ans, currency);
    }

    public JsonElement jsonUserDebt(long userId) {
        UserDebtDto debt = userDebt(userId);
        JsonObject result = new JsonObject();
        result.add("User ID", new JsonPrimitive(userId));
        result.add("User Debt", new JsonPrimitive(debt.getDebt()));
        return result;
    }

}
