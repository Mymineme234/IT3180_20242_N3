package vn.edu.hust.nmcnpm_20242_n3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.hust.nmcnpm_20242_n3.entity.Category;
import vn.edu.hust.nmcnpm_20242_n3.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping // Get all
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/search/{name}") // Get by name
    public Category getCategoryByName(@PathVariable String name) {
        return categoryService.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Category with name " + name + " not found"));
    }

    @PostMapping // Add new
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @PutMapping("/update/{id}") // Update by Id
    public Category updateCategory(@PathVariable int id, @RequestBody Category category) {
        return categoryService.updateById(id, category);
    }

    @DeleteMapping("/delete/{id}") // Delete by Id
    public void deleteCategory(@PathVariable int id) {
        categoryService.deleteById(id);
    }
}
