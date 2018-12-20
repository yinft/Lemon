package com.lemon.domain.dto;

import java.io.Serializable;

/**
 * @Author: yinft
 * @Date: 2018/12/20 21:50
 * @Version 1.0
 */
public class JwtAuthenticationDto implements Serializable {
    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;


    public JwtAuthenticationDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
