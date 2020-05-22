package com.pinyougou;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * 发布订阅--消息的消费者
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2020/5/22 11:38
 */
public class TopicConsumer {
    public static void main(String[] args) throws JMSException, IOException {
        //1，创建连接工厂
        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("tcp://10.211.55.6:61616");

        //2，获取连接
        Connection connection = connectionFactory.createConnection();

        //3，启动连接
        connection.start();

        //4，获取session(参数1：是否开启事务，参数2：消息的确认模式)
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //5,创建主题对象
        Topic topic = session.createTopic("1709B-test-topic");

        //6,创建消息的消费者
        MessageConsumer consumer = session.createConsumer(topic);

        //监听消息
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage =  (TextMessage)message;
                try {
                    System.out.println("发布订阅接收到的消息是"+textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });


        //等待键盘输入
        System.in.read();

        //关闭资源
        consumer.close();
        session.close();
        connection.close();

    }
}
