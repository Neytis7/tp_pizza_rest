// package com.tp.pizza.bll;
//
// import java.util.ArrayList;
// import java.util.List;
// import org.springframework.beans.BeanUtils;
// import org.springframework.context.annotation.Profile;
// import org.springframework.stereotype.Service;
// import com.tp.pizza.bo.Pizza;
//
// @Service
// @Profile("test")
// public class PizzaServiceImpl implements PizzaService {
//
// List<Pizza> listPizza;
//
// public PizzaServiceImpl() {
// super();
// this.listPizza = new ArrayList<>();
// listPizza.add(new Pizza(1, "4 frommages", "Pizza avec du frommage", 7.99f, null));
// listPizza.add(new Pizza(2, "kebaba", "Pizza au kebab", 10.50f, null));
// }
//
// @Override
// public List<Pizza> getPizzas() {
// return this.listPizza;
// }
//
// @Override
// public Pizza getPizzaById(long id) {
// Pizza pizzaARetourner = null;
// for (Pizza pizza : this.listPizza) {
// if (pizza.getId() == id) {
// pizzaARetourner = pizza;
// break;
// }
// }
// return pizzaARetourner;
// }
//
// @Override
// public void addPizza(Pizza pizza) {
// this.listPizza.add(pizza);
// }
//
// @Override
// public void modifiedPizza(Pizza pizza) {
// for (Pizza p : this.listPizza) {
// if (p.getId() == pizza.getId()) {
// BeanUtils.copyProperties(pizza, p);
// break;
// }
// }
// }
//
// @Override
// public void deletePizza(Pizza pizza) {
// for (Pizza p : this.listPizza) {
// if (p.getId() == pizza.getId()) {
// this.listPizza.remove(p);
// break;
// }
// }
// }
// }
