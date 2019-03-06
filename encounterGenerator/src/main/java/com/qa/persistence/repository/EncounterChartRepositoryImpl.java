package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Creature;
import com.qa.persistence.domain.EncounterChart;
import com.qa.utils.JSONUtil;

@Default
@Transactional(SUPPORTS)
public class EncounterChartRepositoryImpl implements EncounterChartRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	@Inject
	private JSONUtil util;

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	@Override
	public String getContentByChart(String biomeKey) {
		Query query = manager.createQuery("SELECT a FROM EncounterChart a WHERE biomeKey like :biomeReference")
				.setParameter("biomeReference", biomeKey);
		Collection<EncounterChart> entries = (Collection<EncounterChart>) query.getResultList();
		return util.getJSONForObject(entries);
	}

	@Transactional(REQUIRED)
	@Override
	public String newEncounterChart(String newChart) {
		EncounterChart chartEntry = util.getObjectForJSON(newChart, EncounterChart.class);
		manager.persist(chartEntry);
		return "{\"message\": \"Encounter chart has been successfully created\"}";
	}

	@Transactional(REQUIRED)
	@Override
	public String removeEncounterChart(String biomeKey, String monsterKey) {
		if (manager.contains(manager.find(EncounterChart.class, biomeKey + monsterKey))) {
			manager.remove(manager.find(EncounterChart.class, biomeKey + monsterKey));
			return "{\"message\": \"the biome has been successfully deleted\"}";
		}
		return "{\"message\": \"invalid biome reference\"}";
	}

	@Transactional(REQUIRED)
	@Override
	public String updateEncounterChart(String biomeKey, String monsterKey, String updatedValue) {
		EncounterChart chartEntry = util.getObjectForJSON(updatedValue, EncounterChart.class);
		if (manager.contains(manager.find(EncounterChart.class, biomeKey + monsterKey))) {
			manager.merge(chartEntry);
			return "{\"message\": \"the biome has been successfully updated\"}";
		}
		return "{\"message\": \"invalid biome reference\"}";
	}
}
