package org.groupOne.model;

import java.math.BigDecimal;

public interface Product {
	int getId();
	String getName();
	BigDecimal getPriceInCents();
}
