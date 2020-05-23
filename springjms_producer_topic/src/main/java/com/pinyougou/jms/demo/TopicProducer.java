package com.pinyougou.jms.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2020/5/23 10:01
 */

@Component
public class TopicProducer {

    @Autowired
    JmsTemplate jmsTemplate;


    //消息的目的地
    @Autowired
    Destination topicTextDestination;

    /**
     * 发送文本消息
     */

    public void  sendTextMessage(final String text){
        jmsTemplate.send(topicTextDestination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(text);
            }
        });

    }
}
