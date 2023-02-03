package org.groupOne.repositories;

import org.groupOne.model.Product;
import org.groupOne.model.Car;
import org.groupOne.model.Motorcycle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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

	@Test
	void test_listProducts() {
		// When
		List<Product> result = productRepo.listProducts();
		List<Product> expected = List.of(kawasaki, bmw);

		// Then
		Assertions.assertEquals(expected, result);
	}
	@Test
	void testGetProductById_exists() {
		//WHEN
		Product expected = kawasaki;
		Product actual = productRepo.getProductById(1).orElse(null);
		//THEN
		Assertions.assertEquals(expected, actual);

	}
	@Test
	void testGetProductById_DoesNotExist() {
		//WHEN
		Optional<Product> actual = productRepo.getProductById(8);
		//THEN
		Assertions.assertTrue(actual.isEmpty());
	}
}
