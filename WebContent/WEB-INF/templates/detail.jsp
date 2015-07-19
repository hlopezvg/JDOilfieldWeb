<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title><tiles:getAsString name="title" /></title>
	
		<link rel="stylesheet" type="text/css" href="css/styleGeneral.css" />
		<link rel='stylesheet' type='text/css' href='js/jquery.alerts-1.1/jquery.alerts.css'/> 
		
		<script type="text/javascript" language="javascript" src="js/jquery-1.7.1.min.js"></script>
		<script type='text/javascript' language="javascript" src='js/jquery.alerts-1.1/jquery.alerts.js'></script>

	
		<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
		<meta http-equiv="refresh" content="<%= session.getMaxInactiveInterval() %>; url=signout.htm">
	</head>
	<body>
		<table align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td><img src="images/logo.gif" alt="logo_home" /></td>
				<td><input type="button" onclick="window.close()" value="Cerrar"/></td>
			</tr>
			<tr><td align="center" colspan="2"><tiles:insertAttribute name="body" /></td></tr>
		</table>
			<div id="footer">
				 <p>Powered by &copy; 2012 J&amp;D Oildfield International S.A</p>
		</div>
	</body>
</html>
