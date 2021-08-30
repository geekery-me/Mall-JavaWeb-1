<%--
  Created by IntelliJ IDEA.
  User: 欧裕扬
  Date: 2021/5/10
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<%@ include file="admin_menu.jsp"%>
<html>
<body>
<div class="container clearfix">
    <%@ include file="admin_menu2.jsp"%>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">用户管理</a><span class="crumb-step">&gt;</span><span>修改用户</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="http://localhost:8888/08_shop/manage/do_user_update" method="post" id="myform" name="myform" >
                    <input type="hidden" name="user_id" value="${user.user_id}">
                    <input type="hidden" name="cpage" value="${cpage}">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <tr>
                            <th><i class="require-red">*</i>用户ID：</th>
                            <td>
                                ${user.user_id}
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>用户姓名：</th>
                            <td>
                                <input class="common-text required"  name="username" size="50" value="${user.user_name}" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>用户密码：</th>
                            <td>
                                <input class="common-text required"  name="password" size="50" value="${user.user_password}" type="text">
                            </td>
                        </tr>

                        <tr>
                            <th>性别：</th>
                            <td>
                                <input type="radio" name="sex" value="T" ${user.user_sex=="T"?"checked=checked":""}/>男
                                <input type="radio" name="sex"  value="F" ${user.user_sex=="F"?"checked=checked":""}/>女
                            </td>
                        </tr>
                        <tr>
                            <th>出生日期：</th>
                            <td>
                                <input class="common-text required"  name="user_birthday" size="50" value="${user.user_birthday}" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>电子邮箱：</th>
                            <td>
                                <input class="common-text required" id="email" name="email" size="50" value="${user.user_email}" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>电话号码：</th>
                            <td>
                                <input class="common-text required" id="phone" name="phone" size="50" value="${user.user_phone}" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>送货地址：</th>
                            <td>
                                <input class="common-text required" id="address" name="address" size="50" value="${user.user_address}" type="text">
                            </td>
                        </tr>

                        <tr>
                            <th></th>
                            <td>
                                <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                            </td>
                        </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>