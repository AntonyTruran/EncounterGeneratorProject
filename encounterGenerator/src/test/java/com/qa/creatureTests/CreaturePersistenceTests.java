package com.qa.creatureTests;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Creature;
import com.qa.persistence.repository.EncounterChoiceImpl;
import com.qa.utils.DiceRoller;
import com.qa.utils.JSONUtil;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class CreaturePersistenceTests extends TestCase {
	
	DiceRoller roller;
    EncounterChoiceImpl choice;
    Creature creature;
    @InjectMocks
	private EncounterChoiceImpl repo;
	@Mock
	private EntityManager manager;
	@Mock
	private Query query;
	private JSONUtil util;
    
	@Before
	public void setup() {
    choice = new EncounterChoiceImpl();
    creature = new Creature("Terrasque",25, "1","fin",
            "95-100", "abberation","any","any","N","boss");
	}
	
	
}
