package com.br.fontana.digital.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.fontana.digital.entity.Sessao;

@Repository
public interface SessaoDAO extends JpaRepository<Sessao, Integer>{

}
