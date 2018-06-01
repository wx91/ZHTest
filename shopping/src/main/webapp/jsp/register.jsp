<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
	<head></head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>会员登录</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>
<script type="text/javascript">
//var flag = false;//判断用户名是否可用
//var imgFlag=false;//判断验证码
	$(function(){
		
	});
	function checkName(){
		var name =$("#username").val();
		$.get("${pageContext.request.contextPath}/checkUsernameServlet?name="
				+name,function(data){
			if(data==0)//可用
			{
				$("#showName").html("用户名未被注册,可以注册")
				flag=true;
			}else{
				$("#showName").html("用户名已存在！！！")
				flag =false;
			}
			
		});
		return flag;
	}
	function checkPassword(){
		var repwd=$("#confirmpwd").val();
		var pwd=$("#inputPassword3").val();
		if(repwd==pwd)
			{
			$("#pwd").html("可以注册")
			flag=true;
			}else{
				$("#pwd").html("两次密码输入不一致，请重新输入")
				flag=false;
			}
	}
	function checkEmail(){
		var email=$("#inputEmail3").val();
		if(email.length>0){
			var reg= /^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/;
			if(reg.test(email)){
				$("#showemail").html("邮箱可以注册")
				return true;
			}else{
				$("#showemail").html("邮箱输入不正确")
				return false;
			}
		}else{
			$("#showemail").html("邮箱不能为空")
			return false;
		}
	}
	
	function checkImgCode(){
		var img=$("#imgInputCode").val();
		$.get("${pageContext.request.contextPath}/checkImgCodeServlet?code="
				+imgCode,function(data){
			if(data==0)//可用
			{
				$("#showImg").html("验证码正确")
				imgFlag=true;
			}else{
				$("#showImg").html("验证码错误！！！")
				imgFlag =false;
			}
		});
		return imgFlag;1
	}
	
	
	
	function checkAll(){
		var flag =false;
		if(!checkName()){
			flag = false;
		}
		if(!checkPassword()){
			flag=false;
		}
		if(!checkEmail()){
			flag=false;
		}
		if(!checkImgcode()){
			flag=false;
		}
		return flag;
	}
</script>
<style>
  body{
   margin-top:20px;
   margin:0 auto;
 }
 .carousel-inner .item img{
	 width:100%;
	 height:300px;
 }
 .container .row div{ 
	 /* position:relative;
	 float:left; */
 }
 
font {
    color: #3164af;
    font-size: 18px;
    font-weight: normal;
    padding: 0 10px;
}
 </style>
</head>
<body>




		<%@include file="Tab.jsp" %>



<div class="container" style="width:100%;background:url('${pageContext.request.contextPath}/image/regist_bg.jpg');">
<div class="row"> 

	<div class="col-md-2"></div>
	
	


	<div class="col-md-8" style="background:#fff;padding:40px 80px;margin:30px;border:7px solid #ccc;">
		<font>会员注册</font>USER REGISTER
		<form class="form-horizontal" style="margin-top:5px;" method="post" 
		action="${pageContext.request.contextPath }/registerServlet" onsubmit="return checkAll()">
			<input type="hidden" name="method" value="regist">
			 <div class="form-group">
			    <label for="username" class="col-sm-2 control-label">用户名</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="username" placeholder="请输入用户名" name="username" onblur="checkName()" ><span id="showName"></span>
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
			    <div class="col-sm-6">
			      <input type="password" class="form-control" id="inputPassword3" placeholder="请输入密码" name="password">
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
			    <div class="col-sm-6">
			      <input type="password" class="form-control" id="confirmpwd" placeholder="请输入确认密码" onblur="checkPassword()"><span id="pwd"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
			    <div class="col-sm-6">
			      <input type="email" class="form-control" id="inputEmail3" placeholder="Email" name="email" onblur="checkEmail()"><span id="showemail"></span>
			    </div>
			  </div>
			 <div class="form-group">
			    <label for="usercaption" class="col-sm-2 control-label">姓名</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="usercaption" placeholder="请输入姓名" name="name">
			    </div>
			  </div>
			  <div class="form-group opt">  
			  <label for="inlineRadio1" class="col-sm-2 control-label">性别</label>  
			  <div class="col-sm-6">
			    <label class="radio-inline">
			  <input type="radio" name="sex" id="inlineRadio1" value="1"> 男
			</label>
			<label class="radio-inline">
			  <input type="radio" name="sex" id="inlineRadio2" value="0"> 女
			</label>
			</div>
			  </div>		
			  <div class="form-group">
			    <label for="date" class="col-sm-2 control-label">出生日期</label>
			    <div class="col-sm-6">
			      <input type="date" class="form-control"  name="birthday">		      
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="date" class="col-sm-2 control-label">验证码</label>
			    <div class="col-sm-3">
			      <input type="text" class="form-control" id="imgInputcode" onblur="checkImgCode()" >
			      
			    </div>
			    <div class="col-sm-2">
			    <img src="${pageContext.request.contextPath}/createImgServlet">
			    <span id="showImg"></span>
			    </div>
			    
			  </div>
			 
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <input type="submit"  width="100" value="注册" name="submit" border="0"
				    style="background: url('${pageContext.request.contextPath}/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
				    height:35px;width:100px;color:white;">
			    </div>
			  </div>
			</form>
	</div>
	
	<div class="col-md-2"></div>
  
</div>
</div>

	  
	
		<%@include file="bottom.jsp" %>

</body></html>




