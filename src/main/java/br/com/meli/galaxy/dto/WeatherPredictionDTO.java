package br.com.meli.galaxy.dto;

import br.com.meli.galaxy.model.enums.WeatherStatusEnum;

public class WeatherPredictionDTO {
	
	private Integer day;
	private WeatherStatusEnum clima;
	
	public WeatherPredictionDTO(Integer day, WeatherStatusEnum clima) {
		super();
		this.day = day;
		this.clima = clima;
	}

	public Integer getDay() {
		return day;
	}

	public WeatherStatusEnum getClima() {
		return clima;
	}

}
