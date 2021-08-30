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
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">图书管理</span></div>
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
            <form action="" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="/08_shop/manage/to_productadd"><i class="icon-font"></i>新增图书</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" onclick="choosemore(this)" name="id[]"  type="checkbox"></th>
                            <th>图书名</th>
                            <th>图书描述</th>
                            <th>图书价格</th>
                            <th>图书库存</th>
                            <th>图书分类父级ID</th>
                            <th>图书子类父级ID</th>
                            <th>图书图片名</th>
                            <th>操作</th>
                        </tr>

                        <c:forEach items="${list}" var="p">
                            <tr>
                                <td class="tc"><input name="id[]" value="${p.product_id}" type="checkbox" ></td>
                                <td>${p.product_name}</td>
                                <td><img src="../img/product/${p.product_filename}" width="80" height="80"/>
                                        ${p.product_descrption}
                                </td>
                                <td>${p.product_price}</td>
                                <td>${p.product_stock}</td>
                                <td>${p.product_fid}</td>
                                <td>${p.product_cid}</td>
                                <td>${p.product_filename}</td>
                                <td>
                                    <a class="link-del" href="/08_shop/manage/to_productupdate?cpage=${cpage}&product_id=${p.product_id}">修改</a>/
                                    <a class="link-del" href="javascript:Delete('${p.product_id}','${p.product_name}','${cpage}')">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                        <script>
                            function Delete(id ,name,cpage){
                                if (confirm("你确定要删除"+name+"吗？")){
                                    var url="/08_shop/manage/do_deleteproduct?cpage="+cpage+"&product_id="+id;
                                    location.href=url;
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
                    <div class="list-page">
                        共${tsum}条记录，当前${cpage}/${tpage}页
                        <a href="/08_shop/manage/productselect?cp=1${searchParams}">首页</a>
                        <a href="/08_shop/manage/productselect?cp=${cpage-1}${searchParams}">上一页</a>
                        <a href="/08_shop/manage/productselect?cp=${cpage+1}${searchParams}">下一页</a>
                        <a href="/08_shop/manage/productselect?cp=${tpage}${searchParams}">尾页</a>

                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>
