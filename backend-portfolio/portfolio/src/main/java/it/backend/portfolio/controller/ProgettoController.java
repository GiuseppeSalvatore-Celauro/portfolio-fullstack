package it.backend.portfolio.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.backend.portfolio.dto.ProgettoDTO;
import it.backend.portfolio.model.Img;
import it.backend.portfolio.model.Progetto;
import it.backend.portfolio.model.Tecnologia;
import it.backend.portfolio.repository.ProgettiRepository;
import it.backend.portfolio.repository.TecnologieRepository;

@RestController
public class ProgettoController {

	private final ProgettiRepository progettiRepository;
	private final TecnologieRepository techRepository;

	ProgettoController(ProgettiRepository repository, TecnologieRepository techRepo) {
		this.progettiRepository = repository;
		this.techRepository = techRepo;
	}
	
	@PostMapping("/progetti")
	public Progetto nuovoProgetto(@RequestBody ProgettoDTO body){
		Progetto progetto = new Progetto();
		
		progetto.setNome(body.getNome());
		progetto.setUrl(body.getUrl());
		progetto.setDescrizione(body.setDescrizione());
		
		for(String imgUrl: body.getImmagini()) {
			Img img = new Img(imgUrl);
			progetto.addImg(img);
		}
		
		for(String techName: body.getTecnologie()) {
			Tecnologia tecnologia = techRepository.findByNome(techName);
			if(tecnologia == null) tecnologia = new Tecnologia(techName);
			progetto.addTecnologia(tecnologia);
		}
		
		return progettiRepository.save(progetto);
	}
}
