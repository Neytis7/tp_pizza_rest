package com.tp.pizza.bo;

import javax.swing.ImageIcon;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {

  private int id;
  private String nom;
  private String description;
  private float prix;
  private ImageIcon image;

  public Pizza(String nom, String description, float prix, ImageIcon image) {
    super();
    this.nom = nom;
    this.description = description;
    this.prix = prix;
    this.image = image;
  }

  @Override
  public String toString() {
    return "Pizza [id=" + id + ", nom=" + nom + ", description=" + description + ", prix=" + prix
        + ", image=" + image + "]";
  }


}
