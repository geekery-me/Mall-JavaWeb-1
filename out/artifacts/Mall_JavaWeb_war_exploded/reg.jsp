<!DOCTYPE html>
<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script src="js/code.js"></script>
    <style>
        .error{
            margin: 30px;
            border:1px solid red;
            padding: 0 20px;
            background: #ffa500;

        }
    </style>


</head>
<body>
<div class="reg">
    <form action="http://localhost:8888/08_shop/register" method="post" onsubmit="return checkForm(this)">
        <h1><a href="index.html"><img src="img/temp/logo.png"></a></h1>
        <p><h1>用户注册</h1></p>
        <p><input type="text" name="user_id" value="" placeholder="请输入ID" onfocus="Focus(this)" onblur="checkItem(this)"  ><span></span></p>
        <p><input type="text" name="user_name" value="" placeholder="请输入姓名" onfocus="Focus(this)" onblur="checkItem(this)" ><span></span></p>
        <p><input type="text" name="user_password" value="" placeholder="请输入密码" onfocus="Focus(this)" onblur="checkItem(this)"><span></span></p>
        <p><input type="text" name="rePassWord" value="" placeholder="请确认密码" onfocus="Focus(this)" onblur="checkItem(this)"><span></span></p>
        <p>
            <input style="width: 15px;height: 15px" type="radio" name="user_sex" value="T" checked="checked">男
            <input style="width: 15px;height: 15px" type="radio" name="user_sex" value="F" >女
        </p>
        <p><input type="text" name="user_birthday" value="" placeholder="请输入出生日期" onfocus="Focus(this)" onblur="checkItem(this)"><span></span></p>
        <p><input type="text" name="user_email" value="" placeholder="请输入邮箱" onfocus="Focus(this)" onblur="checkItem(this)"><span></span></p>
        <p><input type="text" name="user_phone" value="" placeholder="请输入手机号码" onfocus="Focus(this)" onblur="checkItem(this)"><span></span></p>
        <p><input type="text" name="user_address" value="" placeholder="请输入送货地址" onfocus="Focus(this)" onblur="checkItem(this)"><span></span></p>

        <p ><input class="code" type="text" name="Code" value="" placeholder="验证码" onfocus="Focus(this)" onblur="checkItem(this)">
            <img src="/08_shop/codeservlet" onclick="changecode(this)" id="imgcode"><span></span>
        </p>
        <p><input type="submit" name="" value="注册"></p>
        <p>完成此注册，即表明您同意了我们的<a href="#">使用条款和隐私策略</a></p>
        <p class="txt"><a href="#"><span></span>已有账号登录</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>-->
    </form>
</div>
</body>
</html>