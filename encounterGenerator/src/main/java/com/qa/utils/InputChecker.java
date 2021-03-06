package com.qa.utils;

public class InputChecker {
	private static String[] bannedWords = { "SELECT", "DROP", "CREATE", "DELETE", "INSERT", "*", "\'", ";" };

	public String validityCheck(String jsonInput) {
		String checkedInput = "valid";
		for (String word : bannedWords) {
			if (jsonInput.contains(word)) {
				checkedInput = "invlaid";
			}
		}
		return checkedInput;
	}
}
