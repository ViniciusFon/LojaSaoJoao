package com.br.fontana.digital.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the loja database table.
 * 
 */
@Entity
@NamedQuery(name="Loja.findAll", query="SELECT l FROM Loja l")
public class Loja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_loja")
	private Integer cdLoja;

	private String nome;

	private int numero;

	//bi-directional many-to-one association to Ata
	@OneToMany(mappedBy="loja")
	private List<Ata> atas;

	//bi-directional many-to-one association to Potencia
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_potencia")
	private Potencia potencia;

	//bi-directional many-to-one association to Rito
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_rito")
	private Rito rito;

	//bi-directional many-to-one association to Sessao
	@OneToMany(mappedBy="loja")
	private List<Sessao> sessaos;

	//bi-directional many-to-one association to Trabalho
	@OneToMany(mappedBy="loja")
	private List<Trabalho> trabalhos;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="loja")
	private List<Usuario> usuarios;

	public Loja() {
	}

	public Integer getCdLoja() {
		return this.cdLoja;
	}

	public void setCdLoja(Integer cdLoja) {
		this.cdLoja = cdLoja;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public List<Ata> getAtas() {
		return this.atas;
	}

	public void setAtas(List<Ata> atas) {
		this.atas = atas;
	}

	public Ata addAta(Ata ata) {
		getAtas().add(ata);
		ata.setLoja(this);

		return ata;
	}

	public Ata removeAta(Ata ata) {
		getAtas().remove(ata);
		ata.setLoja(null);

		return ata;
	}

	public Potencia getPotencia() {
		return this.potencia;
	}

	public void setPotencia(Potencia potencia) {
		this.potencia = potencia;
	}

	public Rito getRito() {
		return this.rito;
	}

	public void setRito(Rito rito) {
		this.rito = rito;
	}

	public List<Sessao> getSessaos() {
		return this.sessaos;
	}

	public void setSessaos(List<Sessao> sessaos) {
		this.sessaos = sessaos;
	}

	public Sessao addSessao(Sessao sessao) {
		getSessaos().add(sessao);
		sessao.setLoja(this);

		return sessao;
	}

	public Sessao removeSessao(Sessao sessao) {
		getSessaos().remove(sessao);
		sessao.setLoja(null);

		return sessao;
	}

	public List<Trabalho> getTrabalhos() {
		return this.trabalhos;
	}

	public void setTrabalhos(List<Trabalho> trabalhos) {
		this.trabalhos = trabalhos;
	}

	public Trabalho addTrabalho(Trabalho trabalho) {
		getTrabalhos().add(trabalho);
		trabalho.setLoja(this);

		return trabalho;
	}

	public Trabalho removeTrabalho(Trabalho trabalho) {
		getTrabalhos().remove(trabalho);
		trabalho.setLoja(null);

		return trabalho;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setLoja(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setLoja(null);

		return usuario;
	}

}