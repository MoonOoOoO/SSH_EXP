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
    <link href="css/cart.css" rel="stylesheet"/>
    <title>洗衣篮</title>
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
    <div class="row" style="height: 50px">
        <div class="col-md-4 col-md-offset-1">
            <img src="img/shop_cart.jpg" style="margin-left: 72px"/>
        </div>
    </div>
    <hr style="width:80%;margin: 30px 0 10px 10%;height:1px;border-top:1px solid #cccccc;">
    <div class="row shop_top">
        <div class="shop_info_type" style="width: 15%;">
            <input id="select_all_goods_top" type="checkbox"> &nbsp;&nbsp;全选
        </div>
        <div class="shop_info_type" style="width: 35%;text-align: left;padding-left: 40px"> 商品信息</div>
        <div class="shop_info_type" style="width: 12%">单&nbsp;价</div>
        <div class="shop_info_type" style="width: 12%">数&nbsp;量</div>
        <div class="shop_info_type" style="width: 12%">金&nbsp;额</div>
        <div class="shop_info_type" style="width: 14%">操&nbsp;作</div>
    </div>
    <c:if test="${empty(requestScope.list)}">
        <div class="thumbnail detail_info row">
            <h1 style="text-align: center">洗衣篮为空</h1>
        </div>
    </c:if>
    <c:forEach var="item" items="${requestScope.list}">
        <div class="thumbnail detail_info row">
            <input class="orderitemId" value="${item['orderitemId']}" type="hidden">
            <div class="good_info" style="width: 10%">
                <input class="select_one" style="margin: 40px 0 0 45px" type="checkbox" value="${item['price']}"/>
            </div>
            <div class="good_info" style="width: 40%">
                <img class="good_pic" src="${item['picture']}"/>
                <span class="good_name">${item['name']}</span>
            </div>
            <div class="good_info" style="width: 12%;text-align: center;margin-top: 67px">
                <span>￥</span>
                <span class="good_price">${item['price']}</span>
            </div>
            <div class="good_info" style="width: 12%;margin-top: 64px;">
                <div class="row" style="height:25px;text-align: center;">
                    <div class="minus">-</div>
                    <input type="text" value="${item['number']}" class="buy_num" name="number" title="数量" readonly>
                    <div class="plus">+</div>
                </div>
            </div>
            <div class="good_info" style="width: 12%;text-align: center;margin-top: 67px">
                <span>￥</span>
                <span class="good_total_price">${item['price']*item['number']}</span>
            </div>
            <div class="good_info" style="width: 12%;text-align: center;margin-top: 67px">
                <a href="DeleteOrderItem.action?orderitemId=${item['orderitemId']}" class="delete_one">删除</a>
            </div>
        </div>
    </c:forEach>

    <div class="row buy_select_goods">
        <div class="shop_info_bottom" style="width: 15%;">
            <input id="select_all_goods_down" type="checkbox"> &nbsp;&nbsp;<span class="text">全选</span>
        </div>
        <div class="shop_info_bottom" style="width: 15%;float: right">
            <button class="buy_good" id="pay_money" data-toggle="modal" data-target="#myModal">结算</button>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                                class="sr-only">Close</span></button>
                        <h4 class="modal-title" id="myModalLabel">确认信息</h4>
                    </div>
                    <div class="modal-body">
                        <div class="msg"></div>
                        <div class="dropdown" style="text-align: center">
                            <c:choose>
                                <c:when test="${empty(requestScope.addresses)}">
                                    <a href="address_add.html">暂无地址，添加地址</a>
                                </c:when>
                                <c:otherwise>
                                    <label>
                                        选择地址：
                                        <select id="order_address">
                                            <c:forEach var="address" items="${requestScope.addresses}">
                                                <option>
                                                    <a role="menuitem" tabindex="-1" href="#">${address.detail}</a>
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </label>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <a id="confirm_pay" type="button" class="btn btn-primary">确认下单</a>
                        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
                    </div>
                </div>
            </div>
        </div>


        <div class="shop_info_bottom" style="width: 20%;float: right">
            <span class="text">合计（不含运费）：￥</span>
            <b id="total_fee" style="font-size: 20px;margin-left: 5px;color: #f40 ">0</b>
        </div>
        <div class="shop_info_bottom" style="width: 10%;float: right">
            <span class="text">已选商品</span>
            <b id="total_number" style="font-size: 20px;margin-left: 5px;margin-right: 5px;color: #f40">0</b>
            <span class="text">件</span>
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

        $(".minus").click(function () {
            var num = $(this).parent().find(".buy_num").val();
            var good_price = parseInt($(this).parent().parent().parent().find(".good_price").html());
            var total_fee = parseInt($("#total_fee").html());
            var total_price;
            if (num > 1) {
                num--;
                if ($(this).parent().parent().parent().find('input[class="select_one"]').is(":checked")) {
                    total_fee = total_fee - good_price;
                    $("#total_fee").html(total_fee);
                }
                total_price = num * good_price;
                $(this).parent().find(".buy_num").val(num);
                $(this).parent().parent().parent().find(".good_total_price").html(total_price);
            }
        });

        $(".plus").click(function () {
            var num = $(this).parent().find(".buy_num").val();
            var good_price = parseInt($(this).parent().parent().parent().find(".good_price").html());
            var total_fee = parseInt($("#total_fee").html());
            var total_price;
            num++;
            if ($(this).parent().parent().parent().find('input[class="select_one"]').is(":checked")) {
                total_fee = total_fee + good_price;
                $("#total_fee").html(total_fee);
            }
            total_price = num * good_price;
            $(this).parent().find(".buy_num").val(num);
            $(this).parent().parent().parent().find(".good_total_price").html(total_price);
        });

        $("#select_all_goods_top").click(function () {
            var total_fee = 0;
            if ($("#select_all_goods_top").is(":checked")) {
                $(".select_one").prop({"checked": true});
                $("#select_all_goods_down").prop({"checked": true});
                $('input[class="select_one"]:checked').each(function () {
                    total_fee = total_fee.valueOf() + parseInt($(this).parent().parent().find(".good_total_price").html());
                });
                $("#total_number").html($('input[class="select_one"]:checked').length);
                $("#total_fee").html(total_fee);
            } else {
                $(".select_one").prop({"checked": false});
                $("#select_all_goods_down").prop({"checked": false});
                $('input[class="select_one"]:checked').each(function () {
                    total_fee = total_fee.valueOf() - parseInt($(this).parent().parent().find(".good_total_price").html());
                });
                $("#total_number").html($('input[class="select_one"]:checked').length);
                $("#total_fee").html(total_fee);
            }
        });

        $("#select_all_goods_down").click(function () {
            var total_fee = 0;
            if ($("#select_all_goods_down").is(":checked")) {
                $(".select_one").prop({"checked": true});
                $("#select_all_goods_top").prop({"checked": true});
                $('input[class="select_one"]:checked').each(function () {
                    total_fee = total_fee.valueOf() + parseInt($(this).parent().parent().find(".good_total_price").html());
                });
                $("#total_number").html($('input[class="select_one"]:checked').length);
                $("#total_fee").html(total_fee);
            } else {
                $(".select_one").prop({"checked": false});
                $("#select_all_goods_top").prop({"checked": false});
                $('input[class="select_one"]:checked').each(function () {
                    total_fee = total_fee.valueOf() - parseInt($(this).parent().parent().find(".good_total_price").html());
                });
                $("#total_number").html($('input[class="select_one"]:checked').length);
                $("#total_fee").html(total_fee);
            }
        });

        $(".select_one").click(function () {
            var total_fee = 0;
            $('input[class="select_one"]:checked').each(function () {
                total_fee = total_fee.valueOf() + parseInt($(this).parent().parent().find(".good_total_price").html());
            });
            $("#total_fee").html(total_fee);
            $('input[class="select_one"]').each(function () {
                if ($('input[class="select_one"]:checked').length == $('input[class="select_one"]').length) {
                    $("#select_all_goods_top").prop("checked", true);
                    $("#select_all_goods_down").prop("checked", true);
                } else {
                    $("#select_all_goods_top").prop({"checked": false});
                    $("#select_all_goods_down").prop({"checked": false});
                }
            })
            $("#total_number").html($('input[class="select_one"]:checked').length);
        });

        $(".delete_one").click(function () {
            var total_fee = parseInt($("#total_fee").html());
            var r = confirm("确定删除？");
            if (r == true) {
                total_fee = total_fee.valueOf() - parseInt($(this).parent().parent().find(".good_total_price").html());
                $("#total_fee").html(total_fee);
                $(this).parent().parent().remove();
            }
            $("#total_number").html($('input[class="select_one"]:checked').length);
        });

        $("#pay_money").click(function () {
            var msg = "";
            if ($('input[class="select_one"]:checked').length != 0) {
                $('input[class="select_one"]:checked').each(function () {
                    msg += '<div style="font-family: 微软雅黑, serif;font-size: 16px;text-align: center">' +
                            $(this).parent().parent().find(".good_name").html() + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' +
                            $(this).parent().parent().find(".buy_num").val() + "件&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                            $(this).parent().parent().find(".good_total_price").html() + '元</div>';
                });
                $(".msg").html(msg);
                $("#confirm_pay").removeAttr("disabled");
                $("#confirm_pay").attr('href', 'AddOrder.action?order_address=' + $('#order_address option:selected').val() +
                        '&price=' + parseFloat($("#total_fee").html())
                );
            } else {
                $(".msg").html('<div class="text-center" style="font-family: 微软雅黑, serif;font-size: 16px">未选择衣物</div>');
                $("#confirm_pay").attr({"disabled": "true"});
            }
        })
    })
</script>
</html>