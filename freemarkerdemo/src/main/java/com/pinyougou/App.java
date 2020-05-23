package com.pinyougou;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, TemplateException {

        //System.out.println( "Hello World!" );
        //1,创建配置类，创建一个Configuration对象,直接new一个对象。构造方法参数得是freemarker的版本号
        Configuration configuration = new Configuration(Configuration.getVersion());

        //2,设置模板所在的目录
        configuration.setDirectoryForTemplateLoading(
                new File("C:/mycode/yunjisuan/pinyougou-parent/freemarkerdemo/src/main/resources/"));

        //3.设置字符集
        configuration.setDefaultEncoding("utf-8");

        //4,加载模板
        Template template = configuration.getTemplate("test.ftl");

        //5,创建数据模型,可以用map封装，也可以自己定义对象
        Map map = new HashMap();
        map.put("name","张三");
        map.put("message","欢迎学习freemarker，从入门到放弃");
        map.put("isSex",false);




       List list =  new ArrayList();
       Map studentMap1 =  new HashMap();
        studentMap1.put("names","善雨");
        studentMap1.put("address","山东");
        studentMap1.put("sexs","男");

        Map studentMap2 =  new HashMap();
        studentMap2.put("names","一柯");
        studentMap2.put("address","山西");
        studentMap2.put("sexs","男");

        Map studentMap3 =  new HashMap();
        studentMap3.put("names","善昊");
        studentMap3.put("address","山南");
        studentMap3.put("sexs","男");

        list.add(studentMap1);
        list.add(studentMap2);
        list.add(studentMap3);

        map.put("studentList",list);

        map.put("today",new Date());

        map.put("point",1090893298);
        map.put("bw","八维云计算");


        //6,创建Writer对象
        Writer out =  new FileWriter(new File("C:\\item\\test.html"));

        //7,输出
        template.process(map,out);

        //8，关闭Writer 对象
        out.close();


    }
}
