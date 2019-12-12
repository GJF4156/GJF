<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>回复</title>
</head>
<body>
${param.username} ${param.title} <br/>${param.context}<br/>
回复:<input type="text" name="reply"/>
<form action="ReplyServlet?username=${param.username}&title=${param.title}&context=${param.context}">
<input type="submit" value="回复"/>

<c:forEach items="${replies}" var="r" >
	回复${param.username}:${r.replyContext}
	<br/>
</c:forEach>

</form>
<%-- 
<button type="button" class="btn btn-secondary" οnclick="hide('#{specificReview.RId}')">回复</button>  <br />
<p class="cContent">#{specificReview.RComments}</p>   <!--每个人回复的评论 -->  <br />
 
<div class="comment-edit" id="#{specificReview.RId}" style=" display: none;">
    <h:inputTextarea id="doubleComments"
                     class="form-control edit"
                     value="#{comment.RDComments}"                                
                     />
    <!--<h:message for="doubleComments" style="color:red"/>-->
    <div class="preview">
        <div class="buttons">
            <h:commandButton immediate="true" class="btn btn-secondary" rendered="#{!login.isLogin()}" value="评论前请先登录" action="#{navBean.login}" />
            <h:commandButton id="submitButton" rendered="#{login.isLogin()}" actionListener="#{discuss.setTopic(discuss.topic)}"  action="#{comment.storeIntoDB(discuss.topic.TId, specificReview.RId, login.userName, specificReview.ROwnerName)}" class="btn btn-primary post broadcast" value="回复"/>                
        </div>
    </div>
</div>
 --%>
</body>
</html>