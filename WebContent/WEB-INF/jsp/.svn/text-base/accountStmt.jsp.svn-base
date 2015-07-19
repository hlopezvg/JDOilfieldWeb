<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
<%
if(session.getAttribute("SESSION")==null )
{
	response.sendRedirect("http://google.com");  
}
%>

	<tr>
		<td colspan="3" align="center">
			<div class="redText">${sessionScope.msg}</div> <core:set var="msg" value="${null}" scope="session" />
			<form name="form" action="" method="post">
				<br />
				<fieldset>
					<legend class="ocultar_print">Search</legend>
					<table width="95%" border="0" cellpadding="6" cellspacing="6">
						<core:if test="${infoClient==null}">
							<tr>
								<td align="left">Customer:</td>
								<td align="left"><spring:bind path="search.codeClient">
										<select name="codeClient">
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
								<td align="left">&nbsp;</td>
							</tr>
						</core:if>
						<tr>
							<td width="9%" align="left">Month:</td>
							<td width="91%" align="left">
								<spring:bind path="search.month">
									<select name="month">
										<core:forEach items="${searchLists.months}" var="m" varStatus="c">
											<core:choose>
												<core:when test="${(c.count )==search.month}">
													<option value="${c.count }" selected="selected">${m}</option>
												</core:when>
												<core:otherwise>
													<option value="${c.count }">${m}</option>
												</core:otherwise>
											</core:choose>
										</core:forEach>
									</select>
								</spring:bind> &nbsp;&nbsp; Year: <spring:bind path="search.year">
									<select name="year">
										<core:forEach begin="${search.initialYear}" end="${search.currentYear}" step="1" var="y">
											<core:choose>
												<core:when test="${y==search.year}">
													<option value="${y}" selected="selected">${y}</option>
												</core:when>
												<core:otherwise>
													<option value="${y}">${y}</option>
												</core:otherwise>
											</core:choose>
										</core:forEach>
									</select>
								</spring:bind>
							</td>
							<td width="91%" align="left">
							
							         
							        <table width="220" border="0" align="right">
									<tr class="ocultar_print">
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
											</spring:bind></td>
										<td align="right"><input type="submit" name="SubmitButton" value="Search" /></td>
									</tr>
								</table>
								<%-- 
								<input type="submit" name="SubmitButton" value="Search" />
								--%>
							</td>
						</tr>
					</table>
				</fieldset>
			</form> 
			<%@include file="./includes/clientInfo.jsp"%>
		</td>
	</tr>
	<tr>
		<td colspan="3" align="center"><br />
			<core:choose>
				<core:when test="${results.totalRows==-1}">
				</core:when>
				<core:when test="${results.totalRows==0}">
					<div class="redText">
						<fmt:message key="results.zero" />
					</div>
				</core:when>
				<core:otherwise>
					<table width="95%" cellpadding="1" cellspacing="1" align="center" class="borde">
						<thead>
							<tr>
								<th width="15%">Document Type</th>
								<th width="10%">Document Number</th>
								<th width="10%">Date</th>
								<th width="30%">Notes</th>
								<th width="15%">Debit</th>
								<th width="15%">Credit</th>
								<th width="5%">Currency</th>
							</tr>
						</thead>
						<core:forEach items='${results.list}' var="accountStmt" varStatus="vs">
							<core:if test='${vs.count mod 2 eq 0}'>
								<core:set var="color" value="row1" />
							</core:if>
							<core:if test='${vs.count mod 2 != 0}'>
								<core:set var="color" value="row2" />
							</core:if>
							<tr class="${color}">
								<td align="left">${accountStmt.documentType.name}</td>
								<td>${accountStmt.docnum}</td>
								<td align="center">${accountStmt.dateDoc}</td>
								<td align="left">${accountStmt.notes}</td>
								<core:if test='${results.businessPartner.clientType == "I"}'>
									<td align="right"><fmt:formatNumber value="${accountStmt.debit_FC}" type="number"
											pattern="#,##0.00" />
									</td>
								</core:if>
								<core:if test='${results.businessPartner.clientType == "N"}'>
									<td align="right"><fmt:formatNumber value="${accountStmt.debit}" type="number" pattern="#,##0.00" />
									</td>
								</core:if>
								<core:if test='${results.businessPartner.clientType == "I"}'>
									<td align="right"><fmt:formatNumber value="${accountStmt.credit_FC}" type="number"
											pattern="#,##0.00" />
									</td>
								</core:if>
								<core:if test='${results.businessPartner.clientType == "N"}'>
									<td align="right"><fmt:formatNumber value="${accountStmt.credit}" type="number" pattern="#,##0.00" />
									</td>
								</core:if>
								<td align="center">${accountStmt.currency}</td>
							</tr>
						</core:forEach>
						 
						<tr bgcolor="#E6E6E6">
							<td colspan="12"><t:pagination page="accountStmt.htm" numPage="${requestScope.numPage}"
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