package com.qa.creatureTests;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Creature;
import com.qa.persistence.repository.EncounterChoice;
import com.qa.persistence.repository.EncounterChoiceImpl;
import com.qa.utils.DiceRoller;
import com.qa.utils.JSONUtil;

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

	@Inject
	DiceRoller roller;
	@Inject
	Creature creature;

	private static final String MOCK_TABLE_ROW = "[{\"name\":\"Terrasque\",\"CR\":\"25\",\"number\":\"1\",\"type\":\"abberation\",\"enviroment\":\"any\",\"climate\":\"any\",\"alignment\":\"N\",\"role\":\"boss\"}]";
	private static final String MOCK_ENTRY = "{\"name\":\"Terrasque\",\"CR\":\"25\",\"number\":\"1\",\"type\":\"abberation\",\"type\":\"any\",\"climate\":\"any\",\"alignment\":\"N\",\"role\":\"boss\"}";

	@Before
	public void setup() {
		repo.setManager(manager);
		repo.setUtil(util);
	}

	@Test
	public void randomCreatureTest() {
		
	}

	@Test
	public void searrchByCreatureName() {
		Creature mockCreature = new Creature(MOCK_ENTRY);
		Mockito.when(manager.find(Mockito.anyObject(), Mockito.anyString())).thenReturn(mockCreature);
		assertEquals(MOCK_ENTRY, repo.getCreatureByName("Terrasque"));
	}

	@Test
	public void searrchByEnviroment() {
		Creature mockCreature = new Creature(MOCK_ENTRY);
		Mockito.when(manager.find(Mockito.anyObject(), Mockito.anyString())).thenReturn(mockCreature);
		assertEquals(MOCK_ENTRY, repo.getCreatureByEnviroment("any"));
	}

	@Test
	public void searrchByClimate() {
		Creature mockCreature = new Creature(MOCK_ENTRY);
		Mockito.when(manager.find(Mockito.anyObject(), Mockito.anyString())).thenReturn(mockCreature);
		assertEquals(MOCK_ENTRY, repo.getCreatureByClimate("any"));
	}

	@Test
	public void searchByAlignment() {
		Creature mockCreature = new Creature(MOCK_ENTRY);
		Mockito.when(manager.find(Mockito.anyObject(), Mockito.anyString())).thenReturn(mockCreature);
		assertEquals(MOCK_ENTRY, repo.getCreatureByAlignment("N"));
	}

	@Test
	public void serchByRole() {
		Creature mockCreature = new Creature(MOCK_ENTRY);
		Mockito.when(manager.find(Mockito.anyObject(), Mockito.anyString())).thenReturn(mockCreature);
		assertEquals(MOCK_ENTRY, repo.getCreatureByRole("boss"));

	}

	@Test
	public void searchByType() { 
	Creature mockCreature = new Creature(MOCK_ENTRY);
	Mockito.when(manager.find(Mockito.anyObject(), Mockito.anyString())).thenReturn(mockCreature);
	assertEquals(MOCK_ENTRY, repo.getCreatureByType("abberation"));
	}

	@Test
	public void addCreature() {
		assertEquals("{\"message\": \"creature has been sucessfully created\"}", repo.createCreature(MOCK_ENTRY));
	}

	@Test
	public void deleteCreatureValid() {
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(true);
		assertEquals("{\"message\": \"creature has been sucessfully updated\"}", repo.deleteCreature(1L));
	}

	@Test
	public void deleteCreatureInvalid() {
		assertEquals("{\"message\": \"invalid creature number\"}", repo.deleteCreature("1L"));
	}

	@Test
	public void testUpdateAccountPart1() {
		String updatedCreature = "{\"id\":\"111111\"}";
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(true);
		Mockito.when(manager.find(Mockito.any(), Mockito.anyLong())).thenReturn();
		assertEquals("{\"message\": \"account has been sucessfully updated\"}",
				repo.updateCreature(1L, updatedCreature));
	}

	@Test
	public void testUpdateAccountPart2() {
		String updatedCreature = "{\"name\":\"Terrasque\",\"CR\":\"25\",\"number\":\"2\",\"type\":\"abberation\",\"type\":\"any\",\"climate\":\"any\",\"alignment\":\"N\",\"role\":\"boss\"}";
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(true);
		Mockito.when(manager.find(Mockito.any(), Mockito.anyInt())).thenReturn();
		assertEquals("{\"message\": \"account has been sucessfully updated\"}",
				repo.updateCreature(1L, updatedCreature));
	}

	@Test
	public void testUpdateAccountFailed() {
		String updatedCreature = "{\"name\":\"Terrasque\",\"CR\":\"25\",\"number\":\"2\",\"type\":\"abberation\",\"type\":\"any\",\"climate\":\"any\",\"alignment\":\"N\",\"role\":\"boss\"}";
		assertEquals("{\"message\": \"no such account\"}", repo.updateCreature(5L, updatedCreature));
	}
}
