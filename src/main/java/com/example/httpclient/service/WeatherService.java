package com.example.httpclient.service;

import com.example.httpclient.domain.weather.Weather;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherService {

    private Weather weather;

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Optional<String> getIconLink() {
        try {
            return Optional.of(weather.getCurrent().getCondition().getIcon().substring(29));
        } catch (NullPointerException e) {
            return Optional.empty();
        }
    }
}
