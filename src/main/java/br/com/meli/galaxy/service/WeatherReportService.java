package br.com.meli.galaxy.service;

import br.com.meli.galaxy.dto.WeatherReportDTO;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;

public interface WeatherReportService {

	WeatherReportDTO generateReport(Integer year, PlanetNameEnum planetName);

}
