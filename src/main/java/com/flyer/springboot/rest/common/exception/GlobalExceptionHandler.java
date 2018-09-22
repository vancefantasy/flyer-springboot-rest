package com.flyer.springboot.rest.common.exception;

import com.flyer.springboot.rest.common.BaseResponse;
import com.flyer.springboot.rest.constant.ErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * global exception handler for controller
 * <p>
 * Created by jianying.li on 2018/9/16.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Biz exception handler
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public BaseResponse businessErrorHandler(HttpServletRequest req, BizException e) {
        ErrorEnum error = e.getError();
        if (error == null) {
            log.error("businessErrorHandler error, URI: {}", req.getRequestURI(), e);
            return BaseResponse.error().build();
        } else {
            //no need to print the stack exception log again
            log.error("businessErrorHandler error, URI: {}, code : {}, message : {}",
                req.getRequestURI(), error.code, error.message);
            return new BaseResponse.Builder<>().code(error.code).message(error.message).build();
        }
    }

    /**
     * system exception handler
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResponse systemErrorHandler(HttpServletRequest req, Exception e) {
        log.error("systemErrorHandler error, URI: {}", req.getRequestURI(), e);
        return BaseResponse.error().build();
    }

}
