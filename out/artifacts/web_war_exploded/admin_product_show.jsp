
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理员中心</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    <script src="js/common.js" type="text/javascript"></script>
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


<div class ="frame"><img src="pictures/user.png" alt=""></div>
<div class="head_blank"></div>
<form action="exitLogin_click_2" method="post">
<div class="frame">
    <% session = request.getSession();
        String name = (String)session.getAttribute("a_name");%>
    <div>当前管理员：<%=name%>&nbsp&nbsp<button type="submit" style="background-color: rgba(201,64,124,0.19)" onclick="logout()">注销</button></div>
</div>
</form>

<!--第二个导航栏  -->
<div class="frame">
    <div class="head_blank"></div>
    <div class="headline">
        <h3><a href="index"> <span>返回首页>></span></a></h3>
        <h3><span style="color: #1921b1">管理员中心>></span> </h3>
        <h3><span style="color: #1921b1">商品列表</span> </h3>
        <h4><a href="exitLogin_click" onClick="logout()">注销管理员</a></h4>
    </div>
</div>
<div class="frame">
    <div class="headline">
        <a href="admin_product_show"><h3>商品列表</h3></a>
        <a href="admin_product_sales"><h3>销售统计</h3></a>
        <a href="user_log"><h3>客户日志</h3></a>
        <a href="admin_product_add.jsp"><h3 >添加商品</h3></a>
    </div>
</div>




<div class="frame">
    <div class="like">
        <div class="like-bd">
            <ul>
                <c:forEach items="${listMaps}" var="product">
                    <li>
                        <dl>
                            <dd>
                                <img src="pictures/${product.p_id}.png" alt="">
                                <div class="like-text">
                                    <p><input type="text" disabled ="true" name ="product_name" value=${product.p_describe} ></p>
                                    <h4>价格:&nbsp&nbsp<input type ="text" disabled ="true" name = "product_price" class="input_box" style="color: #b1191a" value=${product.p_price}>
                                        &nbsp&nbsp剩余量:&nbsp<input type ="text" disabled ="true" name ="product_num" class="input_box" value=${product.p_num}>
                                    </h4>
                                    <h3>&nbsp&nbsp<a href="admin_product_modify_click?id=${product.p_id}"><span style="color: white">修改</span></a><a href="admin_product_delete?id=${product.p_id}" onClick="del()" style="color: white"><span>删除</span></a>&nbsp&nbsp</h3>
                                </div>
                            </dd>
                        </dl>
                    </li>
                </c:forEach>
            </ul>
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
