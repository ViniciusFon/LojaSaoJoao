package com.br.fontana.digital.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ata database table.
 * 
 */
@Entity
@NamedQuery(name="Ata.findAll", query="SELECT a FROM Ata a")
public class Ata implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cd_sessao")
	private int cdSessao;

	@Temporal(TemporalType.DATE)
	@Column(name="data_aprov")
	private Date dataAprov;

	private int grau;

	//bi-directional many-to-one association to Loja
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_loja")
	private Loja loja;

	//bi-directional one-to-one association to Sessao
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_sessao")
	private Sessao sessao;

	public Ata() {
	}

	public int getCdSessao() {
		return this.cdSessao;
	}

	public void setCdSessao(int cdSessao) {
		this.cdSessao = cdSessao;
	}

	public Date getDataAprov() {
		return this.dataAprov;
	}

	public void setDataAprov(Date dataAprov) {
		this.dataAprov = dataAprov;
	}

	public int getGrau() {
		return this.grau;
	}

	public void setGrau(int grau) {
		this.grau = grau;
	}

	public Loja getLoja() {
		return this.loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Sessao getSessao() {
		return this.sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

}