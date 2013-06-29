<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New User</title>
</head>
<body>


<form:form method="POST" modelAttribute="user" cssClass="form-horizontal">
 <div class="control-group">
 <form:label for="NAME" path="name" cssClass="control-label">姓名：</form:label>
 <div class="controls">
 <form:input path="name" placeholder="姓名"/><form:errors path="name" cssClass="help-inline"/>
 </div>
 </div>
 <div class="control-group">
 <form:label for="GENDER" path="gender" cssClass="control-label">性别：</form:label>
 <div class="controls">
 <form:radiobutton path="gender" value="Male"/>男&nbsp;<form:radiobutton path="gender" value="Female" />女
 <form:errors path="gender" cssClass="help-inline"/>
 </div>
 </div>
 <div class="control-group">
 <form:label for="USERNAME" path="username" cssClass="control-label">帐号：</form:label>
 <div class="controls">
 <form:input path="username" placeholder="帐号"/><form:errors path="username" cssClass="help-inline"/>
 </div>
 </div>
 <div class="control-group">
 <form:label for="PASSWORD" path="password" cssClass="control-label">密码：</form:label>
 <div class="controls">
 <form:password path="password" placeholder="密码"/><form:errors path="password" cssClass="help-inline"/>
 </div>
 </div>
 <div class="form-actions">
 <input type="submit" value="申请注册" class="btn btn-primary" />
 <input type="reset" value="重置" class="btn" />
 </div>
</form:form>
</body>
</html>