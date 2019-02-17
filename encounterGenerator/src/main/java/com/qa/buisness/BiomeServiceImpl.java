package com.qa.buisness;

import javax.inject.Inject;

import com.qa.persistence.repository.BiomeRepository;

public class BiomeServiceImpl implements BiomeService{
	
	@Inject
	BiomeRepository repo;

	public void setRepo(BiomeRepository repo) {
		this.repo = repo;
	}

	@Override
	public String getAllBiomes() {
		return repo.getAllBiomes();
	}

	@Override
	public String newBiome(String biome) {
		return repo.newBiome(biome);
	}

	@Override
	public String removeBiome(String biome) {
		return repo.removeBiome(biome);
	}

	@Override
	public String updateBiome(String reference, String biome) {
		return repo.updateBiome(reference, biome);
	}

}
