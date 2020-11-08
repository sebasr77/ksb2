package com.example.httpclient.controllers;

import com.example.httpclient.domain.weather.Weather;
import com.example.httpclient.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class WeatherController {

    @Value("${baseUrl}")
    private String baseUrl;
    @Value("${key}")
    private String key;
    @Value("${keyValue}")
    private String keyValue;
    @Value("${q}")
    private String q;
    @Value("${langParam}")
    private String lang;
    @Value("${langValue}")
    private String langValue;

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public String displayWeather(Model model) {
        Weather weather = weatherService.getWeather();
        model.addAttribute("weather", weather);

        String iconUrl = weatherService.getIconLink().orElse("");
        model.addAttribute("url", iconUrl);

        return "weather";
    }

    @PostMapping("/weather")
    public String readLocation(String city) {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam(key, keyValue)
                .queryParam(q, city)
                .queryParam(lang, langValue);

        Weather weather = restTemplate.getForObject(url.toUriString(), Weather.class);
        weatherService.setWeather(weather);

        return "redirect:/weather";
    }
}
