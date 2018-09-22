package com.flyer.springboot.rest.common.interceptor;

import com.flyer.springboot.rest.common.BaseResponse;

import java.util.Map;

/**
 * Created by jianying.li on 2018/9/16.
 */
public class HttpLog {

    private Map general;

    private Map parameters;

    private String requestBody;

    private BaseResponse responseBody;

    public Map getParameters() {
        return parameters;
    }

    public void setParameters(Map parameters) {
        this.parameters = parameters;
    }

    public Map getGeneral() {
        return general;
    }

    public void setGeneral(Map general) {
        this.general = general;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public BaseResponse getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(BaseResponse responseBody) {
        this.responseBody = responseBody;
    }
}
