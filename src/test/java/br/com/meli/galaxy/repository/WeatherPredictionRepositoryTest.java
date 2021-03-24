package br.com.meli.galaxy.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.meli.galaxy.model.ent.WeatherPrediction;
import br.com.meli.galaxy.model.ent.WeatherPredictionId;
import br.com.meli.galaxy.model.enums.WeatherStatusEnum;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;

@DataJpaTest
public class WeatherPredictionRepositoryTest {
		
	@Autowired
	private WeatherPredictionRepository repository;

	@Test
	void mustSaveClimaPrediction() {
		var predition = new WeatherPrediction(1, PlanetNameEnum.VULCANO, WeatherStatusEnum.RAIN);
		var resposta = repository.save(predition);
			
		assertThat(resposta).isNotNull();
		assertThat(resposta).isEqualTo(predition);
	}
	
	@Test
	void mustSaveListOfClimaPrediction() {
		var preditions = generateList();
		var resposta = repository.saveAll(preditions);
			
		assertThat(resposta).isNotNull();
		assertThat(resposta.size() > 0).isTrue();
		assertThat(resposta).isEqualTo(preditions);
	}
	
	@Test
	void mustfindClimaPredictionById() {
		var predition = repository.save(new WeatherPrediction(
										1,
										PlanetNameEnum.VULCANO,
										WeatherStatusEnum.RAIN));
		
		var resposta = repository.findById(new WeatherPredictionId(1, PlanetNameEnum.VULCANO)).get();
		
		assertThat(resposta).isNotNull();
		assertThat(resposta).isEqualTo(predition);
	}
	
	private List<WeatherPrediction> generateList(){
		return Arrays.asList(
						new WeatherPrediction(1, PlanetNameEnum.VULCANO, WeatherStatusEnum.RAIN),
						new WeatherPrediction(1, PlanetNameEnum.VULCANO, WeatherStatusEnum.DROUGHT),
						new WeatherPrediction(1, PlanetNameEnum.VULCANO, WeatherStatusEnum.NONE),
						new WeatherPrediction(1, PlanetNameEnum.VULCANO, WeatherStatusEnum.OPTIMAL));
	}
	
	
}
