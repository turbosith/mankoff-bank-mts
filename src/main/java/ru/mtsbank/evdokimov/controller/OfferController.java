package ru.mtsbank.evdokimov.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.evsmanko.mankoff.entity.Credit;
import ru.evsmanko.mankoff.entity.Debit;
import ru.evsmanko.mankoff.entity.OfferEntity;
import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.repository.*;

import java.util.List;

/**
 * Контроллер, показывающий задолеженность клиента перед банком
 */
@Controller
@AllArgsConstructor
@RequestMapping("/evdokimov")
public class OfferController {
    private final  CreditRepository creditRepository;
    private final DebitRepository debitRepository;
    private final UserRepository userRepository;
    private final OfferJDBCRepository offerRepository;

    @GetMapping("/credit/{id}")
    public String getCredit(@PathVariable(value = "id") long id, Model model) {
        List<Credit> credits = creditRepository.findAllByUserId(id);
        List<Debit> debits = debitRepository.findAllByUserId(id);
        User user = userRepository.getUserById(id);
        double sumCredits = 0;
        double sumDebits = 0;
        for (Credit credit : credits) {
            sumCredits += credit.getAmount();
        }
        for (Debit debit : debits) {
            sumDebits += debit.getAmount();
        }
        model.addAttribute("title", "Задолженности");
        model.addAttribute("name", user.getFirstName()+" "+user.getLastName());
        float creditSum = (float) ((Math.random() * ((100000 - 10000) + 1)) + 10000);
        model.addAttribute("sumCredits", sumCredits);
        model.addAttribute("sumDebits", sumDebits);
        model.addAttribute("currentId", user.getId());
        model.addAttribute("sumArrears", sumCredits-sumDebits);
        model.addAttribute("number", "+7(916)502-54-63");
        model.addAttribute("email", "mts@mts.ru");

        return "credit";
    }

    @GetMapping("/credit/err")
    public String getError() {
        return "err";
    }

    @GetMapping("/offer/{id}")
    public String getOffer(@PathVariable(value = "id") long id, Model model) {
        List<OfferEntity> offers = offerRepository.findAllByUserId(id);
        User user = userRepository.getUserById(id);
        model.addAttribute("offers", offers);
        model.addAttribute("name", user.getFirstName()+" "+user.getLastName());
        model.addAttribute("number", "+7(916)502-54-63");
        model.addAttribute("email", "mts@mts.ru");
        return "offer";
    }
    @GetMapping("/offer/add")
    public String newOffer(Model model){
        model.addAttribute("offer" , new OfferEntity());
        return "offeradd";
    }
    @GetMapping("offer/success")
    public String success(Model model){
        return "success";
    }

    @PostMapping
    public String createNewOffer(@ModelAttribute("offer") OfferEntity offer){
        offerRepository.save(offer);
        return "redirect:/evdokimov/offer/success";
    }
}
