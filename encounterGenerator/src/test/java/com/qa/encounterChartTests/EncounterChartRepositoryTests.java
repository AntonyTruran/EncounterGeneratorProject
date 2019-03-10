package com.qa.encounterChartTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Biome;
import com.qa.persistence.domain.Creature;
import com.qa.persistence.domain.EncounterChart;
import com.qa.persistence.repository.EncounterChartRepositoryImpl;
import com.qa.utils.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class EncounterChartRepositoryTests {
	@InjectMocks
	private EncounterChartRepositoryImpl repo;
	@Mock
	private EntityManager manager;
	@Mock
	private Query query;
	@Mock
	private JSONUtil util;

	private static final String MOCK_TABLE_ROW = "[{\"id\":0,\"monsterKey\":\"bats\",\"biomeKey\":\"URBLL\",\"number\":\"1d4\",\"maxChance\":14,\"minChance\":10}]";
	private static final String MOCK_ENTRY = "{\"id\":0,\"monsterKey\":\"bats\",\"biomeKey\":\"URBLL\",\"number\":\"1d4\",\"maxChance\":14,\"minChance\":10}";

	@Before
	public void setUp() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

//	@Test
//	public void getContentsByChart() {
//		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
//		List<EncounterChart> mockEncounterCharts = new ArrayList<EncounterChart>();
//		mockEncounterCharts.add(new EncounterChart( "bats","URBLL", "1d4", 14, 10));
//		Mockito.when(query.getResultList()).thenReturn(mockEncounterCharts);
//		assertEquals(MOCK_TABLE_ROW, repo.getContentByChart("URBLL"));
//	}

	@Test
	public void newEncounterChart() {
		assertEquals("{\"message\": \"Encounter chart has been successfully created\"}",
				repo.newEncounterChart(MOCK_ENTRY));
	}

	@Test
	public void removeEncounterChartValid() {
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(true);
		assertEquals("{\"message\": \"the biome has been successfully deleted\"}",
				repo.removeEncounterChart(1));
	}

	@Test
	public void removeEncounterChartInvalid() {
		assertEquals("{\"message\": \"invalid biome reference\"}", repo.removeEncounterChart(1));
	}

	@Test
	public void updateEncounterChartValid() {
		String updatedEncounterChart = "{\"biomeId\":0,\"biomeReference\":\"URBLL\",\"biomeName\":\"urban\"}";
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(true);
		Mockito.when(manager.find(Mockito.any(), Mockito.anyInt())).thenReturn(updatedEncounterChart);
		assertEquals("{\"message\": \"the biome has been successfully updated\"}",
				repo.updateEncounterChart(1, updatedEncounterChart));

	}

	@Test
	public void updateEncounterChartInvalid() {
		String updatedEncounterChart = "{\"biomeId\":0,\"biomeReference\":\"URBLL\",\"biomeName\":\"urban\"}";
		assertEquals("{\"message\": \"invalid biome reference\"}",
				repo.updateEncounterChart(1, updatedEncounterChart));
	}
}
