package br.com.meli.galaxy.dto;

public class ClimaReportDTO {
	
	private Integer droughtPeriods;
	private Integer rainPeriods;
	private Integer optimalClimaPeriod;
	
	public ClimaReportDTO(Integer droughtPeriods, Integer rainPeriods, Integer optimalClimaPeriod) {
		super();
		this.droughtPeriods = droughtPeriods;
		this.rainPeriods = rainPeriods;
		this.optimalClimaPeriod = optimalClimaPeriod;
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

	public void setDroughtPeriods(Integer droughtPeriods) {
		this.droughtPeriods = droughtPeriods;
	}

	public void setRainPeriods(Integer rainPeriods) {
		this.rainPeriods = rainPeriods;
	}

	public void setOptimalClimaPeriod(Integer optimalClimaPeriod) {
		this.optimalClimaPeriod = optimalClimaPeriod;
	}

}
