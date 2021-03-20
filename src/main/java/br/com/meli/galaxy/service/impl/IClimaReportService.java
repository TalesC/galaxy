package br.com.meli.galaxy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.galaxy.dto.ClimaReportDTO;
import br.com.meli.galaxy.model.ClimaPrediction;
import br.com.meli.galaxy.service.ClimaPredictionService;
import br.com.meli.galaxy.service.ClimaReportService;

@Service
public class IClimaReportService implements ClimaReportService {
	
	@Autowired
	private ClimaPredictionService predictionService;

	@Override
	public ClimaReportDTO generateReport(Integer year) {
		
		var report = new ClimaReportDTO(0, 0, 0);
		var predictions = predictionService.predictByYear(year);
		
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
