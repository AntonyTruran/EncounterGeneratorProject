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

	@Path("/randomCreature/{biomeKey}")
	@GET
	@Produces({ "application/json" })
	public String randomCreature(@PathParam("biomeKey")String chosenTable) {
		return service.randomCreature(chosenTable);
	}

	@Path("/searchByName/{creatureName}")
	@GET
	@Produces({ "application/json" })
	public String searchByName(@PathParam("creatureName")String creatureName) {
		return service.searchByName(creatureName);
	}

	@Path("/searchByEnviroment/{environment}")
	@GET
	@Produces({ "application/json" })
	public String searchByEnviroment(@PathParam("environment")String chosenEnviroment) {
		return service.searchByEnviroment(chosenEnviroment);
	}

	@Path("/searchByClimate/{climate}")
	@GET
	@Produces({ "application/json" })
	public String searchByClimate(@PathParam("climate")String chosenClimate) {
		return service.searchByClimate(chosenClimate);
	}

	@Path("/searchByAlignment/{alignment}")
	@GET
	@Produces({ "application/json" })
	public String searchByAlignment(@PathParam("alignment")String chosenAlignment) {
		return service.searchByAlignment(chosenAlignment);
	}

	@Path("/searchByType/{type}")
	@GET
	@Produces({ "application/json" })
	public String searchByType(@PathParam("type")String chosenType) {
		return service.searchByType(chosenType);
	}

	@Path("/searchByRole/{role}")
	@GET
	@Produces({ "application/json" })
	public String searchByRole(@PathParam("role")String chosenRole) {
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
	@Path("/deleteCreature/{creatureName}")
	@DELETE
	@Produces({ "applicaiton/json" })
	public String deleteCreature(@PathParam("creatureName") String id) {
		return service.deleteCreature(id);
	}

	// U
	@Path("/updateCreature/{creatureName}")
	@PUT
	@Produces({ "application/json" })
	public String updateCreature(@PathParam("creatureName") String id, String creature) {
		return service.updateCreature(id, creature);
}
	public void setService(EncounterChoiceRules service) {
		this.service = service;
	}
}