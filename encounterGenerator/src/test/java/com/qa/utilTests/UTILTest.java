package com.qa.utilTests;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.qa.utils.DiceRoller;
import com.qa.utils.QuantityCalculator;

public class UTILTest extends TestCase {

	DiceRoller roller;
	QuantityCalculator quant;
	//BannedWordsList words;

	@Before
	public void setUp() {
		roller = new DiceRoller();
		quant = new QuantityCalculator();
		//words = new BannedWordsList();
	}

	@Test
	public void testDiceChooser() {
		assertTrue("d4 broken",roller.dice(4) >= 1 && roller.dice(4) <= 4);
		assertTrue("d6 broken",roller.dice(6) >= 1 && roller.dice(6) <= 6);
		assertTrue("d8 broken",roller.dice(8) >= 1 && roller.dice(8) <= 8);
		assertTrue("d10 broken",roller.dice(10) >= 1 && roller.dice(10) <= 10);
		assertTrue("d12 broken",roller.dice(12) >= 1 && roller.dice(12) <= 12);
		assertTrue("d20 broken",roller.dice(20) >= 1 && roller.dice(20) <= 20);
		assertTrue("d100 broken",roller.dice(100) >= 1 && roller.dice(100) <= 100);
	}

	@Test
	public void testQuantityCalculator() {
		assertEquals(1, quant.calculate("1"));
		assertTrue(quant.calculate("2d4") >= 2 && quant.calculate("2d4") <= 8);
		assertTrue(quant.calculate("3d10") >= 3 && quant.calculate("3d10") <= 30);
	}
}