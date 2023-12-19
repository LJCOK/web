
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <link rel="the_top icon" href="icon.ico" />
</head>

<body>

<!-- 导航栏模块top -->
<div class="frame">
    <div class="the_top">
        <div class="the_top_left">
            <ul>
                <li style="color: #ff7fb9">美美的商店欢迎您！</li>
                <li>
                    <a href=login_click><span style="color: #002aff ">&nbsp;&nbsp;登录</span></a>
                    <a href="register.jsp" ><span style="color: #002aff ">&nbsp;&nbsp;免费注册</span></a>
                </li>
            </ul>
        </div>
        <div class="the_top_right">
            <ul>
                <li><a href=admin_click>管理员中心&nbsp&nbsp&nbsp</a></li>
                <li><a href=user_click >个人中心&nbsp&nbsp&nbsp</a></li>
                <li><a href=shoppingCart_click>购物车&nbsp&nbsp&nbsp</a></li>
            </ul>
        </div>
    </div>
</div>

<div class ="frame"><img src="pictures/common.png" alt=""></div>
<div class="head_blank"></div>
<form action="exitLogin_click_2" method="post">
<div class="frame">
    <% session = request.getSession();
        String name = (String)session.getAttribute("u_name");
        if(name==null) {name = (String) session.getAttribute("a_name");}%>
    <div>当前用户：<%=name%>&nbsp&nbsp<button type="submit" style="background-color: rgba(201,64,124,0.19)" onclick="logout()">注销</button></div>
</div>
</form>

<!--第二个导航栏  -->
<div class="frame">
    <div class="head_blank"></div>
    <div class="headline">
        <h3><a href="index"> <span style="color: #b1191a">返回首页>></span></a></h3>
        <h3><span style="color: #b1191a">用户注册</span> </h3>
    </div>
</div>



<div class="frame">
    <div class="register">
        <h3>注册页面
            <div class="login">
                已有账户，去<a href="login_click" class="style_red"><span style="color: #002aff ">登录</span></a>
            </div>
        </h3>
        <div class="reg-form">
            <form action="register" method="post">
                <ul>
                    <li>
                        <label for="">用户名：</label>
                        <input type="text" class="input" placeholder=" 2-8个英文或汉字" name="username">
                    </li>
                    <li>
                        <label for="">手机号：</label>
                        <input type="tel" class="input" placeholder=" 请输入11位手机号" name="phone">
                    </li>
                    <li>
                        <label for="">登录密码：</label>
                        <input type="password" class="input" placeholder=" 8-16位数字或字母" name="password">
                    </li>
                    <li>
                        <label for="">确定密码：</label>
                        <input type="password" class="input"placeholder=" 8-16位数字或字母" name="Cpassword">
                    </li>
                    <li class="agree">
                        <input type="radio" value="user" name="radio">用户注册
                        <input type="radio" value="admin" name="radio">管理员注册
                    </li>
                    <li>
                        <input type="submit" value="完成注册&nbsp;&nbsp;" class="btn">
                    </li>
                </ul>
            </form>
        </div>
    </div>
</div>

<!-- 底部栏目 -->
<div class="frame" >
    <div class="bottom_blank"></div>
    <div class="bottom_column">
        <ul>
            <li>
                <h5 class="logo1"></h5>
                <div >
                    <h4>正品保障</h4>
                    <p>正品保障，可鉴真伪</p>
                </div>
            </li>
            <li>
                <h5 class="logo2"></h5>
                <div >
                    <h4>货流速递</h4>
                    <p>货流速递，即购即送</p>
                </div>
            </li>
            <li>
                <h5 class="logo3"></h5>
                <div >
                    <h4>价格保证</h4>
                    <p>价格保证，童叟无欺</p>
                </div>
            </li>
            <li>
                <h5 class="logo4"></h5>
                <div >
                    <h4>信誉保证</h4>
                    <p>信誉保证，十年老店</p>
                </div>
            </li>
        </ul>
    </div>

    <!-- 信息模块 -->
    <div class="bottom_column_1">
        <div class="link">
            <a href="#">关于我们</a>|<a href="#">联系我们</a>|<a href="#">联系客服</a>|
            <a href="#">商家入驻</a>|<a href="#">友情链接</a>|<a href="#">销售中心</a>
        </div>
        <div>
            地址：华南理工大学计算机学院   邮编：100000   电话：10086  邮箱: 88888888@qq.com
        </div>
    </div>
    <div class="bottom_blank"></div>
    <div class="bottom_blank"></div>
    <div class="bottom_blank"></div>
</div>


</body>

</html>
