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
		Query query = manager.createQuery("SELECT a FROM Creature c WHERE c.monster_id =(SELECT a FROM monster_biome mb WHERE mb.biome_key = '"+chosenTable+"' AND '"+chance+"' < mb.max AND '"+chance+"' >= mb.min");
		//generate number of creatures
		return util.getJSONForObject(query.getResultList());
	}

	@Override
	public String searchByName(String creatureName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String searchByEnviroment(String chosenEnviroment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String searchByClimate(String chosenClimate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String searchByAlignment(String chosenAlignment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String searchByRole(String chosenRole) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String searchByType(String chosenType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createCreature(String creature) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCreature(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateCreature(int id, String account) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
