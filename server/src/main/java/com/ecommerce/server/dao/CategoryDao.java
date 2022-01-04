package com.ecommerce.server.dao;

import com.ecommerce.server.dto.CategoryDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface CategoryDao {

    //중복확인
    Optional<CategoryDto.categoryDto> find(CategoryDto.writeCategoryDto dto);

    //카테고리리스트불러오기
    List<CategoryDto.categoryDto> findAll();

    //카테고리생성
    int create(CategoryDto.writeCategoryDto dto);

    //카테고리수정
    int update(CategoryDto.categoryDto dto);

    //카테고리삭제
    int delete(CategoryDto.categoryIdDto dto);

}
