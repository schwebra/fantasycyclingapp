package com.fantasyCycling.fantasyCyclingApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantasyCycling.fantasyCyclingApp.model.Cyclist;
import com.fantasyCycling.fantasyCyclingApp.model.StagePoints;
import com.fantasyCycling.fantasyCyclingApp.model.User;
import com.fantasyCycling.fantasyCyclingApp.repository.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private CyclistService cyclistService;
	
	@Autowired
	private StagePointsService stagePointsService;

	public UserService(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	public void create(User user) {
		userDao.save(user);
	}

	public Optional<User> retrieveOne(long id) {

		return userDao.findById(id);
	}

	public List<User> retrieveAll() {

		return userDao.findAll();
	}

	public void update(User user) {
		userDao.save(user);
	}

	public Optional<User> findByUsernameAndPassword(String username, String password) {

		return userDao.findByUsernameAndPassword(username, password);
	}

	public Optional<User> findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	public int getTeamStageScore(long userId, long stageId) {
		int total = 0;
		List<StagePoints> scores = stagePointsService.getTeamStagePoints(userId, stageId);
		for (StagePoints stagePoints : scores) {
					total += stagePoints.stagePointsTotal() + stagePoints.rankingsPoints();
			}
		
		return total;
	}

	public List<Cyclist> retrieveTeam(long id) {
		List<Cyclist> team = new ArrayList<Cyclist>();
		List<Long> ids = userDao.getTeam(id);
		for (Long iterator : ids) {
			Cyclist cyclist = cyclistService.retrieveOne(iterator).get();
			team.add(cyclist);

		}
		return team;
	}
	
	public void makeSubstitution(long cyclist1, long cyclist2, long userId) {
		User user = retrieveOne(userId).get();
		Cyclist toRemove = cyclistService.retrieveOne(cyclist1).get();
		Cyclist toAdd = cyclistService.retrieveOne(cyclist2).get();
		List<Cyclist> team = retrieveTeam(userId);
		for (Cyclist cyclist : team) {
			System.out.println(cyclist.toString() + team.indexOf(toAdd));
		}
		user.makeSubstitution();
		
	}


}
