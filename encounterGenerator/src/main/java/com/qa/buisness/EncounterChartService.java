package com.qa.buisness;

public interface EncounterChartService {
	String getContentByChart(String biomeKey);
	
	String newEncounterChart(String newChart);
	
	String removeEncounterChart(int id);

	String updateEncounterChart(int id, String updatedValue);
}
