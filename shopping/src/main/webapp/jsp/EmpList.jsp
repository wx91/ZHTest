<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<script type="text/javascript">
	function exports() {
		window.open('<%=basePath%>exportEmp');
	}
	function exportsTemplate()
	{
		window.open('<%=basePath%>exportEmpTemplate');
	}
	
	function downTemp()
	{
		window.open('<%=basePath%>downTemp');
	}
	
</script>
</head>
<body>

	<h1>员工信息表</h1>
	<table border="1px" cellspacing="0px" width="800px">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>岗位</th>
			<th>上级</th>
			<th>入职日期</th>
			<th>工资</th>
			<th>部门编号</th>
			<th colspan="2">操作</th>
		</tr>

		<c:forEach items="${empList}" var="emp">
			<tr>
				<td>${emp.empno}</td>
				<td>${emp.ename}</td>
				<td>${emp.job}</td>
				<td>${emp.mgr}</td>
				<td>${emp.hireDate}</td>
				<td>${emp.sal}</td>
				<td>${emp.deptno}</td>
				<td><a href="#">删除</a></td>
				<td><a href="#">更改</a></td>
			</tr>
		</c:forEach>

	</table>
	<button value="导出" id="btn_export" onclick="exports()">导出</button>
	<button value="模板导出" id="btn_export" onclick="exportsTemplate()">模板导出</button>
	<button value="下载指定模板" id="btn_down" onclick="downTemp()">下载指定模板</button>
	<form action="<%=basePath%>uploadExcel" enctype="multipart/form-data"
		method="post">
		<input type="file" name="mutiFile" value="选择文件"> <input
			type="submit" value="导入">

	</form>

</body>
</html>