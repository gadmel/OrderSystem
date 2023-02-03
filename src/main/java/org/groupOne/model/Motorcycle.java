package org.groupOne.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Motorcycle implements Product {
  private int id;
  private String name;
  private BigDecimal priceInCents;
}
