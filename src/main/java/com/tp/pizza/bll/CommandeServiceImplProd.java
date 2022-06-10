package com.tp.pizza.bll;

import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import com.tp.pizza.bo.Commande;
import com.tp.pizza.dal.CommandeRepository;

@Service
@Profile("Default")
public class CommandeServiceImplProd implements CommandeService {

  private CommandeRepository commandeRepo;

  public CommandeServiceImplProd(CommandeRepository commandeRepo) {
    super();
    this.commandeRepo = commandeRepo;
  }

  @Override
  public List<Commande> getListCommandes() {
    return this.commandeRepo.findAll();
  }

  @Override
  public Commande getCommandeById(long id) {
    return this.commandeRepo.getById(id);
  }

  @Override
  public void addCommande(Commande commande) {
    this.commandeRepo.save(commande);
  }

  @Override
  public void modifiedCommande(Commande commande) {
    this.commandeRepo.save(commande);
  }

  @Override
  public void deleteCommande(Commande commande) {
    this.commandeRepo.delete(commande);
  }



}
