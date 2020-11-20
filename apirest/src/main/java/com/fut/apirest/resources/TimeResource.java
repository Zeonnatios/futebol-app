package com.fut.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fut.apirest.models.Partidas;
import com.fut.apirest.models.Time;
import com.fut.apirest.repository.PartidaRepository;
import com.fut.apirest.repository.TimeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Futebol")
@CrossOrigin(origins="*")
public class TimeResource {

	@Autowired
	TimeRepository timeRepo;
	
	@Autowired
	PartidaRepository partidaRepo;
	
	@GetMapping("/times")
	@ApiOperation(value="Retorna uma lista de times oedenada por pontos feitos (desc).")
	public List<Time> listarTimes(){
		return timeRepo.findAllOrderByPontos();
	}
	
	@GetMapping("/partidas")
	@ApiOperation(value="Retorna uma lista de partidas.")
	public List<Partidas> listarPartidas(){
		return partidaRepo.findAll();
	}
	
	@PutMapping("/times")
	@ApiOperation(value="Atualiza a quantidade de gols e partidas do time.")
	public Time atualizaTime(@RequestBody Time time) {
		Time t = new Time();
		t = timeRepo.findByNome(time.getNome());
		time.setId(t.getId());
		return timeRepo.save(time);
	}
		
}
