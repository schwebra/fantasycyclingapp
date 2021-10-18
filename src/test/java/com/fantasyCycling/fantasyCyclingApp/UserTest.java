package com.fantasyCycling.fantasyCyclingApp;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import com.fantasyCycling.fantasyCyclingApp.model.Cyclist;
import com.fantasyCycling.fantasyCyclingApp.model.StagePoints;
import com.fantasyCycling.fantasyCyclingApp.model.User;
import com.fantasyCycling.fantasyCyclingApp.service.CyclistService;
import com.fantasyCycling.fantasyCyclingApp.service.StagePointsService;
import com.fantasyCycling.fantasyCyclingApp.service.UserService;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
class UserTest {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CyclistService cyclistService;
	
	@Autowired
	private StagePointsService stagePointsService;

	@Test
	void testThatAUserCanBePersisted() {
		User user = new User("Seb Brice", "brice", "abc123");
		userService.create(user);
		assertTrue(user.getUserId() > 0);

	}

	@Test
	void testThatAUserCanBeRetrieved() {
		User userFromDb = userService.retrieveOne(2).get();
		assertTrue(userFromDb instanceof User);
	}

	@Test
	void testThatAllUserCanBeRetrieved() {
		List<User> allUsers = userService.retrieveAll();
		assertFalse(allUsers.isEmpty());

	}

	@Test
	void testThatAUsersTotalStagePointsCanBeCalculated() {
		List<StagePoints> point = stagePointsService.getTeamStagePoints(1, 1);
		System.out.println(point);
		int score = userService.getTeamStageScore(1, 1);
		assertTrue(2011 == score);
	}

	@Test
	void testThatListOfUsersCyclistCanBeRetrieved() {
		List<Cyclist> team = userService.retrieveTeam(1);
		assertFalse(team.isEmpty());

	}
	
	@Test
	void test_thatCurrentStagePointsofUsercanbeCalculated() {
		int totalPoints = stagePointsService.getTotalCurrentPoints(1);
		assertTrue(totalPoints == 2011);
	}
	
	@Test
	void test_thatASubstitutionCanBeMade() {
		List<Cyclist> originalTeam = userService.retrieveTeam(1);
		userService.makeSubstitution(1, 9, 1);
		List<Cyclist> newTeam = userService.retrieveTeam(1);
		for (Cyclist cyclist : newTeam) {
			System.out.println(cyclist.getName());
		}
		assertFalse(newTeam.get(7) == originalTeam.get(7));
		
	}

}
