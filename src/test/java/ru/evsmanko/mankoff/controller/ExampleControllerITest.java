package ru.evsmanko.mankoff.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import ru.evsmanko.mankoff.dto.ExampleDto;
import ru.evsmanko.mankoff.service.ExampleService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class ExampleControllerITest {

	@MockBean
	private ExampleService service;
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	void testGetUsers() throws Exception {
		when(service.getUsers())
			.thenReturn(Arrays.asList(new ExampleDto().setFirstName("Иван").setLastName("Иванов")));
		
		mvc.perform(get("/users")
				.accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$").isArray())
			.andExpect(jsonPath("$[0].firstName").value("Иван"))
			.andExpect(jsonPath("$[0].lastName").value("Иванов"));
		
		verify(service).getUsers();
	}
}
