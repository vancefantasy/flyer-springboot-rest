package com.flyer.springboot.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by jianying.li on 2018/9/16.
 */
@ActiveProfiles("ut")
@SpringBootTest
@RunWith(SpringRunner.class)
public class AbstractTest {

    protected Logger log = LoggerFactory.getLogger(getClass());

    private static boolean checkDBNameDone = false;

    @Before
    public void setUp() {
        if (!checkDBNameDone) {
            DBUtils.checkDBName();
            checkDBNameDone = true;
        }
    }

    @Test
    public void nothing() {
    }

}
