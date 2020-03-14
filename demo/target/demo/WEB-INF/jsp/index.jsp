<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="utf-8"/>
</head>
<body>
<h2>${msg}</h2><br/>
<form  action="${pageContext.request.contextPath}/garbage/insert">
<%--    <input type="hidden" name="id" id="id"/><br/>--%>
    <input type="text" name="name" id="name"/><br/>
    <input type="number" name="gtype" id="gtype" value="3"/><br/>
    <input type="number" name="aipre" id="aipre" value="0"/><br/>
    <input type="text" name="explain" id="explain" value="干（其他）垃圾即其它垃圾，指除可回收物、有害垃圾、厨余垃圾（湿垃圾）以外的其它生活废弃物。"/><br/>
    <input type="text" name="contain" id="contain" value="常见包括砖瓦陶瓷、渣土、卫生间废纸、猫砂、污损塑料、毛发、硬壳、一次性制品、灰土、瓷器碎片等难以回收的废弃物"/><br/>
    <input type="text" name="tip" id="tip" value="尽量沥干水分；难以辨识类别的生活垃圾都可以投入干垃圾容器内"/><br/>
    <input type="submit" value="提交"/>
</form>

</body>
</html>
