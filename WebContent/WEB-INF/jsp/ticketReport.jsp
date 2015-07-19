<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0" style="margin-top: 20px;">
	<tr>
		<td align="center">
			<p>&nbsp;${msg}</p>
			<p>
				<strong>Ticket Detail </strong>
			</p>
			<table width="460" border="0">
				<tr>
					<td colspan="2" align="left"><div class="line-separator"></div>
					</td>
				</tr>
				<tr>
					<td width="100" align="left"><strong>Ticket Code:</strong>
					</td>
					<td align="left">&nbsp;${element.ticketCode}</td>
				</tr>
				<tr>
					<td align="left"><strong>Date:</strong>
					</td>
					<td align="left"><fmt:formatDate value="${element.datetime}" pattern="yyyy-MM-dd hh:mm:ss" />
					</td>
				</tr>
				<tr>
					<td align="left"><strong>Date Mobile:</strong>
					</td>
					<td align="left"><fmt:formatDate value="${element.datetimeMobile}" pattern="yyyy-MM-dd hh:mm:ss" />
					</td>
				</tr>
				<tr>
					<td align="left">&nbsp;</td>
					<td align="left">&nbsp;</td>
				</tr>
				<tr>
					<td align="left"><strong>Provider</strong>
					</td>
					<td align="left">${element.cardnameProvider}</td>
				</tr>
				<tr>
					<td align="left"><strong>Released by </strong>
					</td>
					<td align="left">${element.releasedBy}</td>
				</tr>
				<tr>
					<td align="left"><strong>Airport</strong>
					</td>
					<td align="left">${element.airport.name}</td>
				</tr>
				<tr>
					<td align="left"><strong>Customer</strong>
					</td>
					<td align="left">${element.cardnameClient}</td>
				</tr>
				<tr>
					<td align="left"><strong>Airplane</strong>
					</td>
					<td align="left">${element.airplaneCode}</td>
				</tr>
				<core:if test="${empty element.airplaneCode and !empty element.newAirplaneCode}">
					<tr>
						<td align="left"><strong>New Airplane </strong>
						</td>
						<td align="left">${element.newAirplaneCode}</td>
					</tr>
				</core:if>
				<tr>
					<td colspan="2" align="left"><div class="line-separator"></div>
					</td>
				</tr>
				<tr>
					<td align="left"><strong>Product</strong>
					</td>
					<td align="left">${element.itemname}</td>
				</tr>
				<tr>
					<td align="left"><strong>QuantityLts</strong>
					</td>
					<td align="left"><fmt:formatNumber value="${element.quantityLts}" type="number" pattern="#,##0.000000" />
					</td>
				</tr>
				<tr>
					<td align="left"><strong>QuantityGal</strong>
					</td>
					<td align="left"><fmt:formatNumber value="${element.quantityGal}" type="number" pattern="#,##0.000000" />
					</td>
				</tr>
				<tr>
					<td colspan="2" align="left"><div class="line-separator"></div>
					</td>
				</tr>
				<tr>
					<td align="left"><strong>Status</strong>
					</td>
					<td align="left">${element.statusLov.nameItem}</td>
				</tr>
				<tr>
					<td align="left"><strong>Overdraft </strong>
					</td>
					<td align="left"><core:if test="${element.overdraftString == 'Y'}">
							<img border="0" src="images/overdraft.png" width="16" height="16" alt="overdraft"/>
						</core:if> <core:if test="${element.overdraftString == 'N'}">
					  NO
					 </core:if></td>
				</tr>
				<tr>
					<td align="left"><strong>Notes</strong>
					</td>
					<td align="left">${element.notes}</td>
				</tr>
				<tr>
					<td colspan="2" align="left"><div class="line-separator"></div>
					</td>
				</tr>
				<tr>
					<td align="left"><strong>User </strong>
					</td>
					<td align="left">${element.user.userName}</td>
				</tr>
				<!-- WE VALIDATE HERE IF THE TICKET COMES FROM JDMOBILE APP OR FROM ANY BROWSER -->
				<tr>
					<td align="left"><strong>Via: </strong>
					</td>
					<core:choose>
					<core:when test="${element.sourceDeviceId == 'VIAWEB'}">
						<td align="left">From the Web.</td>
					</core:when>
					<core:otherwise>
						<td align="left">From the Mobile.</td>
					</core:otherwise>
					</core:choose>
				</tr>
				<!-- END  WE VALIDATE HERE IF THE TICKET COMES FROM JDMOBILE APP OR FROM ANY BROWSER -->
			</table>
		</td>
	</tr>
</table>