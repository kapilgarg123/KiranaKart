package com.kirana.kirana_backend.services;

import com.kirana.kirana_backend.dto.CategoryDTO;
import com.kirana.kirana_backend.entities.CategoryEntity;
import com.kirana.kirana_backend.repositories.CategoryRepositories;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepositories categoryRepositories;
    private final ModelMapper modelMapper;

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepositories.findAll()
                .stream()
                .map(categoryEntity -> modelMapper.map(categoryEntity, CategoryDTO.class))
                .toList();
    }

    @Override
    public CategoryDTO createNewCategory(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = modelMapper.map(categoryDTO, CategoryEntity.class);
        return modelMapper.map(categoryRepositories.save(categoryEntity), CategoryDTO.class);
    }
}
