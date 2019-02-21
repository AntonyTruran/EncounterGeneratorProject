package com.qa.encounterChartTests;

import static org.junit.Assert.assertEquals;

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
	public void getContentByChart() {
		Mockito.when(repo.getContentByChart(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.getContentByChart(MOCK_INPUT));
	}

	@Test
	public void newEncounterChart() {
		Mockito.when(repo.newEncounterChart(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.newEncounterChart(MOCK_INPUT));
	}

	@Test
	public void removeEncounterChart() {
		Mockito.when(repo.removeEncounterChart("any", null)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.removeEncounterChart("any", null));
	}

	@Test
	public void updateEncounterChart() {
		Mockito.when(repo.updateEncounterChart(MOCK_INPUT, MOCK_INPUT, MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.updateEncounterChart(MOCK_INPUT, MOCK_INPUT, MOCK_INPUT));
	}
}
