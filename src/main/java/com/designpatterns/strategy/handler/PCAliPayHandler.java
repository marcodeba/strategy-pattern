package com.designpatterns.strategy.handler;

import com.designpatterns.strategy.annotation.OrderHandlerType;
import com.designpatterns.strategy.model.Order;
import org.springframework.stereotype.Service;

@OrderHandlerType(source = "PC", payMethod = "aliPay")
@Service
public class PCAliPayHandler implements OrderHandler {
    @Override
    public void handle(Order order) {
        System.out.println("调用了PC支付宝支付");
    }
}
