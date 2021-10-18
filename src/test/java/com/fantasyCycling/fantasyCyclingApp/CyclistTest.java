package com.fantasyCycling.fantasyCyclingApp;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import com.fantasyCycling.fantasyCyclingApp.model.Cyclist;
import com.fantasyCycling.fantasyCyclingApp.service.CyclistService;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
class CyclistTest {

	@Autowired
	private CyclistService cyclistService;

	@Test
	void testThatACyclistCanBePersisted() {
		Cyclist cyclist = new Cyclist("Mark Cavendish", 18);
		cyclistService.create(cyclist);
		assertTrue(cyclist.getCyclistId() > 0);
	}

}
