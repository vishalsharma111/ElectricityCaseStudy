package com.vishal.electricity.controller;

import com.vishal.electricity.entity.Category;
import com.vishal.electricity.repository.CategoryRepository;
import com.vishal.electricity.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.findCategories();
    }

    @PutMapping("/{categoryId}")
    public Category updateCategory(@PathVariable Integer categoryId,
                                                   @RequestBody Category categoryDetails)  {
        Optional<Category> optionalCategory = categoryService.searchCategoryById(categoryId);
        if (!optionalCategory.isPresent()){ return null; }
        Category category = optionalCategory.get();
        category.setCostPerUnit(categoryDetails.getCostPerUnit());
        category.setExemptedUnits(categoryDetails.getExemptedUnits());
        final Category updatedCategory = categoryService.saveCategory(category);
        return updatedCategory;
    }

    @PostMapping
    public Category createCategory( @RequestBody Category category) {
        return categoryService.saveCategory(category);
    }




}
