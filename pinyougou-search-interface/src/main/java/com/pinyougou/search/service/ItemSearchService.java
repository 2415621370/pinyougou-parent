package com.pinyougou.search.service;

import java.util.List;
import java.util.Map;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2020/5/18 10:52
 */
public interface ItemSearchService {

    public Map<String,Object> search(Map searchMap);
    public void importList(List list);
    public void deleteByGoodIds(List goodsIdList);
}
