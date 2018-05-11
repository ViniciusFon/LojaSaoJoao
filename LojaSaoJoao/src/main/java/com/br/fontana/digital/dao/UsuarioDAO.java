package com.br.fontana.digital.dao;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.br.fontana.digital.entity.Loja;
import com.br.fontana.digital.entity.Situacao;
import com.br.fontana.digital.entity.Tipousuario;
import com.br.fontana.digital.entity.Usuario;


public interface UsuarioDAO {
	
	public Usuario findOne(Integer cdUsuario);

	public Usuario findByUsername(String userName) throws UsernameNotFoundException;
	
	public List<Usuario> findByLoja(Loja loja);
	
	public List<Usuario> findByFilter(Loja loja, Integer grau, Situacao situacao, Integer mes, Tipousuario tipo);
		
	
}
