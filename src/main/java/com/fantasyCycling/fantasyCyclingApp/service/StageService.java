package com.fantasyCycling.fantasyCyclingApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantasyCycling.fantasyCyclingApp.model.Stage;
import com.fantasyCycling.fantasyCyclingApp.repository.StageDao;

@Service
public class StageService {
	
	@Autowired
	StageDao stageDao;
	
	public StageService(StageDao stageDao) {
		super();
		this.stageDao = stageDao;
	}

	public void create(Stage stage) {
		stageDao.save(stage);
	}

	public Optional<Stage> retrieveOne(long id) {

		return stageDao.findById(id);
	}

	public List<Stage> retrieveAll() {

		return stageDao.findAll();
	}

	public void update(Stage stage) {
		stageDao.save(stage);
	}


}
