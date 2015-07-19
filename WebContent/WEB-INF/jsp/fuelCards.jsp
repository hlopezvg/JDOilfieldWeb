<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<table width="100%" align="center" border="0" cellpadding="0"
cellspacing="0">
	<tr>
		<td colspan="3" align="center">
			<div class="redText">${sessionScope.msg}</div> <core:set var="msg"
				value="${null}" scope="session" />
			<form name="form" action="" method="post">
			<div id="activity_pane"> 
			 <style type="text/css">

	a {
	  color: blue;
	  cursor:pointer;
          text-decoration: underline;
	}

        div.instructions_container {
	   float: left;
           width: 350px;
           margin-right: 50px;

        }

	        div.example_links 
         .link_category {
           margin-bottom: 15px;
        }

	.loading-indicator-bars {
		background-image: url('../images/loading-bars.gif');
		width: 150px;
	}

   </style>


 <script type="text/javascript">

	jQuery(document).ready(
		function() {
			//console.log("IN THE READY METHOD");
		  //
		  // When a user clicks the 'loading-default' link,
		  // call showLoading on the activity pane
		  // with default options
		  //
		  jQuery('a.loading-default').click(

			function() {
				jQuery('#activity_pane').showLoading();
			}

		  ); 


		  //
		  // When a user clicks the 'loading-ajax' link,
		  // call showLoading, sleep, then call hide loading
		  // with default options
		  //
		  jQuery('a.loading-ajax').click(

			function() {
				jQuery('#activity_pane').showLoading(
	 			 {
				    'afterShow': 
					function() {
						setTimeout( "jQuery('#activity_pane').hideLoading()", 3000 );
						addTicketHREF();
					}						
				 }
				);
			}

		  ); 


		  //
		  // When a user clicks the 'loading-bars' link,
		  // call showLoading with addClass specified
		  //
		  jQuery('a.loading-bars').click(

			function() {
				jQuery('#activity_pane').showLoading(
	 			 {
				    'addClass': 'loading-indicator-bars'
								
				 }
				);
			}

		  ); 


		  //
		  // When a user clicks the 'loading-hide' link,
		  // call hideLoading on the activity pane
		  //
		  jQuery('a.loading-hide').click(

			function() {
				jQuery('#activity_pane').hideLoading();
			}

		  ); 

		}
	);
	
	function addTicketHREF(){
		window.setInterval(myTimmer,3000);
	}
	
	function myTimmer(){
		window.location = fuelCardHREF; 
	}

   </script>
				<br />
				<fieldset style="width: 420px;">
					<legend>Search</legend>
					<table width="95%" border="0" cellpadding="6" cellspacing="6">
							
					<!-- THIS IS FOR PROVIDERS editMode/viewMode -->
					<core:if test="${(sessionScope.user.roleId != 1) && (sessionScope.user.roleId != 9)}">
						<core:set var="editModeProvider" value='disabled="disabled"'/>
						<core:set var="viewModeProvider" value='style="display: none;"'/>
					</core:if>
					<!-- END OF PROVIDERS -->
			
						<tr align="left">
			  			<td>Fuel Card Code:</td>
							<td align="left" colspan="3">
						    	<spring:bind path="search.fuelCardCode">
						      		<input size=17 type="text" name="fuelCardCode" id="fuelCardCodeId"   
						      			value="${search.fuelCardCode}" ${editMode}/>
						      	</spring:bind>
						      	<script type="text/javascript">					      	  
							      	//http://www.mkyong.com/jquery/how-to-check-if-an-enter-key-is-pressed-with-jquery/
						      		$('#fuelCardCodeId').keypress(function(event){
							      		var keycode = (event.keyCode ? event.keyCode : event.which);
							      		if(keycode == '13'){
							      			$( "#btnValidateFuelCard" ).trigger( "click" );
									      	return false;
							      		}
							      	});
						      	</script>
						     
						      
			
					      		<input id="btnValidateFuelCard"  style="width: 150px;"  type="button" value="Validate Fuel Card Code" />
					   
						      	
						      	<input id="btnResetSearch"  ${viewModeProvider} style="width: 55px;" type="button" value="Reset"/>
						      	<script type="text/javascript">
						      		$('#btnResetSearch').on("click", function(){
						      			window.location = 'fuelCards.htm';
						      		});
						      			
						      	</script>
						      </td>
							<!--  LETS VALIDATE THE FUEL CARD WITH THIS OPTION -->

							
							<td>  
								<div class="link" id="href_spinner">
									<a class="loading-ajax"></a>
      							</div>
							</td>
							<script>
								var fuelCardHREF;
								$('#fuelCardCodeId').change(function(){
									fuelCardHREF = 'fuelCardAdd.htm?fuelCard='+$(this).val();
									//console.log('evaluate the href --> ' + fuelCardHREF);						
									$('#ticketProviderHREF').attr('href', fuelCardHREF);
									
									//This is for the Button
									//<input type="button" value="Page" onclick="location.href='http://www.domain.com';">
									$('#btnValidateFuelCard').click(function() {
										//Invoke the spinner
										fuelCardHREF = fuelCardHREF + '&btnValidate=true';
										//console.log('evaluate the href from btn--> ' + fuelCardHREF);	
										$('#href_spinner').find("a").trigger("click"); 	
									});
									
								});
							</script>
			  			</tr>
						<!-- <tr>
							<td width="41%">Fuel Card Number:</td>
							<td> <spring:bind path="search.fuelCardCode">
									<input type="text" name="fuelCardCode" value="${search.fuelCardCode}" />
								</spring:bind>
							</td>
						</tr> -->
						
						<tr ${viewModeProvider}>	
						<td>Clients:</td>
							<td> <spring:bind path="search.codeClient">
									<select id='codeClient'  name="codeClient" >
										<option value="0">All</option>
										<core:forEach items='${searchLists.clients}' var="client" varStatus="r">
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
										var carCodeClientParam;
										$('#codeClient').change(function(){
											carCodeClientParam = 'fuelCardAdd.htm?action=add'+'&cardCodeClient='+$('#codeClient').val()+'&btnValidate=false';
											//carCodeClientParam = 'fuelCardAdd.htm?action=add';
											//console.log('evaluate the href --> ' + carCodeClientParam);						
											$('#fuelCardHREF').attr('href', carCodeClientParam);	
										});
									</script>
							</td>
							<td width="31%">&nbsp;</td>
						</tr>
					</table>
					<table width="220" border="0" align="right">
						<tr ${viewModeProvider}>
							<td>Results per page: <spring:bind path="search.numRows">
									<select name="numRows">
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
								</spring:bind>
							</td>
							<td align="right"><input type="submit" name="SubmitButton"
								value="Search" /></td>
						</tr>
					</table>
				</fieldset>
			<!-- The Div for activity id pane -->
			<!--  </div> -->
			</form>
		</td>
	</tr>
	<tr>
		<td colspan="3" align="center"><core:if
				test="${menu[sessionScope.m].insert}">
				<table width="60%" border="0">
					<tr>
						<td align="right">
							<a id="fuelCardHREF" title="<fmt:message key='icons.tooltip.insert'/>"> <img
									border="0" src="images/add_16x16.gif"
									title="<fmt:message key='icons.tooltip.insert'/>" width="16"
									height="16" alt="addFuelCard" /> New Fuel Card
							</a>
						</td>
					</tr>
				</table>
			</core:if> <core:choose>
				<core:when test="${results.totalRows==0}">
					<div class="redText">
						<fmt:message key="results.zero" />
					</div>
				</core:when>
				<core:otherwise>
				<core:if test="${(sessionScope.user.roleId == 1) || (sessionScope.user.roleId == 6) 
												|| (sessionScope.user.roleId == 9)}">
					<table width="80%" border="0" cellpadding="1" cellspacing="1"
						align="center" class="borde">
						<thead>
							<tr>
								<th width="45%">Name</th>
								<th width="22%">Fuel Card</th>
								<th width="12%">Aircraft</th>
								<th width="12%">Status</th>
								<th width="20%">Due Date</th>
								<th width="20%" colspan="2">Operations</th>
							</tr>
						</thead>
						<core:forEach items='${results.list}' var="fuelCard" varStatus="vs">
							<core:if test='${vs.count mod 2 eq 0}'>
								<core:set var="color" value="row1" />
							</core:if>
							<core:if test='${vs.count mod 2 != 0}'>
								<core:set var="color" value="row2" />
							</core:if>
							<tr class="${color}">
								<td align="left">${fuelCard.cardCodeName}</td>
								
								<core:choose>
								<core:when test="${fuelCard.status eq 'Bloqueado'}">
									<core:set var="blocked" value='bgcolor="#FF0000"'/>
									<td align="center" ${blocked}>${fuelCard.fuelCardCode}</td>
								</core:when>
								<core:otherwise>
									<td align="center">${fuelCard.fuelCardCode}</td>
								</core:otherwise>
								</core:choose>
								
								<td align="center">${fuelCard.aircraftCode}</td>
								<td align="center">${fuelCard.status}</td>
								<td align="center">${fuelCard.stringEndDate}</td>
								
								<td width="10%" align="center"><core:if
										test="${menu[sessionScope.m].update}">
										<a href="fuelCardUpdate.htm?action=update
										&amp;fuelCardCode=${fuelCard.fuelCardCode}
										&amp;cardCodeClient=${fuelCard.cardCodeClient}
										&amp;id=${fuelCard.id}">
											<img border="0" src="images/modificar.gif"
											title="<fmt:message key='icons.tooltip.modify'/>" width="17"
											height="17" alt="modificar" />
										</a>
									</core:if></td>
								<td width="10%" align="center">
								<core:if	test="${menu[sessionScope.m].delete}">
										<a href="#"
											onclick="confirmDelete('${fuelCard.fuelCardCode}', 'fuelCardDelete.htm?id=${fuelCard.fuelCardCode}','Fueld Card')">
											<img border="0" src="images/delete_20x20.gif"
											title="<fmt:message key='icons.tooltip.delete'/>" width="20"
											height="20" alt="confirmDelete" />
										</a>
								</core:if></td>
							</tr>
						</core:forEach>
						<tr bgcolor="#E6E6E6">
							<td colspan="7"><t:pagination page="fuelCards.htm"
									numPage="${requestScope.numPage}" total="${results.totalRows}"
									numRows="${search.numRows}" totalPages="${results.totalPages}">
								</t:pagination></td>
						</tr>
					</table>
					</core:if>
				</core:otherwise>
			</core:choose></td>
	</tr>
	</div>
</table>