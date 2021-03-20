package br.com.meli.galaxy.model;

import br.com.meli.galaxy.model.enums.ClimaStatusEnum;

public class ClimaPrediction {
	
	private Integer day;
	private ClimaStatusEnum clima;
	
	public ClimaPrediction(Integer day, ClimaStatusEnum clima) {
		super();
		this.day = day;
		this.clima = clima;
	}

	public Integer getDay() {
		return day;
	}

	public ClimaStatusEnum getClima() {
		return clima;
	}
	

}
