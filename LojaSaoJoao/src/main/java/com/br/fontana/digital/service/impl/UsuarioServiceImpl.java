package com.br.fontana.digital.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.fontana.digital.dao.UsuarioDAO;
import com.br.fontana.digital.entity.Loja;
import com.br.fontana.digital.entity.Usuario;
import com.br.fontana.digital.response.LojaResponse;
import com.br.fontana.digital.response.UsuarioResponse;
import com.br.fontana.digital.service.UsuarioService;
import com.br.fontana.digital.util.FormatUtils;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	public UsuarioServiceImpl(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@Transactional(readOnly=true)
	public UsuarioResponse findByUsername(String userName) throws Exception {
		
		return entityToResponse(usuarioDAO.findByUsername(userName));
	}

	@Transactional(readOnly=true)
	public UsuarioResponse findByCdUsuario(Integer cdUsuario) throws Exception {
		return entityToResponse(usuarioDAO.findOne(cdUsuario));
	}

	@Transactional(readOnly=true)
	public List<UsuarioResponse> findByLoja(Integer cdLoja) throws Exception {
		List<UsuarioResponse> response = new ArrayList<>();
		Loja l = new Loja();
		l.setCdLoja(cdLoja);
		
		List<Usuario> lst = usuarioDAO.findByLoja(l);
		lst.forEach(e -> response.add(entityToResponse(e)));
		
		return response;
	}
	
	private UsuarioResponse entityToResponse(Usuario usuario){
		UsuarioResponse response = null;
		if(usuario!=null){
			response = new UsuarioResponse();
			response.setCdUsuario(usuario.getCdUsuario());
			response.setDataElevacao(FormatUtils.parseDate(usuario.getDataElevacao()));
			response.setDataExaltacao(FormatUtils.parseDate(usuario.getDataExaltacao()));
			response.setDataFiliacao(FormatUtils.parseDate(usuario.getDataFiliacao()));
			response.setDataIniciacao(FormatUtils.parseDate(usuario.getDataIniciacao()));
			response.setDataInstalacao(FormatUtils.parseDate(usuario.getDataInstalacao()));
			response.setDataNasc(FormatUtils.parseDate(usuario.getDataNasc()));
			response.setGrau(usuario.getGrau());
			response.setLoja(new LojaResponse(usuario.getLoja().getNome(), usuario.getLoja().getCdLoja(), usuario.getLoja().getNumero()));
			response.setNome(usuario.getNome());
			response.setSituacao(usuario.getSituacao().getDescricao());
			response.setTipo(usuario.getTipousuario().getDescricao());
			response.setUsername(usuario.getUsername());
		}
		
		return response;
	}

}
