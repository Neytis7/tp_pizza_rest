package com.tp.pizza.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tp.pizza.bo.Pizza;
import com.tp.pizza.dal.PizzaRepository;

@Configuration
public class initDataFixture {

	@Bean
	 public CommandLineRunner initData(PizzaRepository pizzaRepository) 
	{
		 return (args) -> {
			 //PIZZAS
			 Pizza regina = new Pizza();
			 regina.setNom("regina");
			 regina.setDescription("regina description");
			 regina.setPrix(10f);
			 regina.setImage("pizza-regina.jpg");
			 
			 Pizza margharita = new Pizza();
			 margharita.setNom("margharita");
			 margharita.setDescription("margharita description");
			 margharita.setPrix(10.5f);
			 margharita.setImage("pizza-margharita.jpg");
			 
			 Pizza paysanne = new Pizza();
			 paysanne.setNom("paysanne");
			 paysanne.setDescription("paysanne description");
			 paysanne.setPrix(12.8f);
			 paysanne.setImage("pizza-paysanne.jpg");
			 
			 pizzaRepository.save(regina);
			 pizzaRepository.save(margharita);
			 pizzaRepository.save(paysanne);
		 };
	 }
}
