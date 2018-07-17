package com.br.fontana.digital.service;

import java.util.List;

import com.br.fontana.digital.response.UsuarioResponse;

public interface UsuarioService {

	/**
	 * 
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public UsuarioResponse findByUsername(String userName) throws Exception;
	
	/**
	 * 
	 * @param cdUsuario
	 * @return
	 * @throws Exception
	 */
	public UsuarioResponse findByCdUsuario(Long cdUsuario) throws Exception;
	
	/**
	 * 
	 * @param cdLoja
	 * @return
	 * @throws Exception
	 */
	public List<UsuarioResponse> findByLoja(Integer cdLoja) throws Exception;
	
	/**
	 * 
	 * @param cdLoja
	 * @param cdGrau
	 * @param cdSituacao
	 * @param mes
	 * @param cdTipo
	 * @return
	 * @throws Exception
	 */
	public List<UsuarioResponse> findByFilter(Integer cdLoja, Integer cdGrau, Integer cdSituacao, Integer mes,  Integer cdTipo) throws Exception;
}
