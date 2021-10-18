package com.fantasyCycling.fantasyCyclingApp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.SequenceGenerator;

@NamedEntityGraph(
		name="graph.userTeam",
		attributeNodes = @NamedAttributeNode("team")
)
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
	@SequenceGenerator(name = "user_gen", sequenceName = "USER_SEQ", allocationSize = 1)
	long userId;

	String name;
	String username;
	String password;
	int substitutions;

	@ManyToMany
	@JoinColumn(name = "cyclistId")
	@JoinTable(name = "USER_CYCLIST")
	List<Cyclist> team = new ArrayList<Cyclist>(8);

	@ManyToMany
	@JoinColumn(name = "stagePointsId")
	@JoinTable(name = "USER_STAGEPOINTS")
	List<StagePoints> stagePointsList = new ArrayList<StagePoints>();

	public User(String name, String username, String password) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.substitutions = 8;
	}

	public User() {
		super();
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Cyclist> getTeam() {
		return team;
	}

	public int getSubstitutions() {
		return substitutions;
	}

	public void setSubstitutions(int substitutions) {
		this.substitutions = substitutions;
	}

	public void setTeam(List<Cyclist> team) {
		this.team = team;
	}

	public List<StagePoints> getStagePointsList() {
		return stagePointsList;
	}

	public void setStagePointsList(List<StagePoints> stagePointsList) {
		this.stagePointsList = stagePointsList;
	}

	public void makeSubstitution() {
		this.substitutions -= 1;
	}

}
