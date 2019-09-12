package com.jizhang.activiti.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Aaron
 * @Date: 2019/9/12 16:23
 * @Desc: 全局异常处理
 */
@ControllerAdvice(annotations = RestController.class)
public class GlobalExeptionHandler {

    /**
     * 默认异常返回
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResultBody<CExcetion> defaultHandleException(HttpServletRequest req, Exception e){
        CExcetion ce = new CExcetion(ResultCodeConstants.SYSTEM_ERROR,
                "url [" + req.getRequestURL().toString() +"] got error!");
        ResultBody<CExcetion> resultBody = new ResultBody(ce);
        return resultBody;
    }

    /**
     * 自定义异常返回
     * @param req
     * @param ce
     * @return
     */
    @ExceptionHandler(value = CExcetion.class)
    public ResultBody<CExcetion> handleCException(HttpServletRequest req, CExcetion ce){
        ResultBody<CExcetion> resultBody = new ResultBody(ce);
        return resultBody;
    }
}
