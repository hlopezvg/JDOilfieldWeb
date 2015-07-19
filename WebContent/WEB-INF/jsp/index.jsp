<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<form method="post" action="./j_spring_security_check">
	<div class="redText">
		<core:choose>
			<core:when test="${param.login_error==1}">
				<fmt:message key="errors.auth.invalid" />
			</core:when>
			<core:when test="${param.login_error==2}">
				<fmt:message key="errors.session.expired" />
			</core:when>
		</core:choose>
	</div>
	<fieldset class="fieldsetInterno">
		<legend>Sign in</legend>
		<table width="75%" border="0" cellpadding="0" cellspacing="0">
			<tr align="left">
				<td rowspan="2"><img src="images/keys_64x64.gif" alt="" />
				</td>
				<td>Login:</td>
				<td><input type="text" name="j_username" /></td>
			</tr>
			<tr align="left">
				<td>Password:</td>
				<td><input type="password" name="j_password" /></td>
			</tr>
		</table>
		<table width="220">
			<tr>
				<td align="right"><input type="submit" name="ok" value="Sign in" />
				</td>
			</tr>
			<tr>
				<td align="center"><a href="forgotPassword.htm">Forgot your password</a>
				</td>
			</tr>
		</table>
	</fieldset>
</form>
<div id="botton_wrapper">
	<div id="img_bottom"><img height="30px" width="60px"   src="images/RapidSSL_SEAL-90x50.gif"/></div>
</div>