package com.fut.apirest.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "partidas")
public class Partidas implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "id_time_casa")
	private int id_time_casa;
	
	@Column(name = "id_time_visitante")
	private int id_time_visitante;
	
	@Column(name = "time_casa")
	private String nome_time_casa;
	
	@Column(name = "time_visitante")
	private String nome_time_visitante;

	@Column(name = "gols_casa")
	private int gols_time_casa;
	
	@Column(name = "gols_visitante")
	private int gols_time_visitante;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getId_time_casa() {
		return id_time_casa;
	}

	public void setId_time_casa(int id_time_casa) {
		this.id_time_casa = id_time_casa;
	}

	public int getId_time_visitante() {
		return id_time_visitante;
	}

	public void setId_time_visitante(int id_time_visitante) {
		this.id_time_visitante = id_time_visitante;
	}

	public String getNome_time_casa() {
		return nome_time_casa;
	}

	public void setNome_time_casa(String nome_time_casa) {
		this.nome_time_casa = nome_time_casa;
	}

	public String getNome_time_visitante() {
		return nome_time_visitante;
	}

	public void setNome_time_visitante(String nome_time_visitante) {
		this.nome_time_visitante = nome_time_visitante;
	}

	public int getGols_time_casa() {
		return gols_time_casa;
	}

	public void setGols_time_casa(int gols_time_casa) {
		this.gols_time_casa = gols_time_casa;
	}

	public int getGols_time_visitante() {
		return gols_time_visitante;
	}

	public void setGols_time_visitante(int gols_time_visitante) {
		this.gols_time_visitante = gols_time_visitante;
	}
	
}
