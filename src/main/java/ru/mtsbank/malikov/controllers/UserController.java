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
public class UserController {
    private final UserInfoRepository userInfoRepository;

    @GetMapping("/user/{id}")
    public String showUserInfo(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userInfoRepository.findById(id).get());
        return "UserInfo";
    }

    @GetMapping("/users")
    public String showAllUsers(Model model){
        model.addAttribute("users" , userInfoRepository.findAll());
        return "Users";
    }

    @GetMapping("/user/create")
    public String showNewUserForm(Model model){
        model.addAttribute("user" , new UserInfoEntity());
        return "NewUserForm";
    }

    @PostMapping
    public String createNewUser(@ModelAttribute("user") UserInfoEntity user){
        userInfoRepository.save(user);
        return "redirect:/malikov/users";
    }
}
