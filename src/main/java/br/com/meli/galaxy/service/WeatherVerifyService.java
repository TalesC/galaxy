package br.com.meli.galaxy.service;

import br.com.meli.galaxy.model.SimpleSolarSystem;
import br.com.meli.galaxy.model.enums.WeatherStatusEnum;

public interface WeatherVerifyService {

    public WeatherStatusEnum verifyWeather(int day, SimpleSolarSystem solarSystem);
}
