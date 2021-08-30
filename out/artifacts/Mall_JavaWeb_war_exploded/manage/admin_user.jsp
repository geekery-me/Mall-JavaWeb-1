<%--
  Created by IntelliJ IDEA.
  User: 欧裕扬
  Date: 2021/5/10
  Time: 15:18
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
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">用户管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="" method="get">
                    <table class="search-tab">
                        <tr>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="${param.keywords}" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form action="/08_shop/manage/do_user_delete" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="admin_useradd.jsp"><i class="icon-font"></i>新增用户</a>
                        <a id="batchDel" href="javascript:deletemore('确定要批量删除吗？')"><i class="icon-font"></i>批量删除</a>
<%--                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>--%>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" onclick="choosemore(this)" name="id[]"  type="checkbox"></th>
                            <th>用户ID</th>
                            <th>用户姓名</th>
                            <th>用户密码</th>
                            <th>性别</th>
                            <th>email</th>
                            <th>电话号码</th>
                            <th>权限状态</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${list}" var="user">
                            <tr>
                                <td class="tc"><input name="id[]" value="${user.user_id}" type="checkbox" ></td>
                                <td>${user.user_id}</td>
                                <td>${user.user_name}</td>
                                <td>${user.user_password}</td>
                                <td>${user.user_sex=='T'?'男':'女'}</td>
                                <td>${user.user_email}</td>
                                <td>${user.user_phone}</td>
                                <td>${user.user_status}</td>
                                <td>
                                    <a class="link-update" href="/08_shop/manage/to_user_update?user_id=${user.user_id}&cpage=${cpage}">修改</a>

                                    <c:if test="${user.user_status==1}">
                                        <a class="link-del" href="javascript:Delete('你确定要删除${user.user_name}吗？','/08_shop/manage/do_user_delete?user_id=${user.user_id}&cpage=${cpage}')">删除</a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                        <script>
                            function Delete(mess,url){
                                if (confirm(mess)){
                                    location.href=url;
                                }
                            }
                            function choosemore(o) {

                                var elements = document.getElementsByName("id[]");
                                for (var i=0;i<elements.length;i++){
                                    elements[i].checked=o.checked;
                                }
                            }
                            function deletemore(mess){
                                var elements = document.getElementsByName("id[]");
                                for (var i=0;i<elements.length;i++){
                                    if (elements[i].checked==true){
                                        if (confirm(mess)){
                                            var f = document.getElementById("myform");
                                            f.submit();
                                        }
                                    }
                                }
                            }
                        </script>
                    </table>
                    <div class="list-page">
                        共${tsum}条记录，当前${cpage}/${tpage}页
                        <a href="/08_shop/manage/do_user_select?cp=1${searchParams}">首页</a>
                        <a href="/08_shop/manage/do_user_select?cp=${cpage-1}${searchParams}">上一页</a>
                        <a href="/08_shop/manage/do_user_select?cp=${cpage+1}${searchParams}">下一页</a>
                        <a href="/08_shop/manage/do_user_select?cp=${tpage}${searchParams}">尾页</a>

                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>