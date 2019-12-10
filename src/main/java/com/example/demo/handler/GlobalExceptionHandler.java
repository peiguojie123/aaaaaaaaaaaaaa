package com.example.demo.handler;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 *
 * @author xiangze
 *
 */
@ControllerAdvice    //跟前端做交互
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class) //处理所有的异常
    @ResponseBody   //不是返回http页面  而是返回错误信息 所以直接用ResponseBody这个标签

    //编写异常处理方法XsXqServiceImpl
    public Map<String, Object> exceptionHandler(HttpServletRequest req, Exception e) throws Exception {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", false);
        modelMap.put("errMsg", e.getMessage());
        return modelMap;
    }

}