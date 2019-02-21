package com.qa.buisness;

import javax.inject.Inject;

import com.qa.persistence.repository.EncounterChartRepository;

public class EncounterChartServiceImpl implements EncounterChartService{
	@Inject
	EncounterChartRepository repo;

	@Override
	public String getContentByChart(String biomeKey) {
		// TODO Auto-generated method stub
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

	public void setRepo(EncounterChartRepository repo) {
		this.repo = repo;
	}

}
