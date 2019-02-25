package com.qa.persistence.repository;

public interface EncounterChartRepository {
	String getContentByChart(String biomeKey);
	
	String newEncounterChart(String newChart);
	
	String removeEncounterChart(String biomeKey, int monsterKey);
	
	String updateEncounterChart(String biomeKey, int monsterKey, String updatedValue);
}
