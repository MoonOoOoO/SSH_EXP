<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link href="css/font-awesome.min.css" rel="stylesheet"/>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/bootstrap-theme.min.css" rel="stylesheet"/>
    <link href="css/css.css" rel="stylesheet"/>
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <title>注册</title>
</head>

<body>

<div class="container">
    <div class="container">
        <div class="DLtop"><a href="index.jsp"><img src="img/Dlogo.png"/></a></div>
        <div class="row">
            <div class="col-md-6 text-left" style="padding:0;"><img src="img/DLpic1.jpg"/></div>
            <div class="col-md-1 text-left" style="padding:0;">&nbsp;</div>
            <div class="col-md-5" style="padding:0;">
                <form class="form-sign_in" action="Register.action" onSubmit="user_login()">
                    <h2 class="form-sign_in-heading text-center" style="margin-top:0;">洗衣网注册</h2>
                    <input id="user_name" name="username" class="form-control" placeholder="请输入您的用户名" required
                           autofocus>
                    <br/>
                    <input id="user_tel" name="userTel" class="form-control" placeholder="手机号" required autofocus
                           type="tel">
                    <br/>
                    <input id="user_pwd" name="password" class="form-control" placeholder="密码" required type="password">
                    <br/>
                    <button class="btn btn-lg  button btn-block" type="submit">注 册</button>
                    <div style="text-align: center;color: red;font-size: 16px;font-weight: bolder">${sessionScope.status}</div>
                    <span class="deng_lv"><span class="curr" style="font-size: 40px;">☞</span>&nbsp;&nbsp;<a
                            href="login.jsp" class="curr" style="font-size: 15px;">登录</a></span>
                    <br/>
                    <br/>
                </form>
            </div>
        </div>
    </div>

    <footer>
        <hr/>
        <div class="container">
            <p class=" text-center" style="margin-top:70px; line-height:24px; font-size:12px; color: #000000;">©&nbsp;2016&nbsp;辽宁省沈阳市东北大学（浑南校区）软件学院<br>软件工程1401班&nbsp;储志伟&nbsp;李冲&nbsp;魏汝刚&nbsp;王振松<span
                    class="split">|</span>软件工程1410班（宁夏）&nbsp;卢成冬</p>
        </div>
    </footer>
</div>
</body>
<script>
    function user_login() {
        var user_tel = $('#user_tel').val();
        var user_pwd = $('#user_pwd').val();
        var Captcha = $('#Captcha').val();

        if (!user_tel || user_tel.length != 11) {
            alert('请正确输入您的手机号！');
            $('#user_tel').focus();
            return false;
        }
        if (!user_pwd) {
            alert('请输入您的密码！');
            $('#user_pwd').focus();
            return false;
        }
    }
</script>
</html>