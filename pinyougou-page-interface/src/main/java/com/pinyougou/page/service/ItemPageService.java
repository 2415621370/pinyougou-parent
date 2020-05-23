package com.pinyougou.page.service;

import java.io.IOException;

/**
 * 商品详情页的接口
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2020/5/21 9:09
 */
public interface ItemPageService {

    /**
     * 生成商品详情页
     */

    public boolean getItemHtml(Long goodsId) throws IOException, Exception;
}
