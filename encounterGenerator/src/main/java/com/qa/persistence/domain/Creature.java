package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Creature {
	
	public Creature(String creatureName, String challengeRating,String type, String environment,
			String climate, String alignment, String combatRole) {
		this.creatureName = creatureName;
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
	@Column(length = 50, name="creatureName")
	private String creatureName;
	@Column(length = 4)
	private String challengeRating;
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

	public String getCreatureName() {
		return creatureName;
	}

	public void setCreatureName(String creatureName) {
		this.creatureName = creatureName;
	}

	public String getChallengeRating() {
		return challengeRating;
	}

	public void setChallengeRating(String challengeRating) {
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