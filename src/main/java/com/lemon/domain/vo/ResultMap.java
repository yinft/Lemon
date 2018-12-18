package com.lemon.domain.vo;

import com.lemon.enums.ResultEnum;

/**
 * @Author: yinft
 * @Date: 2018/12/16 22:55
 * @Version 1.0
 */
public class ResultMap<T> {


        private static final long serialVersionUID = -5897234194040793245L;

        /**
         * 状态码
         */
        private Integer code;

        /**
         * 状态码信息
         */
        private String msg;

        /**
         * 具体信息
         */
        private T data;

        public static <T> ResultMap<T> success(T object)
        {
            ResultMap<T> resultVO = new ResultMap<>();
            resultVO.setData(object);
            resultVO.setCode(200);
            resultVO.setMsg("成功");
            return resultVO;
        }

        public static ResultMap success()
        {
            return success(null);
        }

        public static <T> ResultMap<T> error(Integer code, String msg)
        {
            ResultMap<T> resultVO = new ResultMap<>();
            resultVO.setCode(code);
            resultVO.setMsg(msg);
            return resultVO;
        }

        public static <T> ResultMap<T> error(ResultEnum resultEnum)
        {
            ResultMap<T> resultVO = new ResultMap<>();
            resultVO.setCode(resultEnum.getCode());
            resultVO.setMsg(resultEnum.getMessage());
            return resultVO;
        }

        public Integer getCode()
        {
            return code;
        }

        public void setCode(Integer code)
        {
            this.code = code;
        }

        public String getMsg()
        {
            return msg;
        }

        public void setMsg(String msg)
        {
            this.msg = msg;
        }

        public T getData()
        {
            return data;
        }

        public void setData(T data)
        {
            this.data = data;
        }

    }


