<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="3" align="center">
			<table width="600" align="center" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td align="right">
						<p>&nbsp;</p> <a href="users.htm"> <img src="images/back.gif"
							title="<fmt:message key='icons.tooltip.back'/>" border="0" alt="back"/> Back</a>
					</td>
				</tr>
			</table>
			<div class="redText">${msg}</div>
			<form name="form" onsubmit="checkform()" method="post" action="">
				<br />
				<fieldset class="fieldsetInterno">
					<legend>New user </legend>
					<table width="70%" border="0" cellpadding="0" cellspacing="0">
					<!--  THIS IS FOR THE NEW ROLE_COBRANZA_ADD_USER -->
					<core:if test="${sessionScope.user.roleId == 9 }">
						<core:set var="addOnlyClient" value="true"/>
						<script>
							console.log("VALIDATING_ROLES");
						</script>
					</core:if>
					<!--  END OF ROLE COBRANZA ADD USER -->
						<spring:hasBindErrors name="userAdd">
							<core:if test="${errors.errorCount>0}">
								<tr align="left">
									<td colspan="4"><spring:hasBindErrors name="userAdd">
											<core:forEach items="${errors.allErrors}" var="error" varStatus="c">
												<div class="redText">- <spring:message message="${error}" /></div>
											</core:forEach>
										</spring:hasBindErrors>
									</td>
								</tr>
							</core:if>
						</spring:hasBindErrors>
						<tr align="left">
							<td width="28%">Login*:</td>
							<td width="31%" align="left"><spring:bind path="userAdd.login">
									<input type="text" name="login" maxlength="20" value="${userAdd.login}" />
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr align="left">
							<td>Password*:</td>
							<td><spring:bind path="userAdd.password">
									<input type="password" name="password" maxlength="20" value="${userAdd.password}" />
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr align="left">
							<td>Name*:</td>
							<td><spring:bind path="userAdd.userName">
									<input type="text" name="userName" maxlength="20" value="${userAdd.userName}" />
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr align="left">
							<td>e-mail:</td>
							<td><spring:bind path="userAdd.email">
									<input type="text" name="email" maxlength="80" value="${userAdd.email}" />
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr align="left">
							<td>Role*:</td>
							<td><spring:bind path="userAdd.roleId">
									<select name="roleId">
										<option value="0">Select a role:</option>
										<core:choose>
											<core:when test="${addOnlyClient == true}">
												<option value=2>ROLE_CLIENTE</option>
											</core:when>
										<core:otherwise>
											<core:forEach items='${lists.roles}' var="rol" varStatus="r">
												<core:choose>
													<core:when test="${userAdd.roleId==rol.id}">
														<option value="${rol.id}" selected="selected">${rol.name}</option>
													</core:when>
													<core:otherwise>
														<option value="${rol.id}">${rol.name}</option>
													</core:otherwise>
												</core:choose>
											</core:forEach>
										</core:otherwise>
										</core:choose>
										
									</select>
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr align="left">
							<td>Customer</td>
							<td align="left"><spring:bind path="userAdd.clientCode">
									<select name="clientCode">
										<option value="">Select a customer:</option>
										<core:forEach items='${lists.partners}' var="partner" varStatus="p">
											<core:choose>
												<core:when test="${userAdd.clientCode!=null && userAdd.clientCode==partner.cardcode}">
													<option value="${partner.cardcode}" selected="selected">${partner.cardname}</option>
												</core:when>
												<core:otherwise>
													<option value="${partner.cardcode}">${partner.cardname}</option>
												</core:otherwise>
											</core:choose>
										</core:forEach>
									</select>
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td align="center">&nbsp;</td>
						</tr>
						<tr align="left">
							<td>J&amp;DOilField contact:</td>
							<td align="left"><spring:bind path="userAdd.idSupervisor">
									<select name="idSupervisor">
										<option value="0">Seleccione un contacto en J&amp;DOilField:</option>
										<core:forEach items='${lists.supervisors}' var="sup" varStatus="s">
											<option value="${sup.id}">${sup.userName}</option>
										</core:forEach>
									</select>
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td align="center">&nbsp;</td>
						</tr>
						<tr align="left">
							<td>Device id:</td>
							<td><spring:bind path="userAdd.deviceId">
									<input type="text" name="deviceId" maxlength="20" value="${userAdd.deviceId}" />
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td align="center">&nbsp;</td>
						</tr>
					</table>
					<table width="220" border="0" align="center">
						<tr>
							<td><input type="submit" name="submit" value="Save" /></td>
							<td align="center">&nbsp;</td>
							<td align="center"><input type="reset" name="reset" value="Reset" /></td>
						</tr>
					</table>
				</fieldset>
			</form>
		</td>
	</tr>
</table>
