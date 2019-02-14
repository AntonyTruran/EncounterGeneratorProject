package com.qa.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import com.qa.persistence.domain.Creature;
import com.qa.utils.DiceRoller;
import com.qa.utils.JSONUtil;

@Default
@Transactional(SUPPORTS)
public class EncounterChoiceImpl implements EncounterChoice{
	 
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	@Inject
	private DiceRoller roll;

	public String randomCreature(String chosenTable) {
		int chance = roll.dice("d100");
		Query query = manager.createQuery("SELECT a FROM Creature c WHERE c.monster_id =(SELECT a FROM monster_biome mb WHERE mb.biome_key = '"+chosenTable+"' AND '"+chance+"' < mb.max AND '"+chance+"' >= mb.min");
		return util.getJSONForObject(query.getResultList());
	}

	
}
