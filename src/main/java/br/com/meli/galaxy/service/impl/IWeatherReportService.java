package br.com.meli.galaxy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.galaxy.dto.WeatherPredictionDTO;
import br.com.meli.galaxy.dto.WeatherReportDTO;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;
import br.com.meli.galaxy.service.WeatherPredictionService;
import br.com.meli.galaxy.service.WeatherReportService;

@Service
public class IWeatherReportService implements WeatherReportService {
	
	@Autowired
	private WeatherPredictionService predictionService;

	@Override
	public WeatherReportDTO generate(Integer year, PlanetNameEnum planetName) {
		
		var report = new WeatherReportDTO(0, 0, 0, planetName);
		var predictions = predictionService.findClimaByYear(year, planetName);
		
		predictions.forEach(prediction -> {
			verifyWeather(report, prediction);
		});
		
		return report;
	}

	private void verifyWeather(WeatherReportDTO report, WeatherPredictionDTO prediction) {
		switch (prediction.getWeather()) {
		case DROUGHT: report.setDroughtDays(report.getDroughtDays() + 1);
			break;
		case RAIN: report.setRainDays(report.getRainDays() + 1);
			break;
		case OPTIMAL: report.setOptimalDays(report.getOptimalDays() + 1);
			break;
		default:
			break;
		}		
	}

}
