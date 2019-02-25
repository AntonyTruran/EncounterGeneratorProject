package com.qa.creatureTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.buisness.EncounterChoiceRules;
import com.qa.rest.CreatureEndpoint;
import com.qa.utils.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class CreatureEndpointTests {
	@InjectMocks
	private CreatureEndpoint endpoint;

	@Mock
	EncounterChoiceRules service;
	@Mock
	private JSONUtil util;

	private static final String MOCK_INPUT = "test";
	private static final String MOCK_OUTPUT = "test_output";

	@Before
	public void setUp() {
		endpoint.setService(service);
	}

	@Test
	public void randomCreatureTest() {
		Mockito.when(service.randomCreature(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, endpoint.randomCreature(MOCK_INPUT));
	}

	@Test
	public void searchByCreatureName() {
		Mockito.when(service.searchByName(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, endpoint.searchByName(MOCK_INPUT));
	}

	@Test
	public void searchByEnviroment() {
		Mockito.when(service.searchByEnviroment(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, endpoint.searchByEnviroment(MOCK_INPUT));
	}

	@Test
	public void searchByClimate() {
		Mockito.when(service.searchByClimate(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, endpoint.searchByClimate(MOCK_INPUT));
	}

	@Test
	public void searchByAlignment() {
		Mockito.when(service.searchByAlignment(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, endpoint.searchByAlignment(MOCK_INPUT));
	}

	@Test
	public void serchByRole() {
		Mockito.when(service.searchByRole(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, endpoint.searchByRole(MOCK_INPUT));
	}

	@Test
	public void searchByType() {
		Mockito.when(service.searchByType(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, endpoint.searchByType(MOCK_INPUT));
	}

	@Test
	public void addCreature() {
		Mockito.when(service.createCreature(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, endpoint.createCreature(MOCK_INPUT));
	}

	@Test
	public void deleteCreatureValid() {
		Mockito.when(service.deleteCreature(1)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, endpoint.deleteCreature(1));
	}

	@Test
	public void deleteCreatureInvalid() {
		Mockito.when(service.deleteCreature(1)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, endpoint.deleteCreature(1));
	}

	@Test
	public void testUpdateCreaturePart1() {
		Mockito.when(service.updateCreature(1, MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, endpoint.updateCreature(1, MOCK_INPUT));
	}

	@Test
	public void testUpdateCreaturePart2() {
		Mockito.when(service.updateCreature(1, MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, endpoint.updateCreature(1, MOCK_INPUT));
	}

	@Test
	public void testUpdateCreatureFailed() {
		Mockito.when(service.updateCreature(1, MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, endpoint.updateCreature(1, MOCK_INPUT));
	}
}
