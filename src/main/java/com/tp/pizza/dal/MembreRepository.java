package com.tp.pizza.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.pizza.bo.Membre;

public interface MembreRepository extends JpaRepository<Membre, Long>{

	public Membre findByLogin(String login);
}