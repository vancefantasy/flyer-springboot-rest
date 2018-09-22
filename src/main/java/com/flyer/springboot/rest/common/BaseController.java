package com.flyer.springboot.rest.common;

import com.flyer.springboot.rest.common.exception.BizException;
import com.flyer.springboot.rest.constant.ErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.Iterator;

/**
 * Created by jianying.li on 2018/9/16.
 */
public class BaseController {

    protected Logger log = LoggerFactory.getLogger(getClass());

    public void checkJSR303(BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            Iterator<ObjectError> iterator = result.getAllErrors().iterator();
            while (iterator.hasNext()) {
                sb.append(iterator.next().getDefaultMessage());
                if (iterator.hasNext()) {
                    sb.append(",");
                }
            }
            log.warn("checkJSR303 fail, error: {}", sb.toString());
            BizException.throwOut(ErrorEnum.PARAMETER_ILLEGAL);
        }
    }

}
