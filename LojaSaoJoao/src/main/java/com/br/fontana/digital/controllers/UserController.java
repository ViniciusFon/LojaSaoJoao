package com.br.fontana.digital.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.fontana.digital.response.EnderecoResponse;
import com.br.fontana.digital.response.UsuarioResponse;
import com.br.fontana.digital.service.EnderecoService;
import com.br.fontana.digital.service.SessaoService;
import com.br.fontana.digital.service.UsuarioService;

@RestController
@RequestMapping("/v1/users")
public class UserController {

	private UsuarioService usuarioService;
	private EnderecoService enderecoService;
	private SessaoService sessaoService;
	
	@Autowired
	public UserController(UsuarioService usuarioService, EnderecoService enderecoService, SessaoService sessaoService) {
		this.usuarioService = usuarioService;
		this.enderecoService = enderecoService;
		this.sessaoService = sessaoService;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<UsuarioResponse> findUser(@PathVariable Long id) throws Exception{
		UsuarioResponse response = usuarioService.findByCdUsuario(id);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/lojas/{cdLoja}/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<UsuarioResponse>> findByFilter(@PathVariable("cdLoja") Integer cdLoja,
    		@RequestParam(name="grau", required=false) Integer nrGrau,
    		@RequestParam(name="status", required=false) Integer cdSituacao,
    		@RequestParam(name="mesNasc", required=false) Integer mes,
    		@RequestParam(name="tipo", required=false) Integer cdTipo)throws Exception {

		if(StringUtils.isEmpty(cdLoja))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
        List<UsuarioResponse> lst = usuarioService.findByFilter(cdLoja, nrGrau, cdSituacao, mes, cdTipo);

        return new ResponseEntity<>(lst, HttpStatus.OK);
    }
	
		
	
	/*@RequestMapping(value = "/{id}/works/",method = RequestMethod.GET, produces = "application/json")
	public void findWorksByUser(@PathVariable("id") Integer id){
		
	}
	
	@RequestMapping(value = "/{id}/works/", params="grau", method = RequestMethod.GET, produces = "application/json")
	public void findWorksByUserAndGrau(@PathVariable("id") Integer id,@RequestParam("grau") Integer nrGrau){
		
	}
	
	@RequestMapping(value = "/{id}/works/{idWork}", method = RequestMethod.GET, produces = "application/json")
	public void findWorkByUserAndId(@PathVariable("id") Integer id,@PathVariable("idWork") Integer idWork){
		
	}*/
	
	@RequestMapping(value = "/{id}/adresses/",method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<EnderecoResponse>>  findAdressesByUser(@PathVariable("id") Long id) throws Exception{
		
		if(StringUtils.isEmpty(id))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		List<EnderecoResponse> lst = enderecoService.findByUsuario(id);
		
		return new ResponseEntity<>(lst, HttpStatus.OK);
	}
	
	/*@RequestMapping(value = "/{id}/adresses/{idAdress}", method = RequestMethod.GET, produces = "application/json")
	public void findAdressByUserAndId(@PathVariable("id") Integer id,@PathVariable("idAdress") Integer idAdress){
		
	}*/
	
	@RequestMapping(value = "/{id}/sessions/", params={"dataIni","dataFim"}, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity findSessionByUserAndDate(@PathVariable("id") Long id,@RequestParam("dataIni") String dataIni, @RequestParam("dataFim") String dataFim) throws Exception{
		
		if(id == null || StringUtils.isEmpty(dataIni) || StringUtils.isEmpty(dataFim))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		sessaoService.find(id, dataIni, dataFim);
		
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
}
