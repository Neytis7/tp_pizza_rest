package com.tp.pizza.bll;

import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import com.tp.pizza.bo.Pizza;
import com.tp.pizza.dal.PizzaRepository;

@Service
@Profile("Default")
public class ServicePizzaProd implements PizzaService {

  private PizzaRepository pizzaRepository;

  public ServicePizzaProd(PizzaRepository pizzaRepository) {
    this.pizzaRepository = pizzaRepository;
  }

  @Override
  public List<Pizza> getPizzas() {
    return this.pizzaRepository.findAll();
  }

  @Override
  public Pizza getPizzaById(int id) {
    return this.pizzaRepository.findById(id);
  }

  @Override
  public void addPizza(Pizza pizza) {
    // TODO Auto-generated method stub

  }

  @Override
  public void modifiedPizza(Pizza pizza) {
    // TODO Auto-generated method stub

  }

  @Override
  public void deletePizza(Pizza pizza) {
    this.pizzaRepository.delete(pizza);
  }
}
