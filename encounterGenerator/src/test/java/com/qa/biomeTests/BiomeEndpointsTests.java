package com.qa.biomeTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.buisness.BiomeService;
import com.qa.rest.BiomeEndpoint;
import com.qa.utils.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class BiomeEndpointsTests {

	@InjectMocks
	BiomeEndpoint endpoint;
	@Mock
	BiomeService service;
	@Mock
	private JSONUtil util;

	private static final String MOCK_INPUT = "test";
	private static final String MOCK_OUTPUT = "test_output";
	
	@Before
	public void setUp() {
		endpoint.setService(service);
	}
	@Test
	public void getAllBiomes() {
		Mockito.when(service.getAllBiomes()).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, endpoint.getAllBiomes());
	}

	@Test
	public void newBiome() {
		Mockito.when(service.newBiome(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, endpoint.newBiome(MOCK_INPUT));
	}

	@Test
	public void removeBiome() {
		Mockito.when(service.removeBiome("any")).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, endpoint.removeBiome("any"));
	}

	@Test
	public void updateBiome() {
		Mockito.when(service.updateBiome("any", MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, endpoint.updateBiome("any", MOCK_INPUT));
	}
}
