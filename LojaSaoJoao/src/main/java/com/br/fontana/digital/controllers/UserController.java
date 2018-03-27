package com.br.fontana.digital.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.fontana.digital.response.UsuarioResponse;
import com.br.fontana.digital.service.UsuarioService;

@RestController
@RequestMapping("/v1/users")
public class UserController {

	private UsuarioService usuarioService;
	
	@Autowired
	public UserController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<UsuarioResponse> findUser(@PathVariable Integer id) throws Exception{
		UsuarioResponse response = usuarioService.findByCdUsuario(id);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/loja", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<UsuarioResponse>> findByLoja(@RequestParam("cdLoja") Integer cdLoja)throws Exception {

        List<UsuarioResponse> lst = usuarioService.findByLoja(cdLoja);

        return new ResponseEntity<>(lst, HttpStatus.OK);
    }
}
