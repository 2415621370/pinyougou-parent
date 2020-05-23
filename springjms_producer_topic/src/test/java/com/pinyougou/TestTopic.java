package com.pinyougou;

import com.pinyougou.jms.demo.TopicProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2020/5/23 10:05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-jms-producer-topic.xml")
public class TestTopic {

    @Autowired
    TopicProducer topicProducer;

    @Test
    public  void sentTextTopic(){
        topicProducer.sendTextMessage("spring-jms-发布订阅模式--66666");
    }
}
