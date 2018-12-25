package com.lemon.util.exception;

import com.lemon.domain.vo.ResultMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 使用Handler类捕获异常，统一返回给前端
 * @Author: yinft
 * @Date: 2018/12/25 11:03
 * @Version 1.0
 */

@ControllerAdvice
public class BaseExceptionHandler {
      @ExceptionHandler(value = BaseException.class)
      @ResponseBody
      public ResultMap handlerBaseException(BaseException e){
                 return ResultMap.error(e.getCode(),e.getMessage());
             }

}
