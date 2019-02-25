package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.buisness.EncounterChartService;

@Path("/encounterCharts")
public class EncounterChartEndpoint {
	@Inject
	private EncounterChartService service;

	@Path("/getContentByChart")
	@GET
	@Produces({ "application/json" })
	public String getContentByChart(String biomeKey) {
		return service.getContentByChart(biomeKey);
	}

	// C
	@Path("/newEncounterChart")
	@POST
	@Produces({ "application/json" })
	public String newEncounterChart(String newChart) {
		return service.newEncounterChart(newChart);
	}

	// D
	@Path("/removeEncounterChart/{biomeReference}+{monsterKey}")
	@DELETE
	@Produces({ "applicaiton/json" })
	public String removeEncounterChart(@PathParam("biomeKey")String biomeKey, @PathParam("monsterKey")int monsterKey) {
		return service.removeEncounterChart(biomeKey, monsterKey);
	}

	// U
	@Path("/updateBiome/{biomeReference}")
	@PUT
	@Produces({ "application/json" })
	public String updateEncounterChart(@PathParam("biomeKey")String biomeKey, @PathParam("monsterKey")int monsterKey, String updatedValue) {
		return service.updateEncounterChart(biomeKey, monsterKey, updatedValue);
	}

	public void setService(EncounterChartService service) {
		this.service = service;
	}
}
