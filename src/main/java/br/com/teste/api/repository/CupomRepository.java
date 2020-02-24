package br.com.teste.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.teste.api.entity.Cupom;

@Repository
public interface CupomRepository extends JpaRepository<Cupom, Integer> {} 
