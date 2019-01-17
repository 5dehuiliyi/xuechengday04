<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf‐8">
    <title>Hello World!</title>
</head>
<body>
Hello ${name}!

</br>
遍历数据模型中的list学生信息（数据模型中的名称stus）
   gt 表示大于 gte 大于等于  lt 小于 lte 小于等于   也可以用括号圈起来 ( a > b)
<table>
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>金额</td>
        <td>出生日期</td>
    </tr>
    <#if stus??>
    <#list stus as stu>
        <tr>
            <td>${stu_index+1}</td>
            <td <#if stu.name == '小明'>style="background: cornflowerblue;"</#if>>${stu.name}</td>
            <td>${stu.age}</td>
            <td>${stu.money}</td>
            <td>${stu.birthday?datetime}</td>
        </tr>
    </#list>
        学生个数：${stus?size}
    </#if>
</table>
<br>
遍历数据模型中的stuMap（map数据）
<br>
第一种方法：在 在[]中填写map的key
<br>
姓名：${(stuMap['stu1'].name)!""}<br>
年龄：${(stuMap['stu1'].age)!""}<br>
<br>
第二种方法：在map后面 加  .key
<br>
姓名：${(stuMap.stu1.name)!""}<br>
年龄：${(stuMap.stu1.age)!""}<br>
<br>
遍历map中的key.stuMap?keys就是key列表（是一个list）
<br>
<#list stuMap?keys as k>
    姓名：${stuMap[k].name}<br>
    年龄：${stuMap[k].age}<br>
</#list>

${point?c}
<br/>
<#assign text="{'bank':'工商银行','account':'10101920201920212'}" />
<#assign data=text?eval />
开户行：${data.bank} 账号：${data.account}
</body>
</html>