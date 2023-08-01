package com.reservacanchas.springboot.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.MimeTypeUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reservacanchas.springboot.app.models.entities.Usuario;

@SpringBootTest
@AutoConfigureMockMvc
class SpringBootReservaCanchasApplicationTests {

	@Test
	void contextLoads() {}
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	void findById() throws Exception {
		Usuario usuario = this.createUser();
		mockMvc.perform(
			MockMvcRequestBuilders.post("/api/usuarios/save")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(usuario)))
		.andExpect(status().isCreated());
		var findById = mockMvc.perform(
				get("/api/usuarios/1").accept(MimeTypeUtils.APPLICATION_JSON_VALUE)
				.header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqdWFucGVyZXoiLCJleHAiOjE2OTA4NDI5Mjh9.uIlNs5eRG0jbzvLRB1WibwOASvesfv1QYmV8sr_LAWgdlrrTxDk7QnGOMgh76sMWV3CQqJbJfeBMUO2BcaFNAQ"))
				.andExpect(status().isOk())
				.andReturn();
		var b = objectMapper.readValue(findById.getResponse().getContentAsString(), Usuario.class);
		assert b.getEmail().equalsIgnoreCase("juanperez@mail.com");
	}
	
	private Usuario createUser() {
		Usuario usuario = new Usuario();
		usuario.setNombre("Juan");
		usuario.setUsername("juanperez");
		usuario.setEmail("juanperez@mail.com");
		usuario.setPassword("12345");
		return usuario;
	}

}
