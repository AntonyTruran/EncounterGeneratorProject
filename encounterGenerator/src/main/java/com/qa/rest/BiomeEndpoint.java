package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.buisness.BiomeService;

@Path("/biome")
public class BiomeEndpoint {
	@Inject
	private BiomeService service;

	public void setService(BiomeService service) {
		this.service = service;
	}

	@Path("/getAllBiomes")
	@GET
	@Produces({ "application/json" })
	public String getAllBiomes() {
		return service.getAllBiomes();
	}

	// C
	@Path("/newBiome")
	@POST
	@Produces({ "application/json" })
	public String newBiome(String creature) {
		return service.newBiome(creature);
	}

	// D
	@Path("/removeBiome/{biomeReference}")
	@DELETE
	@Produces({ "applicaiton/json" })
	public String removeBiome(@PathParam("biomeReference") String reference) {
		return service.removeBiome(reference);
	}

	// U
	@Path("/updateBiome/{biomeReference}")
	@PUT
	@Produces({ "application/json" })
	public String updateBiome(@PathParam("biomeReference") String reference, String biome){
		return service.updateBiome(reference, biome);
	}
}
