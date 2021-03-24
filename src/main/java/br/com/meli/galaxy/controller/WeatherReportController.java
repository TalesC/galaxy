package br.com.meli.galaxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.galaxy.dto.WeatherReportDTO;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;
import br.com.meli.galaxy.service.WeatherReportService;

@RestController
@RequestMapping("/report")
public class WeatherReportController {
	
	@Autowired
	private WeatherReportService service;
		
	
	@GetMapping("/ferenge/{year}")
	public ResponseEntity<WeatherReportDTO> getReportByFerengeYears(@PathVariable("year") Integer year) {
		var report = getReport(year, PlanetNameEnum.FERENGE);
		return report;
	}
	
	@GetMapping("/betasoid/{year}")
	public ResponseEntity<WeatherReportDTO> getReportByBetasoidYears(@PathVariable("year") Integer year) {
		var report = getReport(year, PlanetNameEnum.BETASOID);
		return report;
	}
	
	@GetMapping("/vulcano/{year}")
	public ResponseEntity<WeatherReportDTO> getReportByVulcanoYears(@PathVariable("year") Integer year) {
		var report = getReport(year, PlanetNameEnum.VULCANO);
		return report;
	}
	
	private ResponseEntity<WeatherReportDTO> getReport(Integer year, PlanetNameEnum planet) {
		if(year <= 0 || year > 10) return ResponseEntity.badRequest().build();
		
		var report = service.generateReport(year, planet);
		return ResponseEntity.ok(report);
	}
	
}
