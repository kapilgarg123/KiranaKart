package com.kirana.kirana_backend.services;


import com.kirana.kirana_backend.dto.ProductDTO;
import com.kirana.kirana_backend.entities.CategoryEntity;
import com.kirana.kirana_backend.entities.ProductEntity;
import com.kirana.kirana_backend.repositories.CategoryRepositories;
import com.kirana.kirana_backend.repositories.ProductRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepositories categoryRepositories;

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository
                .findAll()
                .stream()
                .map(productEntity -> modelMapper.map(productEntity, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO createNewProduct(ProductDTO productDTO, Long categoryId) {
        ProductEntity productEntity = modelMapper.map(productDTO, ProductEntity.class);
        CategoryEntity categoryEntity = categoryRepositories.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + categoryId));

        productEntity.setProductCategory(categoryEntity);
        ProductEntity savedProduct = productRepository.save(productEntity);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }

    @Override
    public List<ProductDTO> getProductsByCategory(Long categoryId) {
        CategoryEntity categoryEntity = categoryRepositories.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + categoryId));

        return productRepository.findByProductCategory(categoryEntity)
                .stream()
                .map(productEntity -> modelMapper.map(productEntity, ProductDTO.class))
                .collect(Collectors.toList());
    }
    
}