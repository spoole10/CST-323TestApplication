package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.api.OrdersBusinessService;
import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;

@Service
public class OrderDataService implements DataAccessInterface<OrderEntity> {
	private static final Logger logger = LoggerFactory.getLogger(OrderDataService.class);
	@Autowired
	private OrdersRepository ordersRepository;
	
	@SuppressWarnings("unused")

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public OrderDataService(OrdersRepository ordersRepository, DataSource dataSource) {
		this.ordersRepository = ordersRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public OrderEntity findById(int id) {
		logger.info("==========> In findById method in OrdersDataService");
		return null;
	}
	
	@Override
	public List<OrderEntity> findAll() {
		logger.info("==========> Entering findAll method in OrdersDataService");
		List<OrderEntity> orders = new ArrayList<OrderEntity>();
		try {
			// Get all the Entity Orders
			Iterable<OrderEntity> ordersIterable = ordersRepository.findAll();
			
			// Convert to a List and return the List
			orders = new ArrayList<OrderEntity>();
			ordersIterable.forEach(orders::add);
		}
		catch (Exception e) {
			logger.error("Exception in findAll method in OrdersDataService", e);
			e.printStackTrace();
		}
		// Return the List
		logger.info("==========> Exiting findAll method in OrdersDataService");
		return orders;
	}

	@Override
	public boolean create(OrderEntity order) {
		logger.info("==========> Entering create method in OrdersDataService");
		
		// Example of "overriding" the CrudRepository save() because it simply is never called
		// You can inject a dataSource and use the jdbcTemplate to provide a customized implementation of a save() method
		String sql = "INSERT INTO orders(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES(?, ?, ?, ?)";
		try {
			// Execute SQL Insert
			jdbcTemplateObject.update(sql,
										 order.getOrderNo(),
										 order.getProductName(),
										 order.getPrice(),
										 order.getQuantity());
		}
		catch (Exception e) {
			logger.error("Exception in create method in OrdersDataService", e);
			e.printStackTrace();
			return false;
		}
		logger.info("==========> Exiting create method in OrdersDataService");
		return true;
	}

	@Override
	public boolean update(OrderEntity t) {
		// TODO Auto-generated method stub
		logger.info("==========> In update method in OrdersDataService");
		return true;
	}

	@Override
	public boolean delete(OrderEntity t) {
		logger.info("==========> In delete method in OrdersDataService");
		// TODO Auto-generated method stub
		return true;
	}
}
