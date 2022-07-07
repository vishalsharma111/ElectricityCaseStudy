package com.vishal.electricity.service;

import com.vishal.electricity.entity.Category;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {

        List<Category> findCategories();

        Category saveCategory(Category category);

        Optional<Category> searchCategoryById(Integer categoryId);
}
