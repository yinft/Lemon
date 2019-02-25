package com.lemon.utils.exception;

import com.lemon.domain.vo.ResultMap;
import com.lemon.enums.ResultEnum;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理自定义异常
     *
     * @param e
     * @return
     */
      @ExceptionHandler(BaseException.class)
      @ResponseBody
      public ResultMap handlerBaseException(BaseException e){
          log.error(e.getMessage());
          return ResultMap.error(e.getCode(),e.getMessage());
             }

    /**
     * 系统异常
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResultMap<Object> handleException(Exception e)
    {
        log.error(e.getMessage(), e);
        return ResultMap.error(ResultEnum.SYS_ERROR.getCode(),ResultEnum.SYS_ERROR.getMessage());
    }


//    /**
//     * token过期处理
//     */
//    @ResponseBody
//    @ExceptionHandler(value = JwtException.class)
//    public ResultMap handleExpiredJwtException(JwtException e)
//    {
//        log.error(e.getMessage(), e);
//        return ResultMap.error(ResultEnum.UNAUTHORIZED.getCode(),ResultEnum.UNAUTHORIZED.getMessage());
//    }


}
