package org.groupOne.service;

import org.groupOne.model.Car;
import org.groupOne.model.Motorcycle;
import org.groupOne.model.Product;
import org.groupOne.repositories.ProductRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class ShopServiceTest {
	List<Product> products;
	Product kawasaki;
	Product bmw;
	ProductRepo productRepo;
	ShopService shopService;

	@BeforeEach
	void setUp() throws Exception {
		// Given
		kawasaki = new Motorcycle(1, "Kawasaki", new BigDecimal("1200000"));
		bmw = new Car(2, "BMW", new BigDecimal("2500000"));
		products = List.of(kawasaki, bmw);
		productRepo = new ProductRepo(products);
		shopService = new ShopService(productRepo);
	}

	@Test
	void getProductById_existing() {
		// WHEN
		Product actual = shopService.getProductById(2).orElse(null);
		Product expected = bmw;

		// THEN
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void getProductById_notExisting() {
		// WHEN
		Product actual = shopService.getProductById(200).orElse(null);

		// THEN
		Assertions.assertNull(actual);
	}

	@Test
	void listProducts() {
		//WHEN
		List<Product> actualProductList = shopService.listProducts();
		//THEN
		assertThat(actualProductList).containsExactlyInAnyOrderElementsOf(products);
	}

	@Test
	void addOrder() {
	}

	@Test
	void getOrderById() {
	}

	@Test
	void listOrders() {
	}
}