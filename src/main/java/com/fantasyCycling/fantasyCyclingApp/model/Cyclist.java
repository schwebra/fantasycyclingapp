package com.fantasyCycling.fantasyCyclingApp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Cyclist {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cyclist_gen")
	@SequenceGenerator(name = "cyclist_gen", sequenceName = "CYCLIST_SEQ", allocationSize = 1)
	long cyclistId;

	@Column
	String name;

	@Column
	int value;

	@OneToMany(fetch = FetchType.EAGER)
	private List<StagePoints> stageResults = new ArrayList<StagePoints>();

	public Cyclist(String name, int value) {
		super();
		this.name = name;
		this.value = value;
	}

	public Cyclist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getCyclistId() {
		return cyclistId;
	}

	public void setCyclistId(long cyclistId) {
		this.cyclistId = cyclistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<StagePoints> getStageResults() {
		return stageResults;
	}

	public void setStageResults(List<StagePoints> stageResults) {
		this.stageResults = stageResults;
	}

	@Override
	public String toString() {
		return "Cyclist [cyclistId=" + cyclistId + ", name=" + name + ", value=" + value + ", stageResults="
				+ stageResults + "]";
	}

	
}
