package br.com.meli.galaxy.dto;

import br.com.meli.galaxy.model.enums.PlanetNameEnum;

public class WeatherReportDTO {
	
	private Integer droughtPeriods;
	private Integer rainPeriods;
	private Integer optimalClimaPeriod;
	private PlanetNameEnum basedOnYearsOf;
	
	public WeatherReportDTO(Integer droughtPeriods, Integer rainPeriods, Integer optimalClimaPeriod,
			PlanetNameEnum basedOnYearsOf) {
		super();
		this.droughtPeriods = droughtPeriods;
		this.rainPeriods = rainPeriods;
		this.optimalClimaPeriod = optimalClimaPeriod;
		this.basedOnYearsOf = basedOnYearsOf;
	}

	public Integer getDroughtPeriods() {
		return droughtPeriods;
	}

	public Integer getRainPeriods() {
		return rainPeriods;
	}

	public Integer getOptimalClimaPeriod() {
		return optimalClimaPeriod;
	}

	public PlanetNameEnum getBasedOnYearsOf() {
		return basedOnYearsOf;
	}

	public void setDroughtPeriods(Integer droughtPeriods) {
		this.droughtPeriods = droughtPeriods;
	}

	public void setRainPeriods(Integer rainPeriods) {
		this.rainPeriods = rainPeriods;
	}

	public void setOptimalClimaPeriod(Integer optimalClimaPeriod) {
		this.optimalClimaPeriod = optimalClimaPeriod;
	}

	public void setBasedOnYearsOf(PlanetNameEnum basedOnYearsOf) {
		this.basedOnYearsOf = basedOnYearsOf;
	}
	
}
