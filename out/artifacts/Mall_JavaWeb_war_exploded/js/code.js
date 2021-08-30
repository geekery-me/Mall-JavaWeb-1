function changecode(img){
    img.src="http://localhost:8888/08_shop/codeservlet?"+new Date().getTime();
}

var flag=false;//标记位

function Focus(obj){
    // alert(obj);
    if ($(obj).attr("name")==="Code"){
        $(obj).next().next("span").html("").removeClass("error");

    }else{
        $(obj).next("span").html("").removeClass("error");
    }
}
function checkItem(obj) {

    var $password = $("input[name='user_password']");
    var msg = $(obj).next("span");
    switch($(obj).attr("name")){
        case "user_id":
            if (obj.value ===""){
                msg.html("用户ID不能为空");
                msg.addClass("error");
                flag=false;
            }else{
                var url="userIDCheck?user_id="+encodeURI($(obj).val())+"&time="+new Date().getTime();
                //true是存在该用户
                $.get(url,function (data) {
                    if (data==="true"){
                        msg.html("该ID已经存在，请重新输入");
                        msg.addClass("error");
                        flag=false;
                    }else{
                        msg.html().removeClass("error");
                        flag=true;
                    }
                })
            }

            break;
        case "user_name":
            if (obj.value===""){
                msg.html("用户姓名不能为空");
                msg.addClass("error");
                flag=false;
            }else {flag=true;}

            break;
        case "user_password":
            if (obj.value===""){
                msg.html("用户密码不能为空");
                msg.addClass("error");
                flag=false;
            }else {flag=true;}

            break;
        case "rePassWord":
            if (obj.value===""){
                msg.html("确认密码不能为空");
                msg.addClass("error");
                flag=false;
            }else if (obj.value != $password.val()){
                msg.html("两次密码输入不一致");
                msg.addClass("error");
                flag=false;
            }else {flag=true;}


            break;
        case "user_birthday":
            if (obj.value===""){
                msg.html("用户ID不能为空");
                msg.addClass("error");
                flag=false;
            }else {flag=true;}

            break;
        case "user_email":
            if (obj.value===""){
                msg.html("用户ID不能为空");
                msg.addClass("error");
                flag=false;
            }else {flag=true;}

            break;
        case "user_phone":
            if (obj.value===""){
                msg.html("用户ID不能为空");
                msg.addClass("error");
                flag=false;
            }else {flag=true;}

            break;
        case "user_address":
            if (obj.value===""){
                msg.html("用户ID不能为空");
                msg.addClass("error");
                flag=false;
            }else {flag=true;}

            break;
        case "Code":
            var span = $(obj).next().next();
            if (obj.value===""){
                span.html("验证码不能为空");
                span.addClass("error");
                flag=false;
            }else{
                var url="checkCode?code="+encodeURI($(obj).val())+"&time="+new Date().getTime();
                //true是正确
                $.get(url,function (data) {
                    if (data==="true"){
                        flag=true;
                    }else{
                        span.html("验证码错误,请重新输入");
                        span.addClass("error");
                        flag=false;
                        changecode(document.getElementById("imgcode"))
                    }
                })
            }
            break;
    }

}


function checkForm(form){
    var els = form.getElementsByTagName("input");
    for (var i=0;i<form.length;i++){
        if (els[i]!=null){
            if (els[i].getAttribute("onblur")){
                checkItem(els[i]);
            }
        }
    }
    return flag;
}