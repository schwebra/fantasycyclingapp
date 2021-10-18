package com.fantasyCycling.fantasyCyclingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fantasyCycling.fantasyCyclingApp.model.Cyclist;

@Repository
public interface CyclistDao extends JpaRepository<Cyclist, Long> {

}
