<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="3" align="center">
			<table width="90%" border="0" align="center">
                <tr>
                    <td  align="center">
                    <table width="80%" border="0">
                        <tr>
                              <td align="right">
                                   <a href="payments.htm?m=6">
                                   <img border="0" src="images/back.gif" title="<fmt:message key='icons.tooltip.insert'/>" width="16"
                                    height="16" alt="back"/><span>&nbsp;Back to Payments</span> </a>
                             </td>
                            <%--  
                            <td align="right">                                          
                                 <core:if test="${menu[sessionScope.m].insert}">
                                   <a href="paymentRegistry.htm?m=6"  title="<fmt:message key='icons.tooltip.insert'/>" >
                                   <img border="0" src="images/add_16x16.gif" title="<fmt:message key='icons.tooltip.insert'/>" width="16"
                                    height="16" alt="addUser"/><span>Payment Notification</span> </a>
                                </core:if>
                             </td>--%>
                        </tr>
                    </table>
                    
                    </td>
                </tr>
				<tr>
					<td align="center">
						<div class="redText">${msg}</div> <!--<legend>Registro de Pago </legend>-->
						<table width="70%" border="0" cellpadding="1" cellspacing="1">
							<tr>
								<td align="left"><div class="line-separator"></div></td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" class="borde" border="0" cellpadding="1" cellspacing="1" align="center">
										<thead>
											<tr>
												<th align="center">Type</th>
												<th align="center">Number</th>
												<th align="center">Date</th>
												<th align="center">Amount</th>
												<th align="center">Currency</th>
											</tr>
										</thead>
										<core:forEach items='${lists.documents}' var="document" varStatus="vs">
											<core:if test='${vs.count mod 2 eq 0}'>
												<core:set var="color" value="row1" />
											</core:if>
											<core:if test='${vs.count mod 2 != 0}'>
												<core:set var="color" value="row2" />
											</core:if>
											<tr class="${color}">
												<td align="center">${document.documentType.name}</td>
												<td align="center">${document.docnum}</td>
												<td align="center">${document.docdate}</td>
												<fmt:formatNumber value="${document.doctotal}" pattern="#,##0.00" var="total"/>
												<td align="right">${total}</td>
												<td align="right">${document.currency}</td>
											</tr>
										</core:forEach>
									</table> 
									<core:if test="${fn:length(lists.documents)==0}">
										<fmt:message key="results.invoice.zero" />
									</core:if>
								</td>
							</tr>
							<tr>
								<td align="left"><div class="line-separator"></div></td>
							</tr>
						</table>
						<form name="form" action="" method="post">
							<fieldset class="fieldsetInterno">
								<legend>Forma de Pago</legend>
								<p>&nbsp;</p>
								<table width="70%" border="0" cellpadding="6" cellspacing="6">
									<tr align="left">
										<td colspan="2"><spring:hasBindErrors name="payment">
												<core:forEach items="${errors.allErrors}" var="error" varStatus="c">
													<div class="redText">
														-
														<spring:message message="${error}" />
													</div>
												</core:forEach>
											</spring:hasBindErrors>
										</td>
									</tr>
									<tr align="left">
										<td width="26%">Payment type:</td>
										<td width="74%"><spring:bind path="payment.paymentType">
												<select name="paymentType">
													<option value="0">---</option>
													<core:forEach items='${lists.paymentsTypes}' var="type" varStatus="vs">
														<core:choose>
															<core:when test="${type.nameItem==payment.paymentType}">
																<option selected="selected" value="${type.nameItem}">${type.nameItem}</option>
															</core:when>
															<core:otherwise>
																<option value="${type.nameItem}">${type.nameItem}</option>
															</core:otherwise>
														</core:choose>

													</core:forEach>
												</select>
											</spring:bind>
										</td>
									</tr>
									<tr align="left">
										<td><p>Document number:</p></td>
										<td><spring:bind path="payment.documentNumber">
												<input type="text" name="documentNumber" value="${payment.documentNumber}" />
											</spring:bind>
										</td>
									</tr>
									<tr align="left">
										<td>Bank / Account:</td>
										<td><spring:bind path="payment.account">
												<select name="account">
													<option value="0">---</option>
													<core:forEach items='${lists.accounts}' var="a">

														<core:set var="accountCode" value="${a.bank}/${a.account}" scope="page" />
														<core:choose>
															<core:when test="${pageScope.accountCode==payment.account}">
																<option selected="selected" value="${a.bank}/${a.account}">${a.bank} / ${a.account}</option>
															</core:when>
															<core:otherwise>
																<option value="${a.bank}/${a.account}">${a.bank} / ${a.account}</option>
															</core:otherwise>
														</core:choose>
													</core:forEach>
												</select>
											</spring:bind>
										</td>
									</tr>
									<tr align="left">
										<td>Date:</td>
										<td><spring:bind path="payment.paymentDateString">
												<input type="text" name="paymentDateString" class="inputFecha" value="${payment.paymentDateString}"
													readonly="readonly" />
											</spring:bind> <a onclick="displayCalendar(document.forms[0].paymentDateString,'yyyy-mm-dd',this)"> &nbsp;
												&nbsp;<img src="images/almanaque.gif" title="<fmt:message key='icons.tooltip.calendar'/>" border="0"
												width="20" height="16" alt="calendario"/> </a>
										</td>
									</tr>
									<tr align="left">
										<td>Amount:</td>
										<td><spring:bind path="payment.amount">
												<input type="text" name="amount" value="${payment.amount}" />
											</spring:bind>
										</td>
									</tr>
									<tr align="left">
										<td>Currency:</td>
										<td><spring:bind path="payment.currency">
												<select name="currency">
													<option value="0">---</option>
													<core:forEach items='${lists.currencies}' var="c">
														<core:choose>
															<core:when test="${c.currency==payment.currency}">
																<option value="${c.currency}" selected="selected">${c.currency} = ${c.currencyName}</option>
															</core:when>
															<core:otherwise>
																<option value="${c.currency}">${c.currency} = ${c.currencyName}</option>
															</core:otherwise>
														</core:choose>

													</core:forEach>
												</select>
											</spring:bind>
										</td>
									</tr>
									<tr align="left">
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr align="left">
										<td><div align="right">
												<input type="submit" name="SubmitButton" value="Save" />
											</div>
										</td>
										<td><div align="center">
												<input type="reset" name="reset" value="Reset" />
											</div>
										</td>
									</tr>
								</table>
							</fieldset>
						</form>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
			</table>
		</td>
	</tr>
</table>