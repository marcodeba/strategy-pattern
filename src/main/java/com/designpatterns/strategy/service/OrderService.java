package com.designpatterns.strategy.service;

import com.designpatterns.strategy.annotation.OrderHandlerType;
import com.designpatterns.strategy.annotation.OrderHandlerTypeImpl;
import com.designpatterns.strategy.handler.OrderHandler;
import com.designpatterns.strategy.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class OrderService {
    private Map<OrderHandlerType, OrderHandler> orderHandlerMap = new HashMap<>();

    @Autowired
    public void setOrderHandlerMap(List<OrderHandler> orderHandlerList) {
        for (OrderHandler orderHandler : orderHandlerList) {
            orderHandlerMap.putIfAbsent(AnnotationUtils.findAnnotation(orderHandler.getClass(), OrderHandlerType.class), orderHandler);
        }
    }

    public void pay(Order order) {
        OrderHandlerType orderHandlerType = new OrderHandlerTypeImpl(order.getSource(), order.getPayMethod());
        OrderHandler orderHandler = orderHandlerMap.get(orderHandlerType);
        if (Objects.isNull(orderHandler)) {
            throw new IllegalArgumentException();
        }
        orderHandler.handle(order);
    }
}
