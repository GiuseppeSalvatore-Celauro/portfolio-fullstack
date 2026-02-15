package it.backend.portfolio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	public ProgettoResponse nuovoProgetto(@RequestBody ProgettoDTO body){
		
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
		
		return new ProgettoResponse(saved);
	}
}
