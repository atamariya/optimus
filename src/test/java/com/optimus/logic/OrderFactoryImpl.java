package com.optimus.logic;

import com.optimus.api.Order;
import com.optimus.api.OrderFactory;
import com.optimus.api.base.Factory;

public class OrderFactoryImpl implements OrderFactory, Factory<Order> {

	public Order createOrder() {
		return new OrderImpl();
	}

	public Order createObject() {
		return new OrderImpl();
	}

}
