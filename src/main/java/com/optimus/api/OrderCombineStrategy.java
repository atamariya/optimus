package com.optimus.api;

import java.util.List;

public interface OrderCombineStrategy {

	Order combine(List<Order> orders);
	/**
	 * The factory to create order object returned by this strategy.
	 * @param orderFactory
	 */
	void setOrderFactory(OrderFactory orderFactory); 

}