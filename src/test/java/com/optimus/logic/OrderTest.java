package com.optimus.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.optimus.api.Order;
import com.optimus.api.OrderCombineStrategy;
import com.optimus.api.OrderItem;

public class OrderTest {

	@Test
	public final void testCombine() {
		OrderCombineStrategy orderCombineStrategy = new OrderCombineStrategyImpl();
		Order order = orderCombineStrategy.combine(null);
		assertEquals("Nothing to combine - output null", null, order);
		
		List<Order> orders = new ArrayList<Order>();
		OrderFactoryImpl orderFactory = new OrderFactoryImpl();
		orders.add(orderFactory.createOrder());
		orders.add(orderFactory.createOrder());
		
		// Single order is returned
		orderCombineStrategy.setOrderFactory(orderFactory);
		order = orderCombineStrategy.combine(orders);
		assertTrue("Single order is returned", order != null);
		
		// Multiple SOs will be combined to create a PO. PO creation should take care of MOQ.
		orderCombineStrategy = new CombineSOToCreatePO();
		orderCombineStrategy.setOrderFactory(new PurchaseOrderFactory());
		order = orderCombineStrategy.combine(orders);
		assertTrue("Returned instance should be PO", order instanceof PurchaseOrder);
		
		/* Guest and user orders can be combined. If no shipping address is present in guest
		 * order items, user default shipping address will be used.
		 */
		
	}

}
class PurchaseOrder extends OrderImpl implements Order {
	
}

class OrderImpl implements Order {
	Long id;
	BigDecimal price;
	List<OrderItem> orderItems;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	/**
	 * @param orderItems the orderItems to set
	 */
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}