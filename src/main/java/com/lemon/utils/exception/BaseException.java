package com.lemon.utils.exception;

import com.lemon.enums.ResultEnum;

/**
 * 创建异常类
 *
 * @Author: yinft
 * @Date: 2018/12/25 10:51
 * @Version 1.0
 */
public class BaseException extends RuntimeException {

    private Integer code;
    private String message;



    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BaseException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public BaseException(Integer code, String message) {

        this.code = code;
        this.message = message;
    }

    public BaseException(String msg){
        super(msg);
    }


}
