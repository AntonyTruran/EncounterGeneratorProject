package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.qa.utils.JSONUtil;

@Default
@Transactional(SUPPORTS)
public class EncounterChartRepositoryImpl implements EncounterChartRepository{

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
	public String getContentByChart() {
		// query to select all of a set biomes entried and join to a select creature name
		return null;
	}
	@Override
	public String newEncounterChart(String newChart) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String removeEncounterChart(String biomeKey, String monsterKey) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String updateEncounterChart(String biomeKey, String monsterKey, String updatedValue) {
		// TODO Auto-generated method stub
		return null;
	}
}
