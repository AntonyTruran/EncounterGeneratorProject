package com.qa.testSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.qa.creatureTests.CreatureEndpointTests;
import com.qa.creatureTests.CreaturePersistenceTests;
import com.qa.creatureTests.CreatureServiceTests;


@RunWith(Suite.class)

@Suite.SuiteClasses({CreatureEndpointTests.class, CreaturePersistenceTests.class, CreatureServiceTests.class})
public class TestSuite {

}