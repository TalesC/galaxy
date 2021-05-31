package br.com.meli.galaxy.service.impl;

import br.com.meli.galaxy.model.SimpleSolarSystem;
import br.com.meli.galaxy.model.enums.WeatherStatusEnum;
import br.com.meli.galaxy.service.WeatherVerifyService;
import br.com.meli.galaxy.utils.MatrixUtils;
import br.com.meli.galaxy.utils.TriangleUtils;
import org.springframework.stereotype.Service;

@Service
public class IWeatherVerifyService implements WeatherVerifyService {


    @Override
    public  WeatherStatusEnum verifyWeather(int day, SimpleSolarSystem solarSystem) {
        var clima = WeatherStatusEnum.NONE;

        if(planetsMakesTriangleWithSunInside(day, solarSystem)) clima = WeatherStatusEnum.RAIN;
        else
        if(planetsAlignWithSun(day, solarSystem)) clima = WeatherStatusEnum.DROUGHT;
        else
        if(planetsAlignWithoutSun(day, solarSystem)) clima = WeatherStatusEnum.OPTIMAL;

        return clima;
    }

    private boolean planetsAlignWithSun(int day, SimpleSolarSystem solarSystem) {
        var locations = solarSystem.getAllLocations(day);
        var iscolinear = MatrixUtils.isCollinear(locations);

        return iscolinear;
    }

    private boolean planetsMakesTriangleWithSunInside(int day, SimpleSolarSystem solarSystem) {
        var vertices = solarSystem.getLocationOfPlanets(day);
        var point = solarSystem.getSun().getLocation();
        var isInsideOfTriangle = TriangleUtils.contains(vertices, point);

        return isInsideOfTriangle;
    }

    private boolean planetsAlignWithoutSun(int day, SimpleSolarSystem solarSystem) {
        var locations = solarSystem.getLocationOfPlanets(day);
        var iscolinear = MatrixUtils.isCollinear(locations);

        return iscolinear;
    }
}
