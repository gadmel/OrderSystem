package org.groupOne.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.groupOne.model.Product;
import org.groupOne.model.Order;
import org.groupOne.repositories.OrderRepo;
import org.groupOne.repositories.ProductRepo;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@AllArgsConstructor
public class ShopService {
	private final ProductRepo availableProducts;
	private OrderRepo currentOrders;
//	private OrderRepo archivedOrders;

	public Optional<Product> getProductById(int id) {
		return availableProducts.getProductById(id);
	}

	public List<Product> listProducts() {
		return availableProducts.listProducts();
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