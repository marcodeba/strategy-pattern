package com.designpatterns.strategy.handler;

import com.designpatterns.strategy.model.Order;

/**
 * 订单处理器接口，不同的订单类型可以提供不同的接口实现
 *
 * ******* Think twice, code once. *******
 */
public interface OrderHandler {
    void handle(Order order);
}
