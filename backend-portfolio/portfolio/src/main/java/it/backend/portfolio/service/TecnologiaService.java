package it.backend.portfolio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.backend.portfolio.model.Tecnologia;
import it.backend.portfolio.repository.TecnologieRepository;

@Service
public class TecnologiaService {
	private TecnologieRepository repository;

	public TecnologiaService(TecnologieRepository repository) {
		this.repository = repository;
	}
	
	public List<Tecnologia> getAll(){
		return repository.findAll();
	}
}
