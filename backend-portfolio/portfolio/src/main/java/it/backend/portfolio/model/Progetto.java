package it.backend.portfolio.model;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "progetti")
public class Progetto {
	

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	
	private String nome;
	
	private String url;
	
	private String descrizione;
	
	@OneToMany(mappedBy = "progetto", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Img> immagini = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "progetti_tecnologie",
			joinColumns = @JoinColumn(name = "progetto_id"),
			inverseJoinColumns = @JoinColumn(name = "tecnologia_id")
			)
	private Set<Tecnologia> tecnologie = new HashSet<>();
	
	public Progetto() {}
	
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


	public Set<Tecnologia> getTecnologie() {
		return tecnologie;
	}

	public void setTecnologie(Set<Tecnologia> tecnologie) {
		this.tecnologie = tecnologie;
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	@Override
	public boolean equals(Object o) {
		 if (this == o)
		      return true;
		    if (!(o instanceof Progetto))
		      return false;
		    Progetto progetto = (Progetto) o;
		    return id != null && id.equals(progetto.id);
	}

	@Override
	public String toString() {
		return "Progetto{" + "id=" + this.id +  ", nome='" + this.nome + '\'' + ", url='" + this.url + '\'' + "', descrzione='" + this.descrizione+ '\'' + '}';
	}
	
	
	public void addImg(Img img) {
		immagini.add(img);
		img.setProgetto(this);
	}
	
	public void removeImg(Img img) {
		immagini.remove(img);
		img.setProgetto(null);
	}
	
	public void addTecnologia(Tecnologia tecnologia) {
		tecnologie.add(tecnologia);
		tecnologia.getProgetti().add(this);
	}
	
	public void removeTecnologia(Tecnologia tecnologia) {
		tecnologie.remove(tecnologia);
		tecnologia.getProgetti().remove(this);
	}
	
}
