package com.br.fontana.digital.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sessao database table.
 * 
 */
@Entity
@NamedQuery(name="Sessao.findAll", query="SELECT s FROM Sessao s")
public class Sessao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_sessao")
	private Integer cdSessao;

	@Temporal(TemporalType.DATE)
	private Date data;

	@Column(name="tp_sessao")
	private Integer tpSessao;

	//bi-directional one-to-one association to Ata
	@OneToOne(mappedBy="sessao", fetch=FetchType.LAZY)
	private Ata ata;

	//bi-directional many-to-one association to Loja
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_loja")
	private Loja loja;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="sessaos",fetch=FetchType.LAZY)
	private List<Usuario> usuarios;
	
	private Integer grau;

	public Sessao() {
	}

	public int getCdSessao() {
		return this.cdSessao;
	}

	public void setCdSessao(int cdSessao) {
		this.cdSessao = cdSessao;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getTpSessao() {
		return this.tpSessao;
	}

	public void setTpSessao(int tpSessao) {
		this.tpSessao = tpSessao;
	}

	public Ata getAta() {
		return this.ata;
	}

	public void setAta(Ata ata) {
		this.ata = ata;
	}

	public Loja getLoja() {
		return this.loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public Integer getGrau() {
		return grau;
	}
	
	public void setGrau(Integer grau) {
		this.grau = grau;
	}

}