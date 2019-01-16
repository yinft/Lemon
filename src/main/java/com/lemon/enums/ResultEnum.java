package com.lemon.enums;

/**
 * 异常枚举
 * @Author: yinft
 * @Date: 2018/12/16 23:10
 * @Version 1.0
 */
public enum ResultEnum {


    /**
     * 其他
     */
    SYS_ERROR(500, "服务异常"),
    FORBIDDEN(403,"Token令牌无效"),
    UNAUTHORIZED(401,"Token令牌已过期"),
    USER_DONT_EXISTS(1000000, "用户不存在");



    private Integer code;

    private String message;

    ResultEnum(Integer code, String message)
    {
        this.code = code;
        this.message = message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode()
    {
        return code;
    }

    public String getMessage()
    {
        return message;
    }

}
