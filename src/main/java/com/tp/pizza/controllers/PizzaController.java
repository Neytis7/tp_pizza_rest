package com.tp.pizza.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.tp.pizza.bll.ServicePizzaProd;

@Controller
public class PizzaController {

	private ServicePizzaProd servicePizza;
	
	public PizzaController(ServicePizzaProd servicePizza)
	{
		this.servicePizza = servicePizza;
	}
	
	@GetMapping("/")
	public String index()
	{
		return "index";
	}

	public ServicePizzaProd getServicePizza() {
		return servicePizza;
	}
}
