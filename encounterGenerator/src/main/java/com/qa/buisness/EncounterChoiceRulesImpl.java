package com.qa.buisness;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.persistence.repository.EncounterChoice;

@Default
public class EncounterChoiceRulesImpl implements EncounterChoiceRules {

	@Inject
	EncounterChoice repo;

	public void setRepo(EncounterChoice repo) {
		this.repo = repo;
	}

	@Override
	public String searchByName(String creatureName) {
		return repo.searchByName(creatureName);
	}

	@Override
	public String searchByType(String chosenType) {
		return repo.searchByType(chosenType);
	}

	@Override
	public String randomCreature(String chosenTable) {
		return repo.randomCreature(chosenTable);
	}

	@Override
	public String searchByEnviroment(String chosenEnviroment) {
		return repo.searchByEnviroment(chosenEnviroment);
	}

	@Override
	public String searchByClimate(String chosenClimate) {
		return repo.searchByClimate(chosenClimate);
	}

	@Override
	public String searchByAlignment(String chosenAlignment) {
		return repo.searchByAlignment(chosenAlignment);
	}

	@Override
	public String searchByRole(String chosenRole) {
		return repo.searchByRole(chosenRole);
	}

	@Override
	public String createCreature(String creature) {
		return repo.createCreature(creature);
	}

	@Override
	public String deleteCreature(String id) {
		return repo.deleteCreature(id);
	}
 
	@Override
	public String updateCreature(String id, String creature) {
		return repo.updateCreature(id,creature);
	}
}
