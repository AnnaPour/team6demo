package com.example.team6demo.controller;


import com.example.team6demo.mapper.BaseMapper;
import com.example.team6demo.mapper.CategoryMapper;
import com.example.team6demo.model.Category;
import com.example.team6demo.services.BaseService;
import com.example.team6demo.services.CategoryService;
import com.example.team6demo.tran.ApiResponse;
import com.example.team6demo.tran.resource.CategoryResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController extends BaseController<Category, CategoryResource> {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @Override
    protected BaseService<Category, Long> getBaseService() {
        return categoryService;
    }

    @Override
    protected BaseMapper<Category, CategoryResource> getMapper() {
        return categoryMapper;
    }

    @GetMapping(params = {"description"})
    public ResponseEntity<ApiResponse<CategoryResource>> findByDescription(@RequestParam final String description) {
        return ResponseEntity.ok(ApiResponse.<CategoryResource>builder()
                .data(getMapper().toResource(categoryService.findByDescription(description)))
                .build());
    }
}