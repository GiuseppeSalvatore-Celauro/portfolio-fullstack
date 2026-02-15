package it.backend.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "immagini_progetti")
public class Img {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	
	private String url;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "progetto_id", nullable = false)
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

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	@Override
	public boolean equals(Object o) {
		 if (this == o) return true;
	     if (!(o instanceof Img)) return false;
	     Img other = (Img) o;
	     return id != null && id.equals(other.id);
	}

	@Override
	public String toString() {
		return "Img{" + "id=" + this.id + ", url='" + this.url + '\'' + '}';
	}

	
	
	
}
