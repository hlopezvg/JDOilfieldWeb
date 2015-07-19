<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<meta http-equiv="refresh"
	content="<%=session.getMaxInactiveInterval()%>">
</head>
<body>
	<table width="100%" align="center" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td colspan="3" align="center">
				<div class="redText">
					<br />${msg}
				</div>

				<form name="form" method="post">

					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<spring:hasBindErrors name="passwordChange">
						<core:forEach items="${errors.allErrors}" var="error"
							varStatus="c">
							<div class="redText">
								-
								<spring:message message="${error}" />
							</div>
						</core:forEach>
					</spring:hasBindErrors>
					<p>&nbsp;</p>
					<fieldset class="fieldsetInterno">
						<legend> Change password </legend>
						<table width="80%" border="0" cellpadding="0" cellspacing="0">
							<tr align="left">
								<td>Current password:</td>
								<td><spring:bind path="passwordChange.password">
										<input type="password" name="password" />
									</spring:bind></td>
							</tr>
							<tr align="left">
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr align="left">
								<td width="28%">New Password:</td>
								<td width="31%"><spring:bind
										path="passwordChange.newPassword">
										<input type="password" name="newPassword" />
									</spring:bind></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr align="left">
								<td>Confirm new password:</td>
								<td><spring:bind path="passwordChange.confirmPassword">
										<input type="password" name="confirmPassword" />
									</spring:bind></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
						</table>
						<table width="220" border="0" align="center">
							<tr>
								<td><input type="submit" name="submit" value="Save" /></td>
								<td align="center">&nbsp;</td>
								<td align="center"><input type="reset" name="reset"
									value="Reset" /></td>
							</tr>
						</table>
					</fieldset>
				</form>
			</td>
		</tr>
	</table>
	<br />
</body>
</html>