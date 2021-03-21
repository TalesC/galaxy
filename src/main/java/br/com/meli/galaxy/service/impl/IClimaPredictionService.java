package br.com.meli.galaxy.service.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.meli.galaxy.model.ClimaPrediction;
import br.com.meli.galaxy.model.SimpleSolarSystem;
import br.com.meli.galaxy.model.builder.SimpleSolarSystemBuilder;
import br.com.meli.galaxy.model.enums.ClimaStatusEnum;
import br.com.meli.galaxy.service.ClimaPredictionService;
import br.com.meli.galaxy.utils.MatrixUtils;

public class IClimaPredictionService implements ClimaPredictionService {

	@Override
	public List<ClimaPrediction> predict(Integer earthYear) {
		var solarSystem = this.createSolarSystem();
		var days = earthYear * 365;
		
		var predictions = predict(days, solarSystem);
		
		return predictions;
	}

	private List<ClimaPrediction> predict(Integer days, SimpleSolarSystem solarSystem) {
		var predictionsOfAPlanet = new ArrayList<ClimaPrediction>();
		
		for(int day=0; day < days; day++) {
			predictionsOfAPlanet.add(new ClimaPrediction(
										day,
										verifyClima(day, solarSystem)));
		}		
		return predictionsOfAPlanet;
	}


	private ClimaStatusEnum verifyClima(int day, SimpleSolarSystem solarSystem) {
		
		if(planetsAlignWithSun(solarSystem)) return ClimaStatusEnum.DROUGHT;
		if(planetsMakesTriangleWithSunInside(solarSystem)) return ClimaStatusEnum.RAIN;
		if(planetsAlignWithoutSun(solarSystem)) return ClimaStatusEnum.OPTIMAL;
				
		return ClimaStatusEnum.NONE;
	}

	private boolean planetsAlignWithSun(SimpleSolarSystem solarSystem) {
		var locations = solarSystem.getLocations();		
		var iscolinear = MatrixUtils.isCollinear(locations); 
		
		return iscolinear;
	}
	
	private boolean planetsMakesTriangleWithSunInside(SimpleSolarSystem solarSystem) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private boolean planetsAlignWithoutSun(SimpleSolarSystem solarSystem) {
		// TODO Auto-generated method stub
		return false;
	}

	private SimpleSolarSystem createSolarSystem() {
		return new SimpleSolarSystemBuilder()
							.planets()
							.sun()
							.build();
	}

}
