<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>购物车</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
  <script src="${pageContext.request.contextPath}/js/common.js" type="text/javascript"></script>
  <link rel="the_top icon" href="icon.ico" />
</head>
<body>

<script>
  function nobuy() {
    if (!confirm("确认要移出购物车吗？")) {
      window.event.returnValue = false;
    }
  }
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
    <h3><span style="color: #1921b1">购物车</span> </h3>
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

<!--结算  -->
<div class="frame">
  <div class="headline">
    <h4><a href="user_product_account_click?id=all"> <span><div class="caculate" >一起结算</div></span></a></h4>
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
                <img src="pictures/shopping.png" alt="">
                  <div class="like-text">
                    <p><input type="text" disabled ="true" name ="product_name" value=${product.p_describe} ></p>
                    <h4>价格:&nbsp&nbsp<input type ="text" disabled ="true" name = "product_price" class="input_box" style="color: #b1191a" value=${product.p_price}>
                      &nbsp&nbsp剩余量:&nbsp<input type ="text" disabled ="true" name ="product_num" class="input_box" value=${product.p_num}>
                    </h4>
                    <h3><a href="user_product_account_click?id=${product.p_id}"><span style="color: white">结算</span></a><a href="user_product_delete?id=${product.p_id}" onClick="nobuy()" style="color: white"><span>移出购物车</span></a>&nbsp&nbsp</h3>
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
