package org.groupOne.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class OrderTest {

	int id;
	Product bmw;
	Product kawasaki;
	List<Product> orderedProducts;
	@BeforeEach
	void setUp() throws Exception {
		// Given
		id = 1;
		bmw = new Car(1, "BMW", new BigDecimal("2500000"));
		kawasaki = new Motorcycle(2, "Kawasaki", new BigDecimal("1200000"));
		orderedProducts = new ArrayList<>(List.of(bmw, kawasaki));
	}

	@Test
	void testOrderExists() {
		// When
		Order order = new Order(id, orderedProducts);
		// Then
		Assertions.assertNotNull(order);
	}

	@Test
	void testOrderStatus() {
		// When
		Order order = new Order(id, orderedProducts);
		// Then
		Assertions.assertEquals(OrderStatus.NEW, order.getStatus());
	}
}