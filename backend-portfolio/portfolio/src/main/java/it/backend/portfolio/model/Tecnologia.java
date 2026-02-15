package it.backend.portfolio.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tecnologie")
public class Tecnologia {
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	
	private String nome;
	
	@ManyToMany(mappedBy = "tecnologie", fetch = FetchType.LAZY)
	private Set<Progetto> progetti = new HashSet<>();

	Tecnologia() {}

	public Tecnologia(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public Set<Progetto> getProgetti() {
		return progetti;
	}

	public void setProgetti(Set<Progetto> progetti) {
		this.progetti = progetti;
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
	    if (!(o instanceof Tecnologia)) return false;
	    Tecnologia other = (Tecnologia) o;
	    return id != null && id.equals(other.id);
	}

	@Override
	public String toString() {
		return "Tecnologia{" + "id=" + this.id + ", nome='" + this.nome + '\'' + '}';
	}
	
	
	
}
