package com.br.fontana.digital.service;

import java.util.List;

import com.br.fontana.digital.response.UsuarioResponse;

public interface UsuarioService {

	public UsuarioResponse findByUsername(String userName) throws Exception;
	
	public UsuarioResponse findByCdUsuario(Integer cdUsuario) throws Exception;
	
	public List<UsuarioResponse> findByLoja(Integer cdLoja) throws Exception;
	
	public List<UsuarioResponse> findByLojaAndGrau(Integer cdLoja, Integer cdGrau) throws Exception;
	
	public List<UsuarioResponse> findByLojaAndMes(Integer cdLoja, Integer mes) throws Exception;
	
	public List<UsuarioResponse> findByLojaAndSituacao(Integer cdLoja, Integer cdSituacao) throws Exception;
	
	public List<UsuarioResponse> findByLojaAndTipousuario(Integer cdLoja, Integer cdTipo) throws Exception;
	
	public List<UsuarioResponse> findByLojaAndGrauAndSituacao(Integer cdLoja, Integer grau, Integer cdSituacao) throws Exception;
	
	public List<UsuarioResponse> findByLojaAndTipousuarioAndSituacao(Integer cdLoja, Integer cdTipo,Integer cdSituacao) throws Exception;
}
