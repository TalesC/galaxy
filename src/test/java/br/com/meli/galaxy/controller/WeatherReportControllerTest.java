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

import br.com.meli.galaxy.dto.WeatherReportDTO;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;
import br.com.meli.galaxy.service.WeatherReportService;

@WebMvcTest(WeatherReportController.class)
public class WeatherReportControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private WeatherReportService service;
	
	@Test
	void mustReturnStatus200OKWhenGenerateReportByFerengeYears() throws Exception {
		var uri = new URI("/report/ferenge/1");
		verifyStatus200OK(uri,  PlanetNameEnum.FERENGE);
	}
	
	@Test
	void mustReturnStatus400BadRequestWhenGenerateByFerengeYears() throws Exception {
		var uri = new URI("/report/ferenge/-1");
		verifyStatus400BadRequest(uri);
	}
	
	@Test
	void mustReturnStatus200OKWhenGenerateReportByBetasoidYears() throws Exception {
		var uri = new URI("/report/betasoid/1");
		verifyStatus200OK(uri,  PlanetNameEnum.BETASOID);
	}
	
	@Test
	void mustReturnStatus400BadRequestWhenGenerateByBetasoidYears() throws Exception {
		var uri = new URI("/report/betasoid/-1");
		verifyStatus400BadRequest(uri);
	}
	
	@Test
	void mustReturnStatus200OKWhenGenerateReportByVulcanoYears() throws Exception {
		var uri = new URI("/report/vulcano/1");
		verifyStatus200OK(uri,  PlanetNameEnum.VULCANO);
	}
	
	@Test
	void mustReturnStatus400BadRequestWhenGenerateByVulcanoYears() throws Exception {
		var uri = new URI("/report/vulcano/-1");
		verifyStatus400BadRequest(uri);
	}
	
	private void verifyStatus200OK(URI uri, PlanetNameEnum planet) throws Exception {
		when(service.generateReport(1, planet)).thenReturn(getReport(planet));
		
		mockMvc.perform(MockMvcRequestBuilders.get(uri))
		   .andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	private void verifyStatus400BadRequest(URI uri) throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(uri))
		   .andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	private WeatherReportDTO getReport(PlanetNameEnum planet) {
		return new WeatherReportDTO(10, 11, 20, planet);
	}
}
