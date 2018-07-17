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
	

	/**
	 * 
	 * @param usuario
	 * @return
	 */
	public List<Trabalho> findByUsuario(Usuario usuario);
	
	/**
	 * 
	 * @param usuario
	 * @param titulo
	 * @return
	 */
	public List<Trabalho> findByUsuarioAndTituloContaining(Usuario usuario, String titulo);
	
	/**
	 * 
	 * @param usuario
	 * @param cdGrau
	 * @return
	 */
	public List<Trabalho> findByUsuarioAndGrau(Usuario usuario, Integer cdGrau);
	
	/**
	 * 
	 * @param usuario
	 * @param dataIni
	 * @param dataFim
	 * @return
	 */
	public List<Trabalho> findByUsuarioAndDataLeiBetween(Usuario usuario, Date dataIni, Date dataFim);
	
	/**
	 * 
	 * @param usuario
	 * @return
	 */
	public List<Trabalho> findByUsuarioAndDataLeiIsNull(Usuario usuario);
	
	/**
	 * 
	 * @param loja
	 * @return
	 */
	public List<Trabalho> findByLoja(Loja loja);
	
	/**
	 * 
	 * @param loja
	 * @param cdGrau
	 * @return
	 */
	public List<Trabalho> findByLojaAndGrau(Loja loja, Integer cdGrau);
		
	/**
	 * 
	 * @param loja
	 * @param dataIni
	 * @param dataFim
	 * @return
	 */
	public List<Trabalho> findByLojaAndDataLeiBetween(Loja loja, Date dataIni, Date dataFim);
	
	/**
	 * 
	 * @param loja
	 * @return
	 */
	public List<Trabalho> findByLojaAndDataLeiIsNull(Loja loja);
	
	/**
	 * 
	 * @param loja
	 * @param cdGrau
	 * @return
	 */
	public List<Trabalho> findByLojaAndGrauAndDataLeiIsNull(Loja loja, Integer cdGrau);
	
	/**
	 * 
	 * @param loja
	 * @param titulo
	 * @return
	 */
	public List<Trabalho> findByLojaAndTituloContaining(Loja loja, String titulo);
}
