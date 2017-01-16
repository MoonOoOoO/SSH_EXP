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
    <title>我要购卡</title>
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
                <c:choose>
                    <c:when test="${empty(sessionScope.user)}">
                        <a href="register.jsp"><i class="glyphicon glyphicon-log-in"></i>&nbsp;注册</a>
                    </c:when>
                    <c:otherwise>
                        <a href="Quit.action"><i class="glyphicon glyphicon-log-out"></i>&nbsp;退出</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>

<div id="nav">
    <div class="row">
        <div class="col-md-2 col-xs-3">
            <div class="nav_left">
                <a href="index.jsp">
                    <img style="width: 120px;" src="img/div.jpg"/>
                </a>
            </div>
        </div>
        <div class="col-md-8 col-xs-12">
            <div class="nav_right">
                <ul class="nav nav-pills nav-justified">
                    <li><a href="index.jsp">首页</a></li>
                    <li><a href="WashClothes.action">我要洗衣</a></li>
                    <li class="active"><a href="#">我要购卡</a></li>
                    <li><a href="shopping.jsp">积分商城</a></li>
                </ul>
            </div>
        </div>
        <c:choose>
            <c:when test="${empty(sessionScope.user)}">
                <a class="nav_btn" href="login.jsp">登&nbsp;录</a>
            </c:when>
            <c:otherwise>
                <a class="nav_btn" href="UserCenter.action">${sessionScope.user.userName}</a>
            </c:otherwise>
        </c:choose>
    </div>
</div>

<div id="content">
    <div class="row" style="height: 300px;padding-left: 20px;width: 100%;">
        <div class=" col-md-6" style="padding-right: 11px;height: 100%;left: 5px">
            <div class="thumbnail" style="float:left;height: 90%;width: 100%">
                <img src="img/div.jpg" class="vip_card_pic" alt="...">
                <div class="detail">
                    <span style="color: red;font-size: 20px;">￥100.00</span>
                    <br>
                    <span style="font-size: 15px;line-height: 30px">本卡下单洗衣享受8.5折优惠</span>
                    <br>
                    <span style="font-size: 15px;line-height: 30px">本卡下单洗衣享受8.5折优惠</span>
                    <br>
                    <span style="font-size: 15px;line-height: 30px">本卡下单洗衣享受8.5折优惠</span>
                    <br>
                    <span style="font-size: 15px;line-height: 30px">本卡下单洗衣享受8.5折优惠</span>
                    <br>
                    <button class="buy_vip_card">购卡</button>
                </div>
            </div>
        </div>
        <div class=" col-md-6" style="padding-right: 11px;height: 100%;left: 5px">
            <div class="thumbnail" style="float:left;height: 90%;width: 100%">
                <img src="img/body.jpg" class="vip_card_pic" alt="...">
                <div class="detail">
                    <span style="color: red;font-size: 20px;">￥300.00</span>
                    <br>
                    <span style="font-size: 15px;line-height: 30px">本卡下单洗衣享受8折优惠</span>
                    <br>
                    <span style="font-size: 15px;line-height: 30px">本卡下单洗衣享受8折优惠</span>
                    <br>
                    <span style="font-size: 15px;line-height: 30px">本卡下单洗衣享受8折优惠</span>
                    <br>
                    <span style="font-size: 15px;line-height: 30px">本卡下单洗衣享受8折优惠</span>
                    <br>

                    <button class="buy_vip_card">购卡</button>
                </div>
            </div>
        </div>
    </div>
    <div class="row" style="height: 300px;padding-left: 20px;width: 100%;">
        <div class=" col-md-6" style="padding-right: 11px;height: 100%;left: 5px">
            <div class="thumbnail" style="float:left;height: 90%;width: 100%">
                <img src="img/br.jpg" class="vip_card_pic" alt="...">
                <div class="detail">
                    <span style="color: red;font-size: 20px;">￥500.00</span>
                    <br>
                    <span style="font-size: 15px;line-height: 30px">本卡下单洗衣享受7.5折优惠</span>
                    <br>
                    <span style="font-size: 15px;line-height: 30px">本卡下单洗衣享受7.5折优惠</span>
                    <br>
                    <span style="font-size: 15px;line-height: 30px">本卡下单洗衣享受7.5折优惠</span>
                    <br>
                    <span style="font-size: 15px;line-height: 30px">本卡下单洗衣享受7.5折优惠</span>
                    <br>

                    <button class="buy_vip_card">购卡</button>
                </div>
            </div>
        </div>
        <div class=" col-md-6" style="padding-right: 11px;height: 100%;left: 5px">
            <div class="thumbnail" style="float:left;height: 90%;width: 100%">
                <img src="img/.class.jpg" class="vip_card_pic" alt="...">
                <div class="detail">
                    <span style="color: red;font-size: 20px;">￥800.00</span>
                    <br>
                    <span style="font-size: 15px;line-height: 30px">本卡下单洗衣享受7折优惠</span>
                    <br>
                    <br>
                    <span style="font-size: 15px;line-height: 30px">本卡下单洗衣享受7折优惠</span>
                    <br>
                    <br>
                    <span style="font-size: 15px;line-height: 30px">本卡下单洗衣享受7折优惠</span>
                    <br>
                    <br>
                    <span style="font-size: 15px;line-height: 30px">本卡下单洗衣享受7折优惠</span>
                    <br>
                    <button class="buy_vip_card">购卡</button>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="footer">
    <p>©&nbsp;2016&nbsp;辽宁省沈阳市东北大学（浑南校区）软件学院</p>
    <p>软件工程1401班&nbsp;储志伟&nbsp;李冲&nbsp;魏汝刚&nbsp;王振松<span class="split">|</span>软件工程1410班（宁夏）&nbsp;卢成冬</p>
</div>

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