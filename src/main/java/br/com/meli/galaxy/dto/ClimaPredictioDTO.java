package br.com.meli.galaxy.dto;

import br.com.meli.galaxy.model.enums.ClimaStatusEnum;

public class ClimaPredictioDTO {
	
	private Integer day;
	private ClimaStatusEnum clima;
	
	public ClimaPredictioDTO(Integer day, ClimaStatusEnum clima) {
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
