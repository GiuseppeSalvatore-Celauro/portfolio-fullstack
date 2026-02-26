package it.backend.portfolio.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import it.backend.portfolio.dto.ProgettoDTO;
import it.backend.portfolio.exception.ResourceNotFoundException;
import it.backend.portfolio.model.Categoria;
import it.backend.portfolio.model.Img;
import it.backend.portfolio.model.Progetto;
import it.backend.portfolio.model.Tecnologia;
import it.backend.portfolio.repository.CategoriaRepository;
import it.backend.portfolio.repository.ProgettiRepository;
import it.backend.portfolio.repository.TecnologieRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProgettoService {

	private final ProgettiRepository progettiRepository;
	private final TecnologieRepository techRepository;
	private final CategoriaRepository catRepository;
	public ProgettoService(ProgettiRepository repository, TecnologieRepository techRepository, CategoriaRepository catRepository) {
		this.progettiRepository = repository;
		this.techRepository = techRepository;
		this.catRepository = catRepository;
	}
	
	public Progetto save(ProgettoDTO body) {
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
		
		if(body.getCategoria() != null) {
			Categoria categoria = catRepository.findByCategoria(body.getCategoria());
			if(categoria == null) {
				throw new RuntimeException("Categoria non trovata");
			}
			progetto.setCategoria(categoria);
		}
		Progetto saved = progettiRepository.save(progetto);
		
		return saved;
	}
	
	public List<Progetto> getAll(){
		List<Progetto> progetti =  progettiRepository.findAll();
		return progetti;
	}
	
	public Progetto getById(Long id) {
		Progetto progetto = progettiRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Progetto con id " + id + " non trovato"));
		return progetto;
	}
	
	public void delete(Long id) {
		Progetto progetto = progettiRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Progetto con id " + id + " non trovato"));
		progettiRepository.delete(progetto);
	}
	
	public Progetto edit(Long id, ProgettoDTO body) {
		
		Progetto progetto = progettiRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Progetto con id " + id + " non trovato"));
		
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
		
		if(body.getCategoria() != null) {
		    Categoria categoria = catRepository.findByCategoria(body.getCategoria());
		    if(categoria == null) {
		    	throw new RuntimeException("Categoria non trovata");
		    }
		    progetto.setCategoria(categoria);
		}

		Progetto saved = progettiRepository.save(progetto);
		
		return saved;
	}
}
