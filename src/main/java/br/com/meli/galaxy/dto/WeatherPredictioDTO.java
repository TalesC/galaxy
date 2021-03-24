package br.com.meli.galaxy.dto;

import br.com.meli.galaxy.model.enums.WeatherStatusEnum;

public class WeatherPredictioDTO {
	
	private Integer day;
	private WeatherStatusEnum clima;
	
	public WeatherPredictioDTO(Integer day, WeatherStatusEnum clima) {
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
