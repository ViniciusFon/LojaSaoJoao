package com.br.fontana.digital.dao;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.br.fontana.digital.entity.Loja;
import com.br.fontana.digital.entity.Situacao;
import com.br.fontana.digital.entity.Tipousuario;
import com.br.fontana.digital.entity.Usuario;


public interface UsuarioDAO {
	
	/**
	 * 
	 * @param cdUsuario
	 * @return
	 */
	public Usuario findOne(Long cdUsuario);

	/**
	 * 
	 * @param userName
	 * @return
	 * @throws UsernameNotFoundException
	 */
	public Usuario findByUsername(String userName) throws UsernameNotFoundException;
	
	/**
	 * 
	 * @param loja
	 * @return
	 */
	public List<Usuario> findByLoja(Loja loja);
	
	/**
	 * 
	 * @param loja
	 * @param grau
	 * @param situacao
	 * @param mes
	 * @param tipo
	 * @return
	 */
	public List<Usuario> findByFilter(Loja loja, Integer grau, Situacao situacao, Integer mes, Tipousuario tipo);
		
	
}
