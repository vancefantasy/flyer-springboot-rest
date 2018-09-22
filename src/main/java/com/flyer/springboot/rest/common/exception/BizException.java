package com.flyer.springboot.rest.common.exception;

import com.flyer.springboot.rest.constant.ErrorEnum;

/**
 * User-defined Exception
 * Created by jianying.li on 2018/9/16.
 */
public class BizException extends RuntimeException {

    /**
     * error info
     */
    private ErrorEnum error;

    public BizException(ErrorEnum error) {
        this.error = error;
    }

    public ErrorEnum getError() {
        return error;
    }

    public static void throwOut(ErrorEnum error) {
        throw new BizException(error);
    }

}
