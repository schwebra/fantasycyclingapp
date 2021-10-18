package com.fantasyCycling.fantasyCyclingApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantasyCycling.fantasyCyclingApp.model.StagePoints;
import com.fantasyCycling.fantasyCyclingApp.repository.StagePointsDao;

@Service
public class StagePointsService {

	@Autowired
	private StagePointsDao stagePointsDao;

	public StagePointsService(StagePointsDao stagePointsDao) {
		super();
		this.stagePointsDao = stagePointsDao;
	}

	public void create(StagePoints stagePoints) {
		stagePointsDao.save(stagePoints);
	}

	public Optional<StagePoints> retrieveOne(long id) {

		return stagePointsDao.findById(id);
	}

	public List<StagePoints> retrieveAll() {

		return stagePointsDao.findAll();
	}

	public void update(StagePoints stagePoints) {
		stagePointsDao.save(stagePoints);
	}

	public List<StagePoints> getTeamStagePoints(long userId, long stageId) {
		List<StagePoints> list = stagePointsDao.getS(userId, stageId);
		return list;
	}

	public List<StagePoints> getUsersStagePointsList(long userId) {
		List<StagePoints> list = stagePointsDao.getUserStagePointsList(userId);
		return list;
	}

	public int getTotalCurrentPoints(long userId) {
		int total = 0;
		List<StagePoints> list = getUsersStagePointsList(userId);
		for (StagePoints stagePoints : list) {
			total += stagePoints.stagePointsTotal() + stagePoints.rankingsPoints();
		}
		return total;
	}
}
