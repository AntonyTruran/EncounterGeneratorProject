package com.qa.encounterChartTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.buisness.EncounterChartServiceImpl;
import com.qa.persistence.repository.EncounterChartRepository;
import com.qa.utils.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class EncoutnerChartServiceTests {
	@InjectMocks
	EncounterChartServiceImpl service;

	@Mock
	EncounterChartRepository repo;
	@Mock
	private JSONUtil util;

	private static final String MOCK_INPUT = "test";
	private static final String MOCK_OUTPUT = "test_output";

	@Before
	public void setUp() {
		service.setRepo(repo);
	}

	@Test
	public void getAllEncounterCharts() {
		Mockito.when(repo.getAllEncounterCharts()).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.getAllEncounterCharts());
	}

	@Test
	public void newEncounterChart() {
		Mockito.when(repo.newEncounterChart(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.newEncounterChart(MOCK_INPUT));
	}

	@Test
	public void removeEncounterChart() {
		Mockito.when(repo.removeEncounterChart("any")).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.removeEncounterChart("any"));
	}

	@Test
	public void updateEncounterChart() {
		Mockito.when(repo.updateEncounterChart("any", MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.updateEncounterChart("any", MOCK_INPUT));
	}
}
