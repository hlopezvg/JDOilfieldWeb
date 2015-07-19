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
			                 <spring:bind path="userUpdate.password">
                                    <input type="hidden" name="password" value="${userUpdate.password}" />
                                </spring:bind>
				<br />
				<fieldset class="fieldsetInterno">
				<!--  THIS IS FOR THE NEW ROLE_COBRANZA_ADD_USER -->
					<core:if test="${sessionScope.user.roleId == 9 }">
						<core:set var="addOnlyClient" value="true"/>
						<core:set var="editMode" value='disabled="disabled"'/>
						<script>
							console.log("VALIDATING_ROLES");
						</script>
					</core:if>
					<!--  END OF ROLE COBRANZA ADD USER -->
					<legend>Update user </legend>
					<table width="70%" border="0" cellpadding="0" cellspacing="0">
						<spring:hasBindErrors name="userUpdate">
							<core:if test="${errors.errorCount>0}">
								<tr align="left">
									<td colspan="4"><spring:hasBindErrors name="userUpdate">
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
							<td width="31%" align="left"><spring:bind path="userUpdate.login">
									<input type="text" name="login" maxlength="20" value="${userUpdate.login}" />
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr align="left">
							<td>New Password*:</td>
							<td><spring:bind path="userUpdate.newPassword1">
									<input type="password" name="newPassword1" maxlength="20" value="${userUpdate.newPassword1}" />
								</spring:bind>
							</td>
						</tr>
						<tr align="left">
                            <td>Confirm New Password*:</td>
                            <td><spring:bind path="userUpdate.newPassword2">
                                    <input type="password" name="newPassword2" maxlength="20" value="${userUpdate.newPassword2}" />
                                </spring:bind>
                            </td>
                        </tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr align="left">
							<td>Name*:</td>
							<td><spring:bind path="userUpdate.userName">
									<input type="text" name="userName" maxlength="20" value="${userUpdate.userName}" />
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr align="left">
							<td>e-mail:</td>
							<td><spring:bind path="userUpdate.email">
									<input type="text" name="email" maxlength="80" value="${userUpdate.email}" />
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr align="left">
							<td>Role*:</td>
							<td><spring:bind path="userUpdate.roleId">
									<select name="roleId"  ${editMode}>
										<option value="0">Select a role:</option>
										<core:forEach items='${lists.roles}' var="rol" varStatus="r">
											<core:choose>
												<core:when test="${userUpdate.roleId==rol.id}">
													<option value="${rol.id}" selected="selected">${rol.name}</option>
												</core:when>
												<core:otherwise>
													<option value="${rol.id}">${rol.name}</option>
												</core:otherwise>
											</core:choose>
										</core:forEach>
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
							<td align="left"><spring:bind path="userUpdate.clientCode">
									<select name="clientCode" ${editMode}>
										<option value="">Select a customer:</option>
										<core:forEach items='${lists.partners}' var="partner" varStatus="p">
											<core:choose>
												<core:when test="${userUpdate.clientCode!=null && userUpdate.clientCode==partner.cardcode}">
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
							<td align="left"><spring:bind path="userUpdate.idSupervisor">
									<select name="idSupervisor" id="idSupervisor_"   onchange="idContacto()">
										<option>Seleccione un contacto en J&amp;DOilField:</option>
										<core:forEach items='${lists.supervisors}' var="sup" varStatus="s">
											<core:choose>
												<core:when test="${userUpdate.idSupervisor!=null && userUpdate.idSupervisor==sup.id}">
													<option value="${sup.id}" selected="selected">${sup.userName}</option>
												</core:when>
												<core:otherwise>
													<option value="${sup.id}">${sup.userName}</option>
												</core:otherwise>
											</core:choose>
										</core:forEach>
									</select>
								</spring:bind>
							</td>
						</tr>
						<script>
						     function idContacto(){
						    	 var select = document.getElementById('idSupervisor_');	
						    	 alert(select.options[select.selectedIndex].value);
						     }
						</script>
						
						<tr>
							<td>&nbsp;</td>
							<td align="center">&nbsp;</td>
						</tr>
						<tr align="left">
							<td>Device id:</td>
							<td><spring:bind path="userUpdate.deviceId">
									<input type="text" name="deviceId" maxlength="20" value="${userUpdate.deviceId}" />
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
							<td><input type="submit" name="submit" value="Update" /></td>
							<td align="center">&nbsp;</td>
							<td align="center"><input type="reset" name="reset" value="Reset" /></td>
						</tr>
					</table>
				</fieldset>
			</form>
		</td>
	</tr>
</table>
