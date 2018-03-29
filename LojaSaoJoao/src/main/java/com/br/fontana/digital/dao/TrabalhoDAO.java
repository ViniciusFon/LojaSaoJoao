package com.br.fontana.digital.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.fontana.digital.entity.Loja;
import com.br.fontana.digital.entity.Trabalho;
import com.br.fontana.digital.entity.Usuario;

@Repository
public interface TrabalhoDAO extends JpaRepository<Trabalho, Integer>{

	public List<Trabalho> findByUsuario(Usuario usuario);
	
	public List<Trabalho> findByUsuarioAndTituloContaining(Usuario usuario, String titulo);
	
	public List<Trabalho> findByUsuarioAndGrau(Usuario usuario, Integer cdGrau);
	
	public List<Trabalho> findByLoja(Loja loja);
	
	public List<Trabalho> findByLojaAndGrau(Loja loja, Integer cdGrau);
	
	public List<Trabalho> findByUsuarioAndDataLeiBetween(Usuario usuario, Date dataIni, Date dataFim);
	
	public List<Trabalho> findByLojaAndDataLeiBetween(Loja loja, Date dataIni, Date dataFim);
	
	public List<Trabalho> findByLojaAndDataLeiIsNull(Loja loja);
	
	public List<Trabalho> findByLojaAndGrauAndDataLeiIsNull(Loja loja, Integer cdGrau);
	
	public List<Trabalho> findByLojaAndAndTituloContaining(Loja loja, String titulo);
}
