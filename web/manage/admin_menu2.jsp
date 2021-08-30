<%--
  Created by IntelliJ IDEA.
  User: 欧裕扬
  Date: 2021/5/10
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="sidebar-wrap">
    <div class="sidebar-title">
        <h1>菜单</h1>
    </div>
    <div class="sidebar-content">
        <ul class="sidebar-list">
            <li>
                <a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
                <ul class="sub-menu">
                    <li><a href="/08_shop/manage/do_user_select"><i class="icon-font">&#xe008;</i>用户管理</a></li>
                    <li><a href="/08_shop/manage/selectallcate"><i class="icon-font">&#xe005;</i>分类管理</a></li>
                    <li><a href="/08_shop/manage/productselect"><i class="icon-font">&#xe006;</i>图书管理</a></li>
                    <li><a href="admin_order.jsp"><i class="icon-font">&#xe004;</i>订单管理</a></li>
                    <li><a href="admin_message.jsp"><i class="icon-font">&#xe012;</i>留言管理</a></li>
                    <li><a href="admin_news.jsp"><i class="icon-font">&#xe052;</i>新闻管理</a></li>
                </ul>
            </li>
            <li>
                <a href="#"><i class="icon-font">&#xe018;</i>系统管理</a>
                <ul class="sub-menu">
                    <li><a href="system.html"><i class="icon-font">&#xe017;</i>系统设置</a></li>
                    <li><a href="system.html"><i class="icon-font">&#xe037;</i>清理缓存</a></li>
                    <li><a href="system.html"><i class="icon-font">&#xe046;</i>数据备份</a></li>
                    <li><a href="system.html"><i class="icon-font">&#xe045;</i>数据还原</a></li>
                </ul>
            </li>
        </ul>
    </div>
</div>

