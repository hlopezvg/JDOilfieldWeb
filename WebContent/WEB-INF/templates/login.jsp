<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title><tiles:getAsString name="title" /></title>
	
		<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
		
		<link rel="stylesheet" type="text/css" href="css/styleGeneral.css" />
		<link rel="stylesheet" type="text/css" href="css/form.css" />
	</head>
	<body>
		<div align="center"><tiles:insertAttribute name="header" /></div>
		<div align="center"><tiles:insertAttribute name="body" /></div>
	</body>
</html>
