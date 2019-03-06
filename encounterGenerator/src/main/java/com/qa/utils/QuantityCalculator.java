package com.qa.utils;

import javax.inject.Inject;

public class QuantityCalculator {

	@Inject
	private DiceRoller roll;

	public int calculate(String queryNumber) {
		roll = new DiceRoller();
		int quantity = 0;
		int numberOfDice = 1;
		int diceRequired = 0;
		int diceType = 0;
		Character extracted;
		String extractedString;
		
		try {
			quantity = Integer.parseInt(queryNumber);
			return quantity;
		} catch (NumberFormatException e1) {
			try {
				extracted = queryNumber.charAt(0);
				extractedString = extracted.toString();
				diceRequired = Integer.parseInt(extractedString);
			} catch (NumberFormatException e2) {
				System.out.println("error two");
			}
			try {
				extracted = queryNumber.charAt(2);
				extractedString = extracted.toString();
				diceType = Integer.parseInt(extractedString);
			} catch (NumberFormatException e3) {
				System.out.println("error three");
			}
			while (numberOfDice <= diceRequired) {
				quantity += roll.dice(diceType);
				numberOfDice++;
			}
		}
		return quantity;
	}
}