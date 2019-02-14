package com.qa.buisness;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.persistence.repository.EncounterChoiceImpl;

@Default
public class EncounterChoiceRulesImpl implements EncounterChoiceRules {

	@Inject
	EncounterChoiceImpl repo;
	@Override
	public String randomCreature(String chosenTable) {
		return repo.randomCreature(chosenTable);
	}

}
