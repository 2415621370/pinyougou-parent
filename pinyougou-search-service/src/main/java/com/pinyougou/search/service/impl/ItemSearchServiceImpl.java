package com.pinyougou.search.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.search.service.ItemSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.*;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.core.query.result.ScoredPage;

import javax.swing.text.Highlighter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2020/5/18 10:57
 */

@Service
public class ItemSearchServiceImpl implements ItemSearchService {

    @Autowired
    SolrTemplate solrTemplate;

    /**
     * 先接受用户在页面输入的关键词
     * 然后把关键词传给solr solr进行内部搜索与匹配
     * 吧结果返回出来
     * @param searchMap
     * @return
     */
    @Override
    public Map<String, Object> search(Map searchMap) {
        Map map =  new HashMap();
        //构造高亮查询对象
        HighlightQuery query =  new SimpleHighlightQuery();
        //创建高亮查询设置对象，设置高亮显示的域（可以设置多个，获取高亮数据是通过下标获取）
        HighlightOptions highlightOptions =
                new HighlightOptions().addField("item_title");
        //高亮的前缀
        highlightOptions.setSimplePrefix("<em style='color:red'>");
        //高亮的后缀
        highlightOptions.setSimplePostfix("</em>");
        //设置高亮选项
        query.setHighlightOptions(highlightOptions);
        //关键词的搜索
        Criteria criteria =
                new Criteria("item_keywords").is(searchMap.get("keywords"));
        query.addCriteria(criteria);

        //执行查询，注意：这里面的结果集中的getContent返回的结果集中，并没有带上高亮，需要我们自行处理
        HighlightPage<TbItem> page = solrTemplate.queryForHighlightPage(query, TbItem.class);
        //高亮显示数据结果集的入口
      //  List<HighlightEntry<TbItem>> highlighted = page.getHighlighted();

        //从结果集中取出数据，最先遍历高亮结果入口集
        for(HighlightEntry<TbItem> entry:page.getHighlighted()){
            //健壮性的判断
            if(entry.getHighlights().size()>0 && entry.getHighlights().get(0).getSnipplets().size()>0){
                //通过高亮域下标从高亮结果入口集中再获取高亮数据   <em style='color:red'>联想</em>
                String title = entry.getHighlights().get(0).getSnipplets().get(0);
                //从entry 中获取当前遍历到的item，并将高亮数据设置到标题title
                TbItem item = entry.getEntity();
                item.setTitle(title);
            }
        }
        List<TbItem> contentList = page.getContent();
        map.put("rows",contentList);
        return map;
    }
}
