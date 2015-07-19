<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<table width="90%" align="center" border="0" cellpadding="0" cellspacing="0">
<script>
	<core:remove var="nameClient"/>
	<core:remove var="airCraft"/>
	
	var cardNameClient = '${sessionScope.cardCodeName}';
	var aircraftCode = '${sessionScope.aircraftCode}';
	console.log("THE CLIENT IN CREDITFC NAME IS: " + cardNameClient);
	console.log("THE AIRCRAFT IN CREDITFC IS: " + aircraftCode);
	
	<core:set var="nameClient" value='${sessionScope.cardCodeName}'/>
	<core:set var="airCraft" value='${sessionScope.aircraftCode}'/>	

</script>
  <tr>
	<td align="right">
		<a href="fuelCards.htm?m=12"><img src="images/back.gif"
			title="<fmt:message key='icons.tooltip.back'/>" width="16" height="16" border="0" alt="back"/>Back</a>
	</td>
    </tr>
   <tr>
     <td align="center" ><hr /></td>
   </tr>
   <tr>
    <td align="center" >
	  	   	<p>&nbsp;</p>
	   		<p>&nbsp;</p>
	   		<p>&nbsp;</p>
	   	   	<p>&nbsp;</p>
	   	    	
	 <div>
	 	<img height="270px" width="400px"   src="images/invalid_fuel_card.jpg"/>
	 </div>
	 
	   <p>&nbsp;</p>
	   <p>&nbsp;</p>
	   <p>&nbsp;</p>
	   <p>&nbsp;</p>
	   <p>&nbsp;</p>
	   <p>&nbsp;</p>
	   <p>&nbsp;</p>
	   <p>&nbsp;</p>
	   <p>&nbsp;</p>
   
	</td>
	<div>
				<td>
					Customer:
				</td>
				
				<td>
				<core:choose>
					<core:when test="${not empty nameClient}">
						${nameClient}
					</core:when>
					<core:otherwise>
						THE CUSTOMER DOES NOT EXIST
					</core:otherwise>
				</core:choose>
				</td>
			</div>
			
			<div>
			<td>
					Aircraft:
				</td>
				
				<td>
					<core:choose>
					<core:when test="${not empty airCraft}">
						${airCraft}
					</core:when>
					<core:otherwise>
						THE AIRCRAFT DOES NOT EXIST
					</core:otherwise>
				</core:choose>
				</td>
			</div>
			
   </tr>
   <tr>
     <td align="center"><hr /></td>
   </tr>
  <tr>
    <td align="center" ></td>
  </tr>
</table>
<br />
</body>
</html>