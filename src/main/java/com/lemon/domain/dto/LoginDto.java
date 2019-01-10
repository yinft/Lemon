package com.lemon.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author: yinft
 * @Date: 2018/12/20 21:02
 * @Version 1.0
 */
@Getter
@Setter
public class LoginDto implements Serializable{

        @JsonProperty("username")
        @NotBlank(message ="请输入用户名!")
        @ApiModelProperty("用户名")
        private String username ;

        @JsonProperty("password")
        @ApiModelProperty("密码")
        @NotBlank(message ="请输入密码!")
        private String password ;


    }

