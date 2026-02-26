package it.backend.portfolio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.backend.portfolio.model.Categoria;
import it.backend.portfolio.repository.CategoriaRepository;

@Service
public class CategoriaService {

	private CategoriaRepository catRepository;

	public CategoriaService(CategoriaRepository catRepository) {
		this.catRepository = catRepository;
	}
	
	public List<Categoria> getAll(){
		return catRepository.findAll();
	}
}
