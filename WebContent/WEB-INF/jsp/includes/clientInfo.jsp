<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%--  --%>
<core:if test="${infoClient==null}">
<%--  Si no se encuentra en session es porque no es un cliente,
	  por lo tanto es un administrador haciendo una busqueda por lo cual
      se toma la informacion del resultado de la busqueda 
--%>
	<core:set var="infoClient" value="${results.businessPartner}"></core:set>
</core:if>
<core:if test="${infoClient!=null}">
	<table width="95%" border="0" cellpadding="1" cellspacing="0" class="box info borde">
		<tr>
			<td colspan="5">
				<table width="100%" border="0" cellpadding="5" cellspacing="5">
					<tr align="left">
						<td width="50%"><strong>Customer:</strong> ${infoClient.cardname}</td>
						<td width="25%"><strong>Code:</strong> ${infoClient.cardcode}</td>
						<td width="25%">&nbsp;</td>
					</tr>
					<tr align="left">
						<td><strong>Identification Number:</strong> ${infoClient.lidtradnum}</td>
						<td><strong>Phone:</strong> ${infoClient.phone1}, ${infoClient.phone2}</td>
						<td><strong>E-mail:</strong> <a href="mailto:${infoClient.EMail}">${infoClient.EMail}</a></td>
					</tr>
					<tr align="left">
						<td colspan="3"><strong>Address:</strong> ${infoClient.street} ${infoClient.block}.
							${infoClient.city}-${infoClient.country}
						</td>
					</tr>
					<tr align="left">
						<td><strong>Contact name:</strong> ${infoClient.contact.name}</td>
						<td><strong>Phone:</strong> ${infoClient.contact.tel1},${ infoClient.contact.tel2} -</td>
						<td><strong>E-mail:</strong> <a href="mailto:${infoClient.contact.email}">${infoClient.contact.email}</a>
						</td>
					</tr>
					<%-- <tr align="left">
						<td><strong>Account coordinator:</strong> ${infoClient.slpName}</td>
					</tr>
					<tr>
						<td style="padding-left: 300px;">
						<table>
							<tr>
							<td> <strong>Guarantee bond:</strong> </td>
							<td>
								<fmt:formatNumber value="${infoClient.guaranteeBond}" type="number" pattern="#,##0.00" />
							</td>
							</tr>
							
							<tr>
							<td> <strong>Cash Advanced:</strong> </td>
							<td>
								<fmt:formatNumber value="${infoClient.cashAdvance}" type="number" pattern="#,##0.00" />
							</td>
							</tr>
						</table>
						</td>
					--%>
						<td colspan="2" align="center" style="padding-right: 0px; padding-right: 215px;">
							<table width="270" border="1" bgcolor="#E4E4E4">
								<tr>
									<th align="center"><strong>Balance:</strong> ${infoClient.currency} </th> 
									<td> 
										<fmt:formatNumber value="${infoClient.currentBalance_FC}" type="number" pattern="#,##0.00" />
									</td>
								</tr>
								
								<tr>
									<th align="center"><strong>Orders pending for billing:</strong> ${infoClient.currency} </th> 
									<td> 
										<fmt:formatNumber value="${infoClient.ordersBalance}" type="number" pattern="#,##0.00" />
									</td>
								</tr>
								
								<tr>
									<th align="center"><strong>Estimated balance:</strong> ${infoClient.currency}</th> 
									<td>
										<%--<fmt:formatNumber value="${infoClient.estimatedBalance}" type="number" pattern="#,##0.00" />--%>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</core:if>
