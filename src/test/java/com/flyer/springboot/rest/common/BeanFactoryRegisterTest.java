package com.flyer.springboot.rest.common;

import com.flyer.springboot.rest.AbstractTest;
import org.junit.Test;
import org.springframework.core.env.Environment;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;

/**
 * Created by jianying.li on 2018/9/16.
 */
public class BeanFactoryRegisterTest extends AbstractTest {

    @Test
    public void getBean() throws Exception {
        Environment environment = (Environment) BeanFactoryRegister.getBean("environment");
        log.warn("curernt active env: {}", Arrays.toString(environment.getActiveProfiles()));
        assertNotNull("getBean object is null", environment);
    }

    @Test
    public void getBean1() throws Exception {
        Environment environment = BeanFactoryRegister.getBean(Environment.class);
        log.warn("curernt default env: {}", Arrays.toString(environment.getDefaultProfiles()));
        assertNotNull("getBean1 object is null", environment);
    }

}
