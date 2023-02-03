package org.groupOne.service;

import org.groupOne.model.Product;
import org.groupOne.model.Order;
import org.groupOne.repositories.OrderRepo;
import org.groupOne.repositories.ProductRepo;

import java.util.List;
import java.util.Optional;

public class ShopService {
	private ProductRepo availableProducts;
	private OrderRepo currentOrders;
//	private OrderRepo archivedOrders;

	public Optional<Product> getProductById(int id) {
		return null;
	}

	public List<Product> listProducts() {
		return null;
	}

	public void addOrder(Order order) {
	}

	public Optional<Order> getOrderById() {
		return null;
	}

	public List<Order> listOrders() {
		return null;
	}

}