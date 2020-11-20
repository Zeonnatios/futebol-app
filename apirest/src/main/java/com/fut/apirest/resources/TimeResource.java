package com.fut.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping("/partidas")
	@ApiOperation(value="Retorna uma lista de partidas.")
	public Partidas adicionarPartida(@RequestBody Partidas partida){
		
		return partidaRepo.save(partida);
	}
	
	@PutMapping("/times")
	@ApiOperation(value="Atualiza a quantidade de gols e partidas do time.")
	/*public Time atualizaTime(@RequestParam(value = "casa") String casa,
			@RequestParam(value = "visitante") String visitante,
			@RequestParam(value = "golcasa") int golcasa,
			@RequestParam(value = "golvisitante") int golvisitante) {
		*/
	public Time atualizaTime(@RequestBody Partidas partida) {
		
		Time tc = new Time();
		Time tv = new Time();
		
		tc = timeRepo.findByNome(partida.getNome_time_casa());
		tv = timeRepo.findByNome(partida.getNome_time_visitante());
		
		int golcasa = partida.getGols_time_casa();
		int golvisitante = partida.getGols_time_visitante();
		int pontocasa = tc.getPontos();
		int pontoVisitante = tv.getPontos();
		
		tc.setGols(tc.getGols() + golcasa);
		tv.setGols(tv.getGols() + golvisitante);
		
		if(golcasa == golvisitante) {
			
			tc.setEmpates(tc.getEmpates() + 1);
			tv.setEmpates(tc.getEmpates() + 1);
			tc.setPontos(pontocasa + 1);
			tv.setPontos(pontoVisitante + 1);
			
		}else if(golcasa > golvisitante) {
			
			tc.setVitorias(tc.getVitorias() + 1); 
			tv.setDerrotas(tv.getDerrotas() + 1);
			tc.setPontos(pontocasa + 3);
			
		}else{
			
			tv.setVitorias(tv.getVitorias() + 1); 
			tc.setDerrotas(tc.getDerrotas() + 1);
			tv.setPontos(pontoVisitante + 3);
		}
		
		timeRepo.save(tc);
		
		return timeRepo.save(tv);
	}
		
}
