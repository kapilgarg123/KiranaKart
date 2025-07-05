package com.kirana.kirana_backend.services;

import com.kirana.kirana_backend.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO createNewCategory(CategoryDTO categoryDTO);
}
