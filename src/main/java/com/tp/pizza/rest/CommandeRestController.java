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
import com.tp.pizza.bll.CommandeService;
import com.tp.pizza.bll.PizzaService;
import com.tp.pizza.bo.Commande;
import com.tp.pizza.bo.Pizza;

@RestController
@RequestMapping("/rest")
public class CommandeRestController {

  private CommandeService commandeService;

  public CommandeRestController(CommandeService commandeService, PizzaService pizzaService) {
    super();
    this.commandeService = commandeService;
  }

  @GetMapping("/commandes")
  public List<Commande> getListCommandes() {
    return commandeService.getListCommandes();
  }

  @GetMapping("/commandes/{id}")
  public Commande getCommande(@PathVariable("id") int id) {
    Commande commande = commandeService.getCommandeById(id);
    return commande;
  }

  @PostMapping("/commandes")
  public ResponseEntity<Commande> addCommande(@RequestBody Commande commande) {

    if (commande.getListPizza().isEmpty() || commande.getNameCommande().isBlank()) {
      return new ResponseEntity<Commande>(HttpStatus.BAD_REQUEST);
    }
    CalculPrice(commande);
    commandeService.addCommande(commande);
    return new ResponseEntity<Commande>(commande, HttpStatus.CREATED);
  }

  @PutMapping("/commandes")
  public ResponseEntity<Commande> modifiedCommande(@RequestBody Commande commande) {

    System.out.println(commande);
    if (commande.getListPizza().isEmpty() || commande.getNameCommande().isBlank()) {
      return new ResponseEntity<Commande>(HttpStatus.BAD_REQUEST);
    }

    CalculPrice(commande);
    commandeService.modifiedCommande(commande);
    return new ResponseEntity<Commande>(commande, HttpStatus.OK);
  }

  @DeleteMapping("/commandes/{id}")
  public ResponseEntity<?> deleteCommande(@PathVariable("id") int id) {
    Commande commande = this.commandeService.getCommandeById(id);

    if (commande == null) {
      return new ResponseEntity<Commande>(HttpStatus.BAD_REQUEST);
    }
    this.commandeService.deleteCommande(commande);
    return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
  }

  public void CalculPrice(Commande commande) {
    float totalPrice = 0f;
    for (Pizza pizza : commande.getListPizza()) {
      totalPrice = totalPrice + pizza.getPrix();
    }
    commande.setTotalPrice(totalPrice);
  }
}
