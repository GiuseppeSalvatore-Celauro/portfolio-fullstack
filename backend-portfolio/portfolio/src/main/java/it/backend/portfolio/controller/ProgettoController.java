package it.backend.portfolio.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.backend.portfolio.dto.ProgettoDTO;
import it.backend.portfolio.response.ProgettoResponse;
import it.backend.portfolio.service.ProgettoService;

@RestController
@RequestMapping("/api")
public class ProgettoController {

	
	public final ProgettoService service;

	ProgettoController(ProgettoService service) {
		this.service = service;
	}
	@PostMapping("/progetti")
	public ResponseEntity<ProgettoResponse> nuovoProgetto(@RequestBody ProgettoDTO body){
		return ResponseEntity.ok(new ProgettoResponse(service.save(body)));
	}
	
	@GetMapping("/progetti")
	public ResponseEntity<List<ProgettoResponse>> vediProgetti(){
		List<ProgettoResponse> risposta = service.getAll().stream().map(ProgettoResponse::new).collect(Collectors.toList());
		return ResponseEntity.ok(risposta);
	}
	
	@GetMapping("/progetti/{id}")
	public ResponseEntity<ProgettoResponse> vediProgetto(@PathVariable Long id){
		return ResponseEntity.ok(new ProgettoResponse(service.getById(id)));
	}
	
	@DeleteMapping("/progetti/{id}")
	public ResponseEntity<Void> eliminaProgetto(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/progetti/{id}")
	public ResponseEntity<ProgettoResponse> modificaProgetto(@PathVariable Long id, @RequestBody ProgettoDTO body){
		return ResponseEntity.ok(new ProgettoResponse(service.edit(id, body)));
	}
}
