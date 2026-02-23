package it.backend.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.backend.portfolio.model.Tecnologia;

public interface TecnologieRepository extends JpaRepository<Tecnologia, Long> {
	
	Tecnologia findByNome(String nome);
}
