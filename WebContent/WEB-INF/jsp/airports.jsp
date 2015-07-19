<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td align="center" colspan="3"><br /> <core:if test="${menu[sessionScope.m].insert}">
				<table width="60%" border="0">
					<tr>
						<td align="right">
							<a href="airportAdd.htm?action=add" title="<fmt:message key='icons.tooltip.insert'/>"> 
							<img border="0" src="images/add_16x16.gif"
								title="<fmt:message key='icons.tooltip.insert'/>" width="16" height="16" alt="insertAirport"/>New Airport</a>
						</td>
					</tr>
				</table>
			</core:if> <core:choose>
				<core:when test="${results.totalRows==0}">
					<div class="redText"><fmt:message key="results.zero" /></div>
				</core:when>
				<core:otherwise>
					<div class="redText">${sessionScope.msg}</div>
					<core:set var="msg" value="${null}" scope="session" />
					<table width="60%" border="0" cellpadding="1" cellspacing="1" align="center" class="borde">
						<thead>
							<tr>
								<th width="25%" align="center">Code</th>
								<th width="55%" align="center">Name</th>
								<th width="20%" colspan="2" align="center">Operations</th>
							</tr>
						</thead>
						<!-- Recorrido de la lista de los aeropuertos -->
						<core:forEach items='${results.list}' var="airport" varStatus="r">
							<core:if test='${r.count mod 2 eq 0}'>
								<core:set var="color" value="row1" />
							</core:if>
							<core:if test='${r.count mod 2 != 0}'>
								<core:set var="color" value="row2" />
							</core:if>
							<tr class="${color}">
								<td align="left">${airport.code}</td>
								<td align="left">${airport.name}</td>
								<td width="10%" align="center"><core:if test="${menu[sessionScope.m].update}">
										<a href="airportUpdate.htm?action=update&amp;id=${airport.id}"> <img border="0"
											src="images/modificar.gif" title="<fmt:message key='icons.tooltip.modify'/>" width="17" height="17" alt="modifyAirport"/>
										</a>
									</core:if></td>
								<td width="10%" align="center"><core:if test="${menu[sessionScope.m].delete}">
										<a href="#" onclick="confirmDelete('${airport.code}', 'airportDelete.htm?id=${airport.id}','Airport')">
											<img border="0" src="images/delete_20x20.gif" title="<fmt:message key='icons.tooltip.delete'/>"
											width="20" height="20" alt="deleteAirport"/> </a>
									</core:if></td>
							</tr>
						</core:forEach>
						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
									<tr>
										<td align="right"><strong>Total results: ${fn:length(results.list)}</strong></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</core:otherwise>
			</core:choose> <br />
		</td>
	</tr>
</table>
