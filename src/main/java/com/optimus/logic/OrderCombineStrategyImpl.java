package com.optimus.logic;

import java.util.List;

import com.optimus.api.Order;
import com.optimus.api.OrderFactory;
import com.optimus.api.base.CombineStrategy;
import com.optimus.api.base.Factory;

/**
 * Abstract class implementing all the common checks.
 * 
 * @author Anand.Tamariya
 *
 */
public class OrderCombineStrategyImpl implements CombineStrategy<Order> {
	protected Factory<Order> orderFactory;
	/* (non-Javadoc)
	 * @see com.optimus.logic.OrderCombineStrategy#combine(java.util.List)
	 */
	public Order execute(List<Order> orders) {
		if (orders == null || orders.size() == 0)
			return null;
		
		Order order = orderFactory.createObject();
		return order;
	}

	public void setOrderFactory(OrderFactory orderFactory) {
//		this.orderFactory = orderFactory;
		
	}

	public void setFactory(Factory<Order> factory) {
		this.orderFactory = factory;
	}

}
