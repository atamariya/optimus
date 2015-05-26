package com.optimus.api;

import java.math.BigDecimal;
import java.util.List;

public interface Order {
	/**
	 * null represents a new order.
	 * @return
	 */
	Long getId();
	/**
	 * Named as price to improve reusability. Create a separate interface with total if required.
	 * @return
	 */
	BigDecimal getPrice();
	
	List<OrderItem> getOrderItems();
}
