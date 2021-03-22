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

import br.com.meli.galaxy.dto.ClimaReportDTO;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;
import br.com.meli.galaxy.service.ClimaReportService;

@WebMvcTest(ClimaReportController.class)
public class ClimaReportControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ClimaReportService service;
	
	@Test
	void mustReturnStatus200OKWhenGenerateReportByFerengeYears() throws Exception {
		var uri = new URI("/report/ferenge/1");
		when(service.generateReport(1, PlanetNameEnum.FERENGE)).thenReturn(new ClimaReportDTO(10, 11, 20));
		
		verifyStatus200OK(uri);
	}
	
	@Test
	void mustReturnStatus400BadRequestWhenGenerateByFerengeYears() throws Exception {
		var uri = new URI("/report/ferenge/-1");
		verifyStatus400BadRequest(uri);
	}
	
	@Test
	void mustReturnStatus200OKWhenGenerateReportByBetasoidYears() throws Exception {
		var uri = new URI("/report/ferenge/1");
		when(service.generateReport(1, PlanetNameEnum.BETASOID)).thenReturn(new ClimaReportDTO(10, 11, 20));
		
		verifyStatus200OK(uri);
	}
	
	@Test
	void mustReturnStatus400BadRequestWhenGenerateByBetasoidYears() throws Exception {
		var uri = new URI("/report/betasoid/-1");
		verifyStatus400BadRequest(uri);
	}
	
	@Test
	void mustReturnStatus200OKWhenGenerateReportByVulcanoYears() throws Exception {
		var uri = new URI("/report/vulcano/1");
		when(service.generateReport(1, PlanetNameEnum.VULCANO)).thenReturn(new ClimaReportDTO(10, 11, 20));
		
		verifyStatus200OK(uri);
	}
	
	@Test
	void mustReturnStatus400BadRequestWhenGenerateByVulcanoYears() throws Exception {
		var uri = new URI("/report/vulcano/-1");
		verifyStatus400BadRequest(uri);
	}
	
	private void verifyStatus200OK(URI uri) throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(uri))
		   .andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	private void verifyStatus400BadRequest(URI uri) throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(uri))
		   .andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

}
