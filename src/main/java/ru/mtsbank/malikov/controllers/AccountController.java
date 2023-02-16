package ru.mtsbank.malikov.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.evsmanko.mankoff.entity.UserInfoEntity;
import ru.evsmanko.mankoff.repository.UserInfoRepository;

@Controller
@AllArgsConstructor
@RequestMapping("/malikov")
public class AccountController {
    private final UserInfoRepository userInfoRepository;

    @GetMapping("/user/{id}")
    public String showUserInfo(Model model, @PathVariable("id") Long id) {
        model.addAttribute("id", "ID: " + id);
        model.addAttribute("firstName", "Name: " + userInfoRepository.getUserById(id).getFirstName());
        model.addAttribute("lastName", "Surname: " + userInfoRepository.getUserById(id).getLastName());
        model.addAttribute("age", "Age: " + userInfoRepository.getUserById(id).getAge());
        model.addAttribute("city", "City: " + userInfoRepository.getUserById(id).getCity());
        return "UserInfo";
    }

    @GetMapping("/users")
    public String showAllUsers(Model model){
        model.addAttribute("users" , userInfoRepository.findAll());
        return "Users";
    }

    @GetMapping("/user/create")
    public String ShowNewUserForm(Model model){
        model.addAttribute("user" , new UserInfoEntity());
        return "NewUserForm";
    }

    @PostMapping
    public String createNewUser(@ModelAttribute("user") UserInfoEntity user){
        userInfoRepository.save(user);
        return "redirect:/malikov/users";
    }
}
