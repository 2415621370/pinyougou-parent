package com.pinyougou.user.service.impl;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2020/5/27 10:33
 */
public class Test {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("code","12334");
        String s = JSON.toJSONString(map);
        System.out.println(s);
    }
}
