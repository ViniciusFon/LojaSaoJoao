package com.br.fontana.digital.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the endereco database table.
 * 
 */
@Entity
@NamedQuery(name="Endereco.findAll", query="SELECT e FROM Endereco e")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_endereco")
	private Integer cdEndereco;

	private String bairro;

	@Column(name="cd_tipo")
	private int cdTipo;

	private String cep;

	private String cidade;

	private String complemento;

	private String estado;

	private String logradouro;

	private String numero;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_usuario")
	private Usuario usuario;

	public Endereco() {
	}

	public Integer getCdEndereco() {
		return this.cdEndereco;
	}

	public void setCdEndereco(Integer cdEndereco) {
		this.cdEndereco = cdEndereco;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getCdTipo() {
		return this.cdTipo;
	}

	public void setCdTipo(int cdTipo) {
		this.cdTipo = cdTipo;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}