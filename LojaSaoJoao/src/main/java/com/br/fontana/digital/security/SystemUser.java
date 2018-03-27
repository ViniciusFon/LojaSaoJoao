package com.br.fontana.digital.security;

import java.util.Collection;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;

public class SystemUser extends User {

private static final long serialVersionUID = 1L;
	
	private String nome;
	private Integer loja;
	
	public SystemUser(String nome, String username, String password, Integer loja, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		
		this.nome = nome;
		this.loja = loja;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Integer getLoja() {
		return loja;
	}
}
