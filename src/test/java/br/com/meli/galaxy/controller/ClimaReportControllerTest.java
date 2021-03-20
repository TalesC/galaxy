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
import br.com.meli.galaxy.service.ClimaReportService;

@WebMvcTest(ClimaReportController.class)
public class ClimaReportControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ClimaReportService service;
	
	@Test
	void mustReturnStatus200OKWhenGenerateReport() throws Exception {
		var uri = new URI("/report/1");
		
		when(service.generateReport(1)).thenReturn(new ClimaReportDTO(10, 11, 20));
		
		mockMvc.perform(MockMvcRequestBuilders.get(uri))
			   .andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	void mustReturnStatus400BadRequestWhenSensInvalidInput() throws Exception {
		var uri = new URI("/report/-1");
		
		mockMvc.perform(MockMvcRequestBuilders.get(uri))
			   .andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

}
