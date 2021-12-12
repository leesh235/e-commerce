package com.ecommerce.server.dto;

import lombok.*;
import java.util.Date;

public class UserDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class modifyProfileDto{
        private long userId;
        private String name;
        private Date birthday;
        private String phone;
        private boolean emailCheck;
        private boolean phoneCheck;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class myProfileResponseDto{
        private String email;
        private String name;
        private Date birthday;
        private Date joinDate;
        private String phone;
        private String joinType;
        private boolean emailCheck;
        private boolean phoneCheck;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class unregisterDto{
        private long userId;
        private String password;
    }

}
