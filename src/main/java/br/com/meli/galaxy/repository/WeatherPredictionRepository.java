package br.com.meli.galaxy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.meli.galaxy.model.ent.WeatherPrediction;
import br.com.meli.galaxy.model.ent.WeatherPredictionId;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;

@Repository
public interface WeatherPredictionRepository extends JpaRepository<WeatherPrediction, WeatherPredictionId>{
	
	List<WeatherPrediction> findByPlanet(PlanetNameEnum planet);
	
}
