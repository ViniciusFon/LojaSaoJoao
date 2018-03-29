package com.br.fontana.digital.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.fontana.digital.entity.Endereco;
import com.br.fontana.digital.entity.Loja;
import com.br.fontana.digital.entity.Tipousuario;
import com.br.fontana.digital.entity.Usuario;

@Repository
public interface EnderecoDAO extends JpaRepository<Endereco, Integer>{

	public List<Endereco> findByUsuario(Usuario user);
	
	@Query("select e from Endereco e where e.usuario.loja = ?1 and e.cdTipo = ?2")
	public List<Endereco> findByLojaAndCdTipo(Loja loja, Integer cdTipo);
	
	@Query("select e from Endereco e where e.usuario.loja = ?1 and e.usuario.tipousuario = ?2 and e.usuario.situacao.cdSituacao = 1")
	public List<Endereco> findByLojaAndTipoUsuario(Loja loja, Tipousuario tipo);
}
