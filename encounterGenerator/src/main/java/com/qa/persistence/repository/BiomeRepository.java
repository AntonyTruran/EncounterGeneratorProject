package com.qa.persistence.repository;

public interface BiomeRepository {
	//R
	String getAllBiomes();
	//C
	String newBiome(String biome);
	//D
	String removeBiome(String biome);
	//U
	String updateBiome(String reference, String biome);
}
