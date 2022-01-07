package com.ecommerce.server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class PostOptionDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createPostOptionDto{
        private long postId;
        private String optionName;
        private long optionPrice;
        private long optionAmount;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getPostOptionDto{
        private long postOptionId;
        private String optionName;
        private long optionPrice;
        private long optionAmount;
    }

}
