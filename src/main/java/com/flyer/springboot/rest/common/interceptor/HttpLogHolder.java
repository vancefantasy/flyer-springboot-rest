package com.flyer.springboot.rest.common.interceptor;

import org.springframework.core.NamedThreadLocal;

/**
 * Created by jianying.li on 2018/9/16.
 */
public class HttpLogHolder {
    private static NamedThreadLocal<HttpLog> threadLocal =
        new NamedThreadLocal<>("HttpLogHolder");

    public static void set(HttpLog httpLog) {
        threadLocal.set(httpLog);
    }

    public static HttpLog get() {
        return threadLocal.get();
    }

    public static void clean() {
        threadLocal.remove();
    }
}
