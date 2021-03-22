package br.com.meli.galaxy.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.meli.galaxy.model.ClimaPrediction;
import br.com.meli.galaxy.model.enums.ClimaStatusEnum;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;

@SpringBootTest
public class ClimaPredictionServiceTest {

	@Autowired
	private ClimaPredictionService service;
	
	@Test
	void mustPredictClimaBy10VulcanoYears() {
		var years = 10;
		var predictions = service.predict(years, PlanetNameEnum.VULCANO);
		
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
