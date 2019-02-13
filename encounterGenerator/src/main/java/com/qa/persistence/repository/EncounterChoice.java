package com.qa.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import com.qa.persistence.domain.Creature;
import com.qa.utils.DiceRoller;
import com.qa.utils.JSONUtil;

@Transactional(SUPPORTS)
public class EncounterChoice {
	public 
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	@Inject
	private DiceRoller dice;

	public String randomCreature(String chosenTable) {
		int creatureChance = chance(dice);
		List<Object> encounterTable = toArray(chosenTable);
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

	private String toArray(String chosenTable) {
		Query queries = manager.createQuery("SELECT a FROM Creature c WHERE c.monster_id =(SELECT a FROM monster_biome mb WHERE mb.biome_key ="chosenTable));
//		encounterTable.add(queries);
		return queries.toString();
	}

	private int chance(DiceRoller roll) {
		int creatureChance = roll.dice("d100");
		return creatureChance;
	}
}
