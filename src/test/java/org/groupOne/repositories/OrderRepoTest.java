package org.groupOne.repositories;

import org.groupOne.model.Motorcycle;
import org.groupOne.model.Order;

import org.groupOne.model.Product;
import org.groupOne.model.Car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DisplayName("Testing the order repository")
class OrderRepoTest {

	OrderRepo repository;
	Order order;
	Product bmw;
	Product kawasaki;
	@BeforeEach
	void setUp() {
		bmw = new Car(1, "BMW", new BigDecimal("2500000"));
		kawasaki = new Motorcycle(2, "Kawasaki", new BigDecimal("1200000"));
		order = new Order(1, List.of(bmw, kawasaki));
		repository = new OrderRepo(new ArrayList<>() {{
				add(order);
			}});
	}


	@Test
	@DisplayName("List of orders")
	void listOrders() {
		Assertions.assertEquals(List.of( order), repository.listOrders());
	}


	@Test
	@DisplayName("Get order by id")
	void getById() {
		Assertions.assertEquals(Optional.of(order), repository.getById(1));
	}

	@Test
	@DisplayName("Add single order")
	void addSingleOrder() {
		// When
		Order anotherOrder = new Order(2, new ArrayList<>() {{
			add(bmw);
			add(kawasaki);
		}});

		repository.addSingleOrder(anotherOrder);
		// Then
		Assertions.assertEquals(List.of(order, anotherOrder), repository.listOrders());
	}
}