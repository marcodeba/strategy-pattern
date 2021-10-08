package com.designpatterns.strategy.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {
    private String Source;
    private String payMethod;
    private String code;
    private BigDecimal amount;

}
