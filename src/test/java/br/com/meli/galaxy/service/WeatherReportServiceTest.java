package br.com.meli.galaxy.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.meli.galaxy.model.ent.WeatherPrediction;
import br.com.meli.galaxy.model.enums.WeatherStatusEnum;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;

@SpringBootTest
public class WeatherReportServiceTest {
	
	@MockBean
	private WeatherPredictionGeneratorService predictionService;
	
	@Autowired
	private WeatherReportService service;
	
	@Test
	void mustGenerateAReportByPeriodOfFerenge() {
		generateReport(10, PlanetNameEnum.FERENGE);
	}
	
	@Test
	void mustGenerateAReportByPeriodOfBetasoid() {
		generateReport(10, PlanetNameEnum.BETASOID);
	}
	
	@Test
	void mustGenerateAReportByPeriodOfVulcano() {
		generateReport(10, PlanetNameEnum.VULCANO);
	}
	
	private void generateReport(Integer years, PlanetNameEnum planet) {
		when(predictionService.predict(years, planet))
		.thenReturn(generatePredictionList(planet));
	
		var report = service.generateReport(years, planet);
		
		assertThat(report != null).isTrue();
		assertThat(report.getDroughtPeriods().equals(1));
		assertThat(report.getRainPeriods().equals(1));
		assertThat(report.getOptimalClimaPeriod().equals(2));
	}
	
	private List<WeatherPrediction> generatePredictionList(PlanetNameEnum planet){
		return Arrays.asList(
				new WeatherPrediction(1, planet, WeatherStatusEnum.OPTIMAL),
				new WeatherPrediction(2, planet, WeatherStatusEnum.DROUGHT),
				new WeatherPrediction(3, planet, WeatherStatusEnum.OPTIMAL),
				new WeatherPrediction(4, planet, WeatherStatusEnum.RAIN),
				new WeatherPrediction(5, planet, WeatherStatusEnum.NONE));
	}

}
