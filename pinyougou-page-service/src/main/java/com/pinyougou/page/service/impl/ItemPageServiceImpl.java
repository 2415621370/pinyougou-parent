package com.pinyougou.page.service.impl;


import com.pinyougou.mapper.TbGoodsDescMapper;
import com.pinyougou.mapper.TbGoodsMapper;
import com.pinyougou.mapper.TbItemCatMapper;
import com.pinyougou.page.service.ItemPageService;
import com.pinyougou.pojo.TbGoods;
import com.pinyougou.pojo.TbGoodsDesc;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;


/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2020/5/21 9:39
 */
@Service
public class ItemPageServiceImpl implements ItemPageService {

    @Value("${pagedir}")
    private String pagedir;

    @Autowired
    private FreeMarkerConfig freemarkerConfig;

    @Autowired
    TbGoodsMapper goodsMapper;

    @Autowired
    TbGoodsDescMapper goodsDescMapper;

    @Autowired
    TbItemCatMapper itemCatMapper;


    @Override
    public boolean getItemHtml(Long goodsId) throws Exception {
        try{
            Configuration configuration = freemarkerConfig.getConfiguration();
            Template template = configuration.getTemplate("item.ftl");
            HashMap hashMap = new HashMap<>();

            TbGoods tbGoods = goodsMapper.selectByPrimaryKey(goodsId);
            hashMap.put("goods",tbGoods);

            TbGoodsDesc tbGoodsDescs = goodsDescMapper.selectByPrimaryKey(goodsId);
            hashMap.put("goodsDesc",tbGoodsDescs);
            Long category1Id = tbGoods.getCategory1Id();
            Long category2Id = tbGoods.getCategory2Id();
            Long category3Id = tbGoods.getCategory3Id();


            String name1 = itemCatMapper.selectByPrimaryKey(category1Id).getName();
            String name2 = itemCatMapper.selectByPrimaryKey(category2Id).getName();
            String name3 = itemCatMapper.selectByPrimaryKey(category3Id).getName();
            hashMap.put("name1",name1);
            hashMap.put("name2",name2);
            hashMap.put("name3",name3);

            Writer out= new FileWriter(pagedir + goodsId + ".html");
                                       //    c:\\item\\857.html
            template.process(hashMap,out);
            out.close();
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean deleteItemHtml(Long[] goodsIds) {

        try{
            for (Long goodsId : goodsIds) {
                System.out.println(pagedir + goodsId + ".html");
                new File(pagedir + goodsId + ".html").delete();
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }


    }
}
