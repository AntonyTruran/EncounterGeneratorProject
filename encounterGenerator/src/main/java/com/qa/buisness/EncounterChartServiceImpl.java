package com.qa.buisness;

import javax.inject.Inject;

import com.qa.persistence.repository.EncounterChartRepository;

public class EncounterChartServiceImpl implements EncounterChartService{
	@Inject
	EncounterChartRepository repo;

	@Override
	public String getContentByChart(String biomeKey) {
		// TODO Auto-generated method stub
		return repo.getContentByChart(biomeKey);
	}

	@Override
	public String newEncounterChart(String newChart) {
		// TODO Auto-generated method stub
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
