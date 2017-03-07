<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<title>登录页面</title>
<link rel="stylesheet" href="/dmooc-lich/css/style.default.css" type="text/css" />
<link rel="stylesheet" href="/dmooc-lich/css/custom/index.css" type="text/css" />
<script type="text/javascript" src="/dmooc-lich/js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="/dmooc-lich/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="/dmooc-lich/js/jquery.cookie.js"></script>
<script type="text/javascript" src="/dmooc-lich/js/jquery.uniform.min.js"></script>
<script type="text/javascript" src="/dmooc-lich/js/plugins/general.js"></script>
<script type="text/javascript" src="/dmooc-lich/js/custom/loginAndRegister.js"></script>
<!-- <script type="text/javascript" src="/dmooc-lich/js/custom/verifyCode.js"></script> -->
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
            	<h1 class="logo"><span>DMooc</span></h1>
				<span class="slogan">教师后台管理系统</span>
            </div><!--logo-->
            
            <br clear="all" /><br />
            
            <c:if test="${param.error!=null}">  
				<div class="loginmsg">密码不正确.</div>
            </c:if>
            <div >
            	<div class="loginmsg" id="loginmsg"></div>
            </div>
            
            <form id="teacherLoginForm" action="/dmooc-lich/login" method="post">
                <div class="username">
                	<div class="usernameinner">
                    	<input type="text" name="username" id="username" required="required" oninvalid="setCustomValidity('请输入用户名')" oninput="setCustomValidity('');" placeholder="用户名" />
                    </div>
                </div>
                <div class="password">
                	<div class="passwordinner">
                    	<input type="password" name="password" id="password" required="required" oninvalid="setCustomValidity('请输入密码')" oninput="setCustomValidity('');" placeholder="密码" />
                    </div>
                </div>
                <div>
                	<img id="imgObj" alt="" src="/dmooc-lich/teacher/getVerifyCodeImg"/>  
                </div>
                <div class="username">
               		<input type="text" name="verifyCode" id="verifyCode" required="required" oninvalid="setCustomValidity('请输入验证码')" oninput="setCustomValidity('');" placeholder="请输入验证码,区分大小写"/>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" 	value="${_csrf.token}" />
				<div>
                	<button>登录</button>
                </div>
                <div class="register">
                	<a href="/dmooc-lich/teacher/registerPage">立即注册</a>
                </div>
            </form>
            
        </div><!--loginboxinner-->
    </div><!--loginbox-->


   <!--  <input id="veryCode" name="veryCode" type="text"/>  
    <img id="imgObj" alt="" src="/dmooc-lich/teacher/verifyCode"/>  
    <a href="#" onclick="changeImg()">换一张</a>  
    <input type="button" value="验证" onclick="isRightCode()"/>  
    <div id="info"></div>  -->
</body>
</html>