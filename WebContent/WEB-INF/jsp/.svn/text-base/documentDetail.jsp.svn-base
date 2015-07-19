<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<head>
	<title>::: J & D OILFIELD :::</title>
	<link rel="stylesheet" type="text/css" href="css/styleGeneral.css" />
	<link rel="stylesheet" type="text/css" href="css/form.css" />
	<script type="text/javascript" language="javascript" src="js/calendario.js"></script>
	<meta http-equiv="content-type" content="text/html; charset=iso-8859-1"/>
	<meta http-equiv="refresh" content="<%= session.getMaxInactiveInterval() %>">	
</head>
<body>
<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
  
   <tr>
    <td colspan="3" align="center"><br />
	  <table width="95%">
		  <tr>
		 	 <td align="right">
		 	 <p>&nbsp;</p>
		 	 <a href="documents.htm?page=1">
		 	 <img src="images/back.gif" title="<fmt:message key='icons.tooltip.back'/>" width="16" height="16" border="0" /> 
		 	 Back</a> 
		 	 </td>
		  </tr>
	  </table>
	  <div class="redText">${msg}</div>
    </td>
    </tr>

  <tr>
	<td colspan="3" align="center"><br />
	
      <table width="95%" bgcolor="#FFFFFF" align="center" border="0" cellpadding="0" cellspacing="0" class="box borde" >
        <tr>
          <td>&nbsp;</td>
          <td width="10%" align="left" >&nbsp;</td>
          <td width="90%" align="left" >&nbsp;</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td align="left"><strong>Document Number:</strong></td>
          <td align="left">
          	 ${element.docnum}
		</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td align="left"><strong>Document Type</strong></td>
          <td align="left">
          	${element.documentType.name}  
          	
			<strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Docclass:</strong> ${element.docclass}          </td>
        </tr>
        
        <tr>
          <td width="2%">&nbsp;</td>
          <td align="left" ><strong>Document Date:</strong></td>
          <td align="left" ><fmt:formatDate  value="${element.docdate}" pattern="yyyy-MM-dd hh:mm:ss" />  </td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td align="left" ><strong>Due Date:</strong></td>
          <td align="left" ><fmt:formatDate  value="${element.docduedate}" pattern="yyyy-MM-dd hh:mm:ss" /> </td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td align="left" >&nbsp;</td>
          <td align="left" >&nbsp;</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td align="left" ><strong>Customer Code :</strong></td>
          <td align="left" >${element.businessPartner.cardcode}</td>
        </tr>
        <tr>
          <td width="2%">&nbsp;</td>
          <td align="left" ><strong>Customer Name:</strong></td>
          <td align="left" >${element.businessPartner.cardname}</td>
        </tr>
        <tr>
          <td width="2%">&nbsp;</td>
          <td align="left" ><strong>Customer Address:</strong></td>
          <td align="left" >${element.businessPartner.street} ${element.businessPartner.block}. ${element.businessPartner.city}-${element.businessPartner.country}</td>
        </tr>
          <tr>
          <td width="2%">&nbsp;</td>
          <td align="left" ><strong>Phone - email: </strong></td>
          <td align="left" >${element.businessPartner.phone1} -<strong> </strong>${element.businessPartner.EMail}</td>
        </tr>
         

                <tr>
          <td>&nbsp;</td>
          <td align="left" >&nbsp;</td>
          <td align="left" >&nbsp;</td>
        </tr>
                <tr>
                  <td>&nbsp;</td>
                  <td align="left" ><strong>Base Amount:</strong></td>
                  <td align="left" >
				  		${element.baseamnt} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<strong>% Discount:</strong> <fmt:formatNumber value="${element.discprcnt}" type="number" pattern="#,##0.00"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<strong>vatsum:</strong> <fmt:formatNumber value="${element.vatsum}" type="number" pattern="#,##0.00"/></td>
                </tr>
                <tr>
                  <td>&nbsp;</td>
                  <td align="left" >&nbsp;</td>
                  <td align="left" >&nbsp;</td>
                </tr>
                <tr>
                  <td>&nbsp;</td>
                  <td align="left" ><strong>Total Amount</strong></td>
                  <td align="left" ><fmt:formatNumber value="${element.doctotal}" type="number" pattern="#,##0.00"/></td>
                </tr>
                


                <tr>
                  <td>&nbsp;</td>
                  <td colspan="2" align="left" >&nbsp;</td>
                </tr>
         
		<tr>
          <td colspan="3">&nbsp;</td>
        </tr>
		<tr>
		  <td colspan="3" align="center" >
		  <table width="100%" border="0" cellpadding="0" cellspacing="1" align="center" class="borde">
            <thead align="" >
		      <th width="26%" align="center">Product Description </th>
		      <th width="8%" align="center">Ticket </th>
		      <th width="10%" align="center">Quantity </th>
		      <th width="10%" align="center">Unit Price </th>
		      <th width="10%" align="center">Net Price </th>
		      <th width="10%" align="center">% Discount </th>
		       <th width="10%" align="center">Tax </th>
		      <th width="7%" align="center">Tax Code </th>
		      <th width="7%" align="center">% Tax</th>
		      <th width="10%" align="center">Total </th>
		      </thead>
		  	<core:forEach items='${element.documentDetails}' var="doc" varStatus="vs">
		       <core:if test='${vs.count mod 2 eq 0}'>
	    		<core:set var="color" value="row1" />
			    </core:if>
			    <core:if test='${vs.count mod 2 != 0}'>
			    	<core:set var="color" value="row2" />
			    </core:if>
				 <tr class="${color}">
	              	  <td align="left">${doc.itemname} </td>
	              	  <td align="left">${doc.ticket} </td>
				      <td align="right"><fmt:formatNumber value="${doc.quantity}" type="number" pattern="#,##0.00"/></td>
				      <td align="right"><span><fmt:formatNumber value="${doc.price}" type="number" pattern="#,##0.00"/></span></td>
				      <td align="right"><fmt:formatNumber value="${doc.pricebefdi}" type="number" pattern="#,##0.00"/> </td>
				      

				      
   				      <td align="right"><fmt:formatNumber value="${doc.priceafvat}" type="number" pattern="#,##0.00"/></td>
				      <td align="center" >${doc.taxcode}</td>
				      <td align="right" ><fmt:formatNumber value="${doc.vatprcnt}" type="number" pattern="#,##0.00"/></td>
				      <td align="right"><fmt:formatNumber value="${doc.linetotal}" type="number" pattern="#,##0.00"/></td>
			      </tr>
		   	</core:forEach>
          </table>          </td>
	    </tr>
      </table>
	</td>
	</tr>
</table>
<br />
</body>
</html>