package br.funkollection.webapi.controllers;

import br.funkollection.webapi.domain.DTOs.CategoryDTO;
import br.funkollection.webapi.services.CategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/category")
@CrossOrigin(maxAge = 3600, originPatterns = "*")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryDTO> getAll() {

        return categoryService.listAllCategories();
    }
}
