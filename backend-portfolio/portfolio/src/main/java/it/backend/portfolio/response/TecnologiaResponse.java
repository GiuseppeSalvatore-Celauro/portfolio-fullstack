package it.backend.portfolio.response;

import it.backend.portfolio.model.Tecnologia;

public class TecnologiaResponse {
	private Long id;
	private String nome;
	
	public TecnologiaResponse(Tecnologia tecnologia) {
		this.id = tecnologia.getId();
		this.nome = tecnologia.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	
}
