package com.br.fontana.digital.service;

import java.util.List;

import com.br.fontana.digital.response.EnderecoResponse;

public interface EnderecoService {

	/**
	 * 
	 * @param cdUsuario
	 * @return
	 * @throws Exception
	 */
	public List<EnderecoResponse> findByUsuario(Long cdUsuario) throws Exception;
}
