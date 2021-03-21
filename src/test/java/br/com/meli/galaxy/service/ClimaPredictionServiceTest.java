package br.com.meli.galaxy.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClimaPredictionServiceTest {

	@Autowired
	private ClimaPredictionService service;
	
	@Test
	void mustPredictClimaByEarthYears() {
		var earthYears = 10;
		var predictions = service.predict(earthYears);
		
		assertThat(predictions != null && !predictions.isEmpty());
		assertThat(predictions.size() > 0);
	}
}
