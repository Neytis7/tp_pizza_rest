package com.tp.pizza.bll;

import java.util.List;
import com.tp.pizza.bo.Pizza;

public interface PizzaService {

  List<Pizza> getPizzas();

  Pizza getPizzaById(long id);

  void addPizza(Pizza pizza);

  void modifiedPizza(Pizza pizza);

  void deletePizza(Pizza pizza);

}
