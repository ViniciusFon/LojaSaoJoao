package com.br.fontana.digital.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.fontana.digital.entity.Ata;

@Repository
public interface AtaDAO extends JpaRepository<Ata, Integer>{

}
