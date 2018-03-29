package com.br.fontana.digital.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.br.fontana.digital.entity.Loja;
import com.br.fontana.digital.entity.Situacao;
import com.br.fontana.digital.entity.Tipousuario;
import com.br.fontana.digital.entity.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer>{

	public Usuario findByUsername(String userName) throws UsernameNotFoundException;
	
	public List<Usuario> findByLoja(Loja loja);
	
	public List<Usuario> findByLojaAndGrau(Loja loja, Integer grau);
	
	public List<Usuario> findByLojaAndGrauAndSituacao(Loja loja, Integer grau, Situacao situacao);
	
	@Query("select u from Usuario u where u.loja = ?1 and month(u.dataNasc) = ?2 and u.situacao.cdSituacao=1")
	public List<Usuario> findByLojaAndMonth(Loja loja, Integer mes);
	
	public List<Usuario> findByLojaAndSituacao(Loja loja, Situacao situacao);
	
	public List<Usuario> findByLojaAndTipousuario(Loja loja, Tipousuario tipo);
	
	public List<Usuario> findByLojaAndTipousuarioAndSituacao(Loja loja, Tipousuario tipo, Situacao situacao);
	
	
	
	
}
