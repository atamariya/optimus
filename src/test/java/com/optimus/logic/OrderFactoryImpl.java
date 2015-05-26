package com.optimus.logic;

import com.optimus.api.Order;
import com.optimus.api.OrderFactory;

public class OrderFactoryImpl implements OrderFactory {

	public Order createOrder() {
		// TODO Auto-generated method stub
		return new OrderImpl();
	}

}
