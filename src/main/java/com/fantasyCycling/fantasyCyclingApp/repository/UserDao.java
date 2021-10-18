package com.fantasyCycling.fantasyCyclingApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fantasyCycling.fantasyCyclingApp.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

	Optional<User> findByUsernameAndPassword(String username, String password);

	Optional<User> findByUsername(String username);

	@Query(value = "SELECT TEAM_CYCLISTID FROM USER_CYCLIST WHERE USER_USERID = :userId", nativeQuery = true)
	List<Long> getTeam(@Param("userId") Long userId);

}
