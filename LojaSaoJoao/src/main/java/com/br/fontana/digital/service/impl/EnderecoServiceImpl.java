package com.br.fontana.digital.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.fontana.digital.dao.EnderecoDAO;
import com.br.fontana.digital.entity.Endereco;
import com.br.fontana.digital.entity.Usuario;
import com.br.fontana.digital.response.EnderecoResponse;
import com.br.fontana.digital.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService{
	
	private EnderecoDAO enderecoDAO;
	
	@Autowired
	public EnderecoServiceImpl(EnderecoDAO enderecoDAO) {
		this.enderecoDAO = enderecoDAO;
	}

	@Transactional(readOnly=true)
	public List<EnderecoResponse> findByUsuario(Long cdUsuario) throws Exception {
		List<EnderecoResponse> resp = new ArrayList<>();
		Usuario user = new Usuario();
		user.setCdUsuario(cdUsuario);
		
		List<Endereco> lst = enderecoDAO.findByUsuario(user);
		lst.forEach(e -> resp.add(entityToResponse(e)));
		
		return resp;
	}

	private EnderecoResponse entityToResponse(Endereco end){
		EnderecoResponse response = new EnderecoResponse();
		response.setCdEndereco(end.getCdEndereco());
		response.setBairro(end.getBairro());
		response.setCdTipo(end.getCdTipo());
		response.setCep(end.getCep());
		response.setCidade(end.getCidade());
		response.setComplemento(end.getComplemento());
		response.setEstado(end.getEstado());
		response.setLogradouro(end.getLogradouro());
		response.setNumero(end.getNumero());
		
		return response;
		
	}
}
