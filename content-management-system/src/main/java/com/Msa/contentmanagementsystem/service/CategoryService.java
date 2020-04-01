package com.Msa.contentmanagementsystem.service;

import com.Msa.contentmanagementsystem.model.Category;
import com.Msa.contentmanagementsystem.repository.CategoryRepository;
import com.Msa.contentmanagementsystem.vo.CategoryRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Mono<Category> create(CategoryRequest request){
        Category category = new Category();
        category.setName(request.getName());
        return this.categoryRepository.save(category);
    }

    public Mono<Category> update(Category category){
        return this.categoryRepository.save(category);
    }
    public Mono<Void> delete(String id){
        return this.categoryRepository.deleteById(id);
    }

    public Flux<Category> findAll(){
        return this.categoryRepository.findAll();
    }

    public Mono<Category> findOne(String id){
        return this.categoryRepository.findById(id);
    }
}
