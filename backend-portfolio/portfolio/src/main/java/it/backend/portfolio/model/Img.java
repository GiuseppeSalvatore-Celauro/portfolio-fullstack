package it.backend.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "immagini_progetti")
public class Img {

	private @Id @GeneratedValue Long id;
	
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "progetto_id")
	private Progetto progetto;

	public Img() {}

	public Img(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Progetto getProgetto() {
		return progetto;
	}

	public void setProgetto(Progetto progetto) {
		this.progetto = progetto;
	}

	public Long getId() {
		return id;
	}


	
	
}
