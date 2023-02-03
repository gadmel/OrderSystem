package org.groupOne.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class MotorcycleTest {

	@Test
	void testMotorcycleExists() {
		// Given
		int id = 2;
		String name = "Kawasaki";
		BigDecimal priceInCents = new BigDecimal("1200000"); // 12 000 EUR
		// When
		Motorcycle kawasaki = new Motorcycle(id, name, priceInCents);
		// Then
		Assertions.assertNotNull(kawasaki);
	}
}