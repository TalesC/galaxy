package br.com.meli.galaxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class GalaxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GalaxyApplication.class, args);
	}

}
