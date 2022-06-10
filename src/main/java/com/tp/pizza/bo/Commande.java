package com.tp.pizza.bo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "Commandes")
public class Commande {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String nameCommande;

  @ManyToMany
  private List<Pizza> listPizza;

  private float totalPrice;

  @Override
  public String toString() {
    return "Commande [id=" + id + ", nameCommande=" + nameCommande + ", totalPrice=" + totalPrice
        + "]";
  }

}
