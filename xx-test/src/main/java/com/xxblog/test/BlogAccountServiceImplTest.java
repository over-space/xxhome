package com.xxblog.test;

import com.xxbase.test.SpringBaseTest;
import com.xxblog.services.BlogAccountService;
import com.xxblog.services.BlogGroupService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by admin on 16/05/16.
 */
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class BlogAccountServiceImplTest extends SpringBaseTest {

    @Autowired
    private BlogAccountService blogAccountService;

    @Test
    public void testInit(){
        blogAccountService.clear();
        blogAccountService.initDefaultAccount();
    }

}

