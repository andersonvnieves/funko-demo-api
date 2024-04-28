package br.funkollection.webapi.services;

import br.funkollection.webapi.domain.DTOs.CategoryDTO;
import br.funkollection.webapi.domain.entities.Category;
import br.funkollection.webapi.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    public List<CategoryDTO> listAllCategories() {
        var categoriesDTO = new ArrayList<CategoryDTO>();
        var categories = categoryRepository.findAll();
        if(!categories.isEmpty()){
            categories.forEach(category -> categoriesDTO.add(modelMapper.map(category, CategoryDTO.class)));
        }
        return categoriesDTO;
    }

    public Category findCategoryByLabel(String label) {
        return categoryRepository.findCategoryByLabel(label);
    }
}
