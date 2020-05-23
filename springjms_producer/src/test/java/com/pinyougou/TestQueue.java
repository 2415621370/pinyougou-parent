package com.pinyougou;

import com.pinyougou.jms.demo.QueueProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2020/5/23 9:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-jms-producer.xml")
public class TestQueue {
        @Autowired
        QueueProducer queueProducer;

        @Test
        public void testSend(){
            queueProducer.sendTextMessage("spring -jms-d点对点");
        }
}
