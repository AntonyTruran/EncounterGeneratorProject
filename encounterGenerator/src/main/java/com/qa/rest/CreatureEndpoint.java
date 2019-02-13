package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.buisness.EncounterChoiceRules;

@Path("/creature")
public class CreatureEndpoint {
	@Inject
	private EncounterChoiceRules service;

	@Path("/randomCreature")
	@Produces({ "application/json" })
	public String randomCreature() {
		return service.randomCreature();
	}
}
