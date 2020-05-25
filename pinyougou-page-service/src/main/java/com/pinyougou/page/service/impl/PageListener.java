package com.pinyougou.page.service.impl;

import com.pinyougou.page.service.ItemPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.IOException;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2020/5/25 11:00
 */
@Component
public class PageListener implements MessageListener {

    @Autowired
    ItemPageService itemPageService;

    @Override
    public void onMessage(Message message) {
        System.out.println("页面生成服务开始监听-----");
        TextMessage textMessage =  (TextMessage)message;
        try {
            //goodsid
            String text = textMessage.getText();
            System.out.println("接收到的消息是"+text);
            itemPageService.getItemHtml(Long.parseLong(text));
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
