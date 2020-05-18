package com.pinyougou;

import com.pinyougou.pojo.TbItem;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2020/5/18 8:37
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-solr.xml")
public class TestTempplate {

    @Autowired
    SolrTemplate solrTemplate;


    //从solr库里面增加数据

    @Test
    public void testAdd(){
        TbItem item = new TbItem();
        item.setId(1L);
        item.setTitle("华为手机店");
        item.setBrand("华为");
        item.setCategory("手机");
        item.setGoodsId(1L);
        item.setSeller("华为旗舰店");
        item.setPrice(new BigDecimal(999));
        solrTemplate.saveBean(item);
       //手动提交
        solrTemplate.commit();
    }

    /**
     * 根据id查询
     */
    @Test
    public void findOne(){
        TbItem item = solrTemplate.getById(1, TbItem.class);
        System.out.println(item.getTitle());
    }


    /**
     * 删除
     */
    @Test
    public void del(){
        UpdateResponse updateResponse = solrTemplate.deleteById("1");
        solrTemplate.commit();
    }

    /**
     * 批量添加
     */
    @Test
    public void testAddList(){
       List list =  new ArrayList();
       //ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 100; i++) {
            TbItem item = new TbItem();
            item.setId(i+1L);
            item.setTitle("华为手机店"+i);
            item.setBrand("华为");
            item.setCategory("手机");
            item.setGoodsId(1L);
            item.setSeller("华为旗舰店");
            item.setPrice(new BigDecimal(999+i));
            list.add(item);
        }

        solrTemplate.saveBeans(list);
        solrTemplate.commit();
    }


    /**
     * 分页查询
     */
    @Test
    public  void  testQueryForPage(){
        Query query = new SimpleQuery("*:*");
       //开始索引(默认：0)
        query.setOffset(20);
        query.setRows(20);

        ScoredPage<TbItem> page = solrTemplate.queryForPage(query, TbItem.class);
        //总记录数
        System.out.println(page.getTotalElements());
        List<TbItem> content = page.getContent();
        showList(content);

    }

    private void showList(List<TbItem> list){
  /*    for(TbItem item:list){
          System.out.println(item.getTitle()+";"+item.getPrice());
      }*/

      list.forEach(i->{ System.out.println(i.getTitle()); });

    }

    /**
     * 根据条件查询
     */

    @Test
    public void testPageQuery(){
        Query query =  new SimpleQuery("*:*");
        Criteria criteria = new Criteria("item_title").contains("5");
       // criteria.and("").contains("");
        query.addCriteria(criteria);
        ScoredPage<TbItem> page = solrTemplate.queryForPage(query, TbItem.class);
        List<TbItem> content = page.getContent();
        showList(content);
    }

    /**
     * 删除所有数据
     */
    @Test
    public  void delAll(){
        Query query =  new SimpleQuery("*:*");
        solrTemplate.delete(query);
        solrTemplate.commit();
    }





}
