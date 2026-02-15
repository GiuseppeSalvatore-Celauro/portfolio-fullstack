package it.backend.portfolio.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "progetti")
public class Progetto {
	

	private @Id @GeneratedValue Long id;
	
	private String nome;
	
	private String url;
	
	private String descrizione;
	
	@OneToMany(mappedBy = "progetto", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Img> immagini = new ArrayList<>();
	
	Progetto() {}
	
	Progetto(String nome, String url, String descrizione) {
		this.nome = nome;
		this.url = url;
		this.descrizione = descrizione;
	}
	
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
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Long getId() {
		return id;
	}

	public List<Img> getImmagini() {
		return immagini;
	}

	public void setImmagini(List<Img> immagini) {
		this.immagini = immagini;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.nome, this.descrizione, this.url);
	}

	@Override
	public boolean equals(Object o) {
		 if (this == o)
		      return true;
		    if (!(o instanceof Progetto))
		      return false;
		    Progetto progetto = (Progetto) o;
		    return Objects.equals(this.id, progetto.id) && Objects.equals(this.nome, progetto.nome)
		        && Objects.equals(this.url, progetto.url) && Objects.equals(this.descrizione, progetto.descrizione);
	}

	@Override
	public String toString() {

		return "Progetto{" + "id=" + this.id +  ", nome='" + this.nome + '\'' + ", url='" + this.url + + '\'' + "', descrzione='" + this.descrizione+ '\'' + '}';
	}
	
	
	
	
}
