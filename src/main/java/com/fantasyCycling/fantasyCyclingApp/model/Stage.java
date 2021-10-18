package com.fantasyCycling.fantasyCyclingApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Stage {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stage_gen")
	@SequenceGenerator(name = "stage_gen", sequenceName = "STAGE_SEQ", allocationSize = 1)
	long stageId;

	public Stage() {
		super();
	}

	public long getStageId() {
		return stageId;
	}

	public void setStageId(long stageId) {
		this.stageId = stageId;
	}

}
