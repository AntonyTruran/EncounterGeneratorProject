package com.qa.tests;

import com.qa.domain.Creature;
import com.qa.utils.DiceRoller;
import com.qa.buisness.EncounterChoice;
import junit.framework.TestCase;
import org.junit.Test;

public class AppTest extends TestCase {
    DiceRoller roller = new DiceRoller();
    EncounterChoice choice = new EncounterChoice();
    Creature creature = new Creature("Terrasque",25, "1","fin",
            "95-100", "abberation","any","any","N");
    @Test
    public void testListsInitialised(){
        assertTrue(choice.table.isEmpty());
        assertTrue(creature.tables.isEmpty());
    }
    @Test
    public void testDiceChooser(){
        assertEquals(4,roller.dice("d4"));
        assertEquals(6,roller.dice("d6"));
        assertEquals(8,roller.dice("d8"));
        assertEquals(10,roller.dice("d10"));
        assertEquals(12,roller.dice("d12"));
        assertEquals(20,roller.dice("d20"));
        assertEquals(100,roller.dice("d100"));
    }
    @Test
    public void testLibraryContentsNew() {
        assertEquals(true, choice.toArray(new Creature("Terrasque",25, "1","fin",
                "95-100", "abberation","any","any","N")));//good input integer for number of creatures
        assertEquals(true, choice.toArray(new Creature("Terrasque",25, "2 d6","fin",
                "95-100", "abberation","any","any","N")));//good imput string for number of creatures (2 d4)
    }
    // test cr calculator hashmap of creature range (6-8 split on "-")
}