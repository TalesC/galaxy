package br.com.meli.galaxy.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.meli.galaxy.model.ClimaPrediction;
import br.com.meli.galaxy.model.enums.ClimaStatusEnum;

@SpringBootTest
public class ClimaReportServiceTest {
	
	@MockBean
	private ClimaPredictionService predictionService;
	
	@Autowired
	private ClimaReportService service;
	
	@Test
	void mustGenerateAReportByPeriod() {
		when(predictionService.predict(10))
			.thenReturn(generatePredictionList());
		
		var report = service.generateReport(10);
		
		assertThat(report != null);
		assertThat(report.getDroughtPeriods().equals(1));
		assertThat(report.getRainPeriods().equals(1));
		assertThat(report.getOptimalClimaPeriod().equals(2));
	}
	
	private List<ClimaPrediction> generatePredictionList(){
		return Arrays.asList(
				new ClimaPrediction(1, ClimaStatusEnum.OPTIMAL),
				new ClimaPrediction(2, ClimaStatusEnum.DROUGHT),
				new ClimaPrediction(3, ClimaStatusEnum.OPTIMAL),
				new ClimaPrediction(4, ClimaStatusEnum.RAIN),
				new ClimaPrediction(5, ClimaStatusEnum.NONE));
	}

}
