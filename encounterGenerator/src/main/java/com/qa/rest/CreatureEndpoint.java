package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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

	@Path("/searchByName")
	@GET
	@Produces({ "application/json" })
	public String searchByName(String creatureName) {
		return service.searchByName(creatureName);
	}

	@Path("/searchByEnviroment")
	@GET
	@Produces({ "application/json" })
	public String searchByEnviroment(String chosenEnviroment) {
		return service.searchByEnviroment(chosenEnviroment);
	}

	@Path("/searchByClimate")
	@GET
	@Produces({ "application/json" })
	public String searchByClimate(String chosenClimate) {
		return service.searchByClimate(chosenClimate);
	}

	@Path("/searchByAlignment")
	@GET
	@Produces({ "application/json" })
	public String searchByAlignment(String chosenAlignment) {
		return service.searchByAlignment(chosenAlignment);
	}

	@Path("/searchByType")
	@GET
	@Produces({ "application/json" })
	public String searchByType(String chosenType) {
		return service.searchByType(chosenType);
	}

	@Path("/searchByRole")
	@GET
	@Produces({ "application/json" })
	public String searchByRole(String chosenRole) {
		return service.searchByRole(chosenRole);
	}

	// C
	@Path("/createCreature")
	@POST
	@Produces({"application/json"})
	public String createCreature(String creature) {
		return service.createCreature(creature);
	}

	// admin creation
	// D
	@Path("/deleteCreature/{id}")
	@DELETE
	@Produces({ "applicaiton/json" })
	public String deleteCreature(@PathParam("id") int id) {
		return service.deleteCreature(id);
	}

	// U
	@Path("/updateCreature/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateCreature(@PathParam("id") int id, String creature) {
		return service.updateCreature(id, creature);
}
	public void setService(EncounterChoiceRules service) {
		this.service = service;
	}
}