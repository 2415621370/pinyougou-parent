package com.pinyougou;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2020/5/23 9:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-jms-consumer.xml")
public class TextQueue {

    @Test
    public void TestQueue() throws IOException {
        System.in.read();
    }
}
