package com.qa.buisness;

public interface EncounterChoiceRules {
	//R
	String randomCreature(String chosenTable);

	String searchByName(String creatureName);
	
	String searchByEnviroment(String chosenEnviroment);

	String searchByClimate(String chosenClimate);

	String searchByAlignment(String chosenAlignment);

	String searchByRole(String chosenRole);

	String searchByType(String chosenType);
	//C
	String createCreature(String creature);

	//D
	String deleteCreature(int id);

	//U
	String updateCreature(int id, String creature);	
}
