package br.com.meli.galaxy.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.meli.galaxy.model.enums.PlanetNameEnum;

@SpringBootTest
public class ClimaPredictionServiceTest {

	@Autowired
	private ClimaPredictionService service;
	
	@Test
	void mustPredictClimaByEarthYears() {
		var years = 1;
		var predictions = service.predict(years, PlanetNameEnum.VULCANO);
		
		assertThat(predictions != null && !predictions.isEmpty()).isTrue();
		assertThat(predictions.size() > 0).isTrue();
	}
}
