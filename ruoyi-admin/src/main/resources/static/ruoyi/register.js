var needPassword = [[$(needPassword)]]
$(function() {
    validateRule();
    $('.imgcode').click(function() {
        var url = ctx + "captcha/captchaImage?type=" + captchaType + "&s=" + Math.random();
        $(".imgcode").attr("src", url);
    });
});

$.validator.setDefaults({
    submitHandler: function() {
    	register();
    }
});

function register() {
    $.modal.loading($("#btnSubmit").data("loading"));
    var username = $.common.trim($("input[name='username']").val());
    var password = $.common.trim($("input[name='password']").val());
    var teamname = $.common.trim($("input[name='teamname']").val());
    var wfmname = $.common.trim($("input[name='wfmname']").val());
    var validateCode = $("input[name='validateCode']").val();
    $.ajax({
        type: "post",
        url: ctx + "register",
        data: {
            "loginName": username,
            "password": password,
            "validateCode": validateCode,
            "teamName":teamname,
            "wfmName":wfmname
        },
        success: function(r) {
            if (r.code == web_status.SUCCESS) {
            	layer.alert("<font color='red'>恭喜你，您的账号 " + username + " 注册成功！</font>", {
            	    icon: 1,
            	    title: "系统提示"
            	},
            	function(index) {
            	    //关闭弹窗
            	    layer.close(index);
            	    location.href = ctx + 'login';
            	});
            } else {
            	$.modal.closeLoading();
            	$('.imgcode').click();
            	$(".code").val("");
            	$.modal.msg(r.msg);
            }
        }
    });
}

function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    var validateJson = {}
    if(needPassword){
        validateJson = {
            rules: {
                username: {
                    required: true,
                    email:true,
                    minlength: 2
                },
                password: {
                    required: true,
                    minlength: 5
                },
                confirmPassword: {
                    required: true,
                    equalTo: "[name='password']"
                },
                teamname:{
                    required: true,
                    minlength: 2,
                    maxlength: 100
                },
                wfmname:{
                    required: true,
                    minlength: 2,
                    maxlength: 50
                }
            },
            messages: {
                username: {
                    required: icon + "请输入您的用户名",
                    minlength: icon + "用户名不能小于2个字符"
                },
                password: {
                    required: icon + "请输入您的密码",
                    minlength: icon + "密码不能小于5个字符",
                },
                confirmPassword: {
                    required: icon + "请再次输入您的密码",
                    equalTo: icon + "两次密码输入不一致"
                },
                teamname: {
                    required: icon + "请输入您的Team名",
                    minlength: icon + "Team名不能小于2个字符或大于100个字符",
                    maxlength: icon + "Team名不能大于100个字符"
                },
                wfmname: {
                    required: icon + "请输入您的WFM名",
                    minlength: icon + "WFM名不能小于2个字符或大于50个字符",
                    maxlength: icon + "WFM名不能大于50个字符"
                }
            }
        }
    }else{
        validateJson= {
            rules: {
                username: {
                    required: true,
                    email:true,
                    minlength: 2
                },
                teamname:{
                    required: true,
                    minlength: 2,
                    maxlength: 100
                },
                wfmname:{
                    required: true,
                    minlength: 2,
                    maxlength: 50
                }
            },
            messages: {
                username: {
                    required: icon + "请输入您的用户名",
                    minlength: icon + "用户名不能小于2个字符",
                    email:"邮件格式不正确"
                },
                teamname: {
                    required: icon + "请输入您的Team名",
                    minlength: icon + "Team名不能小于2个字符或大于100个字符",
                    maxlength: icon + "Team名不能大于100个字符"
                },
                wfmname: {
                    required: icon + "请输入您的WFM名",
                    minlength: icon + "WFM名不能小于2个字符或大于50个字符",
                    maxlength: icon + "WFM名不能大于50个字符"
                }
            }
        }
    }

    $("#registerForm").validate(validateJson)
}
