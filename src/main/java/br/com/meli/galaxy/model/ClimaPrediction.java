package br.com.meli.galaxy.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import br.com.meli.galaxy.model.enums.ClimaStatusEnum;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;

@Entity
@IdClass(ClimaPredictionId.class)
public class ClimaPrediction {
	
	@Id
	private Integer day;
	@Id
	private PlanetNameEnum planet;
	
	private ClimaStatusEnum clima;
	
	public ClimaPrediction() {
		super();
	}

	public ClimaPrediction(Integer day, PlanetNameEnum planet, ClimaStatusEnum clima) {
		super();
		this.day = day;
		this.planet = planet;
		this.clima = clima;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public PlanetNameEnum getPlanet() {
		return planet;
	}

	public void setPlanet(PlanetNameEnum planet) {
		this.planet = planet;
	}

	public ClimaStatusEnum getClima() {
		return clima;
	}

	public void setClima(ClimaStatusEnum clima) {
		this.clima = clima;
	}

}
