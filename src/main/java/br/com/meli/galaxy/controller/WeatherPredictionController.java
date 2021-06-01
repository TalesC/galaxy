package br.com.meli.galaxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.galaxy.service.dto.WeatherPredictionDTO;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;
import br.com.meli.galaxy.service.WeatherPredictionService;

@RestController
@RequestMapping("/prediction")
public class WeatherPredictionController {
	
	@Autowired
	private WeatherPredictionService service;
	
	@GetMapping("/vulcano/weather/{day}")
	public ResponseEntity<WeatherPredictionDTO> findByDayOfVulcano(@PathVariable("day") Integer day) {
		return findWeatherByDay(day, PlanetNameEnum.VULCANO);
	}
	
	@GetMapping("/ferenge/weather/{day}")
	public ResponseEntity<WeatherPredictionDTO> findByDayOfFerenge(@PathVariable("day") Integer day) {
		return findWeatherByDay(day, PlanetNameEnum.FERENGE);
	}
	
	@GetMapping("/betasoid/weather/{day}")
	public ResponseEntity<WeatherPredictionDTO> findByDayOfBetasoid(@PathVariable("day") Integer day) {
		return findWeatherByDay(day, PlanetNameEnum.BETASOID);
	}

	private ResponseEntity<WeatherPredictionDTO> findWeatherByDay(Integer day, PlanetNameEnum planetName) {
		if(day <= 0) return ResponseEntity.badRequest().build();
		
		var prediction = service.findWeatherByDay(day, planetName);
		if(prediction == null) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(prediction);
	}
	
	

}
