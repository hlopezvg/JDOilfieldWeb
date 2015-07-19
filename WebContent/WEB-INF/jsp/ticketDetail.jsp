<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0" style="margin-top: 20px;">
			<script>
			     $(document).ready(function(){
			    	 if('${element.amendment}'.length > 0){
			    		 jAlert('<div style="text-align:left"> Important note: The values in <p style="text-align:center; color: green"><strong>GREEN COLOR</strong></p> has been modifed by the Analist </div>');	 
			    	 }
			    	   
			    	
			    	
			    	function trim(str) {
			    		    return str.replace(/^\s+/, "").replace(/\s+$/, "");
			        }
			    	//console.log('${element.amendment}');
					var bar = '${element.amendment}'.split("^"), part;
					var results = {};
					for(var i = 0;i<bar.length;i++){
							part = bar[i].split("-->");
						    //results[trim(part[0])] = trim(part[1]);
						    console.log(part[0] + "  " + part[1]);
 						    if(part[0].indexOf("datetimeString_") != -1){
 						    	//console.log("DatetimeString es " + part[1]);
 						    	$("#date").addClass("hilighted");
 						    	$("#date_").addClass("hilighted");
 						    }
 						    if(part[0].indexOf("providerCode_") != -1){
						    	//console.log("ProviderCode es " + part[1]);
 						    	$("#provider").addClass("hilighted");
 						    	$("#provider_").addClass("hilighted");
						    }
 						    if(part[0].indexOf("airportId_") != -1){
						    	//console.log("AirportId es " + part[1]);
 						    	$("#airportId").addClass("hilighted");
 						    	$("#airportId_").addClass("hilighted");
						    }
 						    if(part[0].indexOf("airplaneCode_") != -1){
						    	//console.log("AirplaneCode es " + part[1]);	
 						    	 $("#airplane").addClass("hilighted");
 						    	 $("#airplane_").addClass("hilighted");
						    }
 						    if(part[0].indexOf("productCode_") != -1){
						    	//console.log("ProductCode es " + part[1]);
 						    	$("#productCode").addClass("hilighted");
 						    	$("#productCode_").addClass("hilighted");
						    }
 						    if(part[0].indexOf("quantityLtsString_") != -1){
						    	//console.log("QuantityLts es " + part[1]);
 						    	$("#quantityLts").addClass("hilighted");
 						    	$("#quantityLts_").addClass("hilighted");
						    }
 						    if(part[0].indexOf("notes_") != -1){
					    	   //console.log("Notes es " + part[1]);	
 						    	$("#notes").addClass("hilighted");
 						    	$("#notes_").addClass("hilighted");
					        }
					}
				});
		    </script>
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
					<td align="left" id="date"><strong>Date:</strong>
					</td>
					<td align="left" id="date_"><fmt:formatDate value="${element.datetime}" pattern="yyyy-MM-dd hh:mm:ss" />
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
					<td align="left" id="provider"><strong>Provider</strong>
					</td>
					<td align="left" id="provider_">${element.cardnameProvider}</td>
				</tr>
				<tr>
					<td align="left"><strong>Released by </strong>
					</td>
					<td align="left">${element.releasedBy}</td>
				</tr>
				<tr>
					<td align="left" id="airportId"><strong>Airport</strong>
					</td>
					<td align="left" id="airportId_">${element.airport.name}</td>
				</tr>
				<tr>
					<td align="left"><strong>Customer</strong>
					</td>
					<td align="left">${element.cardnameClient}</td>
				</tr>
				<tr>
					<td align="left" id="airplane"><strong>Airplane</strong>
					</td>
					<td align="left" id="airplane_">${element.airplaneCode}</td>
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
					<td align="left" id="productCode"><strong>Product</strong>
					</td>
					<td align="left" id="productCode_">${element.itemname}</td>
				</tr>
				<tr>
					<td align="left" id="quantityLts"><strong>QuantityLts</strong>
					</td>
					<td align="left" id="quantityLts_"><fmt:formatNumber value="${element.quantityLts}" type="number" pattern="#,##0.000000" />
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
					<td align="left" id="notes"><strong>Notes</strong>
					</td>
					<td align="left" id="notes_">${element.notes}</td>
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