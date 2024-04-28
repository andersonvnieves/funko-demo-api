package br.funkollection.webapi.repositories;

import br.funkollection.webapi.domain.entities.Funko;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FunkoRepository extends JpaRepository<Funko, String> {

    void deleteById(String id);
    Funko findFunkoById(String id);
}
