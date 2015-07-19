<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="3" align="center">
			<div class="redText">${msg}</div>
			<form name="form" action="" method="post">
				<br/>
				<fieldset>
					<legend>Search</legend>
					<table width="95%" border="0" cellpadding="5" cellspacing="5">
						<core:if test="${infoClient==null}">
							<tr>
								<td width="11%" align="left">Customer:</td>
								<td colspan="4" align="left"><spring:bind path="search.codeClient">
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
									</spring:bind></td>
							</tr>
						</core:if>
						<tr>
							<td align="left">Document Type:</td>
							<td width="30%" align="left"><spring:bind path="search.documentType">
									<select name="documentType">
										<option value="">All</option>
										<core:forEach items='${searchLists.types}' var="t">
											<core:set var="docType" value="${t.id.doctype}+${t.id.subtype}" />

											<core:choose>
												<core:when test="${docType==search.documentType}">
													<option value="${t.id.doctype}+${t.id.subtype}" selected="selected">${t.name}</option>
												</core:when>
												<core:otherwise>
													<option value="${t.id.doctype}+${t.id.subtype}">${t.name}</option>
												</core:otherwise>
											</core:choose>
										</core:forEach>
									</select>
								</spring:bind></td>
							<td width="16%" align="left">Month: <spring:bind path="search.month">
									<select name="month">
										<core:forEach items="${searchLists.months}" var="m" varStatus="c">
											<core:choose>
												<core:when test="${(c.count)==search.month}">
													<option value="${c.count}" selected="selected">${m}</option>
												</core:when>
												<core:otherwise>
													<option value="${c.count}">${m}</option>
												</core:otherwise>
											</core:choose>
										</core:forEach>
									</select>
								</spring:bind> &nbsp;&nbsp;</td>
							<td width="17%" align="left">Year: <spring:bind path="search.year">
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
							<td width="26%" align="left">
								<table width="207" border="0" align="right">
									<tr>
										<td width="141" align="right">Results per page: <spring:bind path="search.numRows">
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
										<td width="56" align="right"><input type="submit" name="SubmitButton" value="Search" />
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</fieldset>
			</form> 
			<%@include file="./includes/clientInfo.jsp"%>
		</td>
	</tr>
	<tr>
	<script>
	$(document).ready(function() 
		    { 
		        $("#documentsTbl").tablesorter(); 
		    } 
		); 
	</script>
	
   
		<td colspan="3" align="center">
			<core:choose>
				<core:when test="${results.totalRows==0}">
					<div class="redText">
						<fmt:message key="results.zero" />
					</div>
				</core:when>
				<core:otherwise>
					<table id="documentsTbl" class="tablesorter">
						<thead>
							<tr>
								<core:if test="${infoClient==null}">
									<th width="7%">Customer Code</th>
									<th width="12%">Customer Name</th>
								</core:if>
								<th width="10%">Doc. Type</th>
								<th width="5%">Doc. Class</th>
								<th width="5%">Doc. Number</th>
								<th width="10%">Date</th>
								<th width="10%">Due date</th>
								<th width="10%">Base Amount</th>
								<th width="8%">% Discount</th>
								<th width="8%">Total Tax</th>
								<th width="6%">Total</th>
								<th width="4%">Currency</th>
								<th width="5%">Doc. Detail</th>
							</tr>
						</thead>
						<core:forEach items='${results.list}' var="document" varStatus="vs">							
							<core:choose>
							<core:when test="${(document.documentType.doctype ne 17) && (document.docstatus ne 'O')}">
							</core:when>
							<core:otherwise>
							<core:if test='${vs.count mod 2 eq 0}'>
							<core:set var="color" value="row1" />
							</core:if>
							<core:if test='${vs.count mod 2 != 0}'>
								<core:set var="color" value="row2" />
							</core:if>
							<tr class="${color}">
								<core:if test="${infoClient==null}">
									<td>${document.businessPartner.cardcode}</td>
									<td align="left"><span>${document.businessPartner.cardname}</span>
									</td>
								</core:if>
								
								<!-- Aqui vamos a pintar primero ordenes de venta que es con esta condicion 
								       d.documentType.id.doctype=17 and d.docstatus='O'
									   d.documentType.id.doctype=13  docsubtype=null
									   d.documentType.id.doctype=14
									   d.documentType.id.doctype=13 &&   [docsubtype]=DN-->
								
								<td align="left">${document.documentType.name}</td>
									<td align="center">${document.docclass}</td>
									<td align="center">${document.docnum}</td>
									<td align="center"><fmt:formatDate value="${document.docdate}" pattern="yyyy-MM-dd hh:mm:ss" />
									</td>
									<td align="center"><fmt:formatDate value="${document.docduedate}" pattern="yyyy-MM-dd hh:mm:ss" />
									</td>
									<td align="right"><fmt:formatNumber value="${document.baseamnt}" pattern="#,##0.00" />
									</td>
									<td align="right"><fmt:formatNumber value="${document.discprcnt}" pattern="#,##0.00" />
									</td>
									<td align="right"><fmt:formatNumber value="${document.vatsum}" pattern="#,##0.00" />
									</td>
									<fmt:formatNumber value="${document.doctotal}" pattern="#,##0.00" var="total"/>
									<td align="right"><core:out value="${total}" />
									</td>
									<td align="right">${document.currency}</td>
									<td align="center">
										<a href="documentDetail.htm?id=${document.id.docentry}*${document.id.doctype}">
											<img border="0" src="images/details_16x16.gif" title="<fmt:message key='icons.tooltip.detail'/>"
											width="17" height="17" alt="viewDetail"/>
										</a>
								</td>
								</tr>
								</core:otherwise>
								</core:choose>	
								
								<!-- ///////////////////********************************//////////////////// -->
								<core:choose>
								<core:when test="${(document.documentType.doctype ne 13)}">
								</core:when>
								<core:otherwise>
								<core:if test='${vs.count mod 2 eq 0}'>
								<core:set var="color" value="row1" />
								</core:if>
								<core:if test='${vs.count mod 2 != 0}'>
									<core:set var="color" value="row2" />
								</core:if>
								<tr class="${color}">
									<core:if test="${infoClient==null}">
										<td>${document.businessPartner.cardcode}</td>
										<td align="left"><span>${document.businessPartner.cardname}</span>
										</td>
									</core:if>
									<td align="left">${document.documentType.name}</td>
										<td align="center">${document.docclass}</td>
										<td align="center">${document.docnum}</td>
										<td align="center"><fmt:formatDate value="${document.docdate}" pattern="yyyy-MM-dd hh:mm:ss" />
										</td>
										<td align="center"><fmt:formatDate value="${document.docduedate}" pattern="yyyy-MM-dd hh:mm:ss" />
										</td>
										<td align="right"><fmt:formatNumber value="${document.baseamnt}" pattern="#,##0.00" />
										</td>
										<td align="right"><fmt:formatNumber value="${document.discprcnt}" pattern="#,##0.00" />
										</td>
										<td align="right"><fmt:formatNumber value="${document.vatsum}" pattern="#,##0.00" />
										</td>
										<fmt:formatNumber value="${document.doctotal}" pattern="#,##0.00" var="total"/>
										<td align="right"><core:out value="${total}" />
										</td>
										<td align="right">${document.currency}</td>
										<td align="center">
											<a href="documentDetail.htm?id=${document.id.docentry}*${document.id.doctype}">
												<img border="0" src="images/details_16x16.gif" title="<fmt:message key='icons.tooltip.detail'/>"
												width="17" height="17" alt="viewDetail"/>
											</a>
									</td>
									</tr>
									</core:otherwise>
									</core:choose>	
								<!-- ///////////////////********************************//////////////////// -->
								
								<!-- ///////////////////********************************//////////////////// -->
								<core:choose>
								<core:when test="${(document.documentType.doctype ne 14)}">
								</core:when>
								<core:otherwise>
								<core:if test='${vs.count mod 2 eq 0}'>
								<core:set var="color" value="row1" />
								</core:if>
								<core:if test='${vs.count mod 2 != 0}'>
									<core:set var="color" value="row2" />
								</core:if>
								<tr class="${color}">
									<core:if test="${infoClient==null}">
										<td>${document.businessPartner.cardcode}</td>
										<td align="left"><span>${document.businessPartner.cardname}</span>
										</td>
									</core:if>
									<td align="left">${document.documentType.name}</td>
										<td align="center">${document.docclass}</td>
										<td align="center">${document.docnum}</td>
										<td align="center"><fmt:formatDate value="${document.docdate}" pattern="yyyy-MM-dd hh:mm:ss" />
										</td>
										<td align="center"><fmt:formatDate value="${document.docduedate}" pattern="yyyy-MM-dd hh:mm:ss" />
										</td>
										<td align="right"><fmt:formatNumber value="${document.baseamnt}" pattern="#,##0.00" />
										</td>
										<td align="right"><fmt:formatNumber value="${document.discprcnt}" pattern="#,##0.00" />
										</td>
										<td align="right"><fmt:formatNumber value="${document.vatsum}" pattern="#,##0.00" />
										</td>
										<fmt:formatNumber value="${document.doctotal}" pattern="#,##0.00" var="total"/>
										<td align="right"><core:out value="${total}" />
										</td>
										<td align="right">${document.currency}</td>
										<td align="center">
											<a href="documentDetail.htm?id=${document.id.docentry}*${document.id.doctype}">
												<img border="0" src="images/details_16x16.gif" title="<fmt:message key='icons.tooltip.detail'/>"
												width="17" height="17" alt="viewDetail"/>
											</a>
									</td>
									</tr>
									</core:otherwise>
									</core:choose>	
								<!-- ///////////////////********************************//////////////////// -->
								
								<!-- ///////////////////********************************//////////////////// -->
								<core:choose>
								<core:when test="${(document.documentType.doctype ne 13) && (d.docsubtype ne 'DN')}">
								</core:when>
								<core:otherwise>
								<core:if test='${vs.count mod 2 eq 0}'>
								<core:set var="color" value="row1" />
								</core:if>
								<core:if test='${vs.count mod 2 != 0}'>
									<core:set var="color" value="row2" />
								</core:if>
								<tr class="${color}">
									<core:if test="${infoClient==null}">
										<td>${document.businessPartner.cardcode}</td>
										<td align="left"><span>${document.businessPartner.cardname}</span>
										</td>
									</core:if>
									
									<td align="left">${document.documentType.name}</td>
										<td align="center">${document.docclass}</td>
										<td align="center">${document.docnum}</td>
										<td align="center"><fmt:formatDate value="${document.docdate}" pattern="yyyy-MM-dd hh:mm:ss" />
										</td>
										<td align="center"><fmt:formatDate value="${document.docduedate}" pattern="yyyy-MM-dd hh:mm:ss" />
										</td>
										<td align="right"><fmt:formatNumber value="${document.baseamnt}" pattern="#,##0.00" />
										</td>
										<td align="right"><fmt:formatNumber value="${document.discprcnt}" pattern="#,##0.00" />
										</td>
										<td align="right"><fmt:formatNumber value="${document.vatsum}" pattern="#,##0.00" />
										</td>
										<fmt:formatNumber value="${document.doctotal}" pattern="#,##0.00" var="total"/>
										<td align="right"><core:out value="${total}" />
										</td>
										<td align="right">${document.currency}</td>
										<td align="center">
											<a href="documentDetail.htm?id=${document.id.docentry}*${document.id.doctype}">
												<img border="0" src="images/details_16x16.gif" title="<fmt:message key='icons.tooltip.detail'/>"
												width="17" height="17" alt="viewDetail"/>
											</a>
									</td>
									</tr>
									</core:otherwise>
									</core:choose>	
								<!-- ///////////////////********************************//////////////////// -->
								
						</core:forEach>
						</table>
						
						<tr bgcolor="#E6E6E6">
							<td colspan="12" bgcolor="#E6E6E6"><t:pagination page="documents.htm"
									numPage="${requestScope.numPage}" total="${results.totalRows}" numRows="${search.numRows}"
									totalPages="${results.totalPages}">
								</t:pagination>
							</td>
						</tr>
					
				</core:otherwise>
			</core:choose>
		</td>
	</tr>
</table>