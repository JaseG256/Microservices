package com.Msa.contentmanagementsystem.service;

import com.Msa.contentmanagementsystem.model.Category;
import com.Msa.contentmanagementsystem.repository.CategoryRepository;
import com.Msa.contentmanagementsystem.vo.CategoryRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {



    private final CategoryRepository categoryRepository;



    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category update(Category category){
        return this.categoryRepository.save(category);
    }

    public Category create(CategoryRequest request){
        Category category = new Category();
        category.setName(request.getName());
        return this.categoryRepository.save(category);
    }

    public void delete(String id){
        final Category category = this.categoryRepository.findById(id).isPresent() ?
            this.categoryRepository.findById(id).get() : new Category();
        this.categoryRepository.delete(category);
    }

    public List<Category> findAll(){
        return this.categoryRepository.findAll();
    }

    public Category findOne(String id){
        return this.categoryRepository.findById(id).get();
    }
}
