package com.designpatterns.strategy.annotation;

import java.lang.annotation.*;

/**
 * 订单的类型，由订单来源 + 订单支付方式决定
 * <p>
 * 注解本质是一个接口 继承自Annotation接口
 * 注解的动态代理实现关键：AnnotationInvocationHandler
 * ******* Think twice, code once. *******
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OrderHandlerType {
    /**
     * 订单来源，PC、mobile，etcd.
     * @return source of order
     */
    String source();

    /**
     * 订单支付方式, wechat, alipay, etcd.
     * @return pay method of order
     */
    String payMethod();
}