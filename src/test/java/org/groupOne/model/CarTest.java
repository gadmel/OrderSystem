package org.groupOne.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;

class CarTest {

	 @Test
	 void testCarExists() {
		 // Given
		 int id = 1;
		 String name = "BMW";
		 BigDecimal priceInCents = new BigDecimal("2500000"); // 25 000 EUR
		 // When
		 Car car = new Car(id, name, priceInCents);
		 // Then
		 Assertions.assertNotNull(car);
	 }

}