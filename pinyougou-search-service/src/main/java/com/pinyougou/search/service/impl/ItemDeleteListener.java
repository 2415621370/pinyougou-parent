package com.pinyougou.search.service.impl;

import com.pinyougou.search.service.ItemSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.util.Arrays;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2020/5/25 10:23
 */
@Component
public class ItemDeleteListener implements MessageListener {

    @Autowired
    ItemSearchService itemSearchService;


    @Override
    public void onMessage(Message message) {

        System.out.println("开始接受消息--------");
        ObjectMessage objectMessage =   (ObjectMessage)message;
        try {
            Long [] goodsIds =  (Long [])objectMessage.getObject();
            System.out.println("接收到消息是："+Arrays.asList(goodsIds));
            itemSearchService.deleteByGoodIds(Arrays.asList(goodsIds));
            System.out.println("删除成功");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
