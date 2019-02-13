package com.qa.buisness;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.persistence.repository.EncounterChoice;

@Default
public class EncounterChoiceRulesImpl implements EncounterChoiceRules {

	@Inject
	EncounterChoice repo;
	@Override
	public String randomCreature() {
		return repo.randomCreature();
	}

}
