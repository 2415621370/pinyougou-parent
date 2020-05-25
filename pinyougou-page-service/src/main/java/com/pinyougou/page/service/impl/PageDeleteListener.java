package com.pinyougou.page.service.impl;

import com.pinyougou.page.service.ItemPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2020/5/25 11:23
 */
@Component
public class PageDeleteListener implements MessageListener {

    @Autowired
    private ItemPageService itemPageService;
    @Override
    public void onMessage(Message message) {

        System.out.println("页面删除开始接受消息");
        ObjectMessage objectMessage =  (ObjectMessage)message;
        try {
            Long[] goodsids =  (Long [])objectMessage.getObject();
            boolean b = itemPageService.deleteItemHtml(goodsids);
            System.out.println("删除页面的结果是："+b);
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
