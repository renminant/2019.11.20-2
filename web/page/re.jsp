<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/18
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <script src="<%=request.getContextPath()%>/js/jquery-3.4.1.min.js"></script>
</head>
<body>

<table>
    <tbody>
    <tr>
        <td>	<input name="method" value="query" class="input-text" type="hidden"/>
            用户名：<input name="name" class="input-text" type="text" />&nbsp;&nbsp;&nbsp;&nbsp;
            用户名：<input name="phone" class="input-text" type="text"/>&nbsp;&nbsp;&nbsp;&nbsp;
            <input value="查 询" type="submit" name="search"/>
        </td>
    </tr>
    </tbody>
</table>
<input type="text" name="loginName">
<script type="text/javascript">
    $(function () {
        var loginName = $("input[name =loginName]");
        console.log(loginName.val())
        loginName.on("blur",function () {
            $.ajax({
                url:"<%=request.getContextPath()%>/cheeck.action",
                data:"name"+loginName.val(),
                dataType:"test",
                type:"post",
                success:function (t) {
                    if (t.length>0) {
                        $("span").html(t);
                    }
                }
            })
        })
    })
    $(function () {
        var search = $("#search");
        var $name=$("input[name=name]");
        var $phone=$("input[name=phone]");
        search.on("click",function () {
            var data={naem:$name.val(),phone:$phone.val()}
            console.log(data);
            $.ajax({
                url:"<%=request.getContextPath()%>/search.action",
                dataType:"json",
                contentType:"application/json",
                    type:"POST",
                data:JSON.stringify(data),
                success:function (t) {
                    $("tbody").empty();
                    for (var ) 
                }

            })
        })
    })
</script>
</body>
</html>
