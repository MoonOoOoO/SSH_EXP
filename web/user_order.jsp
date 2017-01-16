<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link href="css/font-awesome.min.css" rel="stylesheet"/>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/bootstrap-theme.min.css" rel="stylesheet"/>
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link href="css/css.css" rel="stylesheet"/>
    <link href="css/user_center.css" rel="stylesheet"/>
    <title>我的订单</title>
</head>

<body>

<div id="top">
    <div class="row">
        <div class="col-md-6 col-xs-12">
            <div class="top_left">
                <i class="fa fa-phone"></i>&nbsp;<span style="font-size: 12px">联系电话：</span>
                <span style="font-weight: bold;font-size: 15px;">157-0249-2471</span>
            </div>
        </div>
        <div class="col-md-6 col-xs-12">
            <div class="top_right">
                <a href="LoadCart.action"><i class="fa fa-shopping-cart"></i>&nbsp;洗衣篮</a>
                <span class="split">|</span>
                <a href="#"><i class="fa fa-shopping-bag"></i>&nbsp;活动专区</a>
                <span class="split">|</span>
                <a href="register.jsp"><i class="glyphicon glyphicon-log-in"></i>&nbsp;注册</a>
            </div>
        </div>
    </div>
</div>

<div id="nav">
    <div class="row">
        <div class="col-md-2 col-xs-3">
            <div class="nav_left">
                <a href="index.jsp">
                    <img src="img/div.jpg"/>
                </a>
            </div>
        </div>
        <div class="col-md-8 col-xs-12">
            <div class="nav_right">
                <ul class="nav nav-pills nav-justified">
                    <li><a href="index.jsp">首页</a></li>
                    <li><a href="UserCenter.action">我要洗衣</a></li>
                    <li><a href="buy_card.jsp">我要购卡</a></li>
                    <li><a href="shopping.jsp">积分商城</a></li>
                </ul>
            </div>
        </div>
        <div class="right_btn">
            <a class="nav_btn_user" href="user_center.jsp">用户中心</a>
            <a class="nav_btn_quit" href="Quit.action">退出</a>
        </div>
    </div>
</div>

<div id="content">
    <div class="user_center">
        <h2 class="user_title">用户中心</h2>
        <hr/>
        <div class="left_list">
            <div class="list-group">
                <div class="list-group-item list_head">
                    个人设置
                </div>
                <a href="user_center.jsp" class="list-group-item">用户首页</a>
                <a href="update_pwd.jsp" class="list-group-item">修改密码</a>
                <a href="address.jsp" class="list-group-item">地址管理</a>
            </div>
            <div class="list-group">
                <div class="list-group-item list_head">
                    订单中心
                </div>
                <a href="user_order.jsp" class="list-group-item">我的订单</a>
            </div>
            <div class="list-group">
                <div class="list-group-item list_head">
                    充值中心
                </div>
                <a href="buy_card.jsp" class="list-group-item">充值会员</a>
            </div>
        </div>
        <div class="right_content">
            <!--右侧开始-->
            <div class="col-sm-10">
                <div class="T_right">

                    <!--main开始-->
                    <div style=" border-radius:0px; padding:10px 0;">
                        <p class="text-left" style=" font-size:14px; border-bottom:1px "><strong>
                            &nbsp;我的订单&nbsp;</strong></p>
                    </div>
                    <div class="WOde">
                        <ul>
                            <li class="col-md-3">取货地址</li>
                            <li class="col-md-2 text-center">订单号</li>
                            <li class="col-md-3 text-center">下单日期</li>
                            <li class="col-md-2 text-center">金&nbsp;&nbsp;额</li>
                            <li class="col-md-2 text-center">状&nbsp;&nbsp;态</li>
                            <li style="clear:both"></li>
                        </ul>
                    </div>
                    <c:choose>
                        <c:when test="${empty(sessionScope.orders)}">
                            <div class="XOde">
                                <center>您还没有任何订单</center>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="WOde">
                                <c:forEach var="order" items="${sessionScope.orders}">
                                    <ul>
                                        <li class="col-md-3">${order.address}</li>
                                        <li class="col-md-2 text-center">${order.orderId}</li>
                                        <li class="col-md-3 text-center">${order.orderDate}</li>
                                        <li class="col-md-2 text-center">${order.orderPrice}</li>
                                        <li class="col-md-2 text-center">${order.orderStatus}</li>
                                        <li style="clear:both"></li>
                                    </ul>
                                    <hr style="background-color:black;height: 1px;margin-top: 5px;margin-bottom: 5px;"/>
                                </c:forEach>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <!--右侧结束-->
        </div>
    </div>
</div>

<div id="footer">
    <p>©&nbsp;2016&nbsp;辽宁省沈阳市东北大学（浑南校区）软件学院</p>
    <p>软件工程1401班&nbsp;储志伟&nbsp;李冲&nbsp;魏汝刚&nbsp;王振松<span class="split">|</span>软件工程1410班（宁夏）&nbsp;卢成冬</p>
</div>

<a href="LoadCart.action">
    <div class="shopping_cart">
        <i class="fa fa-3x fa-shopping-cart"></i>
        <span class="count">0</span>
    </div>
</a>

<div class="to_top" id="toTop">
    <i class="fa fa-3x fa-angle-up"></i>
</div>

</body>
<script>
    $(function () {
        $("#toTop").click(function () {
            $("html").animate({"scrollTop": "0px"}, 300); //IE,FF
            $("body").animate({"scrollTop": "0px"}, 300); //Webkit
        });
    })
</script>
</html>