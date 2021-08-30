<%--
  Created by IntelliJ IDEA.
  User: 欧裕扬
  Date: 2021/6/6
  Time: 1:28
  To change this template use File | Settings | File Templates.
--%>
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
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="/08_shop/manage/productselect">图书管理</a><span class="crumb-step">&gt;</span><span>新增图书</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="http://localhost:8888/08_shop/manage/do_productadd" method="post" enctype="multipart/form-data" id="myform" name="myform" >
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <tr>
                            <th><i class="require-red">*</i>图书名称：</th>
                            <td>
                                <input  class="common-text required"  name="product_name" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>图书分类</th>
                            <td>
                                <select class="common-text required"  name="id ">
                                    <c:forEach items="${flist}" var="f">
                                        <option value="${f.cate_id}" disabled="disabled">${f.cate_name}</option>
                                        <c:forEach items="${clist}" var="c">
                                            <c:if test="${c.cate_parent_id==f.cate_id}">
                                                <option value="${f.cate_id}-${c.cate_id}">&nbsp;&nbsp;&nbsp;>>>${c.cate_name}</option>
                                            </c:if>
                                        </c:forEach>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>图书图片：</th>
                            <td>
                                <input  class="common-text required"  name="photo" size="50" value="" type="file">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>图书描述：</th>
                            <td>
                                <input  class="common-text required"  name="product_descrption" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>图书价格：</th>
                            <td>
                                <input  class="common-text required"  name="product_price" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>图书库存：</th>
                            <td>
                                <input  class="common-text required"  name="product_stock" size="50" value="" type="text">
                            </td>
                        </tr>




                        <tr>
                            <th></th>
                            <td>
                                <input class="btn btn-primary btn6 mr10" value="提交" type="submit" onsubmit="checkname()">
                                <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                            </td>
                        </tr>

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