package com.fut.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fut.apirest.models.Time;

public interface TimeRepository extends JpaRepository<Time,Long>{
	
	Time findByNome(String nome);

}
