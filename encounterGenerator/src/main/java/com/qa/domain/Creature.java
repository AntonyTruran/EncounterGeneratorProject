package com.qa.domain;

import java.util.HashMap;

public class Creature {
	public HashMap<String, String> tables = new HashMap<String, String>();

	private String creatrueName;
	private int challengeRating;
	private String table;
	private String numberOfCreatures;
	private String chanceRange;
	private String type;
	private String environment;
	private String climate;
	private String alignment;
	private String combatRole;

	public Creature() {
	}

	public Creature(String creatureName, int challengeRating, String numberOfCreatures, String table,
			String chanceRange, String type, String environment, String climate, String alignment, String combatRole) {
		this.creatrueName = creatureName;
		this.challengeRating = challengeRating;
		this.table = table;
		this.numberOfCreatures = numberOfCreatures;
		this.chanceRange = chanceRange;
		this.type = type;
		this.environment = environment;
		this.climate = climate;
		this.alignment = alignment;
		this.combatRole = combatRole;
		String[] environments = environment.split(" ");
		String[] chances = chanceRange.split(",");
		for (int i = 0; i < environments.length; i++) {
			tables.put(environments[i], chances[i]);
		}
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getCreatrueName() {
		return creatrueName;
	}

	public void setCreatrueName(String creatrueName) {
		this.creatrueName = creatrueName;
	}

	public int getChallengeRating() {
		return challengeRating;
	}

	public void setChallengeRating(int challengeRating) {
		this.challengeRating = challengeRating;
	}

	public String getNumberOfCreatures() {
		return numberOfCreatures;
	}

	public void setNumberOfCreatures(String numberOfCreatures) {
		this.numberOfCreatures = numberOfCreatures;
	}

	public String getChanceRange() {
		return chanceRange;
	}

	public void setChanceRange(String chanceRange) {
		this.chanceRange = chanceRange;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	public String getCombatRole() {
		return combatRole;
	}

	public void setCombatRole(String combatRole) {
		this.combatRole = combatRole;
	}

	public HashMap<String, String> getTables() {
		return tables;
	}
}