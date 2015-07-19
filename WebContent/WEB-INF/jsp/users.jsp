<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="3" align="center">
			<div class="redText">${sessionScope.msg}</div> <core:set var="msg" value="${null}" scope="session" />
			<form name="form" action="" method="post">
				<br />
				<fieldset style="width: 500px;">
				
				<!--  THIS IS FOR THE NEW ROLE_COBRANZA_ADD_USER -->
					<core:if test="${sessionScope.user.roleId == 9 }">
						<core:set var="addOnlyClient" value="true"/>
						<core:set var="editMode" value='disabled="disabled"'/>
						<script>
							console.log("VALIDATING_ROLES");
						</script>
					</core:if>
					<!--  END OF ROLE COBRANZA ADD USER -->
					
					<legend>Search</legend>
					<table width="95%" border="0" cellpadding="6" cellspacing="6">
						<tr>
							<td width="41%">User: <spring:bind path="search.login">
									<input type="text" name="login" value="${search.login}" />
								</spring:bind>
							</td>
							<td width="28%">Role: <spring:bind path="search.role">
									<select name="role">
										<option value="0">All</option>
										<core:forEach items='${searchLists.roles}' var="rol" varStatus="r">
											<core:choose>
												<core:when test="${rol.id==search.role}">
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
							<td width="31%">&nbsp;</td>
						</tr>
					</table>
					<table width="220" border="0" align="right">
						<tr>
							<td>Results per page: <spring:bind path="search.numRows">
									<select name="numRows">
										<core:forEach begin='10' end='100' step='10' var="count">
											<core:choose>
												<core:when test="${count==search.numRows}">
													<option value="${count}" selected="selected">${count}</option>
												</core:when>
												<core:otherwise>
													<option value="${count}">${count}</option>
												</core:otherwise>
											</core:choose>
										</core:forEach>
									</select>
								</spring:bind>
							</td>
							<td align="right"><input type="submit" name="SubmitButton" value="Search" /></td>
						</tr>
					</table>
				</fieldset>
			</form>
		</td>
	</tr>
	<tr>
		<td colspan="3" align="center"><core:if test="${menu[sessionScope.m].insert}">
				<table width="60%" border="0">
					<tr>
						<td align="right"><a href="userAdd.htm?action=add" title="<fmt:message key='icons.tooltip.insert'/>">
								<img border="0" src="images/add_16x16.gif" title="<fmt:message key='icons.tooltip.insert'/>" width="16"
								height="16" alt="addUser"/> New User </a></td>
					</tr>
				</table>
			</core:if> <core:choose>
				<core:when test="${results.totalRows==0}">
					<div class="redText"><fmt:message key="results.zero" /></div>
				</core:when>
				<core:otherwise>
					<table width="60%" border="0" cellpadding="1" cellspacing="1" align="center" class="borde">
						<thead>
							<tr>
								<th width="20%">Login</th>
								<th width="30%">Name</th>
								<th width="30%">Role</th>
								<th width="20%" colspan="2">Operations</th>
							</tr>
						</thead>
						<core:forEach items='${results.list}' var="user" varStatus="vs">
							<core:if test='${vs.count mod 2 eq 0}'>
								<core:set var="color" value="row1" />
							</core:if>
							<core:if test='${vs.count mod 2 != 0}'>
								<core:set var="color" value="row2" />
							</core:if>
							<tr class="${color}">
								<td align="left">${user.login}</td>
								<td align="left">${user.userName}</td>
								<td align="left">${user.role.name}</td>
								<td width="10%" align="center"><core:if test="${menu[sessionScope.m].update}">
										<a href="userUpdate.htm?action=update&amp;id=${user.id}"> <img border="0" src="images/modificar.gif"
											title="<fmt:message key='icons.tooltip.modify'/>" width="17" height="17" alt="modificar"/> </a>
									</core:if>
								</td>
								<td width="10%" align="center">
								    <core:if test="${menu[sessionScope.m].delete}">
										<a href="#" onclick="confirmDelete('${user.login}', 'userDelete.htm?id=${user.id}','User')"> <img
											border="0" src="images/delete_20x20.gif" title="<fmt:message key='icons.tooltip.delete'/>" width="20"
											height="20" alt="confirmDelete"/> </a>
									</core:if>
								</td>
							</tr>
						</core:forEach>
						<tr bgcolor="#E6E6E6">
							<td colspan="5"><t:pagination page="users.htm" numPage="${requestScope.numPage}"
									total="${results.totalRows}" numRows="${search.numRows}" totalPages="${results.totalPages}">
								</t:pagination>
							</td>
						</tr>
					</table>
				</core:otherwise>
			</core:choose>
		</td>
	</tr>
</table>
