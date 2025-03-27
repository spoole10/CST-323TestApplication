package com.gcu.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.OrderDataService;
import com.gcu.data.entity.OrderEntity;
import com.gcu.model.OrderModel;

public class OrdersBusinessService implements OrdersBusinessServiceInterface {
	private static final Logger logger = LoggerFactory.getLogger(OrdersBusinessService.class);

	@Autowired
	private OrderDataService service;
	
	@Override
	public void test() {
		logger.info("==========> Entering test method in OrdersBusinessService");
		System.out.println("Hello from the OrdersBusinessService");
		logger.info("==========> Exiting test method in OrdersBusinessService");
	}

	@Override
	public List<OrderModel> getOrders() {
		logger.info("==========> Entering getOrders method in OrdersBusinessService");
		// Get all the Entity Orders
		List<OrderEntity> ordersEntity = service.findAll();
		
		// Iterate over the Entity Orders and create a list of Domain Orders
		List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
		for(OrderEntity entity : ordersEntity) {
			ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity()));
		}
		
		// Return list of Domain Orders
		logger.info("==========> Exiting test method in OrdersBusinessService");
		return ordersDomain;
	}

	@Override
	public void init() {
		logger.info("==========> Entering init method in OrdersBusinessService");
		System.out.println("init OrdersBusinessService");
		logger.info("==========> Exiting init method in OrdersBusinessService");
	}

	@Override
	public void destroy() {
		logger.info("==========> Entering destroy method in OrdersBusinessService");
		System.out.println("destroy OrdersBusinessService");
		logger.info("==========> Exiting destroy method in OrdersBusinessService");
	}

}
