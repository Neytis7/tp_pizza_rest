package com.tp.pizza.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tp.pizza.bll.PizzaService;
import com.tp.pizza.bo.Pizza;

@RestController
@RequestMapping("/rest")
public class PizzaRestController {

  private PizzaService pizzaService;

  public PizzaRestController(PizzaService pizzaService) {
    super();
    this.pizzaService = pizzaService;
  }

  @GetMapping("/pizzas")
  public List<Pizza> getPizzas() {
    return pizzaService.getPizzas();
  }

  @GetMapping("/pizzas/{id}")
  public Pizza getPizza(@PathVariable("id") int id) {
    Pizza pizza = pizzaService.getPizzaById(id);
    return pizza;
  }

  @PostMapping("/pizzas")
  public ResponseEntity<Pizza> addPizza(@RequestBody Pizza pizza) {
    if (
    	pizza.getPrix() <= 0 || 
		pizza.getNom().trim().isBlank() || 
		pizza.getDescription().trim().isBlank()
		
   ) {
      return new ResponseEntity<Pizza>(HttpStatus.BAD_REQUEST);
    }
    
    pizzaService.addPizza(pizza);
    
    return new ResponseEntity<Pizza>(pizza, HttpStatus.CREATED);
  }

  @PutMapping("/pizzas")
  public ResponseEntity<Pizza> modifiedPizza(@RequestBody Pizza pizza) {
	  if (
	    	pizza.getPrix() <= 0 || 
			pizza.getNom().trim().isBlank() || 
			pizza.getDescription().trim().isBlank()
				
	   ) {
		  
	      return new ResponseEntity<Pizza>(HttpStatus.BAD_REQUEST);
	    }

    pizzaService.modifiedPizza(pizza);

    return new ResponseEntity<Pizza>(pizza, HttpStatus.OK);
  }

  @DeleteMapping("/pizzas/{id}")
  public ResponseEntity<?> deletePizza(@PathVariable("id") int id) {
	  Pizza pizza = this.pizzaService.getPizzaById(id);
	  
	  if (pizza == null) {
		  return new ResponseEntity<Pizza>(HttpStatus.BAD_REQUEST);
	  }
	  
	  pizzaService.deletePizza(pizza);
	  
	  return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
  }
}