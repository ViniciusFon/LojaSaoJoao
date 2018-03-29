package com.br.fontana.digital.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the trabalho database table.
 * 
 */
@Entity
@NamedQuery(name="Trabalho.findAll", query="SELECT t FROM Trabalho t")
public class Trabalho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_trabalho")
	private Integer cdTrabalho;

	@Temporal(TemporalType.DATE)
	@Column(name="data_inc")
	private Date dataInc;

	@Temporal(TemporalType.DATE)
	@Column(name="data_lei")
	private Date dataLei;

	private String titulo;

	private Integer grau;

	//bi-directional many-to-one association to Loja
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_loja")
	private Loja loja;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_usuario")
	private Usuario usuario;

	public Trabalho() {
	}

	public Integer getCdTrabalho() {
		return this.cdTrabalho;
	}

	public void setCdTrabalho(Integer cdTrabalho) {
		this.cdTrabalho = cdTrabalho;
	}

	public Date getDataInc() {
		return this.dataInc;
	}

	public void setDataInc(Date dataInc) {
		this.dataInc = dataInc;
	}

	public Date getDataLei() {
		return this.dataLei;
	}

	public void setDataLei(Date dataLei) {
		this.dataLei = dataLei;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getGrau() {
		return this.grau;
	}

	public void setGrau(Integer grau) {
		this.grau = grau;
	}

	public Loja getLoja() {
		return this.loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}