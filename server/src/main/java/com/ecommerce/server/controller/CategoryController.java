package com.ecommerce.server.controller;

import com.ecommerce.server.dto.CategoryDto;
import com.ecommerce.server.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categoryList")
    public ResponseEntity<?> getCategoryList() throws Exception{
        return ResponseEntity.ok().body(categoryService.getCategoryList());
    }

    @PostMapping("/write")
    public ResponseEntity<?> createCategory(@RequestBody CategoryDto.writeCategoryDto dto) throws Exception{
        return ResponseEntity.ok().body(categoryService.writeCategory(dto));
    }

    @PostMapping("/modify")
    public ResponseEntity<?> modifyCategory(@RequestBody CategoryDto.categoryDto dto) throws Exception{
        return ResponseEntity.ok().body(categoryService.modifyCategory(dto));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteCategory(@RequestBody CategoryDto.categoryIdDto dto) throws Exception{
        return ResponseEntity.ok().body(categoryService.deleteCategory(dto));
    }

}
