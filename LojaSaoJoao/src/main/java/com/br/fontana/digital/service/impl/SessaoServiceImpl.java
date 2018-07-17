package com.br.fontana.digital.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.fontana.digital.dao.SessaoDAO;
import com.br.fontana.digital.entity.Sessao;
import com.br.fontana.digital.service.SessaoService;
import com.br.fontana.digital.util.FormatUtils;

@Service
public class SessaoServiceImpl implements SessaoService{

	private SessaoDAO sessaoDAO;
	
	public SessaoServiceImpl(SessaoDAO sessaoDAO) {
		this.sessaoDAO = sessaoDAO;
	}
	
	@Transactional(readOnly=true)
	public void find(Long cdUsuario, String dataIni, String dataFim) throws Exception{
		
		Date dt_ini = FormatUtils.parseDate(dataIni,"dd-MM-yyyy");
		Date dt_fim = FormatUtils.parseDate(dataFim,"dd-MM-yyyy");
		
		if(dt_ini==null || dt_fim==null)
			throw new Exception("Data Invalida");
		
		List<Sessao> lst = sessaoDAO.findByUsuarioAndData(cdUsuario, dt_ini, dt_fim);
		
		System.out.println(lst.size());
		
	}
}
