package br.com.meli.galaxy.controller;

import static org.mockito.Mockito.when;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.meli.galaxy.service.dto.WeatherPredictionDTO;
import br.com.meli.galaxy.model.enums.WeatherStatusEnum;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;
import br.com.meli.galaxy.service.WeatherPredictionService;

@WebMvcTest(WeatherPredictionController.class)
public class WeatherPredictionControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private WeatherPredictionService service;
	
	@Test
	void mustReturnStatus200OKWhenSearchByFerengeDays() throws Exception {
		var uri = new URI("/prediction/ferenge/weather/1");
		verifyStatus200OK(uri,  PlanetNameEnum.FERENGE);
	}
	
	@Test
	void mustReturnStatus400BadRequestWhenSearchByFerengeDays() throws Exception {
		var uri = new URI("/prediction/ferenge/weather/-1");
		verifyStatus400BadRequest(uri);
	}
	
	@Test
	void mustReturnStatus404NotFoundWhenSearchByFerengeDays() throws Exception {
		var uri = new URI("/prediction/ferenge/weather/1000000");
		verifyStatus4004NotFound(uri);
	}
		

	@Test
	void mustReturnStatus200OKWhenSearchByBetasoidDays() throws Exception {
		var uri = new URI("/prediction/betasoid/weather/1");
		verifyStatus200OK(uri,  PlanetNameEnum.BETASOID);
	}
	
	@Test
	void mustReturnStatus400BadRequestWhenSearchByBetasoidDays() throws Exception {
		var uri = new URI("/prediction/betasoid/weather/-1");
		verifyStatus400BadRequest(uri);
	}
	
	@Test
	void mustReturnStatus404NotFoundWhenSearchByBetasoidDays() throws Exception {
		var uri = new URI("/prediction/betasoid/weather/1000000");
		verifyStatus4004NotFound(uri);
	}
	
	@Test
	void mustReturnStatus200OKWhenSearchByVulcanoDays() throws Exception {
		var uri = new URI("/prediction/vulcano/weather/1");
		verifyStatus200OK(uri,  PlanetNameEnum.VULCANO);
	}
	
	@Test
	void mustReturnStatus400BadRequestWhenSearchByVulcanoDays() throws Exception {
		var uri = new URI("/prediction/vulcano/weather/-1");
		verifyStatus400BadRequest(uri);
	}
	
	@Test
	void mustReturnStatus404NotFoundWhenSearchByVulcanoDays() throws Exception {
		var uri = new URI("/prediction/vulcano/weather/1000000");
		verifyStatus4004NotFound(uri);
	}

	private void verifyStatus200OK(URI uri, PlanetNameEnum planet) throws Exception {
		when(service.findWeatherByDay(1, planet)).thenReturn(getWeatherPrediction(planet));
		
		mockMvc.perform(MockMvcRequestBuilders.get(uri))
		   .andExpect(MockMvcResultMatchers.status().isOk());
	}

	private void verifyStatus400BadRequest(URI uri) throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(uri))
		   .andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	private void verifyStatus4004NotFound(URI uri) throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(uri))
		   .andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	
	private WeatherPredictionDTO getWeatherPrediction(PlanetNameEnum planet) {
		return new WeatherPredictionDTO(1, WeatherStatusEnum.DROUGHT);
	}
	
}
