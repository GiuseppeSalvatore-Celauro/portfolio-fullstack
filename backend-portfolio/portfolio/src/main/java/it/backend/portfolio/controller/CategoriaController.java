package it.backend.portfolio.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.backend.portfolio.model.Categoria;
import it.backend.portfolio.service.CategoriaService;

@RestController
@RequestMapping("/api")
public class CategoriaController {

	public final CategoriaService service;

	public CategoriaController(CategoriaService service) {
		this.service = service;
	}
	
	@GetMapping("/categorie")
	public ResponseEntity<List<Categoria>> vediCategorie(){
		List<Categoria> risposta = service.getAll();
		return ResponseEntity.ok(risposta);
	}
	
}
