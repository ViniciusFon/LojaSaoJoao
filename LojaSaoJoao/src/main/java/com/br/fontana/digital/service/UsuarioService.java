package com.br.fontana.digital.service;

import java.util.List;

import com.br.fontana.digital.response.UsuarioResponse;

public interface UsuarioService {

	public UsuarioResponse findByUsername(String userName) throws Exception;
	
	public UsuarioResponse findByCdUsuario(Integer cdUsuario) throws Exception;
	
	public List<UsuarioResponse> findByLoja(Integer cdLoja) throws Exception;
}
