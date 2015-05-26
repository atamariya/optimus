package com.optimus.logic;

import com.optimus.api.Order;
import com.optimus.api.OrderFactory;
import com.optimus.api.base.Factory;

public class PurchaseOrderFactory implements OrderFactory, Factory<Order> {

	public Order createOrder() {
		return new PurchaseOrder();
	}

	public PurchaseOrder createObject() {
		return new PurchaseOrder();
	}

}
