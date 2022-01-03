package com.ecommerce.server.dto;

import lombok.*;
import java.util.Date;

public class UserDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class profileDto{
        private String email;
        private String name;
        private String birthday;
        private String sex;
        private Date joinDate;
        private String phone;
        private String joinType;
        private boolean emailCheck;
        private boolean phoneCheck;
        private boolean emailAd;
        private boolean phoneAd;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class modifyProfileDto{
        private long userId;
        private String name;
        private boolean emailAd;
        private boolean phoneAd;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class modifyPassword{
        private long userId;
        private String currentPassword;
        private String nextPassword;
        private String confirmPassword;
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
