package br.com.meli.galaxy.component;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.meli.galaxy.model.ent.ClimaPrediction;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;
import br.com.meli.galaxy.repository.ClimaPredictionRepository;
import br.com.meli.galaxy.service.ClimaPredictionGeneratorService;


@Component
public class CreateClimaDatabase {

	private static final Logger LOG = LoggerFactory.getLogger(CreateClimaDatabase.class);
	
	@Autowired
	private ClimaPredictionGeneratorService service;
	
	@Autowired
	private ClimaPredictionRepository repository;
	
   @PostConstruct
   public void init() {
	   LOG.info("------------------> Generate Predictions!");
	   
	   var predictions = generatePredictions();
	   LOG.info("------------------> Total of predictions: " + predictions.size());
	  
	   LOG.info("------------------> Starts Persistence ... ");
	   repository.saveAll(predictions);
	   
	   LOG.info("------------------> Finished Persistence! ");
   }
   
   private List<ClimaPrediction> generatePredictions() {
	   var predictions = new ArrayList<ClimaPrediction>();
	   
	   for (PlanetNameEnum planet : PlanetNameEnum.values()) {
		   predictions.addAll(service.predict(10, planet));
	   }
	   
	   return predictions;
   }
}
