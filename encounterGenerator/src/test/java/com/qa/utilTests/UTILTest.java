package com.qa.utilTests;

import junit.framework.TestCase;
import org.junit.Test;

import com.qa.utils.DiceRoller;
import com.qa.utils.QuantityCalculator;

public class UTILTest extends TestCase {

	DiceRoller roller;
	QuantityCalculator quant;

	@Test
	public void testDiceChooser() {
		roller = new DiceRoller();
		assertTrue(roller.dice(4) >= 1 && roller.dice(4) <= 4);
		assertTrue(roller.dice(6) >= 1 && roller.dice(6) <= 6);
		assertTrue(roller.dice(8) >= 1 && roller.dice(8) <= 8);
		assertTrue(roller.dice(10) >= 1 && roller.dice(10) <= 10);
		assertTrue(roller.dice(12) >= 1 && roller.dice(12) <= 12);
		assertTrue(roller.dice(20) >= 1 && roller.dice(20) <= 20);
		assertTrue(roller.dice(100) >= 1 && roller.dice(100) <= 100);
	}

	@Test
	public void testQuantityCalculator() {
		quant = new QuantityCalculator();
		assertEquals(1, quant.calculate("1"));
		assertTrue(quant.calculate("2d4") >= 2 && quant.calculate("2d4") <= 8);
		assertTrue(quant.calculate("3d10") >= 3 && quant.calculate("3d10") <= 30);
	}
}