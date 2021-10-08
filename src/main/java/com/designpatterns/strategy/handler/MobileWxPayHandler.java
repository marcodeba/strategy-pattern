package com.designpatterns.strategy.handler;

import com.designpatterns.strategy.annotation.OrderHandlerType;
import com.designpatterns.strategy.model.Order;
import org.springframework.stereotype.Service;

@OrderHandlerType(source = "mobile", payMethod = "wxPay")
@Service
public class MobileWxPayHandler implements OrderHandler {
    @Override
    public void handle(Order order) {
        System.out.println("调用了手机微信支付");
    }
}
