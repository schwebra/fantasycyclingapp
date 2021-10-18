package com.fantasyCycling.fantasyCyclingApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantasyCycling.fantasyCyclingApp.model.Cyclist;
import com.fantasyCycling.fantasyCyclingApp.repository.CyclistDao;

@Service
public class CyclistService {
	
	@Autowired
	CyclistDao cyclistDao;

	public CyclistService(CyclistDao cyclistDao) {
		super();
		this.cyclistDao = cyclistDao;
	}

	public void create(Cyclist cyclist) {
		cyclistDao.save(cyclist);
	}
	
	public Optional<Cyclist> retrieveOne(long id) {
		return cyclistDao.findById(id);
	}
	
	public List<Cyclist> retrieveAll(){
		return cyclistDao.findAll();
	}
	
	
	
}
