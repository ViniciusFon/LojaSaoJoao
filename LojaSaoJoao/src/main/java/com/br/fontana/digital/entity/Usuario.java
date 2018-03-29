package com.br.fontana.digital.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_usuario")
	private Integer cdUsuario;

	@Temporal(TemporalType.DATE)
	@Column(name="data_elevacao")
	private Date dataElevacao;

	@Temporal(TemporalType.DATE)
	@Column(name="data_exaltacao")
	private Date dataExaltacao;

	@Temporal(TemporalType.DATE)
	@Column(name="data_filiacao")
	private Date dataFiliacao;

	@Temporal(TemporalType.DATE)
	@Column(name="data_iniciacao")
	private Date dataIniciacao;

	@Temporal(TemporalType.DATE)
	@Column(name="data_instalacao")
	private Date dataInstalacao;

	@Temporal(TemporalType.DATE)
	@Column(name="data_nasc")
	private Date dataNasc;

	private Integer grau;

	private String nome;

	private String senha;

	private String username;

	//bi-directional many-to-one association to Endereco
	@OneToMany(mappedBy="usuario",fetch=FetchType.LAZY)
	private List<Endereco> enderecos;

	//bi-directional many-to-one association to Trabalho
	@OneToMany(mappedBy="usuario",fetch=FetchType.LAZY)
	private List<Trabalho> trabalhos;

	//bi-directional many-to-one association to Loja
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_loja")
	private Loja loja;

	//bi-directional many-to-many association to Sessao
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="presenca"
		, joinColumns={
			@JoinColumn(name="cd_usuario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="cd_sessao")
			}
		)
	private List<Sessao> sessaos;

	//bi-directional many-to-one association to Situacao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_situacao")
	private Situacao situacao;

	//bi-directional many-to-one association to Tipousuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_tipo")
	private Tipousuario tipousuario;
	
	@Column(name="ddd_celular")
	private String dddCelular;
	
	@Column(name="nr_celular")
	private String nrCelular;
	
	@Column(name="ddd_residencial")
	private String dddResidencial;
	
	@Column(name="nr_residencial")
	private String nrResidencial;
	
	@Column(name="ddd_comercial")
	private String dddComercial;
	
	@Column(name="nr_comercial")
	private String nrComercial;
	
	private String email;

	public Usuario() {
	}

	public Integer getCdUsuario() {
		return this.cdUsuario;
	}

	public void setCdUsuario(Integer cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public Date getDataElevacao() {
		return this.dataElevacao;
	}

	public void setDataElevacao(Date dataElevacao) {
		this.dataElevacao = dataElevacao;
	}

	public Date getDataExaltacao() {
		return this.dataExaltacao;
	}

	public void setDataExaltacao(Date dataExaltacao) {
		this.dataExaltacao = dataExaltacao;
	}

	public Date getDataFiliacao() {
		return this.dataFiliacao;
	}

	public void setDataFiliacao(Date dataFiliacao) {
		this.dataFiliacao = dataFiliacao;
	}

	public Date getDataIniciacao() {
		return this.dataIniciacao;
	}

	public void setDataIniciacao(Date dataIniciacao) {
		this.dataIniciacao = dataIniciacao;
	}

	public Date getDataInstalacao() {
		return this.dataInstalacao;
	}

	public void setDataInstalacao(Date dataInstalacao) {
		this.dataInstalacao = dataInstalacao;
	}

	public Date getDataNasc() {
		return this.dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Integer getGrau() {
		return this.grau;
	}

	public void setGrau(Integer grau) {
		this.grau = grau;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Endereco addEndereco(Endereco endereco) {
		getEnderecos().add(endereco);
		endereco.setUsuario(this);

		return endereco;
	}

	public Endereco removeEndereco(Endereco endereco) {
		getEnderecos().remove(endereco);
		endereco.setUsuario(null);

		return endereco;
	}

	public List<Trabalho> getTrabalhos() {
		return this.trabalhos;
	}

	public void setTrabalhos(List<Trabalho> trabalhos) {
		this.trabalhos = trabalhos;
	}

	public Trabalho addTrabalho(Trabalho trabalho) {
		getTrabalhos().add(trabalho);
		trabalho.setUsuario(this);

		return trabalho;
	}

	public Trabalho removeTrabalho(Trabalho trabalho) {
		getTrabalhos().remove(trabalho);
		trabalho.setUsuario(null);

		return trabalho;
	}

	public Loja getLoja() {
		return this.loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public List<Sessao> getSessaos() {
		return this.sessaos;
	}

	public void setSessaos(List<Sessao> sessaos) {
		this.sessaos = sessaos;
	}

	public Situacao getSituacao() {
		return this.situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Tipousuario getTipousuario() {
		return this.tipousuario;
	}

	public void setTipousuario(Tipousuario tipousuario) {
		this.tipousuario = tipousuario;
	}

	public String getDddCelular() {
		return dddCelular;
	}

	public void setDddCelular(String dddCelular) {
		this.dddCelular = dddCelular;
	}

	public String getNrCelular() {
		return nrCelular;
	}

	public void setNrCelular(String nrCelular) {
		this.nrCelular = nrCelular;
	}

	public String getDddResidencial() {
		return dddResidencial;
	}

	public void setDddResidencial(String dddResidencial) {
		this.dddResidencial = dddResidencial;
	}

	public String getNrResidencial() {
		return nrResidencial;
	}

	public void setNrResidencial(String nrResidencial) {
		this.nrResidencial = nrResidencial;
	}

	public String getDddComercial() {
		return dddComercial;
	}

	public void setDddComercial(String dddComercial) {
		this.dddComercial = dddComercial;
	}

	public String getNrComercial() {
		return nrComercial;
	}

	public void setNrComercial(String nrComercial) {
		this.nrComercial = nrComercial;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

}