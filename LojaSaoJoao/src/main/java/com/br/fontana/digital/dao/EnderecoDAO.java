package com.br.fontana.digital.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.fontana.digital.entity.Endereco;

@Repository
public interface EnderecoDAO extends JpaRepository<Endereco, Integer>{

}
