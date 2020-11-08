package com.example.httpclient.controllers;

import com.example.httpclient.domain.joke.Response;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class JokeController {


    @GetMapping("/")
    public String displayIndex(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Response response = restTemplate.getForObject("http://api.icndb.com/jokes/random/10", Response.class);

        model.addAttribute("response", response);
        return "index";
    }
}
