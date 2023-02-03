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
		Optional<Product> result = availableProducts.getProductById(id);
		System.out.println(result.isPresent() ? result.get().toString() : "Product does not exist!");
		return result;
	}

	public List<Product> listProducts() {
		List<Product> productList = availableProducts.listProducts();
		System.out.println("These are the products in the repository:");
		for (Product p : productList) {
			System.out.println("- " + p);
		}
		return productList;
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