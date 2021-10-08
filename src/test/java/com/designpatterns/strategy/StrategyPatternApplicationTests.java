package com.designpatterns.strategy;

import com.designpatterns.strategy.model.Order;
import com.designpatterns.strategy.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class StrategyPatternApplicationTests {

    @Autowired
    OrderService orderService;

    @Test
    public void testStrategyPattern() {
        Order order = new Order();
        order.setAmount(BigDecimal.valueOf(1));
        order.setCode("1");
        order.setPayMethod("wxPay");
        order.setSource("mobile");
        orderService.pay(order);

        order.setPayMethod("aliPay");
        orderService.pay(order);

        order.setSource("PC");
        orderService.pay(order);
    }
}
