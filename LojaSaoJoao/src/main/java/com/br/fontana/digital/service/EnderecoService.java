package com.br.fontana.digital.service;

import java.util.List;

import com.br.fontana.digital.response.EnderecoResponse;

public interface EnderecoService {

	
	public List<EnderecoResponse> findByUsuario(Integer cdUsuario) throws Exception;
}
