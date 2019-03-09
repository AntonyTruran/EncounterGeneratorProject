package com.qa.persistence.repository;

public interface EncounterChartRepository {
	String getContentByChart(String biomeKey);
	
	String newEncounterChart(String newChart);
	
	String removeEncounterChart(int id);
	
	String updateEncounterChart(int id, String updatedValue);
}
