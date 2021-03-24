package br.com.meli.galaxy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.galaxy.dto.WeatherReportDTO;
import br.com.meli.galaxy.model.ent.WeatherPrediction;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;
import br.com.meli.galaxy.service.WeatherPredictionGeneratorService;
import br.com.meli.galaxy.service.WeatherReportService;

@Service
public class IWeatherReportService implements WeatherReportService {
	
	@Autowired
	private WeatherPredictionGeneratorService predictionService;

	@Override
	public WeatherReportDTO generateReport(Integer year, PlanetNameEnum planetName) {
		
		var report = new WeatherReportDTO(0, 0, 0, planetName);
		var predictions = predictionService.predict(year, planetName);
		
		predictions.forEach(prediction -> {
			verifyPrediction(report, prediction);
		});
		
		return report;
	}

	private void verifyPrediction(WeatherReportDTO report, WeatherPrediction prediction) {
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
