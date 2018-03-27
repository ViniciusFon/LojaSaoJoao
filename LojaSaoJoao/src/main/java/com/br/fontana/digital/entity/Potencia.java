package com.br.fontana.digital.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the potencia database table.
 * 
 */
@Entity
@NamedQuery(name="Potencia.findAll", query="SELECT p FROM Potencia p")
public class Potencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_potencia")
	private int cdPotencia;

	private String nome;

	private String oriente;

	//bi-directional many-to-one association to Loja
	@OneToMany(mappedBy="potencia")
	private List<Loja> lojas;

	public Potencia() {
	}

	public int getCdPotencia() {
		return this.cdPotencia;
	}

	public void setCdPotencia(int cdPotencia) {
		this.cdPotencia = cdPotencia;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getOriente() {
		return this.oriente;
	}

	public void setOriente(String oriente) {
		this.oriente = oriente;
	}

	public List<Loja> getLojas() {
		return this.lojas;
	}

	public void setLojas(List<Loja> lojas) {
		this.lojas = lojas;
	}

	public Loja addLoja(Loja loja) {
		getLojas().add(loja);
		loja.setPotencia(this);

		return loja;
	}

	public Loja removeLoja(Loja loja) {
		getLojas().remove(loja);
		loja.setPotencia(null);

		return loja;
	}

}