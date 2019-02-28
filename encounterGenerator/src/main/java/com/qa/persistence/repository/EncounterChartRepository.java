package com.qa.persistence.repository;

public interface EncounterChartRepository {
	String getContentByChart(String biomeKey);
	
	String newEncounterChart(String newChart);
	
	String removeEncounterChart(String biomeKey, String monsterKey);
	
	String updateEncounterChart(String biomeKey, String monsterKey, String updatedValue);
}
