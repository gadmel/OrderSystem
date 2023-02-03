package org.groupOne.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class Car implements Product {
	private int id;
	private String name;
	private BigDecimal priceInCents;
}
