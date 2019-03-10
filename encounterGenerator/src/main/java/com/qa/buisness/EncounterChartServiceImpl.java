package com.qa.buisness;

import javax.inject.Inject;
import com.qa.persistence.repository.EncounterChartRepository;
import com.qa.utils.InputChecker;
import com.qa.utils.JSONUtil;

public class EncounterChartServiceImpl implements EncounterChartService {
	
	@Inject
	EncounterChartRepository repo;
	@Inject
	private JSONUtil util;
	@Inject
	private InputChecker inputChecker;

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	@Override
	public String getContentByChart(String biomeKey) {
		return repo.getContentByChart(biomeKey);
	}

	@Override
	public String newEncounterChart(String newChart) {
		String inputCheck ="";
		inputCheck += inputChecker.validityCheck(newChart);
		if (inputCheck.equals("invalid")) {
				return"{\"message\":\"the input included banned words\"}";
			}
		return repo.newEncounterChart(newChart);
	}

	@Override
	public String removeEncounterChart(int id) {
		return repo.removeEncounterChart(id);
	}

	@Override
	public String updateEncounterChart(int id, String updatedValue) {
		String inputCheck ="";
		inputCheck += inputChecker.validityCheck(updatedValue);
		if (inputCheck.equals("invalid")) {
				return"{\"message\":\"the input included banned words\"}";
			}
		return repo.updateEncounterChart(id, updatedValue);
	}

	public void setRepo(EncounterChartRepository repo) {
		this.repo = repo;
	}

}
