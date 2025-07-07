package com.kirana.kirana_backend.controllers;

import com.kirana.kirana_backend.dto.ProductDTO;
import com.kirana.kirana_backend.services.ProductService;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class ProductController {

    private final ProductService productService;

    @GetMapping(path = "/products")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> allProducts = productService.getAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @GetMapping(path = "/category/{categoryId}/products")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable Long categoryId) {
        List<ProductDTO> productsByCategory = productService.getProductsByCategory(categoryId);
        return new ResponseEntity<>(productsByCategory, HttpStatus.OK);
    }

    @PostMapping(path = "/category/{categoryId}/products")
    public ResponseEntity<ProductDTO> createNewProduct(@Valid @RequestBody ProductDTO inputProduct, @PathVariable Long categoryId) {
        ProductDTO createdProduct = productService.createNewProduct(inputProduct, categoryId);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping(path = "/products/{productId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long productId) {
        ProductDTO product = productService.getProductById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping(path = "/products/search")
    public ResponseEntity<List<ProductDTO>> searchProducts(@RequestParam String query) {
        List<ProductDTO> searchResults = productService.searchProducts(query);
        return new ResponseEntity<>(searchResults, HttpStatus.OK);
    }

}
