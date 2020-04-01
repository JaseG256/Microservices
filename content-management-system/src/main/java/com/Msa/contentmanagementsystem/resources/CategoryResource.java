package com.Msa.contentmanagementsystem.resources;

import com.Msa.contentmanagementsystem.model.Category;
import com.Msa.contentmanagementsystem.service.CategoryService;
import com.Msa.contentmanagementsystem.vo.CategoryRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryResource {

    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Mono<Category>> findOne(@PathVariable("id") String id) {
        return ResponseEntity.ok(categoryService.findOne(id));
    }

    @GetMapping
    public ResponseEntity<Flux<Category>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Mono<Category>> newCategory(CategoryRequest request) {
        return new ResponseEntity<>(categoryService.create(request), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> removeCategory(@PathVariable("id") String id) {
        return categoryService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mono<Category>> updateCategory(@PathVariable("id") String id, CategoryRequest category){
        return new ResponseEntity<>(categoryService.create(category), HttpStatus.OK);
    }
}
