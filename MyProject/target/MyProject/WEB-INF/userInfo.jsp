<%@ page import="com.ityuan.pojo.User" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<% User user= (User) session.getAttribute("USER"); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="author" content="m.ehaier.com">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no"
          name="viewport"/>
    <meta name="format-detection" content="telephone=no"/>
    <meta content="yes" name="apple-mobile-web-app-capable"/>
    <meta content="black" name="apple-mobile-web-app-status-bar-style"/>
    <meta content="telephone=no" name="format-detection"/>
    <meta content="false" id="twcClient" name="twcClient"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/v2/style.css">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/../../images/ehaier-icon.png"/>
    <link rel="shortcut icon" type="image/x-icon"
          href="${pageContext.request.contextPath}/../../images/ehaier-icon.png"/>
    <title>校园跑腿</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/v2/member.css">
</head>
<body id="page">
<header class="header">
    <span class="fh left"><a href="javascript:history.back(1)">&nbsp;</a></span> 修改信息
    <span class="hd_right right">
<!--	<a class="gwc" href="../cart/myCart.html"><span id="count">0 </span>&nbsp;</a>
	<a class="right_but" href="../common/navigate.html">&nbsp;</a>-->
</span>
</header>
<span id="login_errorMsg" style="padding:10px;"></span>
<div class="Login">
    <div>
        <div class="Login_bottom">
            <form id="registForm" action="${pageContext.request.contextPath}/User/updateUserInfo">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td height="60" align="left" valign="middle">
                            <input type="text" value="${sessionScope.USER.username}" id="username" name="username" placeholder="用户名" class="login_wbk">
                        </td>
                    </tr>

                    <tr>
                        <td height="60" align="left" valign="middle">
                            <input type="text" value="${sessionScope.USER.phone}" id="phone" name="phone" placeholder="手机号" class="login_wbk">
                        </td>
                    </tr>
                    <tr>
                        <td height="60" align="left" valign="middle">
                            <input type="password" value="${sessionScope.USER.password}" id="password" name="password" placeholder="设置密码" class="login_wbk">
                        </td>
                    </tr>
                    <tr>
                        <td height="60" align="left" valign="middle">
                            <input type="text" id="email" value="${sessionScope.USER.email}" name="email" placeholder="邮箱" class="login_wbk">
                        </td>
                    </tr>
                    <tr>
                        <td height="60" align="center" valign="middle">
                            <input type="submit" value="确认修改" class="dl_login"/>
                        </td>
                    </tr>
                    <tr>
                        <td height="30" style="font-size: 25px;color: red;text-align: center">${msg}</td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
