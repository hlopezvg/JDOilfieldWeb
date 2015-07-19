<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ attribute name="page" required="true"%>
<%@ attribute name="total" required="true"%>
<%@ attribute name="numPage" required="true"%>
<%@ attribute name="numRows" required="true"%>
<%@ attribute name="totalPages" required="true"%>
<%@ attribute name="clientCode" required="false"%>

<core:choose>
	<core:when test="${empty clientCode}">
		<core:set var="elementId" value="" />
	</core:when>
	<core:otherwise>
		<core:set var="elementId" value="&amp;id=${clientCode}" />
	</core:otherwise>
</core:choose>

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
	<tr>
		<td colspan="4" align="right"></td>
	</tr>
	<!-- Se determina la cantidad de paginas -->
	<tr class="row2">
		<td width="26%" align="right">
			<!-- Se muestra la imagen de anterior pagina --> <core:if test='${(numPage-1)!=0}'>
				<a href="${page}?page=${numPage-1}${elementId}"> <img src="images/prev.gif"
					alt="<fmt:message key='icons.tooltip.previous'/>" width="16" height="16" border="0" /> </a>
			</core:if>
		</td>
		<td width="22%" align="center"><strong> Page ${numPage} of ${totalPages} </strong></td>
		<td width="29%" align="left">
			<!-- Se muestra la imagen de siguiente pagina --> <core:if test='${totalPages!= numPage}'>
				<a href="${page}?page=${numPage+1}${elementId}"> <img src="images/next.gif"
					alt="<fmt:message key='icons.tooltip.next'/>" width="16" height="16" border="0" /> </a>
			</core:if>
		</td>
		<!-- Se muestra el total de registros -->
		<td width="23%" align="right"><strong>Total results: ${total} &nbsp;&nbsp;</strong></td>
	</tr>
</table>