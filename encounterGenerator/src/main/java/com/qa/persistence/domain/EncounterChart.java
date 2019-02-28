package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EncounterChart {

	public EncounterChart(String monsterKey, String biomeKey, String number, int maxChance, int minChance) {
		super();
		this.monsterKey = monsterKey;
		this.biomeKey = biomeKey;
		this.number = number;
		this.maxChance = maxChance;
		this.minChance = minChance;
	}

	public EncounterChart() {
		super();
	}

	@Id //adapt one to be a biome key (id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne(targetEntity = Creature.class)
	@Column(length = 50)
	private String monsterKey;
	@ManyToOne(targetEntity = Biome.class)
	@Column(length = 5)
	private String biomeKey;
	@Column(length = 5)
	private String number;
	@Column(length = 3)
	private int maxChance;
	@Column(length = 3)
	private int minChance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMonsterKey() {
		return monsterKey;
	}

	public void setMonsterKey(String monsterKey) {
		this.monsterKey = monsterKey;
	}

	public String getBiomeKey() {
		return biomeKey;
	}

	public void setBiomeKey(String biomeKey) {
		this.biomeKey = biomeKey;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getMinChance() {
		return minChance;
	}

	public void setMinChance(int minChance) {
		this.minChance = minChance;
	}
}
