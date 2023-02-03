package org.groupOne.service;

import org.groupOne.model.Order;
import org.groupOne.model.Product;
import org.groupOne.model.Car;
import org.groupOne.model.Motorcycle;

import org.groupOne.repositories.OrderRepo;
import org.groupOne.repositories.ProductRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;



@Nested
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

	@DisplayName("Testing the shop service - order methods")
	@Nested
	class testShopServiceOrderMethods {

		@Test
		@DisplayName("Add order in Shop Service")
		void addOrder() {
			int prev = emptyShopService.listOrders().size();
			emptyShopService.addOrder(order);
			Assertions.assertEquals(prev + 1, emptyShopService.listOrders().size());
		}

		@Test
		@DisplayName("Get order by id in Shop Service")
		void getOrderById() {
			Assertions.assertEquals(Optional.of(order), fullShopService.getOrderById(1));
		}

		@Test
		@DisplayName("List orders in Shop Service")
		void listOrders() {

			Assertions.assertEquals(List.of(order), fullShopService.listOrders());
		}
	}

}