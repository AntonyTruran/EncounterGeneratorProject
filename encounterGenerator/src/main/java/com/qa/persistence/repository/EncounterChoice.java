package com.qa.persistence.repository;

public interface EncounterChoice {

	// R
	String randomCreature(String chosenTable);

	String searchByName(String creatureName);

	String searchByEnviroment(String chosenEnviroment);

	String searchByClimate(String chosenClimate);

	String searchByAlignment(String chosenAlignment);

	String searchByRole(String chosenRole);

	String searchByType(String chosenType);

	// C
	String createCreature(String creature);

	// D
	String deleteCreature(String id);

	// U
	String updateCreature(String id, String creature);
}
