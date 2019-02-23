package com.qa.encounterChartTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.buisness.EncounterChartService;
import com.qa.rest.EncounterChartEndpoint;
import com.qa.utils.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class EncounterChartEnpointTests {
	@InjectMocks
	EncounterChartEndpoint endpoint;
	@Mock
	EncounterChartService service;
	@Mock
	private JSONUtil util;

	private static final String MOCK_INPUT = "test";
	private static final String MOCK_OUTPUT = "test_output";
	
	@Before
	public void setUp() {
		endpoint.setService(service);
	}
	@Test
	public void getContentByChart() {
		Mockito.when(service.getContentByChart(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, endpoint.getContentByChart(MOCK_INPUT));
	}

	@Test
	public void newEncounterChart() {
		Mockito.when(service.newEncounterChart(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, endpoint.newEncounterChart(MOCK_INPUT));
	}

	@Test
	public void removeEncounterChart() {
		Mockito.when(service.removeEncounterChart("any", 1)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, endpoint.removeEncounterChart("any", 1));
	}

	@Test
	public void updateEncounterChart() {
		Mockito.when(service.updateEncounterChart("any",1, MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, endpoint.updateEncounterChart("any", 1, MOCK_INPUT));
	}
}

