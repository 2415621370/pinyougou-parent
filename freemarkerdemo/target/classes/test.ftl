<html>
<head>
    <meta charset="utf-8"/>
    <title >freemarker入门小demo</title>
</head>
<body>
<#include "head.ftl">
<#-- 我是一个注释，不会有输出-->

<!--我也是一个注释-->
${name},你好。
<#if message??>
    ${message}
<#else >
    message变量不存在
</#if>



<#-- 定义简单的类型 变量-->
<#assign studentName="善雨">

老铁的名字：${studentName}
<#-- 定义对象的类型 变量-->
<#assign student={"name":"善雨","age":"38","sex":"你猜"}>
<br/>
姓名：${student.name}
<br/>
年龄：${student.age}
<br/>

<a href="http://www.baidu.com">点击</a>

性别：
<#if isSex==true>
    男性
<#else >
     女性
</#if>

<br>

<#list studentList as student>
    ${student_index+1} 学生姓名：${student.names} 年龄：${student.address} 性别：${student.sexs}<br/>

</#list>

共 ${studentList?size}条记录

<br>
<#assign text="{'name':'善雨','money':'9.9'}" />

<#assign data=text?eval />
姓名：${data.name} 月薪：${data.money}

<br/>

当前日期：${today?date}<br/>
当前时间：${today?time}<br/>
当前日期+时间：${today?datetime}<br/>
日期格式化：${today?string("yyyy年MM月dd日 HH：mm：ss")}<br/>

${point}
<br/>
${point?c}

<br/>
${bw!'八维'}
</body>
</html>