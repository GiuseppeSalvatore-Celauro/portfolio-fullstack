package it.backend.portfolio.response;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import it.backend.portfolio.model.Img;
import it.backend.portfolio.model.Progetto;
import it.backend.portfolio.model.Tecnologia;

public class ProgettoResponse {
	
	private Long id;
	private String nome;
	private String url;
	private String descrizione;
	private List<String> immagini;
	private Set<String> tecnologie;
	private String categoria;
	public ProgettoResponse(Progetto progetto) {
		this.id = progetto.getId();
		this.nome = progetto.getNome();
		this.url = progetto.getUrl();
		this.descrizione = progetto.getDescrizione();
		this.immagini = progetto.getImmagini()
						.stream()
						.map(Img::getUrl)
						.collect(Collectors.toList());
		this.tecnologie = progetto.getTecnologie()
						.stream()
						.map(Tecnologia::getNome)
						.collect(Collectors.toSet());
		this.categoria = progetto.getCategoria().getCategoria();
						 
	}
	
	
	public Long getId() {return id;}
	public String getNome() {return nome;}
	public String getUrl() {return url;}
	public String getDescrizione() {return descrizione;}
	public List<String> getImmagini() {return immagini;}
	public Set<String> getTecnologie() {return tecnologie;}
	public String getCategoria() {return categoria;}
}
