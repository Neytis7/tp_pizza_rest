package com.tp.pizza.bll;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tp.pizza.bo.Pizza;
import com.tp.pizza.dal.PizzaRepository;

@Service
public class ServicePizzaProd {

	private PizzaRepository pizzaRepository;
	
	public ServicePizzaProd(PizzaRepository pizzaRepository)
	{
		this.pizzaRepository = pizzaRepository;
	}
	
	public List<Pizza> getAllPizza()
	{
		return this.pizzaRepository.findAll();
	}
	
	public Pizza getPizzaByFind(int id)
	{
		return this.pizzaRepository.findById(id);
	}
}
