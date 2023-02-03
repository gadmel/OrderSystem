package org.groupOne.model;

import lombok.RequiredArgsConstructor;
import lombok.Getter;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class Order {
	private final int id;
	private final List<Product> orderedProducts;
	private OrderStatus status = OrderStatus.NEW;

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
}
