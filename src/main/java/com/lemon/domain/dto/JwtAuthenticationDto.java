package com.lemon.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: yinft
 * @Date: 2018/12/20 21:50
 * @Version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
public class JwtAuthenticationDto implements Serializable {

    private final String token;


}
