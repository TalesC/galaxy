package br.com.meli.galaxy.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.meli.galaxy.model.ent.WeatherPrediction;
import br.com.meli.galaxy.model.enums.WeatherStatusEnum;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;
import br.com.meli.galaxy.service.impl.IWeatherPredictionGeneratorService;

public class WeatherPredictionGeneratorServiceTest {

	private WeatherPredictionGeneratorService service = new IWeatherPredictionGeneratorService();
	
	@Test
	void mustPredictClimaBy10VULCANOYears() {
		predict(10, PlanetNameEnum.VULCANO);
	}
	
	@Test
	void mustPredictClimaBy10BETASOIDYears() {
		predict(10, PlanetNameEnum.BETASOID);
	}
	
	@Test
	void mustPredictClimaBy10FERENGEYears() {
		predict(10, PlanetNameEnum.FERENGE);
	}
	
	private void predict(Integer years, PlanetNameEnum planet) {
		var predictions = service.predict(years, planet);
		
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
