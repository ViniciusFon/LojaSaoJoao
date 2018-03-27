package com.br.fontana.digital.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.br.fontana.digital.entity.Loja;
import com.br.fontana.digital.entity.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer>{

	public Usuario findByUsername(String userName) throws UsernameNotFoundException;
	
	public List<Usuario> findByLoja(Loja loja);
}
