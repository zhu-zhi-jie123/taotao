<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	body {
		background-color: f5f5f5;
	}
	#form1 {
		height: 200px;
		width: 500px;	
		margin-top: 300px;
		margin-left: 600px;
	}
	#ISMI_or_SN {
		height: 50px;
		width: 300px;
	}
	#submit {
		height: 50px;
		width: 80px;
	}
</style>
</head>
<body>
	<div id="div1">
		<form id="form1" action="<%=request.getContextPath()%>/SearchServlet" method="post">
			<input id="ISMI_or_SN" type="text" name="ISMI_or_SN" placeholder="请输入ISMI或SN"/>
			<button id="submit" type="submit" onclick="submitFun();">确定</button></br></br>
			<span id="show_dn"><font size="12"><c:if test="${code eq 1 }">${SN }${ISMI }:</c:if>${msg }</font></span>
		</form>
	</div>
</body>
</html>




