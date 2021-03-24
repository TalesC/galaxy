package br.com.meli.galaxy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.meli.galaxy.model.ent.WeatherPrediction;
import br.com.meli.galaxy.model.ent.WeatherPredictionId;

@Repository
public interface WeatherPredictionRepository extends JpaRepository<WeatherPrediction, WeatherPredictionId>{
	
}
