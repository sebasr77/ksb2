package com.example.httpclient.controllers;

import com.example.httpclient.domain.currency.BankData;
import com.example.httpclient.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class GameController {

    private CurrencyService currencyService;

    @Autowired
    public GameController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/game")
    public String displayGame(Model model) {
        RestTemplate  restTemplate = new RestTemplate();
        BankData bankData = restTemplate.getForObject("https://api.exchangeratesapi.io/latest?base=PLN", BankData.class);
        currencyService.setupGame(bankData);

        model.addAttribute("message", currencyService.getMessage());
        return "game";
    }

    @GetMapping("/play")
    public String play(Model model) {
        model.addAttribute("message", currencyService.getMessage());
        model.addAttribute("attempt", currencyService.getAttempts());
        model.addAttribute("status", currencyService.getStatus());
        return "game";
    }

    @PostMapping("/game")
    public String submitGuess(String input) {
        currencyService.checkInput(input);
        return "redirect:/play";
    }
}
