<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人中心</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user.css">
    <script src="${pageContext.request.contextPath}/js/common.js" type="text/javascript"></script>
    <link rel="the_top icon" href="icon.ico" />
</head>
<body>
<script>
function logout() {
if (!confirm("确认要注销吗？")) {
window.event.returnValue = false;
}
}
</script>
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

<div class ="frame"><img src="pictures/user.png" alt=""></div>
<div class="head_blank"></div>
<form action="exitLogin_click_2" method="post">
<div class="frame">
    <% session = request.getSession();
        String name = (String)session.getAttribute("u_name");%>
    <div>当前用户：<%=name%>&nbsp&nbsp<button type="submit" style="background-color: rgba(201,64,124,0.19)" onclick="logout()">注销</button></div>
</div>
</form>
<!--第二个导航栏  -->
<div class="frame">
    <div class="headline">
        <h3><a href="index"> <span>返回首页>></span></a></h3>
        <h3><span style="color: #1921b1">个人中心>></span> </h3>
        <h3><span style="color: #1921b1">个人信息</span> </h3>
        <h4><a href="exitLogin_click" onClick="logout()">注销用户</a></h4>
    </div>
</div>

<div class="frame">
    <div class="headline">
        <a href="shoppingCart_click"><h3>购物车</h3></a>
        <a href="user_information_show"><h3>个人信息</h3></a>
        <a href="user_email_click"><h3>邮箱</h3></a>
    </div>
</div>

<!--个人信息展示-->
<div class="frame">
    <div class="head_blank"></div>
    <div class="user-form">
        <form action="user_information_modify_click" method="post">
        <% List<Map<String, Object>> listMaps = (List<Map<String, Object>>) request.getAttribute("listMaps");%>
        <label for="">用户名：&nbsp;&nbsp;&nbsp;</label>
        <input type="text" class="input"  disabled ="true" value =${listMaps.get(0).get("u_name")} placeholder="">
        <p class="user-form-blank"></p>
        <label for="">手机号：&nbsp;&nbsp;&nbsp;</label>
        <input type="text" class="input"  disabled ="true" value =${listMaps.get(0).get("u_phone")} placeholder="">
        <p class="user-form-blank"></p>
        <label for="">电子邮箱：</label>
        <input type="text" class="input"  disabled ="true" value =${listMaps.get(0).get("u_email")} placeholder="">
        <p class="user-form-blank"></p>
        <label for="">登录密码：</label>
        <input type="text" class="input"  disabled ="true" value =${listMaps.get(0).get("u_password")} placeholder="">
        <p class="user-form-blank"></p>
        <label for="">身份证号：</label>
        <input type="text" class="input"  disabled ="true" value =${listMaps.get(0).get("u_idcard")} placeholder="">
        <p class="user-form-blank"></p>
        <div><button type="submit" style="width:100px;height:50px;background-color: rgba(14,127,126,0.37)" ><font size="3px">修改信息</font></button></div>
        </form>
    </div>
</div>

<div class="user-form-blank_1"></div>

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
