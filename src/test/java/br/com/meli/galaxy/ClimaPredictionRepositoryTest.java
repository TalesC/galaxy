package br.com.meli.galaxy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.meli.galaxy.model.ent.ClimaPrediction;
import br.com.meli.galaxy.model.enums.ClimaStatusEnum;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;
import br.com.meli.galaxy.repository.ClimaPredictionRepository;

@DataJpaTest
public class ClimaPredictionRepositoryTest {
		
	@Autowired
	private ClimaPredictionRepository repository;

	@Test
	void mustSaveClimaPrediction() {
		var predition = new ClimaPrediction(1, PlanetNameEnum.VULCANO, ClimaStatusEnum.RAIN);
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
	
	private List<ClimaPrediction> generateList(){
		return Arrays.asList(
						new ClimaPrediction(1, PlanetNameEnum.VULCANO, ClimaStatusEnum.RAIN),
						new ClimaPrediction(1, PlanetNameEnum.VULCANO, ClimaStatusEnum.DROUGHT),
						new ClimaPrediction(1, PlanetNameEnum.VULCANO, ClimaStatusEnum.NONE),
						new ClimaPrediction(1, PlanetNameEnum.VULCANO, ClimaStatusEnum.OPTIMAL));
	}
	
	
}
