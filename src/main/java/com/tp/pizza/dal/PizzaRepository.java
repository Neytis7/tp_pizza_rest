package com.tp.pizza.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.pizza.bo.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long>{

	Pizza findById(int id);
}