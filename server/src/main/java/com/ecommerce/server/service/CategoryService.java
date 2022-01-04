package com.ecommerce.server.service;

import com.ecommerce.server.dao.CategoryDao;
import com.ecommerce.server.dto.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryDao categoryDao;

    public List<CategoryDto.categoryDto> getCategoryList(){
        return categoryDao.findAll();
    }

    public boolean writeCategory(CategoryDto.writeCategoryDto dto){
        //중복확인
        if(!categoryDao.find(dto).isPresent()){
            //생성로직
            categoryDao.create(dto);

            return true;
        }else{
            return false;
        }
    }

    public boolean modifyCategory(CategoryDto.categoryDto dto){
        if(categoryDao.update(dto) > 0) {
            return true;
        }else{
            return false;
        }
    }

    public boolean deleteCategory(CategoryDto.categoryIdDto dto){
        if(categoryDao.delete(dto) > 0) {
            return true;
        }else{
            return false;
        }
    }

}
