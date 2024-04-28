package br.funkollection.webapi.repositories;

import br.funkollection.webapi.domain.entities.Category;
import br.funkollection.webapi.domain.entities.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findCategoryByLabel(String label);
}
