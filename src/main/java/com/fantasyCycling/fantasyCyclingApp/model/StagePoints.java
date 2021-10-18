package com.fantasyCycling.fantasyCyclingApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class StagePoints {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stagePoints_gen")
	@SequenceGenerator(name = "stagePoints_gen", sequenceName = "STAGEPOINTS_SEQ", allocationSize = 1)
	long stagePointsId;
	
	@Column
	int stageRank;
	
	@Column
	int sprintPoints;
	
	@Column
	int mountainPoints;
	
	@Column
	int gcRank;
	
	@Column
	int pointsRank;
	
	@Column
	int mountainsRank;
	
	@Column
	boolean mostCombative;
	
	@ManyToOne
	@JoinColumn(name = "stageId")
	Stage stage;
	
	
	
	public StagePoints(int stageRank, int sprintPoints, int mountainPoints, int gcRank, int pointsRank,
			int mountainsRank, boolean mostCombative, Stage stage) {
		super();
		this.stageRank = stageRank;
		this.sprintPoints = sprintPoints;
		this.mountainPoints = mountainPoints;
		this.gcRank = gcRank;
		this.pointsRank = pointsRank;
		this.mountainsRank = mountainsRank;
		this.mostCombative = mostCombative;
		this.stage = stage;
	}
	
	

	public StagePoints() {
		super();
	}



	public int stagePointsTotal() {
		int total = 0;
		if (stageRank == 1) {
			total += 200;
		} else if (stageRank == 2) {
			total += 150;
		} else if (stageRank == 3) {
			total += 120;
		} else if (stageRank == 4) {
			total += 100;
		} else if (stageRank == 5) {
			total += 90;
		} else if (stageRank == 6) {
			total += 80;
		} else if (stageRank == 7) {
			total += 70;
		} else if (stageRank == 8) {
			total += 65;
		} else if (stageRank == 9) {
			total += 60;
		} else if (stageRank == 10) {
			total += 55;
		} else if (stageRank == 11) {
			total += 50;
		} else if (stageRank == 12) {
			total += 45;
		} else if (stageRank == 13) {
			total += 40;
		} else if (stageRank == 14) {
			total += 35;
		} else if (stageRank == 15) {
			total += 30;
		} else if (stageRank == 16) {
			total += 25;
		} else if (stageRank == 17) {
			total += 20;
		} else if (stageRank == 18) {
			total += 15;
		} else if (stageRank == 19) {
			total += 10;
		} else if (stageRank == 20) {
			total += 9;
		} else if (stageRank > 20) {
			total += 8;
		} else if (stageRank > 25) {
			total += 7;
		} else if (stageRank > 30) {
			total += 6;
		} else if (stageRank > 35) {
			total += 5;
		} else if (stageRank > 40) {
			total += 4;
		} else if (stageRank > 50) {
			total += 3;
		} else if (stageRank > 60) {
			total += 2;
		} else if (stageRank > 80 && stageRank < 101) {
			total += 1;
		}
		
		total += mountainPoints;
		total+= sprintPoints;
		if (mostCombative) {
			total += 30;
		}
		return total;
	}
	
	public int rankingsPoints() {
		int total = 0;
		//generalClassification
		if (gcRank == 1) {
			total += 50;
		} else if (gcRank == 2) {
			total += 45;
		} else if (gcRank == 3) {
			total += 40;
		} else if (gcRank == 4) {
			total += 35;
		} else if (gcRank == 5) {
			total += 30;
		} else if (gcRank == 6) {
			total += 28;
		} else if (gcRank == 7) {
			total += 26;
		} else if (gcRank == 8) {
			total += 24;
		} else if (gcRank == 9) {
			total += 22;
		} else if (gcRank == 10) {
			total += 21;
		} else if (gcRank == 11) {
			total += 20;
		} else if (gcRank == 12) {
			total += 19;
		} else if (gcRank == 13) {
			total += 18;
		} else if (gcRank == 14) {
			total += 17;
		} else if (gcRank == 15) {
			total += 16;
		} else if (gcRank == 16) {
			total += 15;
		} else if (gcRank == 17) {
			total += 14;
		} else if (gcRank == 18) {
			total += 13;
		} else if (gcRank == 19) {
			total += 12;
		} else if (gcRank == 20) {
			total += 11;
		} else if (gcRank > 20) {
			total += 10;
		} else if (gcRank > 25) {
			total += 9;
		} else if (gcRank > 30) {
			total += 8;
		} else if (gcRank > 35) {
			total += 7;
		} else if (gcRank > 40) {
			total += 5;
		} else if (gcRank > 50) {
			total += 3;
		} else if (gcRank > 60) {
			total += 2;
		} else if (gcRank > 80 && gcRank < 101) {
			total += 1;
		}
		
		
		
		//pointsclass
		if (pointsRank == 1) {
			total += 30;
		} else if (pointsRank == 2) {
			total += 26;
		} else if (pointsRank == 3) {
			total += 22;
		} else if (pointsRank == 4) {
			total += 20;
		} else if (pointsRank == 5) {
			total += 18;
		} else if (pointsRank == 6) {
			total += 16;
		} else if (pointsRank == 7) {
			total += 14;
		} else if (pointsRank == 8) {
			total += 12;
		} else if (pointsRank == 9) {
			total += 10;
		} else if (pointsRank == 10) {
			total += 8;
		} else if (pointsRank == 11) {
			total += 6;
		} else if (pointsRank == 12) {
			total += 4;
		} else if (pointsRank == 13) {
			total += 3;
		} else if (pointsRank == 14) {
			total += 2;
		} else if (pointsRank == 15) {
			total += 1;
		}
		
		//mountains
		if (mountainsRank == 1) {
			total += 30;
		} else if (mountainsRank == 2) {
			total += 26;
		} else if (mountainsRank == 3) {
			total += 22;
		} else if (mountainsRank == 4) {
			total += 20;
		} else if (mountainsRank == 5) {
			total += 18;
		} else if (mountainsRank == 6) {
			total += 16;
		} else if (mountainsRank == 7) {
			total += 14;
		} else if (mountainsRank == 8) {
			total += 12;
		} else if (mountainsRank == 9) {
			total += 10;
		} else if (mountainsRank == 10) {
			total += 8;
		} else if (mountainsRank == 11) {
			total += 6;
		} else if (mountainsRank == 12) {
			total += 4;
		} else if (mountainsRank == 13) {
			total += 3;
		} else if (mountainsRank == 14) {
			total += 2;
		} else if (mountainsRank == 15) {
			total += 1;
		}
		
		return total;
	}



	public long getStagePointsId() {
		return stagePointsId;
	}



	public void setStagePointsId(long stagePointsId) {
		this.stagePointsId = stagePointsId;
	}



	public int getStageRank() {
		return stageRank;
	}



	public void setStageRank(int stageRank) {
		this.stageRank = stageRank;
	}



	public int getSprintPoints() {
		return sprintPoints;
	}



	public void setSprintPoints(int sprintPoints) {
		this.sprintPoints = sprintPoints;
	}



	public int getMountainPoints() {
		return mountainPoints;
	}



	public void setMountainPoints(int mountainPoints) {
		this.mountainPoints = mountainPoints;
	}



	public int getGcRank() {
		return gcRank;
	}



	public void setGcRank(int gcRank) {
		this.gcRank = gcRank;
	}



	public int getPointsRank() {
		return pointsRank;
	}



	public void setPointsRank(int pointsRank) {
		this.pointsRank = pointsRank;
	}



	public int getMountainsRank() {
		return mountainsRank;
	}



	public void setMountainsRank(int mountainsRank) {
		this.mountainsRank = mountainsRank;
	}



	public boolean isMostCombative() {
		return mostCombative;
	}



	public void setMostCombative(boolean mostCombative) {
		this.mostCombative = mostCombative;
	}



	public Stage getStage() {
		return stage;
	}



	public void setStage(Stage stage) {
		this.stage = stage;
	}



	@Override
	public String toString() {
		return "StagePoints [stagePointsId=" + stagePointsId + ", stageRank=" + stageRank + ", sprintPoints="
				+ sprintPoints + ", mountainPoints=" + mountainPoints + ", gcRank=" + gcRank + ", pointsRank="
				+ pointsRank + ", mountainsRank=" + mountainsRank + ", mostCombative=" + mostCombative + ", stage="
				+ stage + "]";
	}
	
	
	

}
