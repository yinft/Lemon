package com.lemon.domain.dto;

import lombok.Data;

/**
 * @Author: yinft
 * @Date: 2019/2/28 20:45
 * @Version 1.0
 */
@Data
public class UserDto {

    private String username;

    private String email;

    private Boolean enabled;

}
