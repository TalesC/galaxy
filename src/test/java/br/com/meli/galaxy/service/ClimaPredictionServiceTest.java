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
		assertThat(getRainPredition(predictions)).isNotNull();
		assertThat(getDroughtPredition(predictions)).isNotNull();
		assertThat(getOptimalPredition(predictions)).isNotNull();
	}
	
	private ClimaPrediction getRainPredition(List<ClimaPrediction> predictions) {
		var rain = predictions.stream()
						.filter(prediction -> prediction.getClima().equals(ClimaStatusEnum.RAIN))
						.findAny().orElse(null);
		return rain;
	}
	
	private ClimaPrediction getDroughtPredition(List<ClimaPrediction> predictions) {
		var drought = predictions.stream()
						.filter(prediction -> prediction.getClima().equals(ClimaStatusEnum.DROUGHT))
						.findAny().orElse(null);
		return drought;
	}
	
	private ClimaPrediction getOptimalPredition(List<ClimaPrediction> predictions) {
		var optimal = predictions.stream()
						.filter(prediction -> prediction.getClima().equals(ClimaStatusEnum.OPTIMAL))
						.findAny().orElse(null);
		return optimal;
	}
}
