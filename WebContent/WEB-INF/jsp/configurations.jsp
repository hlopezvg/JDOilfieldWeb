<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>::: J &amp; D OILFIELD :::</title>
	<link rel="stylesheet" type="text/css" href="css/styleGeneral.css" />
	<link rel="stylesheet" type="text/css" href="css/form.css" />
	<link rel="stylesheet" type="text/css" href="css/calendar.css" />
	<script type="text/javascript"  src="js/calendar.js"></script>
	
	<meta http-equiv="content-type" content="text/html; charset=iso-8859-1"/>
	<meta http-equiv="refresh" content="<%= session.getMaxInactiveInterval() %>">
</head>
<body>
<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
  <tr>
     	<td width="20"  >&nbsp;</td >
    	<td><%@include file="./includes/header.jsp" %></td>
        <td width="20">&nbsp;</td >
  </tr>
   <tr>
	    <td>&nbsp;</td>
	    <td align="center">
			<%@include file="./includes/menu.jsp" %>
		</td>
		<td>&nbsp;</td>
   </tr>
   <!-- <tr>
   <td colspan="3" align="center">
		<table width="90%" border="0" align="center">
		  <tr>
		    <td width="770" align="center">
				<div id="tabsJ">
				<ul>
					<li ><a href="roles.htm?m=10"><span><B>Roles </B></span></a></li>
					
				</ul>
			</div>	
			</td>
		  </tr>
		  <tr >
	   </tr>
	</table>
     </td>
   </tr> -->

</table>
</body>
</html>