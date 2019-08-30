<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>会员信息修改</title>
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/register.css"
	rel="stylesheet" type="text/css" />

<script>
	function checkForm() {
		// 校验用户名:
		// 获得用户名文本框的值:
		var username = document.getElementById("username").value;
		if (username == null || username == '') {
			alert("用户名不能为空!");
			return false;
		}
		var password = document.getElementById("password").value;
		if (password == null || password == '') {
			alert("密码不能为空!");
			return false;
		}
		// 校验密码:
		// 获得密码框的值:
		var password1 = document.getElementById("password1").value;
		if (password1 == null || password1 == '') {
			alert("密码不能为空!");
			return false;
		}
		// 校验确认密码:
		var repassword1 = document.getElementById("repassword1").value;
		if (repassword1 != password1) {
			alert("两次密码输入不一致!");
			return false;
		}
		// 校验email是否为空:
		// 获得email文本框的值:
		var email = document.getElementById("email").value;
		if (email == null || email == '') {
			alert("邮箱不能为空!");
			return false;
		}
	}
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container register">
		<div class="span24">
			<div class="wrap">
				<div class="main clearfix">
					<div class="title">
						<strong>信息修改</strong>USER REGISTER
					</div>
					<div>
						<s:actionerror />
					</div>
					<form id="registerForm"
						action="${ pageContext.request.contextPath }/user_update.action"
						method="post" novalidate="novalidate"
						onsubmit="return checkForm();">
						<input type="hidden" name="uid" value='<s:property value="#session.existUser.uid" />' >
						<table>
							<tbody>
								<tr>
									<th><span class="requiredField">*</span>用户名:</th>
									<td><input type="text" id="username" name="username"
										class="text" maxlength="20" onblur="checkUsername()"
										value='<s:property value="#session.existUser.username" />' />
										<span id="span1"></span></td>
								</tr>
								<tr>
									<th><span class="requiredField">*</span>密&nbsp;&nbsp;码:</th>
									<td><input type="password" id="password" name="password"
										class="text" maxlength="20" autocomplete="off" /> <span><s:fielderror
												fieldName="password" /></span></td>
								</tr>
								<tr>
									<th><span class="requiredField">*</span>新密码:</th>
									<td><input type="password" id="password1" name="password1"
										class="text" maxlength="20" autocomplete="off" /> <span><s:fielderror
												fieldName="password" /></span></td>
								</tr>
								<tr>
									<th><span class="requiredField">*</span>确认密码:</th>
									<td><input id="repassword1" type="password"
										name="repassword1" class="text" maxlength="20"
										autocomplete="off" /></td>
								</tr>
								<tr>
									<th><span class="requiredField">*</span>E-mail:</th>
									<td><input type="text" id="email" name="email"
										class="text" maxlength="200"
										value='<s:property value="#session.existUser.email" />'>
											<span><s:fielderror fieldName="email" /></span></td>
								</tr>
								<tr>
									<th>姓名:</th>
									<td><input type="text" name="name" class="text"
										maxlength="200"
										value='<s:property value="#session.existUser.name" />' /> <span><s:fielderror
												fieldName="name" /></span></td>
								</tr>
								<tr>
									<th>电话:</th>
									<td><input type="text" name="phone" class="text"
										value='<s:property value="#session.existUser.phone" />' /></td>
								</tr>

								<tr>
									<th>地址:</th>
									<td><input type="text" name="addr" class="text"
										maxlength="200"
										value='<s:property value="#session.existUser.addr" />' /> <span><s:fielderror
												fieldName="addr" /></span></td>
								</tr>
								<tr>
									<th>&nbsp;</th>
									<td><input type="submit" class="submit" value="确认修改"></td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
	<div id="_my97DP"
		style="position: absolute; top: -1970px; left: -1970px;">
		<iframe style="width: 190px; height: 191px;"
			src="./会员注册 - Powered By Mango Team_files/My97DatePicker.htm"
			frameborder="0" border="0" scrolling="no"></iframe>
	</div>
</body>
</html>