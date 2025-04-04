/*
 * Saralyn Poole
 * CST-339
 * Activity 3
 * 2/07/2024
 */
package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gcu.api.OrdersBusinessService;
import com.gcu.api.OrdersBusinessServiceInterface;
import com.gcu.api.SecurityBusinessService;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private OrdersBusinessServiceInterface service;
	
	@Autowired
	private SecurityBusinessService security;
	
    @GetMapping("/")
    public String display(Model model) {
    	logger.info("==========> Entering display method in LoginController");
    	// Display Login Form View
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        logger.info("==========> Exiting display method in LoginController");
        return "login";
    }
    
    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
    	// Check for validation errors
    	if (bindingResult.hasErrors()) {
    		model.addAttribute("title", "Login Form");
            logger.info("Error in doLogin in Login Controller");
    		return "login";
    	}
    	logger.info("==========> Entering doLogin method in LoginController");
    	 // Set model attributes
        model.addAttribute("title", "My Orders");
		model.addAttribute("orders", service.getOrders());
        
        service.test();
        security.authenticate("username", "password");

        // Navigate to the "orders" view
        logger.info("==========> Exiting doLogin method in LoginController");
        return "orders";
    }
}
