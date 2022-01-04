package com.ecommerce.server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CategoryDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class writeCategoryDto{
        private String name;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class categoryIdDto{
        private long categoryId;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class categoryDto{
        private long categoryId;
        private String name;
    }

}
