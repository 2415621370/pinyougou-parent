package com.pinyougou;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 *
 * 点对点-消息的生产者
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2020/5/22 10:50
 */
public class QueueProducer {
    public static void main(String[] args) throws JMSException {
        //1，创建连接工厂
        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("tcp://10.211.55.6:61616");

        //2，获取连接
        Connection connection = connectionFactory.createConnection();

        //3，启动连接
        connection.start();

        //4，获取session(参数1：是否开启事务，参数2：消息的确认模式)
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 5，创建队列的对象
        Queue queue = session.createQueue("1709B-test-queue");
//Destination;
        // 6，创建消息的生产者
        MessageProducer producer = session.createProducer(queue);

        // 7，创建消息
        TextMessage textMessage = session.createTextMessage("八维云计算，力量最强悍，666");

        // 8，发送消息
        producer.send(textMessage);

        // 9，关闭资源
        producer.close();
        session.close();
        connection.close();


    }


}
