package com.tp.pizza.bo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MembreUserDetail implements UserDetails {
	
	private List<GrantedAuthority> authorities;
	
	private Membre membre;
	
	public MembreUserDetail(Membre membre) {
		this.membre = membre;
		this.authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}
	
	public Membre getMember() {
		return membre;
	}

	public void setMember(Membre membre) {
		this.membre = membre;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return membre.getPassword();
	}

	@Override
	public String getUsername() {
		return membre.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
