package it.backend.portfolio.dto;

import java.util.List;
import java.util.Set;

public class ProgettoDTO {
	
	private String nome;
	private String url;
	private String descrizione;
	private List<String> immagini;
	private Set<String> tecnologie;
	private String categoria;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrzione) {
		this.descrizione = descrzione;
	}
	public List<String> getImmagini() {
		return immagini;
	}
	public void setImmagini(List<String> immagini) {
		this.immagini = immagini;
	}
	public Set<String> getTecnologie() {
		return tecnologie;
	}
	public void setTecnologie(Set<String> tecnologie) {
		this.tecnologie = tecnologie;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
}
