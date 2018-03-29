package com.br.fontana.digital.response;

public class EnderecoResponse {

	private Integer cdEndereco;

	private String bairro;

	private int cdTipo;

	private String cep;

	private String cidade;

	private String complemento;

	private String estado;

	private String logradouro;

	private String numero;

	public Integer getCdEndereco() {
		return cdEndereco;
	}

	public void setCdEndereco(Integer cdEndereco) {
		this.cdEndereco = cdEndereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getCdTipo() {
		return cdTipo;
	}

	public void setCdTipo(int cdTipo) {
		this.cdTipo = cdTipo;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	

}
