package it.backend.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.backend.portfolio.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	Categoria findByCategoria(String categoria);
}
