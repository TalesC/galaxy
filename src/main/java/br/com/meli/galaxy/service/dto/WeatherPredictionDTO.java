package br.com.meli.galaxy.service.dto;

import br.com.meli.galaxy.model.enums.WeatherStatusEnum;

public class WeatherPredictionDTO {
	
	protected Integer day;
	protected WeatherStatusEnum weather;
	
	public WeatherPredictionDTO(Integer day, WeatherStatusEnum weather) {
		super();
		this.day = day;
		this.weather = weather;
	}

	public Integer getDay() {
		return day;
	}

	public String getWeather() { return weather.name(); }

}
