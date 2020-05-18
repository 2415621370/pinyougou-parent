package com.pinyougou.search.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.search.service.ItemSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;

import java.util.HashMap;
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
        SimpleQuery query = new SimpleQuery();
        //添加查询条件
        Criteria criteria =
                new Criteria("item_keywords").is(searchMap.get("keywords"));
        query.addCriteria(criteria);

        ScoredPage<TbItem> page = solrTemplate.queryForPage(query, TbItem.class);

        map.put("rows",page.getContent());
        return map;
    }
}
