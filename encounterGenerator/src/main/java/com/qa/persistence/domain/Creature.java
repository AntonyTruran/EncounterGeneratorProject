package com.qa.persistence.domain;

import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Creature {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 50)	
	private String creatrueName;
	@Column(length = 2)
	private int challengeRating;
	@Column(length = 100)
	private String table;
	@Column(length = 4)
	private String numberOfCreatures;
	@Column(length = 20)
	private String chanceRange;
	@Column(length = 20)
	private String type;
	@Column(length = 100)
	private String environment;
	@Column(length = 20)
	private String climate;
	@Column(length = 2)
	private String alignment;
	@Column(length = 50)
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
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
}