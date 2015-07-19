<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<table width="100%" align="center" border="0" cellpadding="0"
	cellspacing="0">
	<tr>
		<td colspan="3" align="center">
			<div class="redText">${sessionScope.msg}</div> <core:set var="msg"
				value="${null}" scope="session" />
			<form name="form" action="" method="post">
				<br />
				<fieldset style="width: 500px;">
					<legend>Search</legend>
					<table width="95%" border="0" cellpadding="6" cellspacing="6">
						<tr>
							<td width="41%">Fuel Card Number: <spring:bind path="search.fuelCardCode">
									<input type="text" name="fuelCardCode" value="${search.fuelCardCode}" />
								</spring:bind>
							</td>

							<td width="28%">Clients: <spring:bind path="search.codeClient">
									<select id='clientsSelect'  name="clients">
										<option value="0">All</option>
										<core:forEach items='${searchLists.clients}' var="client" varStatus="r">
											<core:choose>
												<core:when test="${client.cardcode==search.codeClient}">
													<option value="${client.cardcode}">${client.cardname}</option>
												</core:when>
												<core:otherwise>
													<option value="${client.cardcode}">${client.cardname}</option>
												</core:otherwise>
											</core:choose>
										</core:forEach>
									</select>
								</spring:bind>
								<script>
										var carCodeClientParam;
										$('#clientsSelect').change(function(){
											carCodeClientParam = 'fuelCardAdd.htm?action=add'+'&cardCodeClient='+$('#clientsSelect').val();
											//carCodeClientParam = 'fuelCardAdd.htm?action=add';
											console.log('evaluate the href --> ' + carCodeClientParam);						
											$('#fuelCardHREF').attr('href', carCodeClientParam);	
										});
									</script>
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
							<td align="right"><input type="submit" name="SubmitButton"
								value="Search" /></td>
						</tr>
					</table>
				</fieldset>
			</form>
		</td>
	</tr>
	<tr>
		<td colspan="3" align="center"><core:if
				test="${menu[sessionScope.m].insert}">
				<table width="60%" border="0">
					<tr>
						<td align="right">
							<a id="fuelCardHREF" title="<fmt:message key='icons.tooltip.insert'/>"> <img
									border="0" src="images/add_16x16.gif"
									title="<fmt:message key='icons.tooltip.insert'/>" width="16"
									height="16" alt="addFuelCard" /> New Fuel Card
							</a>
						</td>
					</tr>
				</table>
			</core:if> <core:choose>
				<core:when test="${results.totalRows==0}">
					<div class="redText">
						<fmt:message key="results.zero" />
					</div>
				</core:when>
				<core:otherwise>
					<table width="60%" border="0" cellpadding="1" cellspacing="1"
						align="center" class="borde">
						<thead>
							<tr>
								<th width="50%">Name</th>
								<th width="22%">Fuel Card</th>
								<th width="12%">Aircraft</th>
								<th width="20%" colspan="2">Operations</th>
							</tr>
						</thead>
						<core:forEach items='${results.list}' var="fuelCard" varStatus="vs">
							<core:if test='${vs.count mod 2 eq 0}'>
								<core:set var="color" value="row1" />
							</core:if>
							<core:if test='${vs.count mod 2 != 0}'>
								<core:set var="color" value="row2" />
							</core:if>
							<tr class="${color}">
								<td align="left">${fuelCard.cardCodeName}</td>
								<td align="center">${fuelCard.fuelCardCode}</td>
								<td align="center">${fuelCard.aircraftCode}</td>
								<td width="10%" align="center"><core:if
										test="${menu[sessionScope.m].update}">
										<a href="fuelCardUpdate.htm?action=update&amp;id=${fuelCard.fuelCardCode}">
											<img border="0" src="images/modificar.gif"
											title="<fmt:message key='icons.tooltip.modify'/>" width="17"
											height="17" alt="modificar" />
										</a>
									</core:if></td>
								<td width="10%" align="center"><core:if
										test="${menu[sessionScope.m].delete}">
										<a href="#"
											onclick="confirmDelete('${fuelCard.cardCodeName}', 'fuelCardDelete.htm?id=${fuelCard.fuelCardCode}','Fueld Card')">
											<img border="0" src="images/delete_20x20.gif"
											title="<fmt:message key='icons.tooltip.delete'/>" width="20"
											height="20" alt="confirmDelete" />
										</a>
									</core:if></td>
							</tr>
						</core:forEach>
						<tr bgcolor="#E6E6E6">
							<td colspan="5"><t:pagination page="fuelCards.htm"
									numPage="${requestScope.numPage}" total="${results.totalRows}"
									numRows="${search.numRows}" totalPages="${results.totalPages}">
								</t:pagination></td>
						</tr>
					</table>
				</core:otherwise>
			</core:choose></td>
	</tr>
</table>