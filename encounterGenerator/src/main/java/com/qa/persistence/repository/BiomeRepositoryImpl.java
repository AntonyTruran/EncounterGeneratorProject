package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Biome;
import com.qa.utils.JSONUtil;

@Default
@Transactional(SUPPORTS)
public class BiomeRepositoryImpl implements BiomeRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	@Inject
	private JSONUtil util;

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	@Override
	public String getAllBiomes() {
		Query query = manager.createQuery("SELECT a FROM Biome");
		return util.getJSONForObject(query.getResultList());
	}

	@Transactional(REQUIRED)
	@Override
	public String newBiome(String biome) {
		Biome newBiome = util.getObjectForJSON(biome, Biome.class);
		manager.persist(newBiome);
		return "{\"message\": \"biome has been successfully created\"}";
	}


	@Transactional(REQUIRED)
	@Override
	public String removeBiome(String reference) {
		if (manager.contains(manager.find(Biome.class, reference))) {
			manager.remove(manager.find(Biome.class, reference));
			return "{\"message\": \"the biome has been successfully deleted\"}";
		}
		return "{\"message\": \"invalid biome reference\"}";
	}

	@Transactional(REQUIRED)
	@Override
	public String updateBiome(String reference, String biome) {
		Biome aBiome = util.getObjectForJSON(biome, Biome.class);
		if (manager.contains(manager.find(Biome.class, reference))) {
			manager.merge(aBiome);
			return "{\"message\": \"the biome has been successfully updated\"}";
		}
		return "{\"message\": \"invalid biome reference\"}";
	}

}
