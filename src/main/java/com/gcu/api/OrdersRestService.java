package com.gcu.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.OrderList;
import com.gcu.model.OrderModel;



@RestController
@RequestMapping("/service")
public class OrdersRestService {
	private static final Logger logger = LoggerFactory.getLogger(OrdersRestService.class);
	
	@Autowired
	private OrdersBusinessServiceInterface service;
	
	@GetMapping(path="/getjson", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<OrderModel> getOrdersAsJson() {
		logger.info("==========> In getOrdersAsJson() at" + "/getjson");
		return service.getOrders();
	}
	
	@GetMapping(path="/getxml", produces={MediaType.APPLICATION_XML_VALUE})
	public OrderList getOrdersAsXml() {
		logger.info("==========> In getOrdersAsXml() at" + "/getxml");
		OrderList list = new OrderList();
		list.setOrders(service.getOrders());
		logger.info("==========> Exiting getOrdersAsXml()");
		return list;
	}
}
