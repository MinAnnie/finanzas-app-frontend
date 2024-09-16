package org.avmp.springapi.services;

import org.avmp.springapi.entities.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> finAllCategories();

    Optional<Category> findCategoryById(long id);

    Category saveCategory(Category category);

    Optional<Category> updateCategory(Long id, Category category);

    Optional<Category> deleteCategory(long id);
}
