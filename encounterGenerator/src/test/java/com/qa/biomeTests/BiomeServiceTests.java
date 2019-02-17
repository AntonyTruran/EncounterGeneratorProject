package com.qa.biomeTests;

import static org.junit.Assert.assertEquals;

import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.buisness.BiomeServiceImpl;
import com.qa.persistence.repository.BiomeRepository;
import com.qa.utils.JSONUtil;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class BiomeServiceTests extends TestCase{
	@InjectMocks
	BiomeServiceImpl service;
	
	@Mock
	BiomeRepository repo;
	@Mock
	private JSONUtil util;

	private static final String MOCK_INPUT = "test";
	private static final String MOCK_OUTPUT = "test_output";
	
	@Before
	public void setUp() {
		service.setRepo(repo);
	}
	@Test
	public void getAllBiomes() {
		Mockito.when(repo.getAllBiomes()).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.getAllBiomes());
	}

	@Test
	public void newBiome() {
		Mockito.when(repo.newBiome(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.newBiome(MOCK_INPUT));
	}

	@Test
	public void removeBiome() {
		Mockito.when(repo.removeBiome("any")).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.removeBiome("any"));
	}

	@Test
	public void updateBiome() {
		Mockito.when(repo.updateBiome("any", MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.updateBiome("any", MOCK_INPUT));
	}
}
