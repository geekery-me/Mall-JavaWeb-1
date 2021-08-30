<%--
  Created by IntelliJ IDEA.
  User: 欧裕扬
  Date: 2021/6/9
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>cart</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>

<!--------------------------------------cart--------------------->
<%@ include file="head1.jsp"%>
<div class="cart mt"><!-----------------logo------------------->
    <!--<div class="logo"><h1 class="wrapper clearfix"><a href="index.html"><img class="fl" src="img/temp/logo.png"></a><img class="top" src="img/temp/cartTop01.png"></h1></div>-->
    <!-----------------site------------------->
    <div class="site"><p class=" wrapper clearfix"><span class="fl">购物车</span><img class="top"
                                                                                   src="img/temp/cartTop01.png"><a
            href="indexselect" class="fr">继续购物&gt;</a></p></div><!-----------------table------------------->
    <div class="table wrapper">
        <form method="post" id="my" action="deletecart">
            <div class="tr">
                <div>商品</div>
                <div>单价</div>
                <div>数量</div>
                <div>小计</div>
                <div>操作</div>
            </div>

            <c:forEach items="${carts}"  var="c">
                <div class="th">
                    <div class="pro clearfix">
                        <label class="fl">
                            <input type="checkbox" name="ids" value="${c.cart_id}"/><span></span>
                        </label>
                        <a class="fl" href="selectproductview?pid=${c.cart_p_id}">
                            <dl class="clearfix">
                                <dt class="fl">
                                    <img src="img/product/${c.cart_p_filename}" width="80" height="80">
                                </dt>
                                <dd class="fl">
                                    <p>${c.cart_p_name}</p>
                                    <p>书籍信息:</p>
                                    <p>白色瓷瓶+白色串枚</p>
                                </dd>
                            </dl>
                        </a>
                    </div>
                    <div class="price">￥${c.cart_p_price}</div>
                    <div class="number">
                        <p class="num clearfix">
                            <img class="fl sub" src="img/temp/sub.jpg">
                            <span datasrc="${c.cart_id}" class="fl">${c.cart_quantity}</span>
                            <img class="fl add" src="img/temp/add.jpg">
                        </p>
                    </div>
                    <div class="price sAll">￥${c.cart_p_price*c.cart_quantity}</div>
                    <div class="price"><a class="del" datasrc="${c.cart_id}" href="#">删除</a></div>
                </div>
            </c:forEach>


            <div class="goOn">空空如也~<a href="indexselect">去逛逛</a></div>
            <div class="tr clearfix">
                <label class="fl">
                    <input class="checkAll" type="checkbox"/><span></span>
                </label>
                <p class="fl"><a href="#">全选</a><a href="#" class="del">删除</a></p>
                <p class="fr"><span>共<small id="sl">0</small>件商品</span>
                    <span>合计:&nbsp;￥<small id="all">0.00</small></span>
                    <a href="javascript:To_order()" class="count">结算</a>
                </p>
            </div>
        </form>
    </div>
</div>
<script>
    function To_order(){

        var ids="";

        //选择个数
        var j=0;

        var elements = document.getElementsByName("ids");

        for (var i=0;i<elements.length;i++){
            if (elements[i].checked==true){
                j++;
            }
        }

        var n=0;//记录循环到选择的数
        for (var i=0;i<elements.length;i++){
            if (elements[i].checked==true){
                n++;
                if (n===j){
                    ids+=elements[i].value;
                }else {
                    ids+=elements[i].value+"-";
                }

            }
        }
        location="orderselect?ids="+ids;
    }
</script>

<div class="mask"></div>
<div class="tipDel"><p>确定要删除该商品吗？</p>
    <p class="clearfix"><a class="fl cer" href="#">确定</a>
        <a class="fr cancel" href="#">取消</a>
    </p>
</div><!--返回顶部-->


<%@ include file="gotop.jsp"%>
<!--footer-->
<div class="footer">
    <div class="top">
        <div class="wrapper">
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot1.png"/></a><span class="fl">7天无理由退货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot2.png"/></a><span class="fl">15天免费换货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot3.png"/></a><span class="fl">满599包邮</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot4.png"/></a><span class="fl">手机特色服务</span>
            </div>
        </div>
    </div>
    <p class="dibu">最家家居&copy;2013-2017公司版权所有 京ICP备080100-44备0000111000号<br/>
        违法和不良信息举报电话：188-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</p></div><!----------------mask------------------->
<div class="mask"></div><!-------------------mask内容------------------->
<div class="proDets"><img class="off" src="img/temp/off.jpg"/>
    <div class="proCon clearfix">
        <div class="proImg fr"><img class="list" src="img/temp/proDet.jpg"/>
            <div class="smallImg clearfix"><img src="img/temp/proDet01.jpg" data-src="img/temp/proDet01_big.jpg"><img
                    src="img/temp/proDet02.jpg" data-src="img/temp/proDet02_big.jpg"><img src="img/temp/proDet03.jpg"
                                                                                          data-src="img/temp/proDet03_big.jpg"><img
                    src="img/temp/proDet04.jpg" data-src="img/temp/proDet04_big.jpg"></div>
        </div>
        <div class="fl">
            <div class="proIntro change"><p>颜色分类</p>
                <div class="smallImg clearfix"><p class="fl on"><img src="img/temp/prosmall01.jpg" alt="白瓷花瓶+20支快乐花"
                                                                     data-src="img/temp/proBig01.jpg"></p>
                    <p class="fl"><img src="img/temp/prosmall02.jpg" alt="白瓷花瓶+20支兔尾巴草"
                                       data-src="img/temp/proBig02.jpg"></p>
                    <p class="fl"><img src="img/temp/prosmall03.jpg" alt="20支快乐花" data-src="img/temp/proBig03.jpg"></p>
                    <p class="fl"><img src="img/temp/prosmall04.jpg" alt="20支兔尾巴草" data-src="img/temp/proBig04.jpg"></p>
                </div>
            </div>
            <div class="changeBtn clearfix"><a href="#2" class="fl"><p class="buy">确认</p></a><a href="#2" class="fr"><p
                    class="cart">取消</p></a></div>
        </div>
    </div>
</div>
<div class="pleaseC"><p>请选择宝贝</p><img class="off" src="img/temp/off.jpg"/></div>

<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
