package br.com.meli.galaxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.galaxy.dto.WeatherPredictioDTO;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;
import br.com.meli.galaxy.service.WeatherPredictionService;

@RestController
@RequestMapping("/prediction")
public class WeatherPredictionController {
	
	@Autowired
	private WeatherPredictionService service;
	
	@GetMapping("/vulcano/clima/{day}")
	public ResponseEntity<WeatherPredictioDTO> findByDayOfVulcano(@PathVariable("day") Integer day) {
		return findClimaByDay(day, PlanetNameEnum.VULCANO);
	}
	
	@GetMapping("/ferenge/clima/{day}")
	public ResponseEntity<WeatherPredictioDTO> findByDayOfFerenge(@PathVariable("day") Integer day) {
		return findClimaByDay(day, PlanetNameEnum.FERENGE);
	}
	
	@GetMapping("/betasoid/clima/{day}")
	public ResponseEntity<WeatherPredictioDTO> findByDayOfBetasoid(@PathVariable("day") Integer day) {
		return findClimaByDay(day, PlanetNameEnum.BETASOID);
	}

	private ResponseEntity<WeatherPredictioDTO> findClimaByDay(Integer day, PlanetNameEnum planetName) {
		if(day <= 0) return ResponseEntity.badRequest().build();
		
		var prediction = service.findClimaByDay(day, planetName);
		if(prediction == null) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(prediction);
	}
	
	

}
