<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="3" align="center">
			<form name="form" action="" method="post">
				<br />
				<fieldset style="width: 500px;">
					<legend>Search</legend>
					<table width="95%" border="0" cellpadding="6" cellspacing="6">
						<tr>
							<td align="left">&nbsp;&nbsp;&nbsp; Customer: 
								<spring:bind path="search.codeClient">
									<select name="codeClient">
										<option value="0">All</option>
										<core:forEach items='${searchLists.clients}' var="client">
											<core:choose>
												<core:when test="${client.cardcode==search.codeClient}">
													<option value="${client.cardcode}" selected="selected">${client.cardname}</option>
												</core:when>
												<core:otherwise>
													<option value="${client.cardcode}">${client.cardname}</option>
												</core:otherwise>
											</core:choose>
										</core:forEach>
									</select>
								</spring:bind>
							</td>
						</tr>
					</table>
					<table width="220" border="0" align="right">
						<tr>
							<td><spring:bind path="search.numRows">
               Results per page:
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
		<td colspan="3" align="center"><br /> <core:choose>
				<core:when test="${results.totalRows==0}">
					<div class="redText"><fmt:message key="results.zero" /></div>
				</core:when>
				<core:otherwise>
					<table width="70%" border="0" cellpadding="1" cellspacing="1" align="center" class="borde">
						<thead>
							<tr>
								<th width="20%">Customer Code</th>
								<th width="50%">Customer Name</th>
								<th width="10%">Currency</th>
								<th width="20%">Balance</th>
							</tr>
						</thead>
						<core:forEach items='${results.list}' var="bp" varStatus="vs">
							<core:if test='${vs.count mod 2 eq 0}'>
								<core:set var="color" value="row1" />
							</core:if>
							<core:if test='${vs.count mod 2 != 0}'>
								<core:set var="color" value="row2" />
							</core:if>
							<tr class="${color}">
								<td align="left">${bp.cardcode}</td>
								<td align="left"><span>${bp.cardname}</span></td>
								<td align="center"><span>${bp.currency}</span></td>
								<td align="right">
									<core:if test='${bp.clientType == "I"}'>
										<fmt:formatNumber value="${bp.currentBalance_FC}" type="number" pattern="#,##0.00" />
									</core:if> <core:if test='${bp.clientType == "N"}'>
										<fmt:formatNumber value="${bp.currentBalance}" type="number" pattern="#,##0.00" />
									</core:if>
								</td>
							</tr>
						</core:forEach>
						<tr bgcolor="#E6E6E6">
							<td colspan="8" bgcolor="#E6E6E6"><t:pagination page="balances.htm" numPage="${requestScope.numPage}"
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
