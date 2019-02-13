package com.qa.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import com.qa.persistence.domain.Creature;
import com.qa.utils.DiceRoller;
import com.qa.utils.JSONUtil;

@Transactional(SUPPORTS)
public class EncounterChoice {
	public List<Object> encounterTable = new ArrayList();
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	@Inject
	private DiceRoller dice;

	public String randomCreature() {
		// scanner for now then send to from table method
		String creature = "unknown";
		int creatureChance = chance(dice);
		for (Object monster : encounterTable) {
			// find a way to draw the chance range out to be split or substring
			// could use range array and split before using parse int
			// int min = monster.getChanceRange.substring(" ");
			// int max = monster.getChanceRange.substring(" ");
			// SPLIT THE STING AT " " THEN parse int
			if (creatureChance >= min() && creatureChance <= max()) {

			}
		}
		return util.getJSONForObject(creature);
	}

	private String toArray(Creature creature) {
		encounterTable.add(creature);
		return "Array filled";
	}

	private int chance(DiceRoller roll) {
		int creatureChance = roll.dice("d100");
		return creatureChance;
	}
}
