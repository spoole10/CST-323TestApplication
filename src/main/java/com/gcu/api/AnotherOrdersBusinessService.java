package com.gcu.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gcu.model.OrderModel;

public class AnotherOrdersBusinessService implements OrdersBusinessServiceInterface {
	
	private static final Logger logger = LoggerFactory.getLogger(AnotherOrdersBusinessService.class);
	@Override
	public void test() {
		logger.info("==========> Entering test method in AnotherOrdersBusinessService");
		System.out.println("Hello from AnotherOrdersBusinessService");
		logger.info("==========> Exiting test method in AnotherOrdersBusinessService");
	}

	@Override
	public List<OrderModel> getOrders() {
		logger.info("==========> Entering getOrders method in AnotherOrdersBusinessService");
		// Create some Orders
    	List<OrderModel> orders = new ArrayList<OrderModel>();
    	orders.add(new OrderModel(0L, "0000000001", "Product 1", 1.00f, 1));
    	orders.add(new OrderModel(1L, "0000000002", "Product 2", 2.00f, 2));
    	orders.add(new OrderModel(2L, "0000000003", "Product 3", 3.00f, 3));
    	orders.add(new OrderModel(3L, "0000000004", "Product 4", 4.00f, 4));
    	orders.add(new OrderModel(4L, "0000000005", "Product 5", 5.00f, 5));
    	logger.info("==========> Exiting getOrders method in AnotherOrdersBusinessService");
		return orders;
	}

	@Override
	public void init() {
		logger.info("==========> Entering init method in AnotherOrdersBusinessService");
		System.out.println("init AnotherOrdersBusinessService");
		logger.info("==========> Exiting init method in AnotherOrdersBusinessService");
	}

	@Override
	public void destroy() {
		logger.info("==========> Entering destroy method in AnotherOrdersBusinessService");
		System.out.println("destroy AnotherOrdersBusinessService");
		logger.info("==========> Exiting destroy method in AnotherOrdersBusinessService");
	}

}
