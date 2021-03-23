package br.com.meli.galaxy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.meli.galaxy.model.ent.ClimaPrediction;
import br.com.meli.galaxy.model.ent.ClimaPredictionId;

@Repository
public interface ClimaPredictionRepository extends JpaRepository<ClimaPrediction, ClimaPredictionId>{

}
