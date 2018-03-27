package com.br.fontana.digital.response;

public class LojaResponse {

	private String nomeLoja;
	private Integer cdLoja;
	private Integer nrLoja;
	
	public LojaResponse() {
		
	}
	
	public LojaResponse(String nomeLoja, Integer cdLoja, Integer nrLoja) {
		super();
		this.nomeLoja = nomeLoja;
		this.cdLoja = cdLoja;
		this.nrLoja = nrLoja;
	}
	public String getNomeLoja() {
		return nomeLoja;
	}
	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}
	public Integer getCdLoja() {
		return cdLoja;
	}
	public void setCdLoja(Integer cdLoja) {
		this.cdLoja = cdLoja;
	}
	public Integer getNrLoja() {
		return nrLoja;
	}
	public void setNrLoja(Integer nrLoja) {
		this.nrLoja = nrLoja;
	}
	
	
}
