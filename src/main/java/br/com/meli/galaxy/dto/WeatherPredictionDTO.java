package br.com.meli.galaxy.dto;

import br.com.meli.galaxy.model.enums.WeatherStatusEnum;

public class WeatherPredictionDTO {
	
	private Integer day;
	private WeatherStatusEnum weather;
	
	public WeatherPredictionDTO(Integer day, WeatherStatusEnum weather) {
		super();
		this.day = day;
		this.weather = weather;
	}

	public Integer getDay() {
		return day;
	}

	public WeatherStatusEnum getWeather() {
		return weather;
	}

}
