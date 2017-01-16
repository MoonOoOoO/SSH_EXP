<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link href="css/font-awesome.min.css" rel="stylesheet"/>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/bootstrap-theme.min.css" rel="stylesheet"/>
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link href="css/css.css" rel="stylesheet"/>
    <title>首页</title>
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
                    <img src="img/div.jpg"/>
                </a>
            </div>
        </div>
        <div class="col-md-8 col-xs-12">
            <div class="nav_right">
                <ul class="nav nav-pills nav-justified">
                    <li class="active"><a href="#">首页</a></li>
                    <li><a href="WashClothes.action">我要洗衣</a></li>
                    <li><a href="buy_card.jsp">我要购卡</a></li>
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
    <div id="carousel-example-generic" class="carousel slide content_top_img" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="img/div.jpg" alt="...">
                <div class="carousel-caption">
                    <span class="pic_note">图1</span>
                </div>
            </div>
            <div class="item">
                <img src="img/body.jpg" alt="...">
                <div class="carousel-caption">
                    <span class="pic_note">图2</span>
                </div>
            </div>
            <div class="item">
                <img src="img/html.jpg" alt="...">
                <div class="carousel-caption">
                    <span class="pic_note">图3</span>
                </div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>
<div style="position: absolute;margin-top: 990px;margin-left: 190px;"><img src="img/ksxd.jpg"></div>
<div class="container" style="position:relative;margin-top: 1080px;margin-left: 550px">
    <div class="custom-content" id="catchline">
        <div class="col-md-3 col-xs-3"><a href="#"><img src="img/1.jpg"></a>
            <p style="font-size:40px;color:#ff4066;text-align: center;">洗上衣</p></div>
        <div class="col-md-3 col-xs-3"><a href="#"><img src="img/2.jpg"></a>
            <p style="font-size:40px;color:#ff4066;text-align: center;">洗裤子</p></div>
        <div class="col-md-3 col-xs-3"><a href="#"><img src="img/3.jpg"></a>
            <p style="font-size:40px;color:#ff4066;text-align: center;">洗鞋</p></div>
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