package it.backend.portfolio.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import it.backend.portfolio.dto.ProgettoDTO;
import it.backend.portfolio.model.Img;
import it.backend.portfolio.model.Progetto;
import it.backend.portfolio.model.Tecnologia;
import it.backend.portfolio.repository.ProgettiRepository;
import it.backend.portfolio.repository.TecnologieRepository;
import it.backend.portfolio.response.ProgettoResponse;

@RestController
public class ProgettoController {

	private final ProgettiRepository progettiRepository;
	private final TecnologieRepository techRepository;

	ProgettoController(ProgettiRepository repository, TecnologieRepository techRepo) {
		this.progettiRepository = repository;
		this.techRepository = techRepo;
	}
	
	@PostMapping("/progetti")
	public ResponseEntity<ProgettoResponse> nuovoProgetto(@RequestBody ProgettoDTO body){
		
		Progetto progetto = new Progetto();
		
		progetto.setNome(body.getNome());
		progetto.setUrl(body.getUrl());
		progetto.setDescrizione(body.getDescrizione());
		
		if(body.getImmagini() != null) {
			for(String imgUrl: body.getImmagini()) {
				Img img = new Img(imgUrl);
				progetto.addImg(img);
			}
		}
		
		if(body.getTecnologie() != null) {
			for(String techName: body.getTecnologie()) {
				Tecnologia tecnologia = techRepository.findByNome(techName);
				
				if(tecnologia == null) {
					tecnologia = techRepository.save(new Tecnologia(techName));
				}
				
				progetto.addTecnologia(tecnologia);
			}
		}
		
		Progetto saved = progettiRepository.save(progetto);
		
		return ResponseEntity.ok(new ProgettoResponse(saved));
	}
	
	@GetMapping("/progetti")
	public ResponseEntity<List<ProgettoResponse>> vediProgetti(){
		List<Progetto> progetti =  progettiRepository.findAll();
		List<ProgettoResponse> risposta = progetti.stream().map(ProgettoResponse::new).collect(Collectors.toList());
		return ResponseEntity.ok(risposta);
	}
	
	@GetMapping("/progetti/{id}")
	public ResponseEntity<ProgettoResponse> vediProgetto(@PathVariable Long id){
		Progetto progetto = progettiRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return ResponseEntity.ok(new ProgettoResponse(progetto));
	}
	
	@DeleteMapping("/progetti/{id}")
	public ResponseEntity<Void> eliminaProgetto(@PathVariable Long id){
		Progetto progetto = progettiRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		progettiRepository.delete(progetto);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/progetti/{id}")
	public ResponseEntity<ProgettoResponse> modificaProgetto(@PathVariable Long id, @RequestBody ProgettoDTO body){
		
		Progetto progetto = progettiRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		progetto.setDescrizione(body.getDescrizione() != null ? body.getDescrizione() : progetto.getDescrizione());
		progetto.setNome(body.getNome() != null ? body.getNome() : progetto.getNome());
		progetto.setUrl(body.getUrl() != null ? body.getUrl() : progetto.getUrl());
		
		if(body.getImmagini() != null) {
			
			for(Img img: new ArrayList<>(progetto.getImmagini())) {
				progetto.removeImg(img);
			}
			
			for(String urlImg: body.getImmagini()) {
				Img img = new Img(urlImg);
				progetto.addImg(img);
			}
			
		}
		
		if(body.getTecnologie() != null) {
			
			for(Tecnologia tech: new HashSet<>(progetto.getTecnologie())) {
				progetto.removeTecnologia(tech);
			}
			
			for(String techName: body.getTecnologie()) {
				Tecnologia tecnologia = techRepository.findByNome(techName);
				
				if(tecnologia == null) {
					tecnologia = techRepository.save(new Tecnologia(techName));
				}
				
				progetto.addTecnologia(tecnologia);
			}
		}

		Progetto saved = progettiRepository.save(progetto);
		return ResponseEntity.ok(new ProgettoResponse(saved));
	}
}
