package com.pinyougou.search.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.search.service.ItemSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.List;
import java.util.Map;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2020/5/25 9:10
 */
@Component
public class ItemSearchListener implements MessageListener {

    @Autowired
    ItemSearchService itemSearchService;

    @Override
    public void onMessage(Message message) {

        System.out.println("开始监听消息");
        TextMessage textMessage =  (TextMessage) message;
        try {
            //消息本身  tbItemStr
            String text = textMessage.getText();
            //反序列化：将json字符串转化成list 对象
            List<TbItem> itemList = JSON.parseArray(text,TbItem.class);
            for(TbItem item:itemList){
               Map specMap =  JSON.parseObject(item.getSpec());
               item.setSpecMap(specMap);
            }
            itemSearchService.importList(itemList);
            System.out.println("成功导入solr 索引库");
        } catch (JMSException e) {
            e.printStackTrace();
        }


    }
}
