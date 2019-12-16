<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
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
    <title>海尔商城触屏版手机wap用户注册网站模板</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/v2/member.css">

</head>
<body id="page">
<header class="header">
    <span class="fh left"><a href="javascript:history.back(1)">&nbsp;</a></span> 登录
    <span class="hd_right right">

</span>
</header>
<span id="login_errorMsg" style=" padding:10px;"></span>
<div class="Login">
    <div class="Login_top">
        <ul>
            <li class="cur"><A href="${pageContext.request.contextPath}/toMemberLogin">登录</A></li>
            <li><A href="${pageContext.request.contextPath}/toMemberRegist">注册</A></li>
        </ul>
    </div>
    <div>
        <div class="Login_bottom">
            <form id="loginForm" action="${pageContext.request.contextPath}/User/login" method="post">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td height="60" align="center" valign="middle"><input type="text" id="mobileNum" value=""
                                                                              name="phone" placeholder="手机号"
                                                                              class="login_wbk"></td>
                    </tr>
                    <tr>
                        <td height="60" align="center" valign="middle"><input type="password" id="password"
                                                                              name="password" placeholder="密码"
                                                                              class="login_wbk"></td>
                    </tr>
                    <tr>
                        <td height="60" align="center" valign="middle"><input type="submit" value="登录"
                                                                              class="dl_login"/></td>

                    </tr>

                    <tr>
                        <td height="55" align="right" valign="middle">
                            <span style="text-align: center;font-size: 25px;color: green">${msg}</span>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath}/toBackPassword">忘记密码</a>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>

</footer>
</body>
</html>
