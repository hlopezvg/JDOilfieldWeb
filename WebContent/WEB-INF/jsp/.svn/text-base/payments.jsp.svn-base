<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="3" align="center">
		<div class="redText">${sessionScope.msg}</div> <core:set var="msg" value="${null}" scope="session" />
			<table width="90%" border="0" align="center">
				<tr>
					<td align="center">
						
						<form name="form" action="" method="post">
						 <br />
							<fieldset>
								<legend>Search</legend>
								<table width="95%" border="0" cellpadding="6" cellspacing="6">
									<spring:hasBindErrors name="search">
										<core:if test="${errors.errorCount>0}">
											<tr align="left">
												<td colspan="4"><spring:hasBindErrors name="search">
														<core:forEach items="${errors.allErrors}" var="error" varStatus="c">
															<div class="redText">- <spring:message message="${error}" /></div>
														</core:forEach>
													</spring:hasBindErrors>
												</td>
											</tr>
										</core:if>
									</spring:hasBindErrors>
									<core:if test="${infoClient==null}">
										<tr>
											<td colspan="4" align="left">Customer: <spring:bind path="search.codeClient">
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
									</core:if>
									<tr align="left">
										<td width="7%" align="left">From:</td>
										<td width="21%" align="left"><spring:bind path="search.fromDate">
												<input type="text" name="fromDate" maxlength="10" value="${search.fromDate}" class="inputFecha" />
											</spring:bind> <a onclick="displayCalendar(document.forms[0].fromDate,'yyyy-mm-dd',this)"> &nbsp; &nbsp;<img
												src="images/almanaque.gif" title="<fmt:message key='icons.tooltip.calendar'/>" border="0" width="20"
												height="16" alt="calendario" /> </a>
										</td>
										<td width="30%" align="left">to: <spring:bind path="search.toDate">
												<input type="text" name="toDate" maxlength="10" value="${search.toDate}" class="inputFecha" />
											</spring:bind> <a onclick="displayCalendar(document.forms[0].toDate,'yyyy-mm-dd',this)"> <img
												src="images/almanaque.gif" title="<fmt:message key='icons.tooltip.calendar'/>" border="0" width="20"
												height="16" alt="calendario" /> </a>
										</td>
										<td width="42%" align="left">
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
													<td align="right"><input type="submit" name="Submit2" value="Search" /></td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</fieldset>
						</form> 
						</td></tr>
		                <tr>
		                    <td  align="center">
		                    <table width="80%" border="0">
			                    <tr>
			                        <td align="right">			                                
			                             <core:if test="${menu[sessionScope.m].insert}">
                                           <a href="paymentRegistry.htm?m=6"  title="<fmt:message key='icons.tooltip.insert'/>" >
                                           <img border="0" src="images/add_16x16.gif" title="<fmt:message key='icons.tooltip.insert'/>" width="16"
                                            height="16" alt="addUser"/><span>Payment Notification</span> </a>
                                        </core:if>
			                         </td>
			                    </tr>
			                </table>
		                    
		                    </td>
		                </tr>
						<tr>
						<td align="center" colspan="3">
						<core:choose>
							<core:when test="${results==null || results.totalRows==0}">
								<div class="redText">
									<fmt:message key="results.zero" />
								</div>
							</core:when>
							<core:otherwise>
								<table width="95%" border="0" cellpadding="1" cellspacing="1" align="center" class="borde">
									<tr>
										<th width="20%" align="center">Customer</th>
										<th width="10%" align="center">Date</th>
										<th width="15%" align="center">Payment type</th>
										<th width="10%" align="center">Payment number</th>
										<th width="15%" align="center">Bank</th>
										<th width="20%" align="center">Account</th>
										<th width="10%" align="center">Amount</th>
										<th width="10%" align="center">Currency</th>
									</tr>
									<core:forEach items='${results.list}' var="p" varStatus="vs">
										<core:if test='${vs.count mod 2 eq 0}'>
											<core:set var="color" value="row1" />
										</core:if>
										<core:if test='${vs.count mod 2 != 0}'>
											<core:set var="color" value="row2" />
										</core:if>
										<tr class="${color}">
											<td align="left">${p.cardname}</td>
											<td align="center">${p.paymentDateString}</td>
											<td align="left">${p.paymentType}</td>
											<td align="left">${p.documentNumber}</td>
											<td align="left">${p.bank}</td>
											<td align="left">${p.account}</td>
											<td align="right"><fmt:formatNumber value="${p.amount}" type="number" pattern="#,##0.00" /></td>
											<td align="center">${p.currency}</td>
										</tr>
									</core:forEach>
									<tr bgcolor="#E6E6E6">
										<td colspan="8" bgcolor="#E6E6E6"><t:pagination page="payments.htm"
												numPage="${requestScope.numPage}" total="${results.totalRows}" numRows="${search.numRows}"
												totalPages="${results.totalPages}">
											</t:pagination>
										</td>
									</tr>
								</table>
							</core:otherwise>
						</core:choose>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>