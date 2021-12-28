package com.project.ecom.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.project.ecom.pojo.User;
import com.project.ecom.service.LoginService;

@ExtendWith(MockitoExtension.class)
class LoginControllerTest {

	MockMvc mockMvc;

	@Mock
	LoginService service;

	@InjectMocks
	LoginController mockController;

	@BeforeEach
	private void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(mockController).build();
	}

	@Test
	void testAddUser() throws Exception {
		User user = new User("Raghav121", "Raghav121", "9999999999", "raghav121@gmail.com");
		
		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson = ow.writeValueAsString(user);
		
	    //doReturn(true).when(service.insertUser(user));
		when(service.insertUser(Mockito.any())).thenReturn(true);
		this.mockMvc.perform(post("/signup").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andDo(print()).andExpect(status().isNoContent());
	}

//	@Test
//	void testUpdateUser() throws Exception {
//		Optional<User> user = Optional
//				.ofNullable(new User("Raghav121", "Raghav121", "9999999999", "raghav121@gmail.com"));
//		
//		when(service.findByUserId(user.get().getEmail())).thenReturn(user.get());
//		this.mockMvc.perform(get("/signup/" + user.get().getEmail())).andDo(print()).andExpect(status().isOk())
//				.andExpect(jsonPath("$.email", is(user.get().getEmail())));
//	}

	@Test
	void testGetUser() throws Exception {

		Optional<User> user = Optional
				.ofNullable(new User("Raghav121", "Raghav121", "9999999999", "raghav121@gmail.com"));

		when(service.findByUserId(user.get().getEmail())).thenReturn(user.get());
		this.mockMvc.perform(get("/signup/" + user.get().getEmail())).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.email", is(user.get().getEmail())));
	}

	@Test
	void testDeleteUser() throws Exception {
		Optional<User> user = Optional
				.ofNullable(new User("Raghav121", "Raghav121", "9999999999", "raghav121@gmail.com"));

		when(service.removeUser(user.get().getEmail())).thenReturn(true);
		this.mockMvc.perform(delete("/signup/" + user.get().getEmail())).andDo(print())
				.andExpect(status().isNoContent());
	}

//	@Test
//	void testChangePassword() {
//		fail("Not yet implemented");
//	}

}
