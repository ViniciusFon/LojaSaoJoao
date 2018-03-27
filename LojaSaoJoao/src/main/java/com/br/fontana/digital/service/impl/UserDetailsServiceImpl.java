package com.br.fontana.digital.service.impl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.br.fontana.digital.dao.UsuarioDAO;
import com.br.fontana.digital.entity.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private UsuarioDAO usuarioDAO;

	@Autowired
	public UserDetailsServiceImpl(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario applicationUser = usuarioDAO.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUsername(), applicationUser.getSenha(), Collections.emptyList());
    }
}