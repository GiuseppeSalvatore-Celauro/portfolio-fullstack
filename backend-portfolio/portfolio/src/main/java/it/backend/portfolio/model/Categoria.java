package it.backend.portfolio.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorie")
public class Categoria {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	
	private String categoria;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Progetto> progetti = new ArrayList<>();

	public Categoria() {}

	public Categoria(String categoria, List<Progetto> progetti) {
		this.categoria = categoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}
	
	public void addProgetto(Progetto progetto) {
		progetti.add(progetto);
		progetto.setCategoria(this);
	}
	
	public void removeProgetto(Progetto progetto) {
		progetti.remove(progetto);
		progetto.setCategoria(null);
	}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof Categoria)) return false;
	    Categoria that = (Categoria) o;
	    return id != null && id.equals(that.id);
	}

	@Override
	public int hashCode() {
	    return getClass().hashCode();
	}
	
}
