package org.groupOne.repositories;

import org.groupOne.model.Order;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRepo {
	private List<Order> orders = new ArrayList<>();

	public List<Order> listOrders() {
		return orders;
	}

	public Optional<Order> getById(int id) {
		for (Order order : orders) {
			if (order.getId() == id) {
				return Optional.of(order);
			}
		}
		return Optional.empty();
	}


	public void addSingleOrder(Order order) {
		orders.add(order);
	}

}
