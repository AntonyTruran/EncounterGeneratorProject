package com.qa.creatureTests;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Biome;
import com.qa.persistence.domain.Creature;
import com.qa.persistence.repository.EncounterChoiceImpl;
import com.qa.utils.DiceRoller;
import com.qa.utils.JSONUtil;
import com.qa.utils.QuantityCalculator;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class CreaturePersistenceTests extends TestCase {

	@InjectMocks
	private EncounterChoiceImpl repo;

	@Mock
	private EntityManager manager;
	@Mock
	private Query query;
	@Mock
	private JSONUtil util;
	@Mock
	private QuantityCalculator quantity;

	@Inject
	DiceRoller roller;
	@Inject
	Creature creature;

	private static final String MOCK_TABLE_ROW = "[{\"creatureName\":\"Terrasque\",\"challengeRating\":\"25\",\"type\":\"abberation\",\"environment\":\"any\",\"climate\":\"any\",\"alignment\":\"N\",\"combatRole\":\"boss\",\"chartEntries\":[]}]";
	private static final String MOCK_ENCOUNTER = "[{\"creatureName\":\"Terrasque\",\"challengeRating\":\"25\",\"type\":\"abberation\",\"environment\":\"any\",\"climate\":\"any\",\"alignment\":\"N\",\"combatRole\":\"boss\",\"chartEntries\":[]}][{\"number\":5}]";
	private static final String MOCK_ENTRY = "{\"creatureName\":\"Terrasque\",\"challengeRating\":\"25\",\"type\":\"abberation\",\"environment\":\"any\",\"climate\":\"any\",\"alignment\":\"N\",\"combatRole\":\"boss\",\"chartEntries\":[]}";
	private static final String NUMERIC_INPUT = "2d4";
	private static final String MOCK_ITEM = "goblins";

	@Before
	public void setUp() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

//	@Test
//	public void randomCreatureTest() {
//		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
//		Mockito.when(repo.creatureQuantity("any",20)).thenReturn(5);
//		List<Creature> mockCreatues = new ArrayList<Creature>();
//		mockCreatues.add(new Creature("Terrasque", "25", "abberation", "any", "any", "N", "boss"));
//		Mockito.when(query.getResultList()).thenReturn(mockCreatues);
//		assertEquals(MOCK_ENCOUNTER, repo.randomCreature("any"));
//	}
//	@Test
//	public void creaturQuantityTest() {
//		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
//		Mockito.when(query.getSingleResult()).thenReturn(NUMERIC_INPUT);
//		Mockito.when(quantity.calculate(NUMERIC_INPUT)).thenReturn(0);
//		assertEquals("incorrect number returned",0,repo.creatureQuantity("any", 20));
//	}
//
//	@Test
//	public void searchByCreatureName() {
//		Creature mockCreature = new Creature("Terrasque", "25", "abberation", "any", "any", "N", "boss");
//		Mockito.when(manager.find(Mockito.anyObject(), Mockito.anyString())).thenReturn(mockCreature);
//		assertEquals(MOCK_ENTRY, repo.searchByName("Terrasque"));
//	}
//
//	@Test
//	public void searchByEnviroment() {
//		//Creature mocked = new Creature("Terrasque", "25", "abberation", "any", "any", "N", "boss");
//		Creature mocked = util.getObjectForJSON(MOCK_ENTRY, Creature.class);
//		List<Creature> mockCreatures = new ArrayList<Creature>();
//		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
//		mockCreatures.add(mocked);
//		Mockito.when(query.getResultList()).thenReturn(mockCreatures);
//		assertEquals(MOCK_TABLE_ROW, repo.searchByEnviroment("any"));
//	}
//
//	@Test
//	public void searchByClimate() {
//		Creature mocked = util.getObjectForJSON(MOCK_ENTRY, Creature.class);
//		List<Creature> mockCreatures = new ArrayList<Creature>();
//		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
//		mockCreatures.add(mocked);
//		Mockito.when(query.getResultList()).thenReturn(mockCreatures);
//		assertEquals(MOCK_TABLE_ROW, repo.searchByClimate("any"));
//	}
//
//	@Test
//	public void searchByAlignment() {
//		Creature mocked = util.getObjectForJSON(MOCK_ENTRY, Creature.class);
//		List<Creature> mockCreatures = new ArrayList<Creature>();
//		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
//		mockCreatures.add(mocked);
//		Mockito.when(query.getResultList()).thenReturn(mockCreatures);
//		assertEquals(MOCK_TABLE_ROW, repo.searchByAlignment("N"));
//	}
//
//	@Test
//	public void serchByRole() {
//		Creature mocked = util.getObjectForJSON(MOCK_ENTRY, Creature.class);
//		List<Creature> mockCreatures = new ArrayList<Creature>();
//		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
//		mockCreatures.add(mocked);
//		Mockito.when(query.getResultList()).thenReturn(mockCreatures);
//		assertEquals(MOCK_TABLE_ROW, repo.searchByRole("boss"));
//
//	}
//
//	@Test
//	public void searchByType() {
//		Creature mocked = util.getObjectForJSON(MOCK_ENTRY, Creature.class);
//		List<Creature> mockCreatures = new ArrayList<Creature>();
//		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
//		mockCreatures.add(mocked);
//		Mockito.when(query.getResultList()).thenReturn(mockCreatures);
//		assertEquals(MOCK_TABLE_ROW, repo.searchByType("abberation"));
//	}

	@Test
	public void addCreature() {
		assertEquals("{\"message\": \"creature has been successfully created\"}", repo.createCreature(MOCK_ENTRY));
	}

	@Test
	public void deleteCreatureValid() {
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(true);
		assertEquals("{\"message\": \"creature has been successfully deleted\"}", repo.deleteCreature(MOCK_ITEM));
	}

	@Test
	public void deleteCreatureInvalid() {
		assertEquals("{\"message\": \"invalid creature number\"}", repo.deleteCreature(MOCK_ITEM));
	}

	@Test
	public void testUpdateCreaturePart1() {
		String updatedCreature = "{\"id\":\"111111\"}";
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(true);
		Mockito.when(manager.find(Mockito.any(), Mockito.anyLong())).thenReturn(updatedCreature);
		assertEquals("{\"message\": \"the creature has been successfully updated\"}",
				repo.updateCreature(MOCK_ITEM, updatedCreature));
	}

	@Test
	public void testUpdateCreaturePart2() {
		String updatedCreature = "{\"name\":\"Terrasque\",\"CR\":\"25\",\"number\":\"2\",\"type\":\"abberation\",\"type\":\"any\",\"climate\":\"any\",\"alignment\":\"N\",\"role\":\"boss\"}";
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(true);
		Mockito.when(manager.find(Mockito.any(), Mockito.anyInt())).thenReturn(updatedCreature);
		assertEquals("{\"message\": \"the creature has been successfully updated\"}",
				repo.updateCreature(MOCK_ITEM, updatedCreature));
	}

	@Test
	public void testUpdateAccountFailed() {
		String updatedCreature = "{\"name\":\"Terrasque\",\"CR\":\"25\",\"number\":\"2\",\"type\":\"abberation\",\"type\":\"any\",\"climate\":\"any\",\"alignment\":\"N\",\"role\":\"boss\"}";
		assertEquals("{\"message\": \"no such creature\"}", repo.updateCreature(MOCK_ITEM, updatedCreature));
	}
}
