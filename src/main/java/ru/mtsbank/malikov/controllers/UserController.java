package ru.mtsbank.malikov.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.evsmanko.mankoff.repository.DebitRepository;
import ru.evsmanko.mankoff.repository.UserRepository;
import ru.evsmanko.mankoff.service.UserDebtService;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserDebtService userDebtService;

    @GetMapping("/user/{id}")
    public String showUserInfo(Model model, @PathVariable("id") Long id) {
        model.addAttribute("id", "ID: " + id);
        model.addAttribute("debt", "Debt: " + userDebtService.userDebt(id).getDebt() + userDebtService.userDebt(id).getCurrency());
        model.addAttribute("firstName", "Name: " + userRepository.getUserById(id).getFirstName());
        model.addAttribute("lastName", "Surname: " + userRepository.getUserById(id).getLastName());
        return "UserInfo";
    }
}
