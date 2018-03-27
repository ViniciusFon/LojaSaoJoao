package com.br.fontana.digital.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rito database table.
 * 
 */
@Entity
@NamedQuery(name="Rito.findAll", query="SELECT r FROM Rito r")
public class Rito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_rito")
	private int cdRito;

	private String descricao;

	//bi-directional many-to-one association to Loja
	@OneToMany(mappedBy="rito")
	private List<Loja> lojas;

	public Rito() {
	}

	public int getCdRito() {
		return this.cdRito;
	}

	public void setCdRito(int cdRito) {
		this.cdRito = cdRito;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Loja> getLojas() {
		return this.lojas;
	}

	public void setLojas(List<Loja> lojas) {
		this.lojas = lojas;
	}

	public Loja addLoja(Loja loja) {
		getLojas().add(loja);
		loja.setRito(this);

		return loja;
	}

	public Loja removeLoja(Loja loja) {
		getLojas().remove(loja);
		loja.setRito(null);

		return loja;
	}

}