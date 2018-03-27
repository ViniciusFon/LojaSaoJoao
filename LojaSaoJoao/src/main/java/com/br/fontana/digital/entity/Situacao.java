package com.br.fontana.digital.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the situacao database table.
 * 
 */
@Entity
@NamedQuery(name="Situacao.findAll", query="SELECT s FROM Situacao s")
public class Situacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_situacao")
	private Integer cdSituacao;

	private String descricao;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="situacao",fetch=FetchType.LAZY)
	private List<Usuario> usuarios;

	public Situacao() {
	}

	public Integer getCdSituacao() {
		return this.cdSituacao;
	}

	public void setCdSituacao(Integer cdSituacao) {
		this.cdSituacao = cdSituacao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setSituacao(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setSituacao(null);

		return usuario;
	}

}