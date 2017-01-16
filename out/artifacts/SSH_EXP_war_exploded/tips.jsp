<%--suppress ALL --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="css/font-awesome.min.css" rel="stylesheet"/>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/bootstrap-theme.min.css" rel="stylesheet"/>
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link href="css/css.css" rel="stylesheet"/>
    <title>提示</title>
</head>
<body style="font-family: 微软雅黑, sans-serif">
<br/>
<c:choose>
    <c:when test="${requestScope.flag == 1}">
        <br/>
        <br/>
        <h1 style="text-align: center">${requestScope.tip}</h1>
        <h1 style="text-align: center">
            <a href="WashClothes.action" style="font-size: 20px;font-weight: bolder">返回继续添加</a>
        </h1>
        <h1 style="text-align: center">
            <a href="LoadCart.action" style="font-size: 20px;font-weight: bolder">去洗衣篮结算</a>
        </h1>
    </c:when>
    <c:when test="${requestScope.flag == 2}">
        <br/>
        <br/>
        <h1 style="text-align: center">
            <a href="index.jsp" style="font-size: 30px;font-weight: bolder">成功退出，
                <span style="font-size: 30px;font-weight: bolder" id="mes"></span>
                秒钟后返回首页...
            </a>
        </h1>
        <script>
            var t = 6;
            //显示倒数秒数
            function showTime() {
                t -= 1;
                document.getElementById('mes').innerHTML = t;
                if (t == 0) {
                    location.href = 'index.jsp';
                }
                //每秒执行一次,showTime()
                setTimeout("showTime()", 1000);
            }

            //执行showTime()
            showTime();
        </script>
    </c:when>
</c:choose>

</body>
</html>
