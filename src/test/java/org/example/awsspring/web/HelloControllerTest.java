package org.example.awsspring.web;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@WebMvcTest(controllers = HelloController.class)
class HelloControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void hello가_리턴된다() throws Exception{
		String hello = "hello";

		mvc.perform(get("/hello"))
			.andExpect(status().isOk())
			.andExpect(content().string(hello));

	}

	@Test
	public void HelloDto가_리턴된다() throws Exception{
		//given
		String name = "taesoon";
		int amount = 1000;

		//when
		mvc.perform(
					get("/hello/dto")
							.param("name", name)
							.param("amount",String.
								valueOf(amount)))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name", is(name)))
			.andExpect((jsonPath("$.amount",is(amount))));
	}
}