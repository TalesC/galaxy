package br.com.meli.galaxy.model.ent;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((planet == null) ? 0 : planet.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClimaPrediction other = (ClimaPrediction) obj;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (planet != other.planet)
			return false;
		return true;
	}
	
	
}
