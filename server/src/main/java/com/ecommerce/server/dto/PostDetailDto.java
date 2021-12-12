package com.ecommerce.server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

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
        private String title;
        private String writer;
        private Date createdDate;
        private String postUrl;
        private long commentCnt;
        private long likeCnt;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class writeDto{
        private long postId;
        private String title;
        private String category;
        private long userId;
        private String writer;
        private String postUrl;
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
