package com.kirana.kirana_backend.services;


import com.kirana.kirana_backend.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProducts();

    ProductDTO createNewProduct(ProductDTO productDTO, Long categoryId);

    List<ProductDTO> getProductsByCategory(Long categoryId);


}
