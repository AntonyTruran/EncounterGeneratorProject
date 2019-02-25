package com.qa.testSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.qa.biomeTests.BiomeEndpointsTests;
import com.qa.biomeTests.BiomeRepositoryTests;
import com.qa.biomeTests.BiomeServiceTests;
import com.qa.creatureTests.CreatureEndpointTests;
import com.qa.creatureTests.CreaturePersistenceTests;
import com.qa.creatureTests.CreatureServiceTests;
import com.qa.encounterChartTests.EncounterChartEnpointTests;
import com.qa.encounterChartTests.EncounterChartRepositoryTests;
import com.qa.encounterChartTests.EncoutnerChartServiceTests;
import com.qa.utilTests.UTILTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({ CreatureEndpointTests.class, CreaturePersistenceTests.class, CreatureServiceTests.class,
		UTILTest.class, BiomeRepositoryTests.class, BiomeServiceTests.class, BiomeEndpointsTests.class,
		EncounterChartRepositoryTests.class, EncoutnerChartServiceTests.class, EncounterChartEnpointTests.class })
public class TestSuite {

}