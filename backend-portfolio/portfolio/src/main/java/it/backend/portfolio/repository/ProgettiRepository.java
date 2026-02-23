package it.backend.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.backend.portfolio.model.Progetto;

public interface ProgettiRepository extends JpaRepository<Progetto, Long> {

}
