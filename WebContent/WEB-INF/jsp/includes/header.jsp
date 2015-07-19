<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<table width="100%">
	<tr>
		<td width="30%" align="left"><img src="images/logo.gif" alt="logo_home" /></td>
		<td width="70%" align="right" valign="middle" class="ocultar_print">
			<a href="changePassword.htm">
				<img border="0" title="<fmt:message key='icons.tooltip.password'/>" src="images/keys_22x22.gif" alt="image" />
				Change Password
			</a> 
			<a href="signout.htm" style="margin-left: 5px">
				<img border="0" title="<fmt:message key='icons.tooltip.logout'/>" src="images/logout_22x22.gif" alt="image" />
				Sign out
			</a>
			<div align="right" style="margin-top: 10px">
				<core:choose>
					<core:when test="${param.m==1}">
						<strong><em>Welcome ${user.userName} </em></strong>
					</core:when>
					<core:otherwise>
						User: <strong><em>${user.userName} </em></strong>
					</core:otherwise>
				</core:choose>
			</div>
		</td>
	</tr>
</table>
