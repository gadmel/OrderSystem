package org.groupOne.repositories;

import org.groupOne.model.Order;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class OrderRepo {
	private List<Order> orders;

	public List<Order> listOrders() {
		return orders;
	}

	public Optional<Order> getById(int id) {
		try {
			for (Order order : orders) {
				if (order.getId() == id) {
					return Optional.of(order);
				}
			}
		} catch (Exception e) {
			return Optional.empty();
		}
		throw new IllegalArgumentException("No order with id " + id);
	}


	public void addSingleOrder(Order order) {
		orders.add(order);
	}

}
