package com.br.fontana.digital.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.br.fontana.digital.dao.UsuarioDAO;
import com.br.fontana.digital.entity.Loja;
import com.br.fontana.digital.entity.Situacao;
import com.br.fontana.digital.entity.Tipousuario;
import com.br.fontana.digital.entity.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public Usuario findOne(Long cdUsuario) {
		return entityManager.find(Usuario.class, cdUsuario);
	}

	public Usuario findByUsername(String userName) throws UsernameNotFoundException {
		TypedQuery<Usuario> q = entityManager.createQuery("select u from Usuario u where u.username = :username",
				Usuario.class);
		q.setParameter("username", userName);
		return q.getSingleResult();
	}

	public List<Usuario> findByLoja(Loja loja) {
		TypedQuery<Usuario> q = entityManager.createQuery("select u from Usuario u where u.loja = :loja",
				Usuario.class);
		q.setParameter("loja", loja);
		return q.getResultList();
	}

	public List<Usuario> findByFilter(Loja loja, Integer cdGrau, Situacao situacao, Integer mes, Tipousuario tipo) {

		StringBuilder sql = new StringBuilder("select u from Usuario u where u.loja = :loja");
		if (cdGrau != null)
			sql.append(" and u.grau= :grau");
		if (situacao != null)
			sql.append(" and u.situacao= :situacao");
		if (mes != null)
			sql.append(" and month(u.dataNasc)= :mes");
		if (tipo != null)
			sql.append(" and u.tipousuario= :tipousuario");

		TypedQuery<Usuario> q = entityManager.createQuery(sql.toString(), Usuario.class);
		
		q.setParameter("loja", loja);
		if (cdGrau != null)
			q.setParameter("grau", cdGrau);
		if (situacao != null)
			q.setParameter("situacao", situacao);
		if (mes != null)
			q.setParameter("mes", mes);
		if (tipo != null)
			q.setParameter("tipousuario", tipo);

		return q.getResultList();
	}

}
