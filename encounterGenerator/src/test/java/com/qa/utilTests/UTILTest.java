package com.qa.utilTests;

import junit.framework.TestCase;
import org.junit.Test;

import com.qa.utils.DiceRoller;

public class UTILTest extends TestCase {
	
	DiceRoller roller;
    @Test
    public void testDiceChooser(){
    	roller = new DiceRoller();
    	assertTrue(roller.dice("d4")>=1);
    	assertTrue(roller.dice("d4")<=4);
    	assertTrue(roller.dice("d6")>=1);
    	assertTrue(roller.dice("d6")<=6);
        assertTrue(roller.dice("d8")>=1);
        assertTrue(roller.dice("d8")<=8);
        assertTrue(roller.dice("d10")>=1);
        assertTrue(roller.dice("d10")<=10);
        assertTrue(roller.dice("d12")>=1);
        assertTrue(roller.dice("d12")<=12);
        assertTrue(roller.dice("d20")>=1);
        assertTrue(roller.dice("d20")<=20);
        assertTrue(roller.dice("d100")>=1);
        assertTrue(roller.dice("d100")<=100);
    }
}