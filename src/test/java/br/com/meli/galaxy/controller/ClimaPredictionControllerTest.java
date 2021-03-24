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

import br.com.meli.galaxy.dto.ClimaPredictioDTO;
import br.com.meli.galaxy.model.enums.ClimaStatusEnum;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;
import br.com.meli.galaxy.service.ClimaPredictionService;

@WebMvcTest(ClimaPredictionController.class)
public class ClimaPredictionControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ClimaPredictionService service;
	
	@Test
	void mustReturnStatus200OKWhenSearchByFerengeDays() throws Exception {
		var uri = new URI("/prediction/ferenge/clima/1");
		verifyStatus200OK(uri,  PlanetNameEnum.FERENGE);
	}
	
	@Test
	void mustReturnStatus400BadRequestWhenSearchByFerengeDays() throws Exception {
		var uri = new URI("/prediction/ferenge/clima/-1");
		verifyStatus400BadRequest(uri);
	}
	
	@Test
	void mustReturnStatus200OKWhenSearchByBetasoidDays() throws Exception {
		var uri = new URI("/prediction/betasoid/clima/1");
		verifyStatus200OK(uri,  PlanetNameEnum.FERENGE);
	}
	
	@Test
	void mustReturnStatus400BadRequestWhenSearchByBetasoidDays() throws Exception {
		var uri = new URI("/prediction/betasoid/clima/-1");
		verifyStatus400BadRequest(uri);
	}
	
	@Test
	void mustReturnStatus200OKWhenSearchByVulcanoDays() throws Exception {
		var uri = new URI("/prediction/vulcano/clima/1");
		verifyStatus200OK(uri,  PlanetNameEnum.FERENGE);
	}
	
	@Test
	void mustReturnStatus400BadRequestWhenSearchByVulcanoDays() throws Exception {
		var uri = new URI("/prediction/vulcano/clima/-1");
		verifyStatus400BadRequest(uri);
	}

	private void verifyStatus200OK(URI uri, PlanetNameEnum planet) throws Exception {
		when(service.findClimaByDay(1, planet)).thenReturn(getClimaPrediction(planet));
		
		mockMvc.perform(MockMvcRequestBuilders.get(uri))
		   .andExpect(MockMvcResultMatchers.status().isOk());
	}

	private void verifyStatus400BadRequest(URI uri) throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(uri))
		   .andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	private ClimaPredictioDTO getClimaPrediction(PlanetNameEnum planet) {
		return new ClimaPredictioDTO(1, ClimaStatusEnum.DROUGHT);
	}
	
}