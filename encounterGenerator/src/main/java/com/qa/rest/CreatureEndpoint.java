package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.buisness.EncounterChoiceRules;

@Path("/creature")
public class CreatureEndpoint {
	@Inject
	private EncounterChoiceRules service;

	@Path("/randomCreature")
	@GET
	@Produces({ "application/json" })
	public String randomCreature(String chosenTable) {
		return service.randomCreature(chosenTable);
	}
}
