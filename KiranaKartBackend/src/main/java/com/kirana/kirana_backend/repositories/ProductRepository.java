package com.kirana.kirana_backend.repositories;

import com.kirana.kirana_backend.entities.CategoryEntity;
import com.kirana.kirana_backend.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByProductCategory(CategoryEntity categoryEntity);

}
