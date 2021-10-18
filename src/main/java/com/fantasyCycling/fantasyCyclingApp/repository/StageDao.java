package com.fantasyCycling.fantasyCyclingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fantasyCycling.fantasyCyclingApp.model.Stage;

@Repository
public interface StageDao extends JpaRepository<Stage, Long> {

}
