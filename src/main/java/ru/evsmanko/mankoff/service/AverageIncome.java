package ru.evsmanko.mankoff.service;


import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.entity.Credit;
import ru.evsmanko.mankoff.entity.Debit;
import ru.evsmanko.mankoff.repository.CreditRepository;
import ru.evsmanko.mankoff.repository.DebitRepository;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class AverageIncome {
    @Autowired
    private DebitRepository debitRepository;
    private CreditRepository creditRepository;

    public void getAverageIncome(long id) throws IOException {
        List<Debit> debits = debitRepository.findAllByUserId(id);
        List<Credit> credits = creditRepository.findAllByUserId(id);
        double sumDebits = 0;
        double sumCredits = 0;
        for (Debit debit : debits) {
            sumDebits += debit.getAmount();
        }
        for (Credit credit : credits) {
            sumCredits += credit.getAmount();
        }
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/jsons/averageincome.json"));


        JsonObject averageIncome = new JsonObject();
        averageIncome.put("averageIncome", (sumDebits / debits.size()) - (sumCredits / credits.size()));
        Jsoner.serialize(averageIncome, writer);
        writer.close();

    }

}
