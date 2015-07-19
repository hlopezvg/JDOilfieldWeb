<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title><tiles:getAsString name="title" /></title>
	
		<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
		<meta http-equiv="refresh" content="<%= session.getMaxInactiveInterval() %>; url=signout.htm">
		
		<link rel="stylesheet" type="text/css" href="css/styleGeneralPrint.css" media="print" />
		<link rel="stylesheet" type="text/css" href="css/styleGeneral.css" />
		<link rel="stylesheet" type="text/css" href="css/form.css" />
		<link rel="stylesheet" type="text/css" href="css/calendar.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.8.17.custom.css" />
		<link rel='stylesheet' type='text/css' href='css/popbox.css' media='screen' charset='utf-8'/>
		<link rel='stylesheet' type='text/css' href='js/jquery.alerts-1.1/jquery.alerts.css'/> 
		<link rel='stylesheet' type='text/css' href='css/showLoading.css'/> 
		
		<script type="text/javascript" language="javascript" src="js/calendar.js"></script>
		<script type="text/javascript" language="javascript" src="js/functions.js"></script>
		<script type="text/javascript" language="javascript" src="js/jquery-1.7.1.min.js"></script>
		<script type="text/javascript" language="javascript" src="js/jquery-ui-1.8.17.custom.min.js"></script>
		<script type='text/javascript' language="javascript" src='js/popbox.js'></script>
		<script type='text/javascript' language="javascript" src='js/jquery.alerts-1.1/jquery.alerts.js'></script>
		<script type='text/javascript' language="javascript" src='js/showLoading/jquery.showLoading.js'></script>
			
	</head>
	<body>
	<div id="container">
		<div id="content"> 
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr><td><tiles:insertAttribute name="header" /></td></tr>
				<tr><td><tiles:insertAttribute name="menu" /></td></tr>
				<tr><td align="center"><tiles:insertAttribute name="body" /></td></tr>
			</table>
		</div>	
		<div id="footer">
				 <p>Powered by &copy; 2012 J&amp;D Oildfield International S.A</p>
		</div>
	</div>
	</body>
</html>
