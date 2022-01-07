package com.ecommerce.server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

public class PostDetailDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class postRequestDto{
        private long postId;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class postResponseDto{
        private long postId;
        private String category;
        private String title;
//        private String writer;
        private Date createdDate;
        private String postUrl;
        private long price;
        private long amount;
//        private long commentQuantity;
//        private long qnaQuantity;
//        private long likeQuantity;
//        private long purchaseQuantity;
        private String term;
        private List<PostOptionDto.getPostOptionDto> postOptionList;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class writeDto{
        private long postId;
        private long userId;
        private String title;
        private String category;
        private String postUrl;
        private long price;
        private long amount;
        private String term;
        private List<PostOptionDto.createPostOptionDto> postOptionList;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class modifyDto{
        private long postId;
        private String title;
        private String postUrl;
        private String category;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class deleteDto{
        private long postId;
    }

}
