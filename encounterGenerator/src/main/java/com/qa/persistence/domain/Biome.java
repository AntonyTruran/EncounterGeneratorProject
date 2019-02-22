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
public class Biome {

	public Biome(String biomeReference, String biomeName) {
		super();
		this.biomeReference = biomeReference;
		this.biomeName = biomeName;
	}
	
	public Biome() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int biomeId;
	@Column(length = 5)
	private String biomeReference;
	@Column(length = 30)
	private String biomeName;
	
	@OneToMany(mappedBy="biomeKey",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List <EncounterChart> chartEntries = new ArrayList<EncounterChart>();
	
	public String getBiomeReference() {
		return biomeReference;
	}
	public void setBiomeReference(String biomeReference) {
		this.biomeReference = biomeReference;
	}
	public String getBiomeName() {
		return biomeName;
	}
	public void setBiomeName(String biomeName) {
		this.biomeName = biomeName;
	}

	public List<EncounterChart> getChartEntries() {
		return chartEntries;
	}

	public void setChartEntries(List<EncounterChart> chartEntries) {
		this.chartEntries = chartEntries;
	}

}
