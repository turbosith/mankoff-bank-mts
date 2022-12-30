package ru.evsmanko.mankoff.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.entity.Credit;
import ru.evsmanko.mankoff.entity.Debit;
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

    public double userDebt(long userId){
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
        return ans;
    }

    public JsonElement jsonUserDebt(long userId) {
        double debt = userDebt(userId);
        JsonObject result = new JsonObject();
        result.add("User ID", new JsonPrimitive(userId));
        result.add("User Debt", new JsonPrimitive(debt));
        return result;
    }

}
