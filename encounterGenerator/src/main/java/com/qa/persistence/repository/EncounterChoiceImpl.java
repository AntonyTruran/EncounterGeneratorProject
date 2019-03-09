package com.qa.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

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
				"SELECT a.creatureName, a.challengeRating, a.type, a.environment, a.climate, a.alignment, a.combatRole FROM Creature a WHERE a.creatureName =(SELECT ec.monsterKey FROM EncounterChart ec WHERE biomeKey like :chosenTable AND maxChance >= :chance AND minChance <= :chance)")
				.setParameter("chosenTable", chosenTable).setParameter("chance", chance);
		Collection<Creature> creatures = (Collection<Creature>) creature.getResultList();
		String numberOfCreatures = "{\"quantity\": " + creatureQuantity(chosenTable, chance) + "}";
		return util.getJSONForObject(creatures) + numberOfCreatures;
	}

	public int creatureQuantity(String chosenTable, int chance) {
		Query number = manager.createQuery(
				"SELECT ec.number FROM EncounterChart ec WHERE biomeKey like :chosenTable AND maxChance >= :chance AND minChance <= :chance")
				.setParameter("chosenTable", chosenTable).setParameter("chance", chance);
		try {
			Object extractedNumber = number.getSingleResult();
			System.out.println();
			String extracted = extractedNumber.toString();
			System.out.println(extracted);
			System.out.println(extracted);
			return quantity.calculate(extracted);
		} catch (NoResultException e) {
			return 0;
		}
	}

	@Override
	public String searchByName(String creatureName) {
		return util.getJSONForObject(manager.find(Creature.class, creatureName));
	}

	@Override
	public String searchByEnviroment(String chosenEnviroment) {
		Query query = manager.createQuery("SELECT c FROM Creature c WHERE environment LIKE :chosenEnviroment")
				.setParameter("chosenEnviroment", chosenEnviroment);
		Collection<Creature> creatures = (Collection<Creature>) query.getResultList();
		return util.getJSONForObject(creatures);
	}

	@Override
	public String searchByClimate(String chosenClimate) {
		Query creature = manager.createQuery("SELECT c FROM Creature c WHERE climate LIKE :chosenClimate")
				.setParameter("chosenClimate", chosenClimate);
		Collection<Creature> creatures = (Collection<Creature>) creature.getResultList();
		return util.getJSONForObject(creatures);
	}

	@Override
	public String searchByAlignment(String chosenAlignment) {
		Query creature = manager.createQuery("SELECT c FROM Creature c WHERE environment LIKE :chosenAlignment")
				.setParameter("chosenAlignment", chosenAlignment);
		Collection<Creature> creatures = (Collection<Creature>) creature.getResultList();
		return util.getJSONForObject(creatures);
	}

	@Override
	public String searchByRole(String chosenRole) {
		Query creature = manager.createQuery("SELECT c FROM Creature c WHERE environment LIKE :chosenRole")
				.setParameter("chosenRole", chosenRole);
		Collection<Creature> creatures = (Collection<Creature>) creature.getResultList();
		return util.getJSONForObject(creatures);
	}

	@Override
	public String searchByType(String chosenType) {
		Query creature = manager.createQuery("SELECT c FROM Creature c WHERE environment LIKE :chosenType")
				.setParameter("chosenType", chosenType);
		Collection<Creature> creatures = (Collection<Creature>) creature.getResultList();
		return util.getJSONForObject(creatures);
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
