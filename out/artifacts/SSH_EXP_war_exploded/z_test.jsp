<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TEST</title>
</head>
<body style="font-family: 等线, sans-serif">
<h1 style="text-align: center">TEST.JSP</h1>
<h1 style="text-align: center">${sessionScope.user.userName}</h1>
<h1 style="text-align: center">${sessionScope.user.userTel}</h1>
<br/>
<h1 style="text-align: center">
    <a href="UserCenter.action">${sessionScope.user.userName}用户中心</a>
</h1>
<br/>
<h1 style="text-align: center">
    <a href="WashClothes.action">我要洗衣</a>
</h1>

</body>
</html>
