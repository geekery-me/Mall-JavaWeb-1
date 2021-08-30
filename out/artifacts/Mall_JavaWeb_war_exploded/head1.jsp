<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="index.html"><img src="img/logo.png"/></a></h1>
            <div class="fr clearfix" id="top1">
                <p class="fl">
                    <c:if test="${isUser=='1'}">
                        <b>您好</b>${user.user_name}
                    </c:if>
                    <c:if test="${isUser!='1'}">
                        <a href="login.jsp" id="login.jsp">登录</a><a href="reg.jsp" id="reg.jsp">注册</a>
                    </c:if>
                    <c:if test="${isManagerUser=='1'}">
                        ${user.user_name}<a href="manage/admin_index.jsp" id="reg.jsp">进入后台管理</a>
                    </c:if>
                </p>
                <form action="#" method="get" class="fl"><input type="text" placeholder="热门搜索：干花花瓶"/><input
                        type="button"/></form>
                <div class="btn fl clearfix">
                    <c:if test="${isUser=='1'}">
                        <a href="mygxin.jsp"><img src="img/grzx.png"/></a>
                    </c:if>
                    <a href="#" class="er1"><img src="img/ewm.png"/></a>
                    <a href="cart.html"><img src="img/gwc.png"/></a>
                    <p><a href="#"><img src="img/smewm.png"/></a></p>
                </div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="indexselect">首页</a></li>
            <c:forEach var="f" items="${flist}">
                <li><a href="selectproductlist?fid=${f.cate_id}">${f.cate_name}</a>
                    <div class="sList2">
                        <div class="clearfix">
                            <c:forEach items="${clist}" var="c">
                                <c:if test="${c.cate_parent_id==f.cate_id}">
                                    <a href="selectproductlist?id=${f.cate_id}-${c.cate_id}">${c.cate_name}</a>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
