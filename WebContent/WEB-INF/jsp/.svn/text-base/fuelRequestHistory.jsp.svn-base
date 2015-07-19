<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="3" align="center">
			<div class="redText">${msg}</div>
			<table width="100%" border="0">
				<tr align="left">
					<td valign="top">
						<p align="justify"><span class="Estilo1">Fuel Request Historical</span></p>
					</td>
				</tr>
				<tr>
					<td align="center">
						<table width="90%" border="0" cellpadding="1" cellspacing="1" align="center" class="borde">
							<thead>
								<tr>
									<th>ID</th>
									<th>Cliente</th>
									<th>Status</th>
									<th>Active Date</th>
									<th>Inactive Date</th>
									<th>Last send date</th>
								</tr>
							</thead>
							<tbody>
								<core:forEach items="${fuelRequests.list}" var="fr" varStatus="vs">
									<core:if test='${r.count mod 2 eq 0}'>
										<core:set var="color" value="row1" />
									</core:if>
									<core:if test='${r.count mod 2 != 0}'>
										<core:set var="color" value="row2" />
									</core:if>
									<tr class="${color}">
										<td>${fr.idFuelRequest}</td>
										<td>${fr.cardNameClient}</td>
										<td align="center">
											<core:if test="${fr.status == -1}">
												inactive
										    </core:if> <core:if test="${fr.status == 0}">
												scheduled
										    </core:if> <core:if test="${fr.status == 1}">
												running
										    </core:if> <core:if test="${fr.status == 2}">
												finished
										    </core:if> <core:if test="${fr.status == 3}">
												cancelled
										    </core:if>
										</td>
										<td align="center">
											<core:choose>
												<core:when test="${fr.initDate != null}">
													<fmt:formatDate value="${fr.initDate}" pattern="yyyy-MM-dd" />
												</core:when>
												<core:otherwise>-</core:otherwise>
											</core:choose>
										</td>
										<td align="center">
											<core:choose>
												<core:when test="${fr.endDate != null}">
													<fmt:formatDate value="${fr.endDate}" pattern="yyyy-MM-dd" />
												</core:when>
												<core:otherwise>-</core:otherwise>
											</core:choose>
										</td>
										<td align="center">
											<core:choose>
												<core:when test="${fr.lastDateSent != null}">
													<fmt:formatDate value="${fr.lastDateSent}" pattern="yyyy-MM-dd" />
												</core:when>
												<core:otherwise>-</core:otherwise>
											</core:choose>
										</td>
									</tr>
									<core:set var="N" value="${vs.count}" />
									<core:if test="${not empty fr.airportFuelRequests}">
										<tr>
											<td colspan="6" style="text-align: left;">
												<p>Airports available for recharging fuel:</p>
												<ul>
													<core:forEach items="${fr.airportFuelRequests}" var="ap" varStatus="r">
														<li style="padding: 2px; margin-left: 50px; text-align: left; text-indent: 10px">${ap.code} -
															${ap.name}</li>
													</core:forEach>
												</ul>
											</td>
										</tr>
									</core:if>
								</core:forEach>
								<core:forEach begin="1" end="${5 - N}" step="1" varStatus="r">
									<core:if test='${r.count mod 2 eq 0}'>
										<core:set var="color" value="row1" />
									</core:if>
									<core:if test='${r.count mod 2 != 0}'>
										<core:set var="color" value="row2" />
									</core:if>
									<tr class="${color}">
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
								</core:forEach>
								<tr>
									<td colspan="6">
										<t:pagination page="fuelRequestHistory.htm" numPage="${requestScope.numPage}"
											total="${fuelRequests.totalRows}" numRows="${searchFRH.numRows}"
											totalPages="${fuelRequests.totalPages}" clientCode="${searchFRH.idElement}">
										</t:pagination>
									</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<p style="text-align: center">
	<a href="#" onclick="window.close();">Close Window</a>
</p>
