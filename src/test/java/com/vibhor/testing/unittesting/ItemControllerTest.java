package com.vibhor.testing.unittesting;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.vibhor.testing.unittesting.business.ItemBusinessService;
import com.vibhor.testing.unittesting.modal.Item;

@RunWith(SpringRunner.class) //Telling Spring Test
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService businessService;
	@Test
	public void itemController_basic() throws Exception{
		// call /hello-world
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON); 
		MvcResult result = mockMvc
				.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\": 1,\"price\":10,\"name\":\"Ball\"}"))
				.andReturn();
		
		//verify /hello-world
		//assertEquals("Hello World", result.getResponse().getContentAsString());
	}
	
	@Test
	public void itemFromBusinessService_basic() throws Exception{
		// call /hello-world
		
		when(businessService.retrieveHardCodedtem()).thenReturn(new Item(2, "Bat", 2, 300));
		RequestBuilder request = MockMvcRequestBuilders
				.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON); 
		MvcResult result = mockMvc
				.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\": 2,\"price\":2,\"name\":\"Bat\"}"))
				.andReturn();
		
		//verify /hello-world
		//assertEquals("Hello World", result.getResponse().getContentAsString());
	}
	
	@Test
	public void retrieveAllItems_basic() throws Exception{
		// call /hello-world
		
		when(businessService.retrieveAllItems()).thenReturn(
				Arrays.asList(new Item(2, "Bat", 2, 300),
						new Item(3, "Bat", 3, 300)));
		RequestBuilder request = MockMvcRequestBuilders
				.get("/all-items-from-database")
				.accept(MediaType.APPLICATION_JSON); 
		MvcResult result = mockMvc
				.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"id\": 2,\"price\":2,\"name\":\"Bat\"}, {id: 3,price:3,name:Bat}]"))
				.andReturn();
		
		//verify /hello-world
		//assertEquals("Hello World", result.getResponse().getContentAsString());
	}

}
