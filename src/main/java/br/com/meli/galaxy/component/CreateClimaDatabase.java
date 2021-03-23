package br.com.meli.galaxy.component;



import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
public class CreateClimaDatabase {

	private static final Logger LOG = LoggerFactory.getLogger(CreateClimaDatabase.class);

   @Autowired
   private Environment environment;

   @PostConstruct
   public void init() {
	   LOG.info("+++++++++++++++++++ Starts CreateClimaDatabase");
	   Arrays.asList(environment.getDefaultProfiles()).forEach(str ->{
		   LOG.info(str);
	   });
	  
   }
}
