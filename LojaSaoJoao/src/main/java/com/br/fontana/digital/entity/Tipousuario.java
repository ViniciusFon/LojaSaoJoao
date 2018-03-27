package com.br.fontana.digital.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipousuario database table.
 * 
 */
@Entity
@NamedQuery(name="Tipousuario.findAll", query="SELECT t FROM Tipousuario t")
public class Tipousuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_tipo")
	private int cdTipo;

	private String descricao;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tipousuario",fetch=FetchType.LAZY)
	private List<Usuario> usuarios;

	public Tipousuario() {
	}

	public int getCdTipo() {
		return this.cdTipo;
	}

	public void setCdTipo(int cdTipo) {
		this.cdTipo = cdTipo;
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
		usuario.setTipousuario(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setTipousuario(null);

		return usuario;
	}

}