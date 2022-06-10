package com.tp.pizza.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tp.pizza.bo.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

}
