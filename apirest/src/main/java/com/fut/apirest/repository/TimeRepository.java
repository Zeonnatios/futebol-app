package com.fut.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fut.apirest.models.Time;

public interface TimeRepository extends JpaRepository<Time,Long>{
	
	Time findByNome(String nome);
	
	@Query(value = "SELECT * FROM time ORDER BY pontos DESC", nativeQuery = true)
	List<Time> findAllOrderByPontos();

}
