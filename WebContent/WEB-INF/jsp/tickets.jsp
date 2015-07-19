<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

  

<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
 	<tr>
		<td colspan="3" align="center">
		  <div class="redText">${sessionScope.msg}</div> <core:set var="msg" value="${null}" scope="session" />
			<form name="form" action="" method="post">
			 <div id="activity_pane"> 
				<br />
				<fieldset>
					<legend class="ocultar_print">Search</legend>
					<table id="controlTableID"  width="100%" border="0" cellpadding="6" cellspacing="6">
						<spring:hasBindErrors name="search">
							<core:if test="${errors.errorCount>0}">
								<tr align="left">
									<td colspan="4"><spring:hasBindErrors name="search">
											<core:forEach items="${errors.allErrors}" var="error" varStatus="c">
												<div class="redText">- <spring:message message="${error}" /></div>
											</core:forEach>
										</spring:hasBindErrors>
									</td>
								</tr>
							</core:if>
							<spring:bind path="search.login">
								<input type="text"  id="login" name="login" value=${sessionScope.user.roleId}/>
							</spring:bind>
						</spring:hasBindErrors>
						<core:if test="${(sessionScope.user.roleId == 1) || (sessionScope.user.roleId == 6)}">
						    <script>
						    	reportAdmin = true;
						    </script>
						</core:if>
						
						<core:choose>
						<core:when test="${infoClient==null}">
						<script>
							var adminLoged = true;
						</script>
						
		<!-- THIS IS FOR PROVIDERS -->
		<core:if test="${(sessionScope.user.roleId == 1)}">
			<core:set var="ticketProvider_" value='disabled="disabled"'/>
		</core:if>
		<!-- END OF PROVIDERS -->
						
						
		<!-- THIS SECTION WAS DESIGN FOR THE NEW ROLE VIEW DOMESTIC CLIENTS -->
		<script type="text/javascript">
			  	console.log('User login: ' + '${sessionScope.user.login}');
			  	console.log('Role ID: ' + '${sessionScope.user.roleId}');
			  </script>
			<!-- CHANGE FROM 05/07/2015 -->
			<!--They need to have operators and chief operators view the report.-->
			<!--role = 3 ( ROLE_OPERATOR ) -->
			<!--role = 5 ( ROLE_CHIEF_OPERATOR ) -->
			<!--role=  8 ( ROLE_VIEW_LOCAL_CUSTOMER ) -->
			<core:choose>
			<core:when test="${(sessionScope.user.roleId == 3) || (sessionScope.user.roleId == 5) || (sessionScope.user.roleId == 8)}">
				<script>
					reportViewDomesticClients = true;
					console.log("roleID: " + '${sessionScope.user.roleId}');
			    	console.log("edit mode -----------> " + '${enableCal}');
			    	console.log("reportDomestic : " + reportViewDomesticClients);
				</script>
				
				<!-- <core:set var="editMode" value='disabled="disabled"'/> -->
				<!-- Enable ticket for Mercader(role_local_view_customer -->
				<core:set var="editMode" value=''/>
				<core:set var="enableAddTicket" value=""/>
			</core:when>
			<core:otherwise>
			    <script>
					var reportViewDomesticClients = false;
					console.log("edit mode -----------> " + '${editMode}');
				</script>
		        <core:set var="editMode" value=''/>
		        <core:set var="enableAddTicket" value="href="/>
			        
			</core:otherwise>
			</core:choose>
			
			<!-- THIS IS FOR PROVIDERS editMode -->
			<core:if test="${(sessionScope.user.roleId == 10)}">
				<core:set var="editModeProvider" value='disabled="disabled"'/>
			</core:if>
			<!-- END OF PROVIDERS -->
			
			
		<!-- THIS SECTION WAS DESIGN FOR THE NEW ROLE VIEW DOMESTIC CLIENTS --> 		
									
							<tr>
								<td width="9%" align="left">Customer:</td>
								<td colspan="3" align="left"><spring:bind path="search.codeClient">
										<select id="codeClient"  name="codeClient" ${editMode} ${editModeProvider}>
											<option value="0">All</option>
											<core:forEach items='${searchLists.clients}' var="client">
												<core:choose>
													<core:when test="${client.cardcode==search.codeClient}">
														<option value="${client.cardcode}" selected="selected">${client.cardname}</option>
													</core:when>
													<core:otherwise>
														<option value="${client.cardcode}">${client.cardname}</option>
													</core:otherwise>
												</core:choose>
											</core:forEach>
										</select>
									</spring:bind>
									<script>
										var iataHREF;
										$('#codeClient').change(function(){
											iataHREF = 'reportTicket.htm?output=xml&customer='+$(this).val()+'&invoiceNumber='+$('#invoiceNumber').val()+'&type=xmlReport';
											//console.log('evalute the href --> ' + iataHREF);						
											$('#newHREF_XML').attr('href', iataHREF);	
										});
									</script>
								</td>
							</tr>
						</core:when>
						<core:otherwise>
						<script>
							var adminLoged = false;
						</script>
						</core:otherwise>
						</core:choose>
						
					<!-- Seccion para la busqueda de airports -->
						  <tr align="left">
						  <td align="left">Airport:</td>
						    <td colspan="5" align="left">
								
							<spring:bind path="search.airportCode"> 
							 	<select name="airportCode"  ${editMode} ${editModeProvider}>
								    <option value="0"> All </option>
					                <core:forEach items='${searchLists.airports}' var="airport">
							      		<core:choose>
									      <core:when test="${airport.code == search.airportCode}">
												<option value="${airport.code}" selected> ${airport.name} </option>
									      </core:when>
									      <core:otherwise>	<option value="${airport.code}"> ${airport.name} </option></core:otherwise>
									    </core:choose>
									</core:forEach>
								</select>
							</spring:bind>
							</td>
					      </tr>
								      
					<!-- Fin Seccion de busqueda de Aeropuertos -->
					
					<!--  PROVIDRES -->
						<tr align="left">
							<td align="left">Provider:</td>
							<td colspan="5" align="left"><spring:bind path="search.codeProvider">
									<select name="codeProvider" ${editMode}  ${editModeProvider}>
										<option value="0">All</option>
										<core:forEach items='${searchLists.providers}' var="provider">
											<core:choose>
												<core:when test="${provider.cardcode==search.codeProvider}">
													<option value="${provider.cardcode}" selected="selected">${provider.cardname}</option>
												</core:when>
												<core:otherwise>
													<option value="${provider.cardcode}">${provider.cardname}</option>
												</core:otherwise>
											</core:choose>
										</core:forEach>
									</select>
								</spring:bind>
							</td>
						</tr>
			  			<!--  END OF  PROVIDRES -->
							
							
						<!-- SEARCH FOR AIRPLANES -->	
						<tr>
							<td>Airplanes:</td>
							<td>
								<div id="hidden_input_holder_airplane_code"
									style="display: none">
									<input id="airplaneCode" type="text" name="airplaneCode"
										value="${search.airplaneCode}" />
								</div> 
								<div class="ui-widget">
									<input style="height: 15px; width: 145px;" id="tags" ${editMode} ${editModeProvider}/>
								</div>
							</td>
						
						<!-- INIT JQUERY AUTOCOMPLETE -->
	          	  	<script>
					$(function() {
						var airplanes = new Array();
	 		     	    var cardCode = "${user.clientCode}";
	 		     	    //alert("${user.clientCode}"); 
	 		     	    <core:forEach items='${searchLists.airplanes}' var="airplane">
	 		     	  	//console.log('Airplanes: ' + '${airplane}');
	 		     	    var groupKey = '${airplane.id.cardcode}';	
	 		     	    if(adminLoged == true){
							airplanes.push('${airplane.id.code}');
						} 
	 		     	    if(adminLoged == false){
	 		     	    	if(groupKey == cardCode){
								//alert('${airplane.id.code}');
								airplanes.push('${airplane.id.code}');
							}	
	 		     	    }
				        </core:forEach>  
						$( "#tags" ).autocomplete({ 	
							source: airplanes
						});
						$( "#tags" ).autocomplete({
							 change: function(event, ui) {
								 updateAirplaneCODE(ui.item.value);
							 }
						});
					});
					
					
					function updateAirplaneCODE(airplaneCode){
						var holderAirplaneCode = document.getElementById('airplaneCode');
						holderAirplaneCode.value= airplaneCode;
						//alert(holderAirplaneCode.value);
					 }
			</script>
			<!-- AUTOCOMPLETE FOR INVOICE NUMBER, THIS PART IS SPECIALLY DESIGNED FOR IATA INVOICE -->
			<!-- SHOULD BE COMMENTED UNTTIL WE IMPROVE THE PERFORMANCE -->
				<!-- <tr align="left">
					<td>Invoice Number:</td>
					<td>
						<div id="hidden_input_holder_invoice_number"
							style="display: none">
							<input id="invoiceNumber" type="text" name="invoiceNumber"
								value="" />
						</div>
						<div class="ui-widget">
							<input size="17" id="tags_invoice" ${editMode} />
						</div>
					</td>
				</tr> 
			<script>
			$(function() {
				var invoice = new Array();
		     	   <core:forEach items='${searchLists.docNum}' var="docNum">
		     	   		invoice.push('${docNum}');
		        	</core:forEach>  
		        $( "#tags_invoice" ).autocomplete({ 	
					source: invoice,
				});
			
				$( "#tags_invoice" ).autocomplete({
					 change: function(event, ui) {
						 updateInvoiceNumber(ui.item.value);
						 $('#codeClient').focus();
					 },
					 select: function(event, ui) {
						 updateInvoiceNumber(ui.item.value);
						 $('#codeClient').focus();
					 }
				});
			});
			
			
			
			function updateInvoiceNumber(invoiceNumber){
				var holderInvoiceNumber = document.getElementById('invoiceNumber');
				var iataHREF;
				holderInvoiceNumber.value= invoiceNumber;
				//alert(holderAirplaneCode.value);
				iataHREF = 'reportTicket.htm?output=xml&customer='+$('#codeClient').val()+'&invoiceNumber='+$('#invoiceNumber').val()+'&type=xmlReport';
				console.log('evalute the href -- ' + iataHREF);						
				$('#newHREF_XML').attr('href', iataHREF);
			 }
			</script>--> 
			
			<!-- END JQUERY AUTOCOMPLETE -->
			<!-- END SEARCH FOR AIRPLANES -->
						</tr>
						<tr align="left">
							<td align="left" width="10%">Ticket code:</td>
							<td align="left" width="26%">
							<div class="ui-widget">
								<div class='popbox'>
								    <a class='open' href='#'>
								    	<spring:bind path="search.codeTicket">
								      		<input style="height: 15px; width: 145px;" type="text" name="codeTicket" id="codeTicketID"   
								      				value="${search.codeTicket}" ${editMode} ${editModeProvider}/>
								      	</spring:bind> 
								    </a>
								    <div class='collapse'>
								      <div class='box'>
								        <div class='arrow'></div>
								        <div class='arrow-border'></div>
											<p><small>
												In order to search using Ticket Code, type all the letters in lower-case;
											</small></p>
								      </div>
								    </div>
								  </div>
							</div>         
							</td>
						
						<!-- THIS IS THE PART THAT GET LOADS WHEN PAGE IS LOADED -->
						<script type='text/javascript' charset='utf-8'>
	    					$(document).ready(function(){
	    						var hrefRport;
	    						var codeClientTxt;
	    						var reportViewDomesticClients;
	    						var reportAdmin;	
	    						$('#statusReport').prop("disabled", true);
	    						//console.log("THIS!! : " + reportViewDomesticClients);
	    						$('.popbox').popbox();
	    						console.log("Is hidden: " + $('#trHREF_FC').css('display'));
	    						if(reportViewDomesticClients){
		      						document.getElementById("trHREF_").style.display="";
		      					}
	    						
	    						if(reportAdmin){
		      						document.getElementById("trHREF").style.display="";
		      						document.getElementById("trHREF_").style.display="";
		      						document.getElementById("trHREF_XML").style.display="";
		      					}
	    						
	    						//User logged in
	    						document.getElementById("trHREF_FC").style.display="";
	    						
	    						$('#newHREF_FC').hover(function(){
	    							if($('#fromDateID').val() !== "" && $('#toDateID').val() !== ""){
	    								 var newHref='reportTicket.htm?output=xls&initDate='+from_+
    									 '&endDate='+to_+'&type=consumptionREP'+ 
    									 '&cardCode='+ "A" +'&airplaneCode='+"A";
    							 		$('#newHREF_FC').prop('href', newHref);
	    							}	
	    						});
	    						
	    					  	console.log('User login: ' + '${sessionScope.user.login}');
	    					  	console.log('Role ID: ' + '${sessionScope.user.roleId}');
	    					  	console.log('Client Code: ' + '${sessionScope.user.clientCode}');

	    					});
			  			</script>
				
							<td align="left" width="8%">From:</td>
							<td align="left" width="17%"><spring:bind path="search.fromDate">
									<input type="text"  id="fromDateID" name="fromDate" maxlength="10" value="${search.fromDate}" class="inputFecha"  
									onchange="setFromDate(this.value)"/>
								</spring:bind> <a onclick="displayCalendar(document.forms[0].fromDate,'yyyy-mm-dd',this)"> &nbsp; &nbsp; <img
									class="ocultar_print" src="images/almanaque.gif" title="<fmt:message key='icons.tooltip.calendar'/>"
									border="0" width="20" height="16" alt="almanaque" /> </a>
							</td>
							<td align="left" width="3%">to:</td>
							<td align="left" width="36%"><spring:bind path="search.toDate">
									<input type="text" name="toDate" id= "toDateID"  maxlength="10" value="${search.toDate}" class="inputFecha" 
									onchange="setToDate(this.value)"/>
								</spring:bind> <a onclick="displayCalendar(document.forms[0].toDate,'yyyy-mm-dd',this)"> &nbsp; &nbsp; <img
									class="ocultar_print" src="images/almanaque.gif" title="<fmt:message key='icons.tooltip.calendar'/>"
									border="0" width="20" height="16" alt="almanaque" /> </a>
							</td>
						</tr>
						
						
						<tr align="left">
							<td align="left">Ticket Status:</td>
							<td align="left"><spring:bind path="search.statusTicket">
									<select name="statusTicket" ${editMode} ${editModeProvider}>
										<option value="0">All</option>
										<core:forEach items='${searchLists.status}' var="s">
											<core:choose>
												<core:when test="${s.idItem==search.statusTicket}">
													<option value="${s.idItem}" selected="selected">${s.nameItem}</option>
												</core:when>
												<core:otherwise>
													<option value="${s.idItem}">${s.nameItem}</option>
													alert(${s.idItem});
												</core:otherwise>
											</core:choose>
										</core:forEach>
									</select>
								</spring:bind>
							</td>
							<!-- This AREA IS ONLY FOR THE ROLE VIEW_DOMESTIC_CLIENTS -->
							<core:choose>
							<core:when test="${(sessionScope.user.roleId == 8  || sessionScope.user.roleId == 6
							|| sessionScope.user.roleId == 1)}">
								<td align="left">Status Report:</td>
								<td align="left">
								<div id="hidden_input_holder_cardname_provider" style="display:none">
									<input id="inputStatus">
								</div>
								    <select id="statusReport">
										<option value="A" selected="selected">All</option>
										<option value="O">Open</option>
										<option value="C">Closed</option>
									</select>
									<script>
									$('#statusReport').change(function (){
										$('#inputStatus').val($('#statusReport').val());
										console.log('statusReport'  + $('#statusReport').val());
										hrefRport = $('#newHREF_').attr('href');
										console.log('evalute the href --> ' + hrefRport.substr(0, hrefRport.length -1)+$('#statusReport').val());
										//$('#newHREF_').attr('href', "");							
										$('#newHREF_').attr('href', hrefRport.substr(0, hrefRport.length -1)+$('#statusReport').val());
									});
									</script>
								</td>
							</core:when>
							<core:otherwise>
							<td align="left">Overdraft:</td>
							<td align="left"><spring:bind path="search.isOverdraft">
									<select name="isOverdraft">
										<option value="0">---</option>
										<core:choose>
											<core:when test="${search.isOverdraft=='N'}">
												<option value="N" selected="selected">No</option>
											</core:when>
											<core:otherwise>
												<option value="N">No</option>
											</core:otherwise>
										</core:choose>
										<core:choose>
											<core:when test="${search.isOverdraft=='Y'}">
												<option value="Y" selected="selected">Yes</option>
											</core:when>
											<core:otherwise>
												<option value="Y">Yes</option>
											</core:otherwise>
										</core:choose>
									</select>
								</spring:bind>
							</td>
							</core:otherwise>
							</core:choose>
							<td align="left">&nbsp;</td>
							<td align="left">
								<table border="0" width="100%" class="ocultar_print" align="right">
									<tr>
										<td align="right"><spring:bind path="search.numRows">
						                        Results per page:
						                        <select name="numRows" ${editMode}>
													<core:forEach begin='10' end='100' step='10' var="count">
														<core:choose>
															<core:when test="${count==search.numRows}">
																<option value="${count}" selected="selected">${count}</option>
															</core:when>
															<core:otherwise>
																<option value="${count}">${count}</option>
															</core:otherwise>
														</core:choose>
													</core:forEach>
												</select>
											</spring:bind></td>
										<td align="right"><input type="submit" name="SubmitButton" value="Search" ${editMode} ${editModeProvider}/>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</fieldset>
			</div>
			</form>
			<%@include file="./includes/clientInfo.jsp"%>
		</td>
	</tr>
	 <td align="center" colspan="3">
	<table width="60%" border="0">
		      <tr>
		        <td align="right">  
		        	<a  href="ticketAdd.htm?action=add" title="<fmt:message key='icons.tooltip.insert'/>" >
		        	<img border="0" src="images/add_16x16.gif" title="<fmt:message key='icons.tooltip.insert'/>" width="16" height="16"/> 
		        	New Ticket</a>
		        </td>
		        
		        <!-- THIS SECTION IS FOR TICKET PROVIDER 
		        <tr>
			         <td align="right">
		        	 <a  id="ticketProviderHREF" title="<fmt:message key='icons.tooltip.insert'/>" >
		        	<img border="0" src="images/add_16x16.gif" title="<fmt:message key='icons.tooltip.insert'/>" width="16" height="16"/> 
		        	New Ticket Provider</a>
		        </td>
		        </tr>
		        THIS SECTION IS FOR TICKET PROVIDER -->
		       
		      </tr>
		      
		      <script>
		      var actFrom, actTo;
		      var from_, to_;
		      function setFromDate(fromDate){
		    	  //alert(fromDate);
		    	  actFrom = true;
		    	  from_ = fromDate;
		    	  setHREF();
		      }
		      
		      function setToDate(toDate){
		    	  //alert(toDate);
		    	  actTo = true;
		    	  to_= toDate;
		    	  setHREF();
		      }
		      
		      
		      
		      function setHREF(){
		    	  if(adminLoged){
		    		  if(actFrom && actTo){
			    		  document.getElementById("newHREF").href='reportTicket.htm?output=xls&initDate='+from_+'&endDate='+to_+'&type=webMobile';
			    		  //Enable status combo for DomesticReport
			    		  document.getElementById("newHREF_").href='reportTicket.htm?output=xls&initDate='+from_+'&endDate='+to_+'&type=domesticOP'+'&status=A';
			    		  $('#statusReport').prop("disabled", false);
			    	  } 
		    	  }
		      }
		 	
		      //This is for invoice
    		  //Commented, right now date is not necessary
    		  //document.getElementById("newHREF_XML").href='reportTicket.htm?output=xml&initDate='+from_+'&endDate='+to_+'&type=xmlReport';
    		  //document.getElementById("newHREF_XML").href='reportTicket.htm?output=xml&customer='+codeClientTxt+'&invoiceNumber='+$('#invoiceNumber').val()+'&type=xmlReport';
    		  //
		      </script>
		      <tr>
		        <td align="right">
		        	<div id="trHREF" style="display:none">
			        	<a id="newHREF"  title="<fmt:message key='icons.tooltip.report'/>">
			        	<img border="0" src="images/ticket_report_16x16.jpg" title="<fmt:message key='icons.tooltip.report'/>" width="16" height="16"/> 
			        	Create Report (Tickets via WEB/Mobile)</a>
		        	</div>
		        </td>
		      </tr>
		      <tr>
		      <!-- Especial report for ROLE VIEW only domestic clients -->
		      <td align="right">
		        	<div id="trHREF_" style="display:none">
			        	<a id="newHREF_"  title="<fmt:message key='icons.tooltip.report'/>">
			        	<img border="0" src="images/ticket_report_16x16.jpg" title="<fmt:message key='icons.tooltip.report'/>" width="16" height="16"/> 
			        	Create Report (Ticket domestic clients)</a>
		        	</div>
		        </td>
		      </tr>
		      <!-- END  ---  Especial report for ROLE VIEW only domestic clients -->
		      
		      <!-- Especial report for customer fuel consumption -->
		      <td align="right">
		        	<div id="trHREF_FC" style="display:none">
			        	<a id="newHREF_FC"  title="<fmt:message key='icons.tooltip.report'/>">
			        	<img border="0" src="images/ticket_report_16x16.jpg" title="<fmt:message key='icons.tooltip.report'/>" width="16" height="16"/> 
			        	Create Report (Fuel Consumption)</a>
		        	</div>
		        </td>
		      </tr>
		      <!-- END  ---  Especial report for customer fuel consumption -->
		      
		       <!-- Especial AREA FOR XML -->
		      <td align="right">
		        	<div id="trHREF_XML" style="display:none">
			        	<a id="newHREF_XML"  title="<fmt:message key='icons.tooltip.report'/>">
			        	<img border="0" src="images/ticket_report_16x16.jpg" title="<fmt:message key='icons.tooltip.report'/>" width="16" height="16"/> 
			        	Create XML IATA Invoice (Standard 2.0.2) </a>
		        	</div>
		        </td>
		      </tr>
		      <!-- END  ---  Especial AREA FOR XML -->
		    </table>
		    <tr>
	</td>
	
	<tr>
		<td align="center">
			<core:choose>
                                <core:when test="${(results==null || results.totalRows==0)}">					
					<div class="redText">
						<fmt:message key="results.zero" />
					</div>
				</core:when>
				<core:otherwise>
					<!-- LISTA DE RESULTADOS -->
                <core:choose>
                     	<core:when test="${(sessionScope.user.roleId == 8)}">
 		     		
			</core:when>
			<core:otherwise>


		<table width="95%" border="0" cellpadding="1" cellspacing="1" align="center" class="borde">
                                                <thead>
                                                        <tr>
                                                                <core:if test="${infoClient==null}">
                                                                        <th class="borde" width="20%">Customer</th>
                                                                </core:if>
                                                                <th class="borde" width="10%">Ticket Code</th>
                                                                <th class="borde" width="17%">Provider</th>
                                                                <th class="borde" width="25%">Airport</th>
                                                                <th class="borde" width="10%">Date</th>
                                                                <th class="borde" width="7%">Airplane</th>
                                                                <th class="borde" width="1%">Checked</th>
                                                                <th class="borde" width="1%">Amendment</th>
                                                                <th class="ocultar_print" width="2%">Ticket Detail</th>
                                                                <th class="ocultar_print" width="2%">&nbsp;</th>
                                                        </tr>
                                                </thead>
                                                <core:set var="yes" value="Y" />
                                                <core:forEach items='${results.list}' var="t" varStatus="vs">
                                                        <core:if test='${vs.count mod 2 eq 0}'>
                                                                <core:set var="color" value="row1" />
                                                        </core:if>
                                                        <core:if test='${vs.count mod 2 != 0}'>
                                                                <core:set var="color" value="row2" />
                                                        </core:if>
                                                        <tr class="${color}">
                                                                <core:if test="${infoClient==null}">
                                                                        <td class="borde" align="left">${t.cardnameClient}</td>
                                                                </core:if>
                                                                <td class="borde">${t.ticketCode}</td>
                                                                <td class="borde" align="left">${t.cardnameProvider}</td>
                                                                <td class="borde" align="left">
                                                                        <core:if test="${t.airport!=null}">${t.airport.name}</core:if>
                                                                </td>
                                                                <td class="borde"><fmt:formatDate value="${t.datetime}" pattern="yyyy-MM-dd hh:mm:ss" /></td>
                                                                <td class="borde">
                                                                        <core:if test="${!empty t.airplaneCode}">${t.airplaneCode}</core:if>
                                                                        <core:if test="${empty t.airplaneCode}">${t.newAirplaneCode} - new</core:if>
                                                                <!-- Checked -->
                                                                </td>
                                                                <td class="borde" align="center">
																	  <core:if test="${t.checked == 'N'}">
																	  	<img border="0" src="images/uncheck.png" width="16" height="16" alt="overdraft"/>
																	  </core:if>
																	  <core:if test="${t.checked == 'Y'}">
																	  	<img border="0" src="images/overdraft.png" width="16" height="16" alt="overdraft"/>
																	  </core:if>
                                                                </td>
                                                                <!-- Amendment -->
                                                                <td  align="center">
																	  <core:if test="${(fn:length(t.analistAmendment) <= 0)}">
																	  	<img border="0" src="images/uncheck.png" width="16" height="16" alt="Unchecked"/>
																	  </core:if>
																	  <core:if test="${fn:length(t.analistAmendment) > 0}">
																	  	<img border="0" src="images/overdraft.png" width="16" height="16" alt="Checked"/>
																	  </core:if>
																</td>
                                                                <core:if test="${menu[sessionScope.m].update}">
                                                                </core:if>
                                                                <td align="center"><a href="ticketDetail.htm?id=${t.id}" target="_blank"	
                                                                        onclick="return popup(this.href, 'Ticket detail')"> <img border="0" src="images/details_16x16.gif" alt="details"
                                                                                title="<fmt:message key='icons.tooltip.detail'/>" width="17" height="17" /> </a></td>
                                                                <td align="center" class="ocultar_print">
																	<core:if test="${menu[sessionScope.m].update}">
                                                <!-- Lets comment the update icon, the idea its to let the Analists (aka Operator) to modify the ticket several times -->
                                                                                <%-- <core:if test="${t.status==1}"> --%>
                                                                                        <a href="ticketUpdate.htm?id=${t.id}"> <img border="0" src="images/modificar.gif" alt="modificar"
                                                                                                title="<fmt:message key='icons.tooltip.modify'/>" width="17" height="17" /> </a>
                                                                                <%--</core:if>--%>
                                                                        </core:if>
                                                                </td>
                                                        </tr>
                                                </core:forEach>
                                                <tr bgcolor="#E6E6E6">
                                                        <td colspan="12"><t:pagination page="tickets.htm" numPage="${requestScope.numPage}"
                                                                        total="${results.totalRows}" numRows="${search.numRows}" totalPages="${results.totalPages}">
                                                                </t:pagination>
                                                        </td>
                                                </tr>
                                        </table>
                        </core:otherwise>
                </core:choose>
	
					
				</core:otherwise>
			</core:choose>
		</td>
	</tr>
	</div>
</table>