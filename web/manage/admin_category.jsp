<%--
  Created by IntelliJ IDEA.
  User: 欧裕扬
  Date: 2021/5/31
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp"%>
<div class="container clearfix">
    <%@ include file="admin_menu2.jsp"%>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">分类管理</span></div>
        </div>
        <div class="result-wrap">
            <form action="" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="/08_shop/manage/admin_to_addcate"><i class="icon-font"></i>新增分类</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" onclick="choosemore(this)" name="id[]"  type="checkbox"></th>
                            <th>分类ID</th>
                            <th>分类名称</th>
                            <th>父级ID</th>
                            <th>操作</th>
                        </tr>

                        <c:forEach  var="cate" items="${catelist}">
                            <c:if test="${cate.cate_parent_id==0}">
                                <tr>
                                    <td class="tc"><input name="id[]" value="${user.user_id}" type="checkbox" ></td>
                                    <td>${cate.cate_id}</td>
                                    <td>${cate.cate_name}</td>
                                    <td>${cate.cate_parent_id}</td>
                                    <td><a class="link-update" href="/08_shop/manage/to_updatecate?cate_id=${cate.cate_id}">修改</a>/
                                        <a class="link-del" href="javascript:Delete(${cate.cate_id})">删除</a></td>
                                </tr>
                            </c:if>
                            <c:forEach items="${catelist}" var="zcate">
                                <c:if test="${zcate.cate_parent_id==cate.cate_id}">
                                    <tr>
                                        <td class="tc"><input name="id[]" value="${user.user_id}" type="checkbox" ></td>
                                        <td>${zcate.cate_id}</td>
                                        <td>&nbsp;&nbsp;&nbsp;>>${zcate.cate_name}</td>
                                        <td>${zcate.cate_parent_id}</td>
                                        <td><a class="link-update" href="/08_shop/manage/to_updatecate?cate_id=${zcate.cate_id}">修改</a>/
                                            <a class="link-del" href="javascript:Delete(${zcate.cate_id})">删除</a></td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                        <script>
                            function Delete(id){
                                if (confirm("你确定要删除该分类吗？")){
                                    location.href="/08_shop/manage/do_deletecate?cate_id="+id;
                                }
                            }
                            function choosemore(o) {

                                var elements = document.getElementsByName("id[]");
                                for (var i=0;i<elements.length;i++){
                                    elements[i].checked=o.checked;
                                }
                            }

                        </script>
                    </table>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>