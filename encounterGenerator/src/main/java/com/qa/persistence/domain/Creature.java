package com.qa.persistence.domain;

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
	
	public Creature(String creatureName, int challengeRating,String type, String environment,
			String climate, String alignment, String combatRole) {
		this.creatrueName = creatureName;
		this.challengeRating = challengeRating;
		this.type = type;
		this.environment = environment;
		this.climate = climate;
		this.alignment = alignment;
		this.combatRole = combatRole;
	}

	public Creature() {
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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