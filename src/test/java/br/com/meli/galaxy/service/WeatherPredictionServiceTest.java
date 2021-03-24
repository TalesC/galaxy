package br.com.meli.galaxy.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.meli.galaxy.model.enums.WeatherStatusEnum;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;

@SpringBootTest
public class WeatherPredictionServiceTest {

	@Autowired
	private WeatherPredictionService service;
	
	@Test
	void mustFindPredictionByDayOfPlanet() {
		var prediction = service.findClimaByDay(1, PlanetNameEnum.VULCANO);
		
		assertThat(prediction).isNotNull();
		assertThat(prediction.getDay()).isEqualTo(1);
		assertThat(prediction.getClima()).isEqualTo(WeatherStatusEnum.NONE);
	}
	
	@Test
	void mustReturnNullIfNotFindPrediction() {
		var prediction = service.findClimaByDay(100000, PlanetNameEnum.VULCANO);
		
		assertThat(prediction).isNull();
	}
	
}
