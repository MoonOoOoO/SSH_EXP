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
    <title>我要洗衣</title>
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
                    <li><a href="index.jsp">首页</a></li>
                    <li class="active"><a href="#">我要洗衣</a></li>
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
    <br>
    <div class="catalog">
        <div class="catalog_title">
            <i class="fa fa-circle-o"></i>&nbsp;衣&nbsp;物
        </div>
        <hr/>
        <br>
        <div class="row">
            <c:forEach var="cloth" items="${requestScope.clothes}">
                <c:if test="${cloth.clothesType eq '1'}">
                    <div class="col-md-4">
                        <div class="thumbnail clothes_item">
                            <img src="${cloth.clothesPic}" alt="...">
                            <form action="AddClothes.action" method="get">
                                <input name="clothesId" type="hidden" value="${cloth.clothesId}">
                                <div class="caption">
                                    <p>衣物：<span class="item_info">${cloth.clothesName}</span></p>
                                    <p>单价：<span class="item_info price">${cloth.clothesPrice}元/条</span></p>
                                    <div class="control_num">
                                        <p class="number">数量：</p>
                                        <div class="minus">-</div>
                                        <input type="text" value="1" class="buy_num" name="number" title="数量" readonly>
                                        <div class="plus">+</div>
                                    </div>
                                    <button type="submit" class="add_to_cart">加入洗衣篮</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
        <br/>
        <div class="catalog_title">
            <i class="fa fa-circle-o"></i>&nbsp;鞋&nbsp;子
        </div>
        <hr/>
        <br>
        <div class="row">
            <c:forEach var="cloth" items="${requestScope.clothes}">
                <c:if test="${cloth.clothesType eq '2'}">
                    <div class="col-md-4">
                        <div class="thumbnail clothes_item">
                            <img src="${cloth.clothesPic}" alt="...">
                            <form action="AddClothes.action?clothesId=${cloth.clothesId}">
                                <div class="caption">
                                    <p>衣物：<span class="item_info">${cloth.clothesName}</span></p>
                                    <p>单价：<span class="item_info price">${cloth.clothesPrice}元/条</span></p>
                                    <div class="control_num">
                                        <p class="number">数量：</p>
                                        <div class="minus">-</div>
                                        <input type="text" value="1" class="buy_num" name="number" title="数量" readonly>
                                        <div class="plus">+</div>
                                    </div>
                                    <a type="submit" class="add_to_cart">加入洗衣篮</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
        <br/>
        <div class="catalog_title">
            <i class="fa fa-circle-o"></i>&nbsp;配&nbsp;带&nbsp;物
        </div>
        <hr/>
        <br>
        <div class="row">
            <c:forEach var="cloth" items="${requestScope.clothes}">
                <c:if test="${cloth.clothesType eq '3'}">
                    <div class="col-md-4">
                        <div class="thumbnail clothes_item">
                            <img src="${cloth.clothesPic}" alt="...">
                            <form action="AddClothes.action?clothesId=${cloth.clothesId}">
                                <div class="caption">
                                    <p>衣物：<span class="item_info">${cloth.clothesName}</span></p>
                                    <p>单价：<span class="item_info price">${cloth.clothesPrice}元/条</span></p>
                                    <div class="control_num">
                                        <p class="number">数量：</p>
                                        <div class="minus">-</div>
                                        <input type="text" value="1" class="buy_num" name="number" title="数量" readonly>
                                        <div class="plus">+</div>
                                    </div>
                                    <a type="submit" class="add_to_cart">加入洗衣篮</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
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
</div>
</body>

<script>
    $(function () {
        $("#toTop").click(function () {
            $("html").animate({"scrollTop": "0px"}, 300); //IE,FF
            $("body").animate({"scrollTop": "0px"}, 300); //Webkit
        });
        $(".minus").click(function () {
            var num = $(this).parent().find(".buy_num").val();
            if (num > 1) {
                num--;
                $(this).parent().find(".buy_num").val(num);
            }
        });
        $(".plus").click(function () {
            var num = $(this).parent().find(".buy_num").val();
            num++;
            $(this).parent().find(".buy_num").val(num);
        });
    })
</script>
</html>
