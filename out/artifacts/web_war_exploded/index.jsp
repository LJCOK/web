<%--
  Created by IntelliJ IDEA.
  User: LJC
  Date: 2023/11/26
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- SEO优化 -->
  <title>李建成的商店！</title>
  <!-- 引入favicon图标 -->
  <link rel="the_top icon" href="icon.ico"  />
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
  <script src="js/common.js" type="text/javascript"></script>
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
<form action="exitLogin_click_2" method="post">
<div class="frame">
  <% session = request.getSession();
    String name = (String) session.getAttribute("u_name");
  if(name==null) {name = (String) session.getAttribute("a_name");}%>
  <div>当前用户：<%=name%>&nbsp&nbsp<button type="submit" style="background-color: rgba(201,64,124,0.19)" onclick="logout()">注销</button></div>
</div>
</form>

<!-- 搜索栏模块 -->
<header class="header frame">
  <form action="search1" method="post">

  <div class="search">
    <input type="search" name="search" placeholder="搜索空内容即为刷新(支持模糊搜索)">
    <button >搜索</button>
  </div>
  </form>
  <div class="hotwords">
    <ul>
      <li><span>今日推荐：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></li>
      <li><a href="#">时尚穿搭</a></li>
      <li><a href="#">耐克</a></li>      <li><a href="#">阿迪达斯</a></li>
      <li><a href="#">NASA联名</a></li>
    </ul>
  </div>
  <a href=shoppingCart_click><div class="shopping">购物车
  </div></a>
</header>

<!--猜你喜欢  -->
<div class="frame">
  <div class="headline">
    <h3>猜你喜欢</h3>
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
                <p><input type="text" disabled ="true" value=${product.p_describe} ></p>
                <h4>价格:&nbsp&nbsp<input type ="text" disabled ="true" class="input_box" style="color: #b1191a" value=${product.p_price}>
                  &nbsp&nbsp剩余量:&nbsp<input type ="text" disabled ="true" class="input_box" value=${product.p_num}>
                </h4>
              </div>
              <a href="shoppingCard_add_click?id=${product.p_id}" onClick="shopping_add()" ><div class="shopping-trolley" >加入购物车</div></a>
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
