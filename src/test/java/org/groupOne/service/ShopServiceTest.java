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
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;



@Nested
class ShopServiceTest {
	ShopService emptyShopService;
	ShopService fullShopService;
	List<Product> products;
	Product kawasaki;
	Product bmw;
	ProductRepo productRepo;
	Order order;
	Order invalidOrder;

	@BeforeEach
	@DisplayName("Set up the Testing variables")
	void setUp() {
		// Given
		bmw = new Car(1, "BMW", new BigDecimal("2500000"));
		kawasaki = new Motorcycle(2, "Kawasaki", new BigDecimal("1200000"));
		Product mercedes = new Car(3, "Mercedes", new BigDecimal("1000000000"));
		products = List.of(kawasaki, bmw);
		order = new Order(1, products);
		invalidOrder = new Order(2, List.of(bmw, kawasaki, mercedes));
		productRepo = new ProductRepo(products);
		emptyShopService = new ShopService(productRepo);
		fullShopService = new ShopService(productRepo , new OrderRepo(List.of(order)));
	}

	@Nested
	@DisplayName("Testing the shop service - product methods")
	class testingProductsMethods {

		@Test
		@DisplayName("Get an existing product by id succeeds")
		void getProductById_existing() {
			// WHEN
			Product actual = fullShopService.getProductById(1).orElse(null);
			Product expected = bmw;
			// THEN
			Assertions.assertEquals(expected, actual);
		}

		@Test
		@DisplayName("Get an non-existent product by id returns an empty Optional")
		void getProductById_notExisting() {
			// WHEN
			Product actual = fullShopService.getProductById(200).orElse(null);

			// THEN
			Assertions.assertNull(actual);
		}

		@Test
		@DisplayName("Shop service lists all products")
		void listProducts() {
			//WHEN
			List<Product> actualProductList = fullShopService.listProducts();
			//THEN
			assertThat(actualProductList).containsExactlyInAnyOrderElementsOf(products);
		}
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
		@DisplayName("Add order in Shop Service, Product does not exist")
		void addOrder_productNotExisting() {
			Assertions.assertThrows(NoSuchElementException.class, () -> {
				emptyShopService.addOrder(invalidOrder);
			});
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