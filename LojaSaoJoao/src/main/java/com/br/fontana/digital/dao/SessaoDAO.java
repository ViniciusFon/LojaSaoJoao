package com.br.fontana.digital.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.fontana.digital.entity.Loja;
import com.br.fontana.digital.entity.Sessao;

@Repository
public interface SessaoDAO extends JpaRepository<Sessao, Integer>{

	/**
	 * 
	 * @param loja
	 * @return
	 */
	public List<Sessao> findByLoja(Loja loja);
	
	/**
	 * 
	 * @param loja
	 * @param grau
	 * @return
	 */
	public List<Sessao> findByLojaAndGrau(Loja loja, Integer grau);
	
	/**
	 * 
	 * @param loja
	 * @param dataIni
	 * @param dataFim
	 * @return
	 */
	public List<Sessao> findByLojaAndDataBetween(Loja loja, Date dataIni, Date dataFim);
	
	/**
	 * 
	 * @param loja
	 * @param grau
	 * @param dataIni
	 * @param dataFim
	 * @return
	 */
	public List<Sessao> findByLojaAndGrauAndDataBetween(Loja loja, Integer grau, Date dataIni, Date dataFim);
	
	/**
	 * 
	 * @param loja
	 * @param tpSessao
	 * @param dataIni
	 * @param dataFim
	 * @return
	 */
	public List<Sessao> findByLojaAndTpSessaoAndDataBetween(Loja loja, Integer tpSessao, Date dataIni, Date dataFim);
	
	/**
	 * 
	 * @param usuario
	 * @param dataIni
	 * @param dataFim
	 * @return
	 */
	@Query("select s from Sessao s join s.usuarios u where u.cdUsuario =?1 and s.data between ?2 and ?3")
	public List<Sessao> findByUsuarioAndData(Long usuario, Date dataIni, Date dataFim);
}
