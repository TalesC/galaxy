package br.com.meli.galaxy.service;

import br.com.meli.galaxy.dto.ClimaReportDTO;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;

public interface ClimaReportService {

	ClimaReportDTO generateReport(Integer year, PlanetNameEnum planetName);

}
