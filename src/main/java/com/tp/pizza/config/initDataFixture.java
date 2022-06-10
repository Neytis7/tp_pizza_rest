package com.tp.pizza.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.tp.pizza.bo.Membre;
import com.tp.pizza.bo.Commande;
import com.tp.pizza.bo.Pizza;
import com.tp.pizza.dal.MembreRepository;
import com.tp.pizza.dal.CommandeRepository;
import com.tp.pizza.dal.PizzaRepository;

@Configuration
public class initDataFixture {
  @Bean
  public CommandLineRunner initData(
		  PizzaRepository pizzaRepository,
      CommandeRepository commandeRepository,
      MembreRepository membreRepository,
      PasswordEncoder passwordEncoder
  ) {
    return (args) -> {
      // PIZZAS
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

      // // COMMANDES
      Commande commande1 = new Commande();
      commande1.setNameCommande("Creed");
      List<Pizza> listPizza = new ArrayList<>();
      listPizza.add(paysanne);
      listPizza.add(regina);
      listPizza.add(paysanne);
      commande1.setListPizza(listPizza);
      CalculPrice(commande1);
      commandeRepository.save(commande1);
      
      //MEMBRES
	 Membre faf = new Membre (1l, "FAFET", "Théophane", "faf", passwordEncoder.encode("azerty"));
	 Membre neytis = new Membre (2l, "MEDA", "Curtis", "neytis", passwordEncoder.encode("azerty"));
	 
	 membreRepository.save(faf);
	 membreRepository.save(neytis);
    };
  }

  public void CalculPrice(Commande commande) {
    float totalPrice = 0f;
    for (Pizza pizza : commande.getListPizza()) {
      totalPrice = totalPrice + pizza.getPrix();
    }
    commande.setTotalPrice(totalPrice);
  }
}
