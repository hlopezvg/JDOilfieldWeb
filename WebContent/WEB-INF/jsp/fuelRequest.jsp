<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<script type="text/javascript">//<![CDATA[
	function resetFields() {
		document.form.fromDate.value = "";
		document.form.toDate.value = "";
		document.form.codeClient.value = "0";
		window.location = '/JDOilField/fuelRequest.htm';
	}

	function validarCheckBoxs() {
		var checkBoxs = document.getElementsByTagName("INPUT");
		var count = 0;
		var i;
		
		for (i = 0; i < checkBoxs.length; i++) {
			if (checkBoxs[i].type == "checkbox") {
				if (checkBoxs[i].checked && !checkBoxs[i].disabled) {
					count = count + 1;
				}
			}
		}
		
		if (count == 0) {
			alert('At least you should select a valid Fuel Request');
			
			return false;
		} else {
			result = confirm('Are you sure you wat to do the operation with the Fuel Request?');
			
			if (result) {
				location.href = fuelRequest.htm;
				
				return true;
			}
			
			if (!result) {
				return false;
			}
		}
	}
//]]></script>

<form name="form" action="" method="post">
	<table width="90%" style="float: center" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td align="center">
				<div class="redText">${sessionScope.msg}</div><core:set var="msg" value="${null}" scope="session" />
				<div class="redText">
					<core:if test="${results.mensaje ne null and results.mensaje eq 'success.send.fuelrequest'}">
						<core:set var="mensaje" value="${results.mensaje}" scope="session" />
						<fmt:message key='${mensaje}' />
						<core:set var="mensaje" value="${null}" scope="session" />
					</core:if>
				</div>
				<%@include file="./includes/clientInfo.jsp"%>
				<table style="float: right">
					<core:choose>
						<core:when test="${sessionScope.user ne null and sessionScope.user.roleId > 0 and sessionScope.user.roleId == 5}">
							<core:set var="apagar" value="disabled='disabled'" />
							<core:set var="blockLink" value="return false" />
						</core:when>
						<core:otherwise>
							<core:set var="apagar" value="" />
							<core:set var="blockLink" value="" />
						</core:otherwise>
					</core:choose>
					<core:if test="${results != null}">
						<tr>
							<td align="left"><input type="submit" ${apagar} name="batchAnnulate" value="Annulate FuelRequest"
								onclick="return validarCheckBoxs();" />
								<img style="border: 0px" src="images/delete_20x20.gif"
									title="<fmt:message key='icons.tooltip.annulate'/>" width="16" height="16" alt="eliminar" />
							</td>
						</tr>
						<tr>
							<td align="left"><input type="submit" size="200" name="batchAnnulate"
								value="    Send FuelRequest    " onclick="return validarCheckBoxs();" />
								<img style="border: 0px" src="images/send_fuel_request_mail.gif"
									title="<fmt:message key='icons.tooltip.send'/>" width="16" height="16" alt="email" />
							</td>
						</tr>
					</core:if>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center">
				<core:choose>
					<core:when test="${results==null || results.totalRows==0}">
						<div class="redText"><fmt:message key="results.zero" /></div>
					</core:when>
					<core:otherwise>
						<table width="100%" border="0" cellpadding="1" cellspacing="1" style="float: center" class="borde">
							<thead>
								<tr>
									<th class="borde" style="width: 25%" rowspan="2">Customer</th>
									<th class="borde" style="width: 9%" rowspan="2">Client Code</th>
									<th class="borde" style="width: 20%" colspan="2">Contract</th>
									<th class="borde" style="width: 20%" colspan="2">Current Period</th>
									<th class="ocultar_print" style="width: 8%" rowspan="2">Last Sent</th>
									<th class="ocultar_print" style="width: 10%" rowspan="2">Status</th>
									<th class="ocultar_print" style="width: 15%" rowspan="5">Operations</th>
								</tr>
								<tr>
									<th class="borde">init</th>
									<th class="borde">end</th>
									<th class="borde">period init</th>
									<th class="borde">period end</th>
								</tr>
							</thead>
							<!-- THIS SECTION LET PRINTS ON JSP THE VALUE O THE LIST SIZE -->
							<core:forEach items='${results.list}' var="fuelRequest" varStatus="vs">
								<core:if test='${vs.count mod 2 eq 0}'>
									<core:set var="color" value="row1" />
								</core:if>
								<core:if test='${vs.count mod 2 != 0}'>
									<core:set var="color" value="row2" />
								</core:if>
								<tr class="${color}">
									<core:if test="${infoClient==null}">
										<!-- TR de Customer -->
										<td class="borde" align="left">
											<core:choose>
												<core:when test="${fuelRequest.businessPartner.cardname != null}">
	    											${fuelRequest.businessPartner.cardname}
	    										</core:when>
												<core:otherwise>
												</core:otherwise>
											</core:choose>
										</td>
									</core:if>
									<!-- TD de Client code -->
									<td class="borde">
										<core:choose>
											<core:when test="${fuelRequest.businessPartner.cardcode != null}">
			    								${fuelRequest.businessPartner.cardcode}
		    								</core:when>
											<core:otherwise>
											</core:otherwise>
										</core:choose>
									</td>
									<!-- TR de Current loading fuel request -->
									<td style="width: 10%" align="center">
										<core:choose>
											<core:when test="${fuelRequest.initDate != null}">
												<fmt:formatDate value="${fuelRequest.initDate}" pattern="yyyy-MM-dd" />
											</core:when>
											<core:otherwise>
											</core:otherwise>
										</core:choose>
									</td>
									<!-- TR de last sent date -->
									<td align="center">
										<core:choose>
											<core:when test="${fuelRequest.endDate != null}">
												<fmt:formatDate value="${fuelRequest.endDate}" pattern="yyyy-MM-dd" />
											</core:when>
											<core:otherwise>
											</core:otherwise>
										</core:choose>
									</td>
									<td align="center">
										<!-- TR de current period init --> 
										<core:choose>
											<core:when test="${fuelRequest != null}">
												<fmt:formatDate value="${fuelRequest.currentDatePeriodInit}" pattern="yyyy-MM-dd" />
											</core:when>
											<core:otherwise>
											</core:otherwise>
										</core:choose>
									</td>
									<!-- TD de current period end -->
									<td align="center">
										<core:choose>
											<core:when test="${fuelRequest != null}">
												<fmt:formatDate value="${fuelRequest.currentDatePeriodEnd}" pattern="yyyy-MM-dd" />
											</core:when>
											<core:otherwise>
											</core:otherwise>
										</core:choose>
									</td>
									<!-- FIN TD de current period end -->
									<!-- TD LAST SENT DATE	-->
									<td align="center">
										<core:choose>
											<core:when test="${fuelRequest != null}">
												<fmt:formatDate value="${fuelRequest.lastDateSent}" pattern="yyyy-MM-dd" />
											</core:when>
											<core:otherwise>
											</core:otherwise>
										</core:choose>
									</td>
									<!-- FIN TD LAST SENT DATE	-->
									<td align="center" class="ocultar_print">
										<core:if test="${fuelRequest.status == -1}">
											inactive
									    </core:if> <core:if test="${fuelRequest.status == 0}">
											scheduled
									    </core:if> <core:if test="${fuelRequest.status == 1}">
											running
									    </core:if>
									</td>
									<td style="width: 40%" align="center" class="ocultar_print"> 
										<a href="fuelRequestUpdate.htm?action=update&amp;id=${fuelRequest.idFuelRequest}&amp;client=${fuelRequest.businessPartner.cardcode}" 
				   							onclick="${blockLink}">
				   							<img style="border: 0px" src="images/schedule_16x16.png"
												title="<fmt:message key='icons.tooltip.schedule'/>" width="16" height="16" alt="schedule" /> 
										</a> 
										<core:set var="hUrl" value="fuelRequestHistory.htm?id=${fuelRequest.businessPartner.cardcode}" /> 
										<core:set var="hUrlP" value="fuelRequestPreview.htm?id=${fuelRequest.idFuelRequest}" />
										<core:set var="options" value="toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,copyhistory=no,resizable=yes" />
										<core:set var="position" value="width=740,height=350,left=270,top=400,screenX=400,screenY=520" />
										<a href="${hUrl}" target="_blank" onclick="return popup(this.href, 'Fuel Request History')"> 
											<img style="border: 0px" src="images/folder.gif" title="<fmt:message key='icons.tooltip.historial'/>"
												width="16" height="16" alt="folder" />
										</a>
										<core:choose>
											<core:when test="${empty fuelRequest.initDate}">
												<a href="#"> 
													<img border="0" src="images/fuel_request_preview.png"
														title="<fmt:message key='icons.tooltip.preview'/>" width="16" height="16" alt="preview" />
												</a>
											</core:when>
											<core:otherwise>
												<a href="${hUrlP}" target="_blank" onclick="return popup(this.href, 'Fuel Request Preview')">
													<img border="0" src="images/fuel_request_preview.png"
														title="<fmt:message key='icons.tooltip.preview'/>" width="16" height="16" alt="preview" />
												</a>
											</core:otherwise>
										</core:choose>
										<core:if test="${fuelRequest.initDate != null}">
											<spring:bind path="search.listFuelRequestId[${vs.index}].annulateSend">
												<input type="hidden" name="_<core:out value="${status.expression}"/>" />
												<input type="checkbox" title="<fmt:message key='icons.tooltip.annulate'/>"
													name="<core:out value="${status.expression}"/>" value="true" />
											</spring:bind>
										</core:if>
										<core:if test="${empty fuelRequest.initDate}">
											<input type="checkbox" disabled="disabled" />
										</core:if>
									</td>
								</tr>
							</core:forEach>
						</table>
					</core:otherwise>
				</core:choose>
			</td>
		</tr>
	</table>
</form>
