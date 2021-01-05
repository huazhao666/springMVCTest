$(function () { //
    $("#login_form").submit(function () { //绑定表单的提交事件
        //alert("submit")// 验证使用的
        $.ajax({
            url: "../api/user/login",//api记得写；
            //url: "../data/login2.json",
            type: "post",//请求方法
            //contentType:"",请求数据类型
            data:$("#login_form").serialize(),//请求数据：使用表单的数据
            dataType: "json",//响应数据格式:content-type
            success:function (resp) { //200；
                //返回数据，success=true；去main；success=false;返回code和message
                if(resp.success){
                    //把地址栏url为指定的值
                    window.location.href="main.html";
                }else {
                    alert("错误码："+ resp.code+"\n错误信息："+ resp.message);
                }
                //alert(JSON.stringify(resp))//提示语，json对象转为字符串
            },
            error:function (req,textStatus,err) { //响应状态码为4xx，5xx；
                alert(req.status)
            }
        })
        return false;//返回值决定是否使用表单的默认提交
    })
})