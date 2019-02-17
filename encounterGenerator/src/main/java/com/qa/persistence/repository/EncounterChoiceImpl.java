package com.qa.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import static javax.transaction.Transactional.TxType.REQUIRED;

import com.qa.persistence.domain.Creature;
import com.qa.utils.DiceRoller;
import com.qa.utils.JSONUtil;

@Default
@Transactional(SUPPORTS)
public class EncounterChoiceImpl implements EncounterChoice {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	public void setRoll(DiceRoller roll) {
		this.roll = roll;
	}

	@Inject
	private JSONUtil util;
	@Inject
	private DiceRoller roll;

	@Override
	public String randomCreature(String chosenTable) {
		int chance = roll.dice("d100");
		Query creature = manager.createQuery(
				"SELECT a FROM Creature c WHERE c.monster_id =(SELECT a FROM monster_biome mb WHERE mb.biome_key = '"
						+ chosenTable + "' AND '" + chance + "' <= mb.max AND '" + chance + "' >= mb.min");
//		Query query2 = manager.createQuery("SELECT toString(mb.quantity) FROM monster_biome mb WHERE mb.biome_key = '"
//+ chosenTable + "' AND '" + chance + "' >= mb.min AND '" + chance + "' <= mb.max");
//		int numberOfCreatures = 1;
//		try {
//			numberOfCreatures = query2.getFirstResult();
//		}catch() {
//			String[] output= query2.getSingleResult().splitString("d");
//		}
		// generate number of creatures select number from mb where monster key = chance
		// try to parse the number, if fail split sting parse both and calculate (while i < numberOfDice) {numberOfCreature += roll.dice(diceType)}
		return util.getJSONForObject(creature.getResultList());//+numberOfCreatures);
	}

	@Override
	public String searchByName(String creatureName) {
		return util.getJSONForObject(manager.find(Creature.class, creatureName));
	}

	@Override
	public String searchByEnviroment(String chosenEnviroment) {
		return util.getJSONForObject(manager.find(Creature.class, chosenEnviroment));
	}

	@Override
	public String searchByClimate(String chosenClimate) {
		return util.getJSONForObject(manager.find(Creature.class, chosenClimate));
	}

	@Override
	public String searchByAlignment(String chosenAlignment) {
		return util.getJSONForObject(manager.find(Creature.class, chosenAlignment));
	}

	@Override
	public String searchByRole(String chosenRole) {
		return util.getJSONForObject(manager.find(Creature.class, chosenRole));
	}

	@Override
	public String searchByType(String chosenType) {
		return util.getJSONForObject(manager.find(Creature.class, chosenType));
	}

	@Transactional(REQUIRED)
	@Override
	public String createCreature(String creature) {
		Creature newCreature = util.getObjectForJSON(creature, Creature.class);
		manager.persist(newCreature);
		return "{\"message\": \"creature has been successfully created\"}";
	}

	@Override
	public String deleteCreature(int id) {
		if (manager.contains(manager.find(Creature.class, id))) {
			manager.remove(manager.find(Creature.class, id));
			return "{\"message\": \"creature has been successfully deleted\"}";
		}
		return "{\"message\": \"invalid creature number\"}";
	}

	@Transactional(REQUIRED)
	@Override
	public String updateCreature(int id, String creature) {
		Creature aCreature = util.getObjectForJSON(creature, Creature.class);
		if (manager.contains(manager.find(Creature.class, id))) {
			manager.merge(aCreature);
			return "{\"message\": \"the creature has been successfully updated\"}";
		}
		return "{\"message\": \"no such creature\"}";
	}

	public String getATrainee(String trainee) {
		return util.getJSONForObject(manager.find(Creature.class, trainee));
}

}
