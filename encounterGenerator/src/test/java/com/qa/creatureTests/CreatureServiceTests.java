package com.qa.creatureTests;

import static org.junit.Assert.assertEquals;

import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.buisness.EncounterChoiceRulesImpl;
import com.qa.persistence.repository.EncounterChoiceImpl;
import com.qa.utils.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class CreatureServiceTests {
	@InjectMocks
	private EncounterChoiceRulesImpl service;

	@Mock
	EncounterChoiceImpl repo;
	@Mock
	private Query query;
	@Mock
	private JSONUtil util;

	private static final String MOCK_INPUT = "test";
	private static final String MOCK_OUTPUT = "test_output";
	
	@Before
	public void setUp() {
		service.setRepo(repo);
	}

	@Test
	public void randomCreatureTest() {
		Mockito.when(repo.randomCreature(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.randomCreature(MOCK_INPUT));
	}

	@Test
	public void searchByCreatureName() {
		Mockito.when(repo.searchByName(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.searchByName(MOCK_INPUT));
	}

	@Test
	public void searchByEnviroment() {
		Mockito.when(repo.searchByEnviroment(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.searchByEnviroment(MOCK_INPUT));
	}

	@Test
	public void searchByClimate() {
		Mockito.when(repo.searchByClimate(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.searchByClimate(MOCK_INPUT));
	}

	@Test
	public void searchByAlignment() {
		Mockito.when(repo.searchByAlignment(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.searchByAlignment(MOCK_INPUT));
	}

	@Test
	public void serchByRole() {
		Mockito.when(repo.searchByRole(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.searchByRole(MOCK_INPUT));
	}

	@Test
	public void searchByType() {
		Mockito.when(repo.searchByType(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.searchByType(MOCK_INPUT));
	}

	@Test
	public void addCreature() {
		Mockito.when(repo.createCreature(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.createCreature(MOCK_INPUT));
	}

	@Test
	public void deleteCreatureValid() {
		Mockito.when(repo.deleteCreature(1)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.deleteCreature(1));
	}

	@Test
	public void deleteCreatureInvalid() {
		Mockito.when(repo.deleteCreature(1)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.deleteCreature(1));
	}

	@Test
	public void testUpdateCreaturePart1() {
		Mockito.when(repo.updateCreature(1, MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, repo.updateCreature(1, MOCK_INPUT));
	}

	@Test
	public void testUpdateCreaturePart2() {
		Mockito.when(repo.updateCreature(1, MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.updateCreature(1, MOCK_INPUT));
	}

	@Test
	public void testUpdateCreatureFailed() {
		Mockito.when(repo.updateCreature(1, MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.updateCreature(1, MOCK_INPUT));
	}
}
