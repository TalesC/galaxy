package br.com.meli.galaxy.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;

import br.com.meli.galaxy.service.impl.IWeatherVerifyService;
import org.junit.jupiter.api.Test;

import br.com.meli.galaxy.model.ent.WeatherPrediction;
import br.com.meli.galaxy.model.enums.WeatherStatusEnum;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;
import br.com.meli.galaxy.service.impl.IWeatherPredictionGeneratorService;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class WeatherPredictionGeneratorServiceTest {

	@Autowired
	private WeatherPredictionGeneratorService weatherPredictionService;

	@Test
	void mustPredictWeatherBy10VULCANOYears() {
		predict(10, PlanetNameEnum.VULCANO);
	}
	
	@Test
	void mustPredictWeatherBy10BETASOIDYears() {
		predict(10, PlanetNameEnum.BETASOID);
	}
	
	@Test
	void mustPredictWeatherBy10FERENGEYears() {
		predict(10, PlanetNameEnum.FERENGE);
	}
	
	private void predict(Integer years, PlanetNameEnum planet) {
		var predictions = weatherPredictionService.predict(years, planet);

		assertThat(predictions != null && !predictions.isEmpty()).isTrue();
		assertThat(predictions.size() > 0).isTrue();
		assertThat(getAnyPredition(predictions)).isNotNull();
	}
	
	private WeatherPrediction getAnyPredition(List<WeatherPrediction> predictions) {
		var rain = predictions.stream()
						.filter(prediction -> verifyStatus(prediction))
						.findAny().orElse(null);
		return rain;
	}
	
	private boolean verifyStatus(WeatherPrediction prediction) {
		return prediction.getWeather().equals(WeatherStatusEnum.RAIN) ||
				prediction.getWeather().equals(WeatherStatusEnum.DROUGHT) ||
				prediction.getWeather().equals(WeatherStatusEnum.OPTIMAL);
	}
}
