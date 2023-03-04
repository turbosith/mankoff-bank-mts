package ru.mtsbank.anikin.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.evsmanko.mankoff.entity.Transfer;
import ru.evsmanko.mankoff.service.TransferService;

@Controller
@AllArgsConstructor
@RequestMapping(path = "transfers")
public class TransferController {
    private final TransferService transferService;

    @GetMapping
    public String showTransfers(Model model) {
        var transfers = transferService.findAll();
        model.addAttribute("transfers", transfers);
        return "transfers";
    }

    @GetMapping(path="/bySender")
    public String showBySenderId(@RequestParam(value = "id") Long id, Model model) {
        var transfers = transferService.findBySenderId(id);
        model.addAttribute("transfers", transfers);
        return "transfers";
    }

    @GetMapping("/save")
    public String saveTransfer(Model model) {
        model.addAttribute("transfer", new Transfer());
        return "saveTransfer";
    }

    @PostMapping
    public String saveTransfer(Transfer transfer){
        transferService.save(transfer);
        return "redirect:/transfers";
    }
}
