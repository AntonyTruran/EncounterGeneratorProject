package com.qa.biomeTests;

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
import com.qa.persistence.repository.BiomeRepositoryImpl;
import com.qa.utils.JSONUtil;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class BiomeRepositoryTests extends TestCase {

	@InjectMocks
	private BiomeRepositoryImpl repo;
	@Mock
	private EntityManager manager;
	@Mock
	private Query query;
	@Mock
	private JSONUtil util;

	private static final String MOCK_TABLE_ROW = "[{\"biomeReference\":\"URBLL\",\"biomeName\":\"urban\",\"chartEntries\":[]}]";
	private static final String MOCK_ENTRY = "{\"biomeReference\":\"URBLL\",\"biomeName\":\"urban\"}";

	@Before
	public void setUp() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void getAllBiomes() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Biome> mockBiomes = new ArrayList<Biome>();
		mockBiomes.add(new Biome("URBLL", "urban"));
		Mockito.when(query.getResultList()).thenReturn(mockBiomes);
		assertEquals(MOCK_TABLE_ROW, repo.getAllBiomes());
	}

	@Test
	public void newBiome() {
		assertEquals("{\"message\": \"biome has been successfully created\"}", repo.newBiome(MOCK_ENTRY));
	}

	@Test
	public void removeBiomeValid() {
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(true);
		assertEquals("{\"message\": \"the biome has been successfully deleted\"}", repo.removeBiome("any"));
	}

	@Test
	public void removeBiomeInvalid() {
		assertEquals("{\"message\": \"invalid biome reference\"}", repo.removeBiome("any"));
	}

	@Test
	public void updateBiomeValid() {
		String updatedBiome = "{\"biomeId\":0,\"biomeReference\":\"URBLL\",\"biomeName\":\"urban\"}";;
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(true);
		Mockito.when(manager.find(Mockito.any(), Mockito.anyInt())).thenReturn(updatedBiome);
		assertEquals("{\"message\": \"the biome has been successfully updated\"}", repo.updateBiome("any", updatedBiome));
	
	}

	@Test
	public void updateBiomeInvalid() {
		String updatedBiome = "{\"biomeId\":0,\"biomeReference\":\"URBLL\",\"biomeName\":\"urban\"}";;
		assertEquals("{\"message\": \"invalid biome reference\"}", repo.updateBiome("any", updatedBiome));
	}
}
