package br.com.meli.galaxy.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.meli.galaxy.model.ent.ClimaPrediction;
import br.com.meli.galaxy.model.enums.ClimaStatusEnum;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;
import br.com.meli.galaxy.service.impl.IClimaPredictionGeneratorService;

public class ClimaPredictionGeneratorServiceTest {

	private ClimaPredictionGeneratorService service = new IClimaPredictionGeneratorService();
	
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
	
	private ClimaPrediction getAnyPredition(List<ClimaPrediction> predictions) {
		var rain = predictions.stream()
						.filter(prediction -> verifyStatus(prediction))
						.findAny().orElse(null);
		return rain;
	}
	
	private boolean verifyStatus(ClimaPrediction prediction) {
		return prediction.getClima().equals(ClimaStatusEnum.RAIN) ||
				prediction.getClima().equals(ClimaStatusEnum.DROUGHT) ||
				prediction.getClima().equals(ClimaStatusEnum.OPTIMAL);
	}
}
