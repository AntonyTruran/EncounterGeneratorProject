package com.qa.utils;

import javax.inject.Inject;

public class QuantityCalculator {

	@Inject
	private DiceRoller roll;

	public int calculate(String queryNumber) {
		roll = new DiceRoller();
		int quantity = 0;
		int numberOfDice = 1;
		if (queryNumber.contains("d")) {
			String[] randomAmount = queryNumber.split("d");
			int diceRequired = Integer.parseInt(randomAmount[0]);
			int diceType = Integer.parseInt(randomAmount[1]);
			while (numberOfDice <= diceRequired) {
				quantity += roll.dice(diceType);
				numberOfDice++;
			}
		} else {
			try {
			quantity = Integer.parseInt(queryNumber);
			}catch(NumberFormatException e) {
				return quantity;
			}
		}
		return quantity;
	}
}