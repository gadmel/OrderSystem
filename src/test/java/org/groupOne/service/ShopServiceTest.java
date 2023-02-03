package org.groupOne.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class ShopServiceTest {

	@Test
	void getProductById() {
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