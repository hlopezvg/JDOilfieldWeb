<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>::: J &amp; D OILFIELD ::: </title>
	<link rel="stylesheet" type="text/css" href="css/styleGeneral.css" />
	<link rel="stylesheet" type="text/css" href="css/form.css" />
	
	<script type="text/javascript" src="js/functions.js"></script>
	<meta http-equiv="content-type" content="text/html; charset=iso-8859-1"/>
	<meta http-equiv="refresh" content="<%= session.getMaxInactiveInterval() %>">
</head>

<body>
<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
  <tr>
  	<td width="20">&nbsp;</td>
    <td>
		<%@include file="./includes/header.jsp" %> 
	</td>
	<td width="20">&nbsp;</td>
  </tr>
   <tr>
   <td   >&nbsp;</td >
     <td  align="center">
		<%@include file="./includes/menu.jsp" %>
	 </td>
	 <td  >&nbsp;</td >
   </tr>
  <tr>
    <td align="center" colspan="3"><br />
        <core:if test="${menu[sessionScope.m].insert}">
			<table width="60%" border="0">
		      <tr>
		        <td align="right">
		        	<a href="acNumberAdd.htm?action=add" title="<fmt:message key='icons.tooltip.insert'/>">
		        	<img border="0" src="images/add_16x16.gif" title="<fmt:message key='icons.tooltip.insert'/>" width="16" height="16"/> 
		        	New AC/Number</a>
		        </td>
		      </tr>
		    </table>
		</core:if>
    <core:choose>
    <core:when test="${results.totalRows==0}">
     	 <br />    <br />    <br />
    	<div class="redText"><fmt:message key="results.zero"/></div>
    	<br />    <br />    <br />
    </core:when>
	<core:otherwise>
	
	    <div class="redText">${sessionScope.msg}</div> 
		<core:set var="msg" value="${null}" scope="session" />
	
	<table width="60%" border="0" cellpadding="1" cellspacing="1" align="center" class="borde">
  		<thead align="" >
	    	<th width="25%" align="center">Code   </th>
	        <th width="55%" align="center">Name</th>
	        <th width="20%" colspan="2" align="center">Operations</th>
	    </thead>    
		    <!-- Recorrido de la lista de los codigos ac -->
		    <core:forEach items='${results.list}' var="acNumber" varStatus="r">
		    <core:if test='${r.count mod 2 eq 0}'>
		    	<core:set var="color" value="row1" />
		    </core:if>
		    <core:if test='${r.count mod 2 != 0}'>
		    	<core:set var="color" value="row2" />
		    </core:if>
		    <tr class="${color}">
			  	<td align="left">${acNumber.code}</td>
			  	<td align="left">${acNumber.name}</td>
			 	<td width="10%" align="center" >
			 	    <core:if test="${menu[sessionScope.m].update}">
						<a href="acNumberUpdate.htm?action=update&id=${acNumber.code}"> 
						<img border="0" src="images/modificar.gif" title="<fmt:message key='icons.tooltip.modify'/>" width="17" height="17" /></a>
					</core:if>
				</td>
			  	<td width="10%" align="center">
			  	    <core:if test="${menu[sessionScope.m].delete}">
						<a href="#" onclick="confirmDelete('${acNumber.code}', 'acNumberDelete.htm?id=${acNumber.id}','AcNumber')">
						<img border="0" src="images/delete_20x20.gif" title="<fmt:message key='icons.tooltip.delete'/>" width="20" height="20" /></a>	
					</core:if>
				</td>
		  	</tr>
 			</core:forEach>
 
		  <tr >
		    <td colspan="4" >
		    <table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
		      <tr>
		        <td align="right"><br /><strong>Total results: ${fn:length(results.list)}</strong>&nbsp;&nbsp;</td>
		      </tr>
		    </table>
		    </td>
		   </tr>
		</table>
		</core:otherwise>
	</core:choose>		
    <br />
    </td>
  </tr>
</table>
<br />
</body>
</html>