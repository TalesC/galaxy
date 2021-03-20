package br.com.meli.galaxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.galaxy.dto.ClimaReportDTO;
import br.com.meli.galaxy.service.ClimaReportService;

@RestController
@RequestMapping("/report")
public class ClimaReportController {
	
	@Autowired
	private ClimaReportService service;
	
	@GetMapping("/{year}")
	public ResponseEntity<ClimaReportDTO> getReport(@PathVariable("year") Integer year) {
		
		if(year < 0) return ResponseEntity.badRequest().build();
		
		var report = service.generateReport(year);
		return ResponseEntity.ok(report);
	}
	
}
