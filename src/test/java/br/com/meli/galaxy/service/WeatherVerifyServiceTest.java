package br.com.meli.galaxy.service;

import br.com.meli.galaxy.model.SimpleSolarSystem;
import br.com.meli.galaxy.model.builder.SimpleSolarSystemBuilder;
import br.com.meli.galaxy.model.enums.WeatherStatusEnum;
import br.com.meli.galaxy.service.impl.IWeatherVerifyService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherVerifyServiceTest {

    private WeatherVerifyService service = new IWeatherVerifyService();

    @Test
    void mustVerifyWeather(){
        var weather = service.verifyWeather(1, createSolarSystem());

        assertThat(weather instanceof WeatherStatusEnum);
        assertThat(Arrays.stream(WeatherStatusEnum.values()).anyMatch(w -> w == weather));
    }

    private SimpleSolarSystem createSolarSystem() {
        return new SimpleSolarSystemBuilder()
                .planets()
                .sun()
                .build();
    }
}
