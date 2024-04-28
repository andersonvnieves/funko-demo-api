package br.funkollection.webapi.repositories;

import br.funkollection.webapi.domain.entities.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Integer> {
    Serie findSerieByLabel(String label);
}
