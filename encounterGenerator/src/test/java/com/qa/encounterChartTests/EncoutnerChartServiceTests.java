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
import com.qa.utils.InputChecker;
import com.qa.utils.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class EncoutnerChartServiceTests {
	@InjectMocks
	EncounterChartServiceImpl service;

	@Mock
	EncounterChartRepository repo;
	@Mock
	private JSONUtil util;
	@Mock
	private InputChecker inputChecker;

	private static final String MOCK_INPUT = "test";
	private static final String MOCK_OUTPUT = "test_output";
	private static final String INVALID_INPUT = "SELECT * FROM *";
	private static final String INVALID_OUTPUT = "{\"message\":\"the input included banned words\"}";

	@Before
	public void setUp() {
		service.setRepo(repo);
		inputChecker = new InputChecker();
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
	public void testInvalidNewChart() {
		Mockito.when(inputChecker.validityCheck(INVALID_INPUT)).thenReturn("invalid");
		Mockito.when(repo.newEncounterChart(INVALID_INPUT)).thenReturn(INVALID_OUTPUT);
		assertEquals(INVALID_OUTPUT, service.newEncounterChart(INVALID_INPUT));
	}

	@Test
	public void removeEncounterChart() {
		Mockito.when(repo.removeEncounterChart("any", "bats")).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.removeEncounterChart("any", "bats"));
	}

	@Test
	public void testInvalidRemoveChart() {
		Mockito.when(inputChecker.validityCheck("SELECT")).thenReturn("invalid");
		Mockito.when(repo.removeEncounterChart(INVALID_INPUT, "bats")).thenReturn(INVALID_OUTPUT);
		assertEquals(INVALID_OUTPUT, service.removeEncounterChart(INVALID_INPUT, "bats"));
	}

	@Test
	public void updateEncounterChart() {
		Mockito.when(repo.updateEncounterChart(MOCK_INPUT, "bats", MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.updateEncounterChart(MOCK_INPUT, "bats", MOCK_INPUT));
	}

	@Test
	public void testInvalidUpdateChart() {
		Mockito.when(inputChecker.validityCheck(INVALID_INPUT)).thenReturn("invalid");
		Mockito.when(repo.updateEncounterChart(INVALID_INPUT, "bats", INVALID_INPUT)).thenReturn(INVALID_OUTPUT);
		assertEquals(INVALID_OUTPUT, service.updateEncounterChart(INVALID_INPUT, "bats", INVALID_INPUT));
	}

}
