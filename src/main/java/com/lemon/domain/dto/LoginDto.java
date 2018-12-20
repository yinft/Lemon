package com.lemon.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @Author: yinft
 * @Date: 2018/12/20 21:02
 * @Version 1.0
 */
public class LoginDto {



        @JsonProperty("username")
        @NotBlank(message ="请输入用户名!")
        @ApiModelProperty("用户名")
        private String username ;

        @JsonProperty("password")
        @ApiModelProperty("密码")
        @NotBlank(message ="请输入密码!")
        private String password ;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }


        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

