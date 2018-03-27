package com.br.fontana.digital.response;

public class UsuarioResponse {

	private Integer cdUsuario;	
	private String tipo;
	private Integer grau;
	private String nome;
	private String username;
	private String dataElevacao;	
	private String dataExaltacao;	
	private String dataFiliacao;	
	private String dataIniciacao;	
	private String dataInstalacao;	
	private String dataNasc;
	private String situacao;
	private LojaResponse loja;
	
	public Integer getCdUsuario() {
		return cdUsuario;
	}
	public void setCdUsuario(Integer cdUsuario) {
		this.cdUsuario = cdUsuario;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getGrau() {
		return grau;
	}
	public void setGrau(Integer grau) {
		this.grau = grau;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDataElevacao() {
		return dataElevacao;
	}
	public void setDataElevacao(String dataElevacao) {
		this.dataElevacao = dataElevacao;
	}
	public String getDataExaltacao() {
		return dataExaltacao;
	}
	public void setDataExaltacao(String dataExaltacao) {
		this.dataExaltacao = dataExaltacao;
	}
	public String getDataFiliacao() {
		return dataFiliacao;
	}
	public void setDataFiliacao(String dataFiliacao) {
		this.dataFiliacao = dataFiliacao;
	}
	public String getDataIniciacao() {
		return dataIniciacao;
	}
	public void setDataIniciacao(String dataIniciacao) {
		this.dataIniciacao = dataIniciacao;
	}
	public String getDataInstalacao() {
		return dataInstalacao;
	}
	public void setDataInstalacao(String dataInstalacao) {
		this.dataInstalacao = dataInstalacao;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public LojaResponse getLoja() {
		return loja;
	}
	public void setLoja(LojaResponse loja) {
		this.loja = loja;
	}
	
}
