package com.tp.pizza.bll;

import java.util.List;
import com.tp.pizza.bo.Commande;

public interface CommandeService {

  List<Commande> getListCommandes();

  Commande getCommandeById(long id);

  void addCommande(Commande commande);

  void modifiedCommande(Commande commande);

  void deleteCommande(Commande commande);
}
