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


@Nested
class ShopServiceTest {

	@Test
	void getProductById() {
	}

	@Test
	void listProducts() {
	}

	@DisplayName("Testing the shop service - order methods")
	@Nested
	class testShopServiceOrderMethods {
		ShopService emptyShopService;
		ShopService fullShopService;

		Product bmw;
		Product kawasaki;
		Order order;
		@BeforeEach
		@DisplayName("Set up the Testing variables")
		@Test
		void setUp() {
			bmw = new Car(1, "BMW", new BigDecimal("2500000"));
			kawasaki = new Motorcycle(2, "Kawasaki", new BigDecimal("1200000"));
			order = new Order(1, List.of(bmw, kawasaki));
			emptyShopService = new ShopService();
			fullShopService = new ShopService(null , new OrderRepo(List.of(order)));
		}

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