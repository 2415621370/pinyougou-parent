package com.pinyougou.portal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.content.service.ContentService;
import com.pinyougou.pojo.TbContent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2020/5/14 14:23
 */

@RestController
@RequestMapping("/content")
public class ContentController {


    @Reference
    private ContentService contentService;

    /**
     * 根据广告分类ID查询广告列表
     * @param categoryId
     * @return
     */
    @RequestMapping("/findByCategoryId")
    public List<TbContent> findByCategoryId(Long categoryId) {
        return contentService.findByCategoryId(categoryId);
    }
}
