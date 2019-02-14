package com.qa.tests;

import com.qa.persistence.domain.Creature;
import com.qa.persistence.repository.EncounterChoiceImpl;
import com.qa.utils.DiceRoller;
import com.qa.utils.JSONUtil;

import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
@RunWith(MockitoJUnitRunner.class)
public class AppTest extends TestCase {
	
	DiceRoller roller;
    EncounterChoiceImpl choice;
    Creature creature;
    @InjectMocks
	private EncounterChoiceImpl repo;
	@Mock
	private EntityManager manager;
	@Mock
	private Query query;
	private JSONUtil util;
    
	
	@Before
	public void setup() {
    choice = new EncounterChoiceImpl();
    creature = new Creature("Terrasque",25, "1","fin",
            "95-100", "abberation","any","any","N","boss");
    repo.setManager(manager);
	util = new JSONUtil();
	repo.setUtil(util);
	}
    @Test
    public void testListsInitialised(){
        assertTrue(choice.encounterTable.isEmpty());
        assertTrue(creature.tables.isEmpty());
    }
    @Test
    public void testDiceChooser(){
    	roller = new DiceRoller();
    	assertTrue(roller.dice("d4")>=1);
    	assertTrue(roller.dice("d4")>=4);
    	assertTrue(roller.dice("d6")>=1);
    	assertTrue(roller.dice("d6")>=6);
        assertTrue(roller.dice("d8")>=1);
        assertTrue(roller.dice("d8")>=8);
        assertTrue(roller.dice("d10")>=1);
        assertTrue(roller.dice("d10")>=10);
        assertTrue(roller.dice("d12")>=1);
        assertTrue(roller.dice("d12")>=12);
        assertTrue(roller.dice("d20")>=1);
        assertTrue(roller.dice("d20")>=20);
        assertTrue(roller.dice("d100")>=1);
        assertTrue(roller.dice("d100")>=100);
    }
    
    @Test
    public void testLibraryContentsNew() {
    	}
    // test cr calculator hashmap of creature range (6-8 split on "-")
}