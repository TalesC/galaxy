package br.com.meli.galaxy.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.meli.galaxy.dto.WeatherPredictionDTO;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;
import br.com.meli.galaxy.model.enums.WeatherStatusEnum;

@SpringBootTest
public class WeatherReportServiceTest {
	
	@MockBean
	private WeatherPredictionService predictionService;
	
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
		when(predictionService.findClimaByYear(years, planet))
		.thenReturn(generatePredictionList(planet));
	
		var report = service.generateReport(years, planet);
		
		assertThat(report != null).isTrue();
		assertThat(report.getDroughtPeriods().equals(1));
		assertThat(report.getRainPeriods().equals(1));
		assertThat(report.getOptimalClimaPeriod().equals(2));
	}
	
	private List<WeatherPredictionDTO> generatePredictionList(PlanetNameEnum planet){
		return Arrays.asList(
				new WeatherPredictionDTO(1, WeatherStatusEnum.OPTIMAL),
				new WeatherPredictionDTO(2, WeatherStatusEnum.DROUGHT),
				new WeatherPredictionDTO(3, WeatherStatusEnum.OPTIMAL),
				new WeatherPredictionDTO(4, WeatherStatusEnum.RAIN),
				new WeatherPredictionDTO(5, WeatherStatusEnum.NONE));
	}

}
