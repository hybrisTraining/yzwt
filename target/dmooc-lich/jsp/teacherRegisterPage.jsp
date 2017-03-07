<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>登录页面</title>
<link rel="stylesheet" href="/dmooc-lich/css/style.default.css" type="text/css" />
<link rel="stylesheet" href="/dmooc-lich/css/custom/index.css" type="text/css" />
<script type="text/javascript" src="/dmooc-lich/js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="/dmooc-lich/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="/dmooc-lich/js/jquery.cookie.js"></script>
<script type="text/javascript" src="/dmooc-lich/js/jquery.uniform.min.js"></script>
<script type="text/javascript" src="/dmooc-lich/js/plugins/general.js"></script>
<script type="text/javascript" src="/dmooc-lich/js/custom/loginAndRegister.js"></script>
<!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="css/style.ie9.css"/>
<![endif]-->
<!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="css/style.ie8.css"/>
<![endif]-->
<!--[if lt IE 9]>
	<script src="js/plugins/css3-mediaqueries.js"></script>
<![endif]-->
</head>
<body class="loginpage">
	<div class="loginbox">
    	<div class="loginboxinner">
        	
            <div class="logo">
            	<h1 class="logo"><span>欢迎注册</span></h1>
            </div><!--logo-->
            
            <br clear="all" /><br />
            
            <div class="nousername">
				<div class="loginmsg">密码不正确.</div>
            </div><!--nousername-->
            
            <div >
            	<div class="loginmsg" id="loginmsg"></div>
            </div>
            
            <form  id="teacherRegisterForm" action="/dmooc-lich/teacher/register" method="post">
                <div class="username">
                	<div class="usernameinner">
                    	<input  name="username" min="3" required="required" placeholder="用户名" oninvalid="setCustomValidity('请输入不少于3个单位的用户名')" oninput="setCustomValidity('');"/>
                    </div>
                </div>
                <c:if test="${username !=null}">  
					<div class="loginmsg">"${username}"</div>
            	</c:if>
                <div class="password">
                	<div class="usernameinner">
                    	<input  name="password" min="6" required="required" oninvalid="setCustomValidity('请输入不少于6位的密码')" oninput="setCustomValidity('');" placeholder="密码" />
                    </div>
                </div>
                <c:if test="${password !=null}">  
					<div class="loginmsg">"${password}"</div>
            	</c:if>
                
                <div class="password">
                	<div class="usernameinner">
                    	<input  name="password2" min="6" required="required" oninvalid="setCustomValidity('请再次输入密码')" oninput="setCustomValidity('');" placeholder="请再次输入密码" />
                    </div>
                </div>
 
                 <c:if test="${password2 !=null}">  
					<div class="loginmsg">"${password2}"</div>
            	</c:if>
            	               
                <div class="phone">
                	<div class="phoneinner">
                    	<input type="number" name="mobile" pattern="^1[345678][0-9]{9}$" required="required" oninvalid="setCustomValidity('请输入正确的电话号')" oninput="setCustomValidity('');" placeholder="电话号码" />
                    </div>
                </div>
                <c:if test="${mobile !=null}">  
					<div class="loginmsg">"${mobile}"</div>
            	</c:if>
            	
                <input type="hidden" name="${_csrf.parameterName}" 	value="${_csrf.token}" />
                
                <div>
                	<img id="imgObj" alt="" src="/dmooc-lich/teacher/getVerifyCodeImg"/>  
                </div>
                <div class="username">
               		<input type="text" name="verifyCode" id="verifyCode" required="required" oninvalid="setCustomValidity('请输入验证码')" oninput="setCustomValidity('');" placeholder="请输入验证码,区分大小写"/>
                </div>
                <div>
                	<button id="register">注册</button>
                </div>

                <div class="register">
                	<a href="/dmooc-lich/teacher/loginPage">返回</a>
                </div>
                
                
            </form>

        </div><!--loginboxinner-->
    </div><!--loginbox-->


</body>
</html>