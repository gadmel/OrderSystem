package org.groupOne.repositories;

import org.groupOne.model.Product;
import org.groupOne.model.Car;
import org.groupOne.model.Motorcycle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.util.List;

class ProductRepoTest {

	List<Product> products;
	Product kawasaki;
	Product bmw;
	ProductRepo productRepo;

	@BeforeEach
	void setUp() throws Exception {
		// Given
		kawasaki = new Motorcycle(1, "Kawasaki", new BigDecimal("1200000"));
		bmw = new Car(2, "BMW", new BigDecimal("2500000"));
		products = List.of(kawasaki, bmw);
		productRepo = new ProductRepo(products);
	}
	@Test
	void testProductRepoExists() {
		// Then
		Assertions.assertNotNull(productRepo);
	}
}