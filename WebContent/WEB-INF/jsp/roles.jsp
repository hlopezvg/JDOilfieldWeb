<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0" style="margin-top: 20px">
	<tr>
		<td colspan="3" align="center">
			<core:if test="${menu[sessionScope.m].insert}">
				<table width="60%" border="0" align="center">
					<tr>
						<td align="left">&nbsp;</td>
						<td align="right" colspan="2"><br /> <a href="roleAdd.htm?action=add"
							title="<fmt:message key='icons.tooltip.insert'/>"> <img border="0" src="images/add_16x16.gif"
								title="<fmt:message key='icons.tooltip.insert'/>" width="16" height="16" alt="add"/> New Role </a>
						</td>
					</tr>
				</table>
			</core:if>
			<div class="redText">${sessionScope.msg}</div> <core:set var="msg" value="${null}" scope="session" /> <core:choose>
				<core:when test="${results.totalRows==0}">
					<div class="redText"><fmt:message key="results.zero" /></div>
				</core:when>
				<core:otherwise>
					<table width="60%" border="0" cellpadding="1" cellspacing="1" align="center" class="borde">
						<thead>
							<tr>
								<th width="30%">Role Name</th>
								<th width="50%">Description</th>
								<th width="20%" colspan="10">Operations</th>
							</tr>
						</thead>
						<!-- Recorrido de la lista de los roles -->
						<core:forEach items='${results.list}' var="rol" varStatus="r">
							<core:if test='${r.count mod 2 eq 0}'>
								<core:set var="color" value="row1" />
							</core:if>
							<core:if test='${r.count mod 2 != 0}'>
								<core:set var="color" value="row2" />
							</core:if>
							<tr class="${color}">
								<td align="left">${rol.name}</td>
								<td align="left">${rol.description}</td>
								<td width="20%" align="center"><a href="roleUpdate.htm?action=update&amp;id=${rol.id}"> <img
										border="0" src="images/details_16x16.gif" title="<fmt:message key='icons.tooltip.detail'/>" width="17"
										height="17" alt="detail"/> </a>
								</td>
								<td align="center">
									<core:if test="${menu[sessionScope.m].delete}">
										<a href="#" onclick="confirmDelete('${rol.name}', 'roleDelete.htm&amp;id=${rol.id}','role')"> <img
											border="0" src="images/delete_20x20.gif" title="<fmt:message key='icons.tooltip.delete'/>" width="20"
											height="20" alt="delete"/> </a>
									</core:if>
								</td>
							</tr>
						</core:forEach>
						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
									<tr>
										<td colspan="4">&nbsp;</td>
									</tr>
									<tr>
										<td width="26%" align="right">&nbsp;</td>
										<td width="23%" align="center">&nbsp;</td>
										<td width="22%" align="left"></td>
										<td width="29%" align="right"><strong>Total results: ${fn:length(results.list)}</strong></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</core:otherwise>
			</core:choose>
		</td>
	</tr>
</table>
