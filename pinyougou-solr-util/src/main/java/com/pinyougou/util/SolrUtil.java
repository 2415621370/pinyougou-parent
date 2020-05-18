package com.pinyougou.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pinyougou.mapper.TbItemMapper;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.pojo.TbItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2020/5/18 9:48
 */
@Component
public class SolrUtil {
    //从mysql里面查询出来数据，pinyougou-dao

    @Autowired
    TbItemMapper itemMapper;

    @Autowired
    SolrTemplate solrTemplate;

    public void importItemData(){
        TbItemExample tbItemExample = new TbItemExample();
        TbItemExample.Criteria criteria = tbItemExample.createCriteria();
        criteria.andStatusEqualTo("1");//该商品已经审核通过
        List<TbItem> tbItems = itemMapper.selectByExample(tbItemExample);

        System.out.println("====商品列表====");
       for(TbItem item:tbItems){
           System.out.println(item.getTitle());
           //{"机身内存":"16G","网络":"联通3G"}
           String spec = item.getSpec();
           //将spec 字段中的json字符串转化成map对象
           Map map = JSON.parseObject(spec);
           item.setSpecMap(map);
       }

        solrTemplate.saveBeans(tbItems);
        solrTemplate.commit();

        System.out.println("====OVER====");
    }

    public static void main(String[] args){
        //加载spring配置文件，构建spring容器
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath*:spring/applicationContext*.xml");




        SolrUtil solrUtil =   (SolrUtil)context.getBean("solrUtil");
        solrUtil.importItemData();

    }
}
