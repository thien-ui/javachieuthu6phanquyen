package com.hutech.Nguyentansang.services;

import com.hutech.Nguyentansang.entity.Category;
import com.hutech.Nguyentansang.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class categoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    public List<Category> getAllCategory() {return categoryRepository.findAll();}
    public Category getCategoryById(Long id) {return categoryRepository.findById(id).orElse(null);}
    public Category saveCategory(Category category) { return categoryRepository.save(category);}
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }



}
