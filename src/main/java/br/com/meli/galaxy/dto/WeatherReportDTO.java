package br.com.meli.galaxy.dto;

import br.com.meli.galaxy.model.enums.PlanetNameEnum;

public class WeatherReportDTO {
	
	private Integer droughtDays;
	private Integer rainDays;
	private Integer optimalDays;
	private PlanetNameEnum onPlanet;
	
	public WeatherReportDTO(Integer droughtDays, Integer rainDays, Integer optimalDays, PlanetNameEnum onPlanet) {
		super();
		this.droughtDays = droughtDays;
		this.rainDays = rainDays;
		this.optimalDays = optimalDays;
		this.onPlanet = onPlanet;
	}

	public Integer getDroughtDays() {
		return droughtDays;
	}

	public void setDroughtDays(Integer droughtDays) {
		this.droughtDays = droughtDays;
	}

	public Integer getRainDays() {
		return rainDays;
	}

	public void setRainDays(Integer rainDays) {
		this.rainDays = rainDays;
	}

	public Integer getOptimalDays() {
		return optimalDays;
	}

	public void setOptimalDays(Integer optimalDays) {
		this.optimalDays = optimalDays;
	}

	public PlanetNameEnum getOnPlanet() {
		return onPlanet;
	}

	public void setOnPlanet(PlanetNameEnum onPlanet) {
		this.onPlanet = onPlanet;
	}
	
}
