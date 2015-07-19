<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c-rt" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="3" align="center">
			<div class="redText">${msg}</div>
			<form name="form" action="" method="post">
				<br />
				<fieldset style="width: 500px;">
					<legend>Search</legend>
					<table width="100%" border="0" cellpadding="6" cellspacing="6">
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
								<td width="9%" align="left">Customer:</td>
								<td colspan="3" align="left"><spring:bind path="search.codeClient">
										<select name="codeClient">
											<option value="0">Choose a Customer</option>
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
						<tr>
							<td align="left">Product: <spring:bind path="search.codeProduct">
								</spring:bind></td>
							<td width="42%" align="left"><spring:bind path="search.codeProduct">
									<select name="codeProduct">
										<option value="0">Choose a Product</option>
										<core:forEach items='${searchLists.products}' var="product">
											<core:choose>
												<core:when test="${product.itemcode==search.codeProduct}">
													<option value="${product.itemcode}" selected="selected">${product.itemname}</option>
												</core:when>
												<core:otherwise>
													<option value="${product.itemcode}">${product.itemname}</option>
												</core:otherwise>
											</core:choose>
										</core:forEach>
									</select>
								</spring:bind>
							</td>
						</tr>
                        <tr>
            <td align="left" width="8%">From:</td>
                        <td align="left" width="17%">
                            <spring:bind path="search.fromDate">
                                <input type="text" name="fromDate" maxlength="10" value="${search.fromDate}" class="inputFecha" />
                            </spring:bind>
                            <a  onclick="displayCalendar(document.forms[0].fromDate,'yyyy-mm-dd',this)"> &nbsp; &nbsp;
                                <img class="ocultar_print" src="images/almanaque.gif" title="<fmt:message key='icons.tooltip.calendar'/>" border="0" width="20" height="16" /> 
                            </a>
                        </td>
                         <td></td>
                         <td></td>
                        <%-- 
                        <td align="left" width="3%">to:</td>
                        <td align="left" width="36%">
                            <spring:bind path="search.toDate">
                                <input type="text" name="toDate" maxlength="10" value="${search.toDate}" class="inputFecha" />
                            </spring:bind>
                            <a  onclick="displayCalendar(document.forms[0].toDate,'yyyy-mm-dd',this)"> &nbsp; &nbsp;
                                <img class="ocultar_print" src="images/almanaque.gif" title="<fmt:message key='icons.tooltip.calendar'/>" border="0" width="20" height="16" />
                            </a>
                        </td>--%>
		                <td align="left">&nbsp;</td>
		                <td align="left">&nbsp;</td>
		                <td align="right"></td>
		                <td align="right">
                        <input type="submit" name="SubmitButton" value="Search" />  </td>
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
				<core:when test="${results.totalRows == -10}">
					<div class="redText">
						<fmt:message key="results.select.customer" />
					</div>
				</core:when>
			</core:choose> 
			<core:choose>
				<core:when test="${results==null || results.totalRows==0}">
					<div class="redText">
						<fmt:message key="results.zero" />
					</div>
				</core:when>
				<core:otherwise>
					<!-- LISTA DE RESULTADOS -->
					<core:set var="providerCardCode" value="P-0001" />
                    <%--<jsp:useBean id="providerCardCode" type="java.lang.String" />--%>
                    
					<core:if test="${results.businessPartner != null}">
						<table width="70%" border="0" cellpadding="1" cellspacing="1" align="center" class="borde">
							<thead>
								<tr>
								    <th  align="center">Pricelist</th>
									<th  align="center">Product</th>
									<th  align="center">Period</th>
									<th  align="center">Price</th>
									<th  align="center">Currency</th>
									<th  align="center">Last Update</th>
									<th  align="center">Price Type</th>
								</tr>
							</thead>
							<%--<core:forEach items="${results.list}" var="price" varStatus="vs">--%>
							<core:forEach  items="${results.list}" var="price" varStatus="vs">
								<core:if test='${vs.count mod 2 eq 0}'>
									<core:set var="color" value="row1" />
								</core:if>
								<core:if test='${vs.count mod 2 != 0}'>
									<core:set var="color" value="row2" />
								</core:if>
								<tr class="${color}">
									<%--<td align="left"><core:if test="${price.product!=null}">${price.product.itemname}</core:if></td>--%>
									<td>${price.id.pricelist}</td>
									<td align="left">${price.productId}</td>
									<td align="center">
										<fmt:formatDate value="${price.datefirst}" pattern="yyyy-MM-dd" /> - <fmt:formatDate
											value="${price.datelast}" pattern="yyyy-MM-dd" />
									</td>
									<td align="right"><fmt:formatNumber value="${price.price}" type="number" pattern="#,##0.00" /></td>
									<td align="center">${price.currency}
									       <%-- 
									       <core:choose>
										       <core:when test="${fn:length(price.currency)==0}">${price.lastCurrency}</core:when>
										       <core:otherwise>${price.currency}</core:otherwise>
									       </core:choose>
									       --%>
									</td>
									<td align="center"><fmt:formatDate value="${price.lastUpdate}" pattern="yyyy-MM-dd hh:mm:ss" /></td>
									<td>
									<core:choose>
									   <core:when test='${fn:toLowerCase(infoClient.clientType) == fn:toLowerCase("I")}'>International</core:when>
									   <core:otherwise>
										<core:choose>
										   <core:when test='${fn:toLowerCase(price.cardcode)== fn:toLowerCase(providerCardCode)}'>International</core:when>
										   <core:otherwise>National</core:otherwise>
										</core:choose>
										</core:otherwise>
									</core:choose>	
									</td>
								</tr>
							</core:forEach>
						</table>
					</core:if>
				</core:otherwise>
			</core:choose>
		</td>
	</tr>
</table>