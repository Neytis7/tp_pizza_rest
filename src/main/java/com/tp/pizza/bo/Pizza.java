package com.tp.pizza.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "pizza")
public class Pizza {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotBlank
  @Column(nullable = false, length = 55)
  private String nom;

  @NotBlank
  @Column(nullable = false, length = 255)
  private String description;

  @Min(0)
  @Column(columnDefinition = "TINYINT")
  private float prix;

  @NotBlank
  private String image;

  public Pizza(String nom, String description, float prix, String image) {
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
