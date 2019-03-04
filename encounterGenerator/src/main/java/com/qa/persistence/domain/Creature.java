package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Creature {
	
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int creatureId;
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
	
	@OneToMany(mappedBy="monsterKey",fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List <EncounterChart> chartEntries = new ArrayList<>();

	public int getCreatureId() {
		return creatureId;
	}

	public void setCreatureId(int id) {
		this.creatureId = id;
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

	public List<EncounterChart> getChartEntries() {
		return chartEntries;
	}

	public void setChartEntries(List<EncounterChart> chartEntries) {
		this.chartEntries = chartEntries;
	}
}