package org.groupOne.repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class ProductRepoTest {

	@Test
	void testProductRepoExists() {
		// Given
		// When
		ProductRepo productRepo = new ProductRepo();
		// Then
		Assertions.assertNotNull(productRepo);
	}
}