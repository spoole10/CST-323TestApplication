package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.api.AnotherOrdersBusinessService;
import com.gcu.api.OrdersBusinessService;
import com.gcu.api.OrdersBusinessServiceInterface;

@Configuration
public class SpringConfig {
	
	@Bean(name="ordersBusinessService", initMethod="init", destroyMethod="destroy")
	public OrdersBusinessServiceInterface getOrdersBusiness() {
		return new OrdersBusinessService();
	}
}
