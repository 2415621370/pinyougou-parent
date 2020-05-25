package com.pinyougou.controller;

import com.pinyougou.entity.TbItem;
import com.pinyougou.service.TbItemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 商品表(TbItem)表控制层
 *
 * @author makejava
 * @since 2020-05-24 19:21:35
 */
@RestController
@RequestMapping("tbItem")
public class TbItemController {
    /**
     * 服务对象
     */
    @Resource
    private TbItemService tbItemService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbItem selectOne(Long id) {
        return this.tbItemService.queryById(id);
    }

}