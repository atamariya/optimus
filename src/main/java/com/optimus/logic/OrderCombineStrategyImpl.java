package com.optimus.logic;

import java.util.List;

import com.optimus.api.Order;
import com.optimus.api.OrderCombineStrategy;
import com.optimus.api.OrderFactory;

/**
 * Abstract class implementing all the common checks.
 * 
 * @author Anand.Tamariya
 *
 */
public class OrderCombineStrategyImpl implements OrderCombineStrategy {
	protected OrderFactory orderFactory;
	/* (non-Javadoc)
	 * @see com.optimus.logic.OrderCombineStrategy#combine(java.util.List)
	 */
	public Order combine(List<Order> orders) {
		if (orders == null || orders.size() == 0)
			return null;
		
		Order order = orderFactory.createOrder();
		return order;
	}

	public void setOrderFactory(OrderFactory orderFactory) {
		this.orderFactory = orderFactory;
		
	}

}
