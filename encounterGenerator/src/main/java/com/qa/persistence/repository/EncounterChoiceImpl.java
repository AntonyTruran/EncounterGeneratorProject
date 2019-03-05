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
import com.qa.utils.QuantityCalculator;

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
	@Inject
	private QuantityCalculator quantity;

	@Override
	public String randomCreature(String chosenTable) {
		roll = new DiceRoller();
		int chance = roll.dice(100);
		Query creature = manager.createQuery(
				"SELECT a FROM Creature c WHERE c.monsterKey =(SELECT a FROM EncounterChart mb WHERE mb.biomeKey = '"
						+ chosenTable + "' AND '" + chance + "' <= mb.maxChance AND '" + chance + "' >= mb.minChance");
		int numberOfCreatures = creatureQuantity(chosenTable,chance);
		return util.getJSONForObject(creature.getResultList()) + numberOfCreatures;
	}

	public int creatureQuantity(String chosenTable, int chance) {
		Query number = manager.createQuery("SELECT mb.number FROM EncounterChart mb WHERE mb.biomeKey = '"
				+ chosenTable + "' AND '" + chance + "' <= mb.maxChance AND '" + chance + "' >= mb.minChance");
		String extractedNumber = number.toString();
		return quantity.calculate(extractedNumber);
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

	@Transactional(REQUIRED)
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
}
