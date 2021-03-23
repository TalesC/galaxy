package br.com.meli.galaxy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.galaxy.dto.ClimaReportDTO;
import br.com.meli.galaxy.model.ent.ClimaPrediction;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;
import br.com.meli.galaxy.service.ClimaPredictionGeneratorService;
import br.com.meli.galaxy.service.ClimaReportService;

@Service
public class IClimaReportService implements ClimaReportService {
	
	@Autowired
	private ClimaPredictionGeneratorService predictionService;

	@Override
	public ClimaReportDTO generateReport(Integer year, PlanetNameEnum planetName) {
		
		var report = new ClimaReportDTO(0, 0, 0, planetName);
		var predictions = predictionService.predict(year, planetName);
		
		predictions.forEach(prediction -> {
			verifyPrediction(report, prediction);
		});
		
		return report;
	}

	private void verifyPrediction(ClimaReportDTO report, ClimaPrediction prediction) {
		switch (prediction.getClima()) {
		case DROUGHT: report.setDroughtPeriods(report.getDroughtPeriods() + 1);
			break;
		case RAIN: report.setRainPeriods(report.getRainPeriods() + 1);
			break;
		case OPTIMAL: report.setOptimalClimaPeriod(report.getOptimalClimaPeriod() + 1);
			break;
		default:
			break;
		}		
	}

}
