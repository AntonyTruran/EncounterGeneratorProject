package com.qa.buisness;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.persistence.repository.EncounterChoice;
import com.qa.persistence.repository.EncounterChoiceImpl;

@Default
public class EncounterChoiceRulesImpl implements EncounterChoiceRules {

	@Inject
	EncounterChoice repo;

	public void setRepo(EncounterChoice repo) {
		this.repo = repo;
	}

	@Override
	public String searchByName(String creatureName) {
		// TODO Auto-generated method stub
		return repo.searchByName(creatureName);
	}

	@Override
	public String searchByType(String chosenType) {
		// TODO Auto-generated method stub
		return repo.searchByType(chosenType);
	}

	@Override
	public String randomCreature(String chosenTable) {
		return repo.randomCreature(chosenTable);
	}

	@Override
	public String searchByEnviroment(String chosenEnviroment) {
		// TODO Auto-generated method stub
		return repo.searchByEnviroment(chosenEnviroment);
	}

	@Override
	public String searchByClimate(String chosenClimate) {
		// TODO Auto-generated method stub
		return repo.searchByClimate(chosenClimate);
	}

	@Override
	public String searchByAlignment(String chosenAlignment) {
		// TODO Auto-generated method stub
		return repo.searchByAlignment(chosenAlignment);
	}

	@Override
	public String searchByRole(String chosenRole) {
		// TODO Auto-generated method stub
		return repo.searchByRole(chosenRole);
	}

	@Override
	public String createCreature(String creature) {
		// TODO Auto-generated method stub
		return repo.createCreature(creature);
	}

	@Override
	public String deleteCreature(int id) {
		// TODO Auto-generated method stub
		return repo.deleteCreature(id);
	}
 
	@Override
	public String updateCreature(int id, String account) {
		// TODO Auto-generated method stub
		return repo.updateCreature(id,account);
	}
}
