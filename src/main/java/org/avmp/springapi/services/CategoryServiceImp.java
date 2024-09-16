package org.avmp.springapi.services;

import org.avmp.springapi.entities.Category;
import org.avmp.springapi.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Category> finAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Category> findCategoryById(long id) {
        return categoryRepository.findById(id);
    }

    @Transactional
    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Transactional
    @Override
    public Optional<Category> updateCategory(Long id, Category category) {
        Optional<Category> categoryDb = categoryRepository.findById(id);

        if (categoryDb.isPresent()) {
            Category CategoryD = categoryDb.orElseThrow();
            CategoryD.setName(category.getName());
            CategoryD.setDescription(category.getDescription());
            return Optional.of(categoryRepository.save(CategoryD));
        }


        return categoryDb;
    }

    @Transactional
    @Override
    public Optional<Category> deleteCategory(long id) {
        Optional<Category> categoryDb = categoryRepository.findById(id);

        categoryDb.ifPresent(categoryD
                -> categoryRepository.delete(categoryD)
        );

        return categoryDb;
    }
}
