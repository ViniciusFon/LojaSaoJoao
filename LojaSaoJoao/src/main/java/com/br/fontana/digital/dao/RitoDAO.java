package com.br.fontana.digital.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.fontana.digital.entity.Rito;

@Repository
public interface RitoDAO extends JpaRepository<Rito, Integer>{

}
