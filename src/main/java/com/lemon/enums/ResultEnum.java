package com.lemon.enums;

/**
 * @Author: yinft
 * @Date: 2018/12/16 23:10
 * @Version 1.0
 */
public enum ResultEnum {


    /**
     * 其他
     */
    SYS_ERROR(500, "服务异常"),



            ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message)
    {
        this.code = code;
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
