package com.tp.pizza.bo;

import javax.swing.ImageIcon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Pizza {

	private int id;
	private String nom;
	private String description;
	private int prix;
	private ImageIcon image;
	
	public Pizza(String nom, String description, int prix, ImageIcon image) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.image = image;
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", nom=" + nom + ", description=" + description + ", prix=" + prix + ", image="
				+ image + "]";
	}	
	
	
}
