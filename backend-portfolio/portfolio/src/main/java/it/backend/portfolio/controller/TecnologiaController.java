package it.backend.portfolio.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.backend.portfolio.response.TecnologiaResponse;
import it.backend.portfolio.service.TecnologiaService;

@RestController
@RequestMapping("/api")
public class TecnologiaController {
	private final TecnologiaService service;

	public TecnologiaController(TecnologiaService service) {
		this.service = service;
	}
	
	@GetMapping("/tecnologie")
	public ResponseEntity<List<TecnologiaResponse>> vediCategorie(){
		List<TecnologiaResponse> risposta = service.getAll().stream().map(TecnologiaResponse::new).collect(Collectors.toList());
		return ResponseEntity.ok(risposta);
	}
	
}
