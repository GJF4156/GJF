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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/amazeui.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/application.js" ></script>

	</head>
	<body>
		<header data-am-widget="header" class="am-header am-header-default header">
		  <div class="am-header-left am-header-nav">
		     <a href="javascript:history.go(-1)" class="">
		       <i class="am-header-icon am-icon-angle-left"></i>
		     </a>
		  </div>
		  <h1 class="am-header-title"> <a href="#title-link" class="" style="color: #333;">校园跑腿</a></h1>
		  <div class="am-header-right am-header-nav">
		     <a href="#right-link" class=""> </a>
		  </div>
	  </header>
	  <div class="communityPage-main">
	  	<div class="communityPage-info">
	  		<img class="communityPage-img" src="images/boy.png">
	  		<div>
	  			<p class="communityPage-title"> 饮食健康</p>
	  			<p class="communityPage-num"><label>话题<span class="communityPage-topic-num cmn-theme-color">0</span></label></p>
	  		</div>
	  	</div>
	  	<div class="communityPage-topic cmn-theme-color-active" id="communityPage-topic"><a class="active">全部</a></div>
	  </div>
	  <div class="nokeshuo">
	  <div class="am-g am-intro-bd">
        <a href="content.jsp">
            <div class="am-intro-left am-u-sm-3"><img src="images/p.png"/></div>
            <div class="am-intro-right am-u-sm-9">
                <div class="text">
                    <span style="float: left;color: black;font-size: 16px"><i>王同学</i></span>
                    <span class="fr gray" style="margin-right: 2%"><i>回复<span class="communityPage-comment-num cmn-theme-color">0</span></i></span>
                </div>
                <p>超市带饭鱼香茄子超市带饭鱼香茄子超市带饭鱼香茄子超市带饭鱼香茄子超市带饭鱼香茄子超市带饭鱼香茄子</p>
                <div class="text">
                    <span class="fl">5分钟前</span>
                </div>
            </div>
        </a>
    </div>
	  	<img src="images/none.png" />
	  	<p>还没话题，快来说两句</p>
	  </div>
	  <div class="communityPage-publish-btn cmn-theme-bgcolor" id="communityPage-publish-btn"><a id="down_order"
                                                                                           href="posting.jsp"
                                                                                           style="color: white">发帖</a>
</div>
<div class="h50"></div>
<div data-am-widget="navbar" class="am-navbar am-cf am-navbar-default footer " id="tab2">

</div>
	</body>
</html>
