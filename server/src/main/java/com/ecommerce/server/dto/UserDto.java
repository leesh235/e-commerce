package com.ecommerce.server.dto;

import lombok.*;
import java.util.Date;

public class UserDto {

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

}
