<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>校园跑腿</title>
		<meta name="description" content="校园跑腿" />
		<meta name="keywords" content="校园跑腿"/>
		<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<link rel="stylesheet" href="css/amazeui.min.css" />
		<link rel="stylesheet" href="css/style.css" />
		<script type="text/javascript" src="js/jquery.min.js" ></script>
		<script type="text/javascript" src="js/amazeui.min.js" ></script>
		<script type="text/javascript" src="js/application.js" ></script>

	</head>
	<body>
		<div class="member">
			<a href="${pageContext.request.contextPath}/toMemberLogin">
				<div class="member-pic">
					<img src="images/p.png" />s
				</div>
			</a>
			<div class="member-infor">157****8547</div>
		</div>
		<ul class="member-nav">
			<a href="address.jsp"><li><i class="am-icon-map-marker"></i><span>收货地址</span></li></a>
			<a href="order1.jsp"><li><i class="am-icon-cart-arrow-down"></i><span>我的发布</span></li></a>
			<a href="run_order.jsp"><li><i class="am-icon-newspaper-o"></i><span>我的抢单</span></li></a>

			<!--
                        <li><a href=""><i class="am-icon-cart-arrow-down"></i><span>购物车</span></a></li>
            -->
<!--
			<li><a href=""><i class="am-icon-bell-o"></i><span>系统通知</span></a></li>
-->
			<a href="account.jsp"><li><i class="am-icon-credit-card"></i><span>账户管理</span></li></a>
			<a href="money.jsp"><li><i class="am-icon-cc-mastercard"></i><span>我的积分</li></a>
		</ul>
		<ul class="member-nav mt">
			<a href=""><li><i class="am-icon-phone"></i>联系我们</li></a>
		</ul>
		<div class="h50"></div>
		<div data-am-widget="navbar" class="am-navbar am-cf am-navbar-default footer "  id="tab3">

		</div>

	</body>
</html>
