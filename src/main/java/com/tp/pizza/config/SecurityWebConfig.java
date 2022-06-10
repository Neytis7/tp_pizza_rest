package com.tp.pizza.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.tp.pizza.bo.Membre;
import com.tp.pizza.bo.MembreUserDetail;
import com.tp.pizza.dal.MembreRepository;

@Component
public class SecurityWebConfig implements UserDetailsService {

	private MembreRepository membreRepository;
	
	public SecurityWebConfig(MembreRepository membreRepository) {
		this.membreRepository = membreRepository;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Membre membre = membreRepository.findByLogin(username);
		
		if (membre == null) {
			System.out.println("pas trouvé");
			throw new UsernameNotFoundException("Cet utilisateur n'a pas été trouvé.");
		} else {
			System.out.println("trouvé");
		}
		
		return new MembreUserDetail(membre);
	}
}