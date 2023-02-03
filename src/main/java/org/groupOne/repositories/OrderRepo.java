package org.groupOne.repositories;

import org.groupOne.model.Order;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
public class OrderRepo {
	private List<Order> orders;

	public List<Order> listOrders() {
		return orders;
	}

	public Optional<Order> getById(int id) {
		//return orders.stream().filter(order -> order.getId() == id).findFirst();
		return Optional.empty();
	}

	public void addSingleOrder(Order order) {
		orders.add(order);
	}

}
