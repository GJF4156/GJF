<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>校园跑腿</title>
    <meta name="description" content="校园跑腿"/>
    <meta name="keywords" content="校园跑腿"/>
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/timedropper.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/datedropper.css"/>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/amazeui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/application.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/timedropper.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/datedropper.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/TimeObjectUtil.js"></script>


</head>
<script type="text/javascript">
    $(function () {
        $("#picktime").hide();
        $(".radio").children('.yuan').on('click', function () {
            $('.rdactive').removeClass('rdactive');
            $(this).addClass("rdactive").siblings().removeClass("rdactive");
            var gender = $(this).next().text();
        });
        setInterval(function () {
            var date = $("#pickdate").val();
            if (date !== "不限") {
                $("#picktime").show();
            }
        }, 1000);
        $("#pickdate").dateDropper({
            animate: true,
            format: 'Y-m-d',
            maxYear: '2020'
        });
        $("#picktime").timeDropper({
            meridians: true,
            format: 'HH:mm'
        });
        //获得文本框对象
        var t = $("#text_box");
//初始化数量为1,并失效减
        $('#min').attr('disabled', true);
        //数量增加操作
        $("#add").click(function () {
            // 给获取的val加上绝对值，避免出现负数
            t.val(Math.abs(parseInt(t.val())) + 1);
            if (parseInt(t.val()) != 2) {
                $('#min').attr('disabled', false);
            }
            ;
        })
        //数量减少操作
        $("#min").click(function () {
            t.val(Math.abs(parseInt(t.val())) - 1);
            if (parseInt(t.val()) == 0) {
                $('#min').attr('disabled', true);
            }
            ;
        })
    });
</script>
<body>
<header data-am-widget="header" class="am-header am-header-default header">
    <div class="am-header-left am-header-nav">
        <a href="javascript:history.go(-1)" class="">
            <i class="am-header-icon am-icon-angle-left"></i>
        </a>
    </div>
    <h1 class="am-header-title"><a href="#title-link" class="" style="color: #333;">发布中心</a></h1>
    <div class="am-header-right am-header-nav">
        <a href="#right-link" class=""> </a>
    </div>
</header>
<form action="${pageContext.request.contextPath}/order/createOrder">
    <%--<input type="hidden" name="uid" value="${USER.uid}"/>--%>
    <%--<input type="hidden" name="username" value="${USER.username}"/>--%>
    <a href="${pageContext.request.contextPath}/address/selectAllAddress?testId=2">
        <input class="add_input" name="" id="" type="text" style="height: 6%;padding-left: 8px"
               placeholder="请选择您要送达的地址" readonly="readonly">
        <input class="add_input" name="address" id="contents" type="text" style="height: 6%;padding-left: 8px"
               readonly="readonly" value="${param.consignee}&nbsp;${param.cphone}&nbsp;${param.content}">
    </a>
    <div class="demo" style="background: white;margin-top: 2px">
        <span class="add_input1" style="color: gray">找人干什么： </span>
        <select name="colId" class="select" style="background: white">
            <option>---请选择---</option>
            <option value="求帮忙">求帮忙</option>
            <option value="求带饭">求带饭</option>
            <option value="取快递">取快递</option>
            <option value="求陪跑">求陪跑</option>
        </select>
    </div>
    <textarea id="content" name="describe" class="add_input" type="text" style="padding-left: 8px" placeholder="任务要求"
              cols="10"
              rows="5"></textarea>
    <div style="margin-left: 4px" class="radio">
        <input type="radio" name="other_requirements" value="不限" style="color: black;" checked>不限
    </div>
    <div class="radio">
        <input type="radio" name="other_requirements" value="限美女" class="girl">限女生
    </div>
    <div class="radio">
        <input type="radio" name="other_requirements" value="限男生" class="boy">限女生
    </div>
    <div style="background: white;margin-top: 33px;padding-bottom: 4px">
        <span class="add_input1" style="color: gray">感谢回馈： </span>￥
        <input id="min" name="" type="button" value="-"/>
        <input id="text_box" name="cost" type="number" value="0" style="width:30px;text-align: center"/>
        <input id="add" name="" type="button" value="+"/>
    </div>
    <div class="demo" style="background: white;margin-top: 2px">
        <span class="add_input1" style="color: gray">期望完成时间： </span>
        <input type="text" name="order_date" class="input add_input1" placeholder="请点击我选择日期" id="pickdate" value=""/>
        <input type="text" name="order_time" class="input add_input2" id="picktime" readonly="readonly"/>
    </div>
    <div style="width: 100%;text-align: center;margin-top: 50px">
        <input type="submit" class=" className" value="立即发布"/>
    </div>
</form>
</body>
</html>
