
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录页面</title>
    <!--    关联css文件-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" type="text/css">
    <link rel="the_top icon" href="icon.ico" />
</head>

<body>

<!-- 导航栏模块top -->
<div class="frame">
    <div class="the_top">
        <div class="the_top_left">
            <ul>
                <li style="color: #ff7fb9">李建成的商店欢迎您！</li>
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
<div class="frame">
    <% session = request.getSession();
        String name = (String)session.getAttribute("u_name");
        if(name==null) {name = (String) session.getAttribute("a_name");}%>
    <div>当前用户：<%=name%></div><button value="注销"></button>
</div>

<!--第二个导航栏  -->
<div class="frame">
    <div class="headline">
        <h3><a href="index"> <span style="color: #b1191a">返回首页>></span></a></h3>
        <h3><span style="color: #b1191a">登录</span> </h3>
    </div>
</div>

<div class="login-box">
    <!--    中间层-->
    <div class="login-middle">
        <!--        中间框框-->
        <div class="login-middle-frame">
            <div class="loginform">
                <!--                    用户、管理员登录-->
                <div class="nav-tab">
                    <a href="#" class="style_blue">登录界面</a>
                </div>
                <div class="tab-content">
                    <div class="profix">
                        <!--                        定义向何处发送表单数据-->
                        <form action="login" method="post">
                        <div class="input-prepend">
                            <span class="prependtop"></span>
                            <input type="text" placeholder="手机号 测试用：123" name ="phone">
                        </div>
                        <div class="input-prepend">
                            <span class="prependlast"></span>
                            <input type="text" placeholder="密码 测试用：123" name ="password">
                        </div>
                        <div class="setting">
                            <input type="radio" value="user" name="radio1">用户登录
                            <input type="radio" value="admin" name="radio1">管理员登录
                        </div>
                        <div class="buttom">
                            <input type="submit" value="登&nbsp;&nbsp;录" class="login_buttom">
                        </div>
                        </form>
                        <div class="registration">
                            <span>没有账号？</span>
                            <a href="register.jsp">立即注册</a>
                        </div>
                    </div>
                </div>
            </div>
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
