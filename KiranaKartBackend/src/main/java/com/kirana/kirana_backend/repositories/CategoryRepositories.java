package com.kirana.kirana_backend.repositories;

import com.kirana.kirana_backend.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepositories extends JpaRepository<CategoryEntity, Long> {
}
