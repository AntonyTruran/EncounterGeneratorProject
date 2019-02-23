package com.qa.buisness;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.qa.persistence.domain.EncounterChart;
import com.qa.persistence.repository.EncounterChartRepository;
import com.qa.utils.JSONUtil;

public class EncounterChartServiceImpl implements EncounterChartService{
	@Inject
	EncounterChartRepository repo;
	@Inject
	private JSONUtil util;

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	@Override
	public String getContentByChart(String biomeKey) {
		return repo.getContentByChart(biomeKey);
	}

	@Override
	public String newEncounterChart(String newChart) {
		EncounterChart chartEntry = util.getObjectForJSON(newChart, EncounterChart.class);
		if (chartEntry.getBiomeKey().contains("")) {}
		return repo.newEncounterChart(newChart);
	}

	@Override
	public String removeEncounterChart(String biomeKey, int monsterKey) {
		// TODO Auto-generated method stub
		return repo.removeEncounterChart(biomeKey, monsterKey);
	}

	@Override
	public String updateEncounterChart(String biomeKey, int monsterKey, String updatedValue) {
		// TODO Auto-generated method stub
		return repo.updateEncounterChart(biomeKey, monsterKey, updatedValue);
	}

	public void setRepo(EncounterChartRepository repo) {
		this.repo = repo;
	}

}
