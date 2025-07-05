package com.kirana.kirana_backend.controllers;


import com.kirana.kirana_backend.dto.CategoryDTO;
import com.kirana.kirana_backend.services.CategoryService;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Data
@RequestMapping(path = "/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping(path = "/")
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping(path = "/")
    public CategoryDTO createNewCategory(@RequestBody CategoryDTO inputCategory) {
        return categoryService.createNewCategory(inputCategory);
    }

}
