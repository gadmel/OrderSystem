package org.groupOne.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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

//	public Optional<Product> getProductById(int id) {
//	}
//
//	public List<Product> listProducts() {
//	}
//

	public ShopService() {
//		availableProducts = new ProductRepo();
		currentOrders = new OrderRepo();
	}

	public ShopService(ProductRepo availableProducts, OrderRepo currentOrders) {
//		this.availableProducts = availableProducts;
		this.currentOrders = currentOrders;
	}

	public void addOrder(Order order) {
		currentOrders.addSingleOrder(order);
	}

	public Optional<Order> getOrderById(int id) {
		return currentOrders.getById(id);
	}

	public List<Order> listOrders() {
		return currentOrders.listOrders();
	}

}