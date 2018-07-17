package com.br.fontana.digital.service;

public interface SessaoService {

	/**
	 * 
	 * @param cdUsuario
	 * @param dataIni
	 * @param dataFim
	 * @throws Exception
	 */
	public void find(Long cdUsuario, String dataIni, String dataFim) throws Exception;
}
