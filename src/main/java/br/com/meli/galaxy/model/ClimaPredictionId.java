package br.com.meli.galaxy.model;

import java.io.Serializable;

import br.com.meli.galaxy.model.enums.PlanetNameEnum;

public class ClimaPredictionId implements Serializable {

	private static final long serialVersionUID = -756299426410402865L;
	
	private Integer day;
	private PlanetNameEnum planet;
	
	public ClimaPredictionId(Integer day, PlanetNameEnum planet) {
		super();
		this.day = day;
		this.planet = planet;
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
		ClimaPredictionId other = (ClimaPredictionId) obj;
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
