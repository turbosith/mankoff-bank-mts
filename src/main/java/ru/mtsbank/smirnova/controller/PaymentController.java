package ru.mtsbank.smirnova.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.evsmanko.mankoff.entity.PaymentEntity;
import ru.evsmanko.mankoff.repository.PaymentJDBCRepository;
import ru.evsmanko.mankoff.repository.PaymentRepository;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/smirnova")
public class PaymentController {
    private final PaymentJDBCRepository paymentRepository;

    @GetMapping("/payment/all")
    public String allPayments(Model model){
        List<PaymentEntity> allPayments = paymentRepository.allPayments();
        model.addAttribute("allPayments", allPayments);
        return "all_payments";
    }

    @GetMapping("/payment/{userId}")
    public String userPayments(Model model, @PathVariable(value="userId") Long userId){
        List<PaymentEntity> userPayments = paymentRepository.userPayments(userId);
        model.addAttribute("userPayments", userPayments);
        return "payments";
    }

    @GetMapping("/payment/save")
    public String savePayment(Model model){
        model.addAttribute("payment", new PaymentEntity());
        return "savePayment";
    }

    @PostMapping
    public String createNewPayment(@ModelAttribute("payment") PaymentEntity payment){
        paymentRepository.savePayment(payment);
        return "redirect:/smirnova/payments";
    }
}
