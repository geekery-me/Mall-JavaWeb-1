<%--
  Created by IntelliJ IDEA.
  User: 欧裕扬
  Date: 2021/5/10
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp"%>
<html>
<body>
<div class="container clearfix">
    <%@ include file="admin_menu2.jsp"%>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="/08_shop/manage/selectallcate">分类管理</a><span class="crumb-step">&gt;</span><span>修改分类</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form onsubmit="return checkname()" action="http://localhost:8888/08_shop/manage/do_updatecate" method="post" id="myform" name="myform" >
                    <input type="hidden" name="cate_id" value="${cate.cate_id}"/>
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <tr>
                            <th><i class="require-red">*</i>父级ID：</th>
                            <td>
                                    <select class="common-text required"  name="parentID">
                                        <option value="0" selected="selected">根目录</option>
                                        <c:forEach items="${catelist}" var="acate">
                                            <c:if test="${acate.cate_parent_id==0}">
                                                <option value="${acate.cate_id}"  >${acate.cate_name}</option>
                                            </c:if>
                                        </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>分类名：</th>
                            <td>
                                <input id="cn" class="common-text required"  name="cate_name" size="50" value="${cate.cate_name}" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th></th>
                            <td>
                                <input class="btn btn-primary btn6 mr10" value="修改" type="submit">
                                <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                            </td>
                        </tr>
                        <script>
                            function checkname() {
                                var catename = document.getElementById("cn");
                                if (catename.value==""){
                                    return false;
                                }else {return true;}
                            }
                        </script>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>