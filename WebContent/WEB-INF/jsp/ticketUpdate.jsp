<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="3" align="center">
			<div class="redText">${msg}</div>
			<table width="600" align="center" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td align="right">
						<a href="tickets.htm?page=1"><img src="images/back.gif"
							title="<fmt:message key='icons.tooltip.back'/>" width="16" height="16" border="0" alt="back"/>Back</a>
					</td>
				</tr>
			</table>
			  <script type="text/javascript">
			  	console.log('User login: ' + '${sessionScope.user.login}');
			  </script>
			<core:choose>
			<core:when test="${(sessionScope.user.roleId == 5) || (sessionScope.user.roleId == 1) || (sessionScope.user.roleId == 6)}">
				<core:set var="editMode" value=''/>
				<core:set var="enableCal" value="onclick"/>
				<!-- '\"displayCalendar(document.forms[0].datetimeString,\\'yyyy-mm-dd hh:ii:ss\\' ,this,true)\"' -->
				<script>
				console.log("roleID: " + '${sessionScope.user.roleId}');
		    	console.log("edit mode -----------> " + '${enableCal}');
			    </script>
			</core:when>
			<core:otherwise>
			    <script>
			        <core:set var="editMode" value='disabled="disabled"'/>
			        <core:set var="enableCal" value="onclick_"/>
			        console.log("edit mode -----------> " + '${editMode}');
			    </script>
			</core:otherwise>
			</core:choose>
			
			<form name="form" id="ticketUpdateForm" action="" method="post">
				<fieldset class="fieldsetInterno">
					<legend>Update Ticket </legend>
					<table width="90%" border="0" cellpadding="4" cellspacing="4">
						<tr align="left">
							<td colspan="2"><spring:hasBindErrors name="ticket">
									<core:forEach items="${errors.allErrors}" var="error">
										<div class="redText">-<spring:message message="${error}" /></div>
									</core:forEach>
								</spring:hasBindErrors>
							</td>
						</tr>
						
						<tr>
						<td>Checked:</td>
							<td width="30%" colspan="2" align="left">
							    <spring:bind path="ticket.checked">
								    <div id="divChecked">
								     	<input type="checkbox" id="btnChecked" name="checked" value="${ticket.checked}" >
								    </div>
								     <script>
								     $(document).ready(function(){
								    	 //alert('ready');
								    	 console.log('ready');
								    	 var editMode = 'disabled="disabled"';
										//$("#btnChecked").prop("checked", true);
										//<img border="0" src="images/overdraft.png" width="16" height="16" alt="overdraft"/>
										if('${ticket.checked}' == 'Y'){
											$("#btnChecked").remove();
											$("#divChecked").append('<img border="0" src="images/overdraft.png" width="16" height="16" alt="overdraft"/>');	
										}
									});
								     </script>
								</spring:bind>
								 <script type="text/javascript">
									$('#btnChecked').mousedown(function() {
									    if (!$(this).is(':checked')) {
									        //this.checked = confirm("Are you sure?");
									         jConfirm('Are you sure you want to check the ticket? ' + '<br><b>'
									        		 + ' Note: Ticket is going to be sent without amendment and it is going to be checked', 'J&D Oilfield', function(r) {
												if(r){
													//jAlert('Ticket is going to be sent without amendment and already checked');
												    $('#submit_button_checked').trigger("click");
												}   
											});
									        //$(this).trigger("change");
									    }
									});
   								 </script>
							</td>
						</tr>
						
						<tr align="left">
							<td width="18%">Ticket code:</td>
							<td colspan="2" align="left"><spring:bind path="ticket.ticketCode">
									<input id="ticketCode" type="text" name="ticketCode" value="${ticket.ticketCode}" ${editMode}/>
								</spring:bind>
							</td>
						</tr>
						<!-- Pass the role ID of the user to the controller -->
						 <div style="display: none">
						 <spring:bind path="ticket.sessionRoleId">			   
				              <input type="text"  id= "sessionRoleId" name="sessionRoleId" value=${sessionScope.user.roleId} />
				         </spring:bind>
						</div>
						<tr>
						<!-- CUSTOMER SECTION -->
							<td align="left">Customer</td>
							<td align="left" colspan="2">
							<!--Hidden Value for Ammendment Value for the controller  -->
							<input type="hidden" id="amendmentCustomerCode" name="customerCode_" value=""/>
							<spring:bind path="ticket.cardnameClient">
									<select  name="cardnameClient" id="cardnameClient" ${editMode}>
										<core:forEach items='${lists.customers}' var="client">
											<core:choose>
												<core:when test="${ticket.clientCode == client.cardcode}">
													<option value="${client.cardname}" title="${client.cardname}" selected="selected">${client.cardname}</option>
												</core:when>
												<core:otherwise>
													<option value="${client.cardname}">${client.cardname}</option>
												</core:otherwise>
											</core:choose>
										</core:forEach>
									</select>
							</spring:bind>
							<!-- THIS SECTIONS WILL FILL THE ARRAY THAT'S GOING TO BE SENT TO THE CONTROLLER IN ORDER TO TRIGGER THE UPDATE, THIS IS THE
							SAME WAY FOR ALL THE VALUES ON THE FORM -->
							<script>
								var $custCode;
								$(document).ready(function(){
									$custCode = $('#cardnameClient');
									$custCode.data('oldVal',  $custCode.val());
									//alert("oldValue --> "  + $prvCode.data('oldVal'));
									$("#oldValues").addOldValuesToArray($custCode.data('oldVal'));
									
								});
								
							       $("#cardnameClient").change(function () {
						        	$custCode.data('newVal',  $custCode.val());
									   //alert("new val --> " + $prvCode.data('newVal'));
									    	if($custCode.data('oldVal') != $custCode.data('newVal')){
									            //alert("changed to --> " + $custCode.data('newVal'));	
									          //Let's call here the method that adds the changes.
									            $("#amendmentCustomerCode").addToArray($custCode.data('newVal'));
									           // alert($("#amendmentCustomerCode").val());
								            }else{
								            	$("#amendmentCustomerCode").removeFromArray($("#amendmentCustomerCode").val());
									           // alert($("#amendmentCustomerCode").val());
								            }

								  });
								</script>
							</td>
						</tr>
						<tr align="left">
							<td>Status</td>
							<td colspan="2"><spring:bind path="ticket.status">
									<input type="text" name="status" value="${ticket.statusLov.nameItem}" disabled="${editMode}" />
								</spring:bind>
							</td>
						</tr>
						<tr align="left">
							<td>Overdraft</td>
							<td colspan="2"><core:if test="${ticket.overdraftString == 'Y'}">
									<img border="0" src="images/overdraft.png" width="16" height="16" alt="overdraft"/>
								</core:if> <core:if test="${ticket.overdraftString == 'N'}">
									<input type="text" value="NO" disabled="disabled" />
								</core:if>
							</td>
						</tr>
						<tr align="left">
							<td>Date:</td>
							<td  ${editMode} width="30%" colspan="2" align="left">
							<!--Hidden Value for Ammendment Value for the controller  -->
							<input type="hidden" id="amendmentDate" name="datetimeString_" value=""/>
							<spring:bind path="ticket.datetimeString">
									<input 	${editMode} readonly="readonly" type="text" name="datetimeString" id="date_" onchange="forceDateChk()"  
										value="<fmt:formatDate  value='${ticket.datetime}' pattern='yyyy-MM-dd hh:mm:ss' />" />
							<script>
									var $dateChange;
									$(document).ready(function(){
										$dateChange = $('#date_');
										$dateChange.data('oldVal',  $dateChange.val());
										//alert("oldValue --> "  + $dateChange.data('oldVal'));
										$("#oldValues").addOldValuesToArray($dateChange.data('oldVal'));
										
									});
									
								//Call from onchange, it differs from the other ways because the input es readonly	
								   function forceDateChk(){
									   $dateChange.data('newVal',  $dateChange.val());
									   //alert("new val --> " + $dateChange.data('newVal'));
								    	
								    	if($dateChange.data('oldVal') != $dateChange.data('newVal')){
								            //alert("changed to --> " + $dateChange.data('newVal'));
								            //Let's call here the method that adds the changes.
								            $("#amendmentDate").addToArray($dateChange.data('newVal'));
								            //Disable the checked button
								            //alert($("#amendmentDate").val());
							            }else{
							            	$("#amendmentDate").removeFromArray($("#amendmentDate").val());
								            //alert("quitando: "+ $("#amendmentDate").val());
								   }
								}
							</script>
							</spring:bind> 
								<a  id="cal_" ${enableCal}="displayCalendar(document.forms[0].datetimeString,'yyyy-mm-dd hh:ii:ss' ,this,true)"> <img 
										 src="images/almanaque.gif" alt="<fmt:message key='icons.tooltip.calendar'/>" border="0" width="20"
										height="16" /> 
								</a>
							</td>
						</tr>
						<tr align="left">
							<td>Provider:</td>
							<td colspan="2"><spring:bind path="ticket.providerCode">
							<!--Hidden Value for Ammendment Value for the controller  -->
							<input type="hidden" id="amendmentProviderCode" name="providerCode_" value=""/>
									<select  name="providerCode" id="providerCode" ${editMode}>
										<core:forEach items='${lists.providers}' var="provider">
											<core:choose>
												<core:when test="${provider.cardcode==ticket.providerCode}">
													<option value="${provider.cardcode}" title="${provider.cardname}" selected="selected">${provider.cardname}</option>
												</core:when>
												<core:otherwise>
													<option value="${provider.cardcode}">${provider.cardname}</option>
												</core:otherwise>
											</core:choose>
										</core:forEach>
									</select>
								</spring:bind>
								<script>
								var $prvCode;
								$(document).ready(function(){
									$prvCode = $('#providerCode');
									$prvCode.data('oldVal',  $prvCode.val());
									//alert("oldValue --> "  + $prvCode.data('oldVal'));
									$("#oldValues").addOldValuesToArray($prvCode.data('oldVal'));
									
								});
								
							       $("#providerCode").change(function () {
						        	$prvCode.data('newVal',  $prvCode.val());
									   //alert("new val --> " + $prvCode.data('newVal'));
									    	if($prvCode.data('oldVal') != $prvCode.data('newVal')){
									            //alert("changed to --> " + $prvCode.data('newVal'));	
									          //Let's call here the method that adds the changes.
									            $("#amendmentProviderCode").addToArray($prvCode.data('newVal'));
									           // alert($("#amendmentProviderCode").val());
								            }else{
								            	$("#amendmentProviderCode").removeFromArray($("#amendmentProviderCode").val());
									           // alert($("#amendmentProviderCode").val());
								            }

								  });
								</script>
							</td>
						</tr>
						<tr align="left">
							<td>Airport:</td>
							<td colspan="2"><spring:bind path="ticket.airportId">
							<!--Hidden Value for Ammendment Value for the controller  -->
							<input type="hidden" id="amendmentAirportId" name="airportId_" value=""/>
									<select name="airportId" id="airportId" ${editMode}>
										<core:forEach items='${lists.airports}' var="airport">
											<core:choose>
												<core:when test="${airport.id==ticket.airportId}">
													<option value="${airport.id}" selected="selected">${airport.name}</option>
												</core:when>
												<core:otherwise>
													<option value="${airport.id}">${airport.name}</option>
												</core:otherwise>
											</core:choose>
										</core:forEach>
									</select>
									<script>
									var $airport_;
									$(document).ready(function(){
										$airport_ = $('#airportId');
										$airport_.data('oldVal',  $airport_.val());
										//alert("oldValue --> "  +  $airport_.data('oldVal'));
										$("#oldValues").addOldValuesToArray($airport_.data('oldVal'));
									});
									
								       $("#airportId").change(function () {
								        	  $airport_.data('newVal',  $airport_.val());
											   //alert("new val --> " + $airport_.data('newVal'));
										    	if($airport_.data('oldVal') != $airport_.data('newVal')){
										            //alert("changed to --> " + $airport_.data('newVal'));
										            $("#amendmentAirportId").addToArray($airport_.data('newVal'));
										            //alert($("#amendmentAirportId").val());
									            } else{
									            	$("#amendmentAirportId").removeFromArray($("#amendmentAirportId").val());
										            //alert($("#amendmentAirportId").val());
									            } 
								       });
									</script>
								</spring:bind>
							</td>
						</tr>
						<tr align="left">
							<td>Airplane:</td>
							<td colspan="2" align="left"><spring:bind path="ticket.airplaneCode">
							<!--Hidden Value for Ammendment Value for the controller  -->
							<input type="hidden" id="amendmentAirplaneCode" name="airplaneCode_" value=""/>
									<input type="text" maxlength="10" name="airplaneCode" value="${ticket.airplaneCode}" id="airplaneCode" ${editMode}/>
								</spring:bind>
								<script>
								var $el;
								$(document).ready(function(){
									$el = $('#airplaneCode');								
									$el.data('oldVal',  $el.val() );
									//alert("oldValue --> "  + $el.data('oldVal'));
									$("#oldValues").addOldValuesToArray($el.data('oldVal'));
								});
								
							    $('#airplaneCode').change(function(){						            
						            $el.data('newVal',  $(this).val() );
						            //alert("newValue--> "  + $el.data('newVal'));
						            
							    	if($el.data('oldVal') != $el.data('newVal')){
							           // alert("changed to --> " + $el.data('newVal'));
							            $("#amendmentAirplaneCode").addToArray($el.data('newVal'));
							           // alert($("#amendmentAirplaneCode").val());
						            }else{
						            	$("#amendmentAirplaneCode").removeFromArray($("#amendmentAirplaneCode").val());
							           // alert($("#amendmentAirplaneCode").val());
						            }
								    
								});
								</script>
							</td>
						</tr>
						<tr align="left">
							<td>Product:</td>
							<td colspan="2" align="left"><spring:bind path="ticket.productCode">
							<!--Hidden Value for Ammendment Value for the controller  -->
							<input type="hidden" id="amendmentProductCode" name="productCode_" value=""/>
									<select name="productCode" id="productCode" ${editMode}>
										<core:forEach items='${lists.products}' var="product">
											<core:choose>
												<core:when test="${product.itemcode==ticket.productCode}">
													<option value="${product.itemcode}" selected="selected">${product.itemname}</option>
												</core:when>
												<core:otherwise>
													<option value="${product.itemcode}">${product.itemname}</option>
												</core:otherwise>
											</core:choose>
										</core:forEach>
									</select>
									<script>
									var $product_;
									$(document).ready(function(){
										$product_ = $('#productCode');
										$product_.data('oldVal',  $product_.val());
										//alert("oldValue --> "  +  $product_.data('oldVal'));
										$("#oldValues").addOldValuesToArray($product_.data('oldVal'));
									});
									
								       $("#productCode").change(function () {
								        	  $product_.data('newVal',  $product_.val());
											   //alert("new val --> " + $product_.data('newVal'));
										    	if($product_.data('oldVal') != $product_.data('newVal')){
										           // alert("changed to --> " + $product_.data('newVal'));
										            $("#amendmentProductCode").addToArray($product_.data('newVal'));
										           // alert($("#amendmentProductCode").val());
									            } else{
									            	$("#amendmentProductCode").removeFromArray($("#amendmentProductCode").val());
										           // alert($("#amendmentProductCode").val());
									            }
								       });
								</script>
								</spring:bind>
							</td>
						</tr>
						<tr align="left">
							<td>QuantityLts:</td>
							<td colspan="2" align="left"><spring:bind path="ticket.quantityLtsString">
							<!--Hidden Value for Ammendment Value for the controller  -->
							<input type="hidden" id="amendmentQtyLts" name="quantityLtsString_" value=""/>
							<input maxlength="25" type="text" id="quantityLtsString" name="quantityLtsString" value="${ticket.quantityLtsString}" 
												${editMode}/>
								</spring:bind>
								<script>
								var $quantity;
								$(document).ready(function(){
									$quantity = $('#quantityLtsString');								
									$quantity.data('oldVal',  $quantity.val() );
									//alert("oldValue --> "  + $quantity.data('oldVal'));
									$("#oldValues").addOldValuesToArray($quantity.data('oldVal'));
								});
								
							    $('#quantityLtsString').change(function(){						            
						            $quantity.data('newVal',  $(this).val() );
						            //alert("newValue--> "  + $quantity.data('newVal'));
						            
							    	if($quantity.data('oldVal') != $quantity.data('newVal')){	
							            $("#amendmentQtyLts").addToArray($quantity.data('newVal'));
							           // alert($("#amendmentQtyLts").val());
						            }else{
						            	$("#amendmentQtyLts").removeFromArray($("#amendmentQtyLts").val());
							           // alert($("#amendmentQtyLts").val());
						            }
								});
								</script>
							</td>
						</tr>
						<tr align="left">
							<td>Notes:</td>
							<!--Hidden Value for Ammendment Value for the controller  -->
							<input type="hidden" id="amendmentNotes" name="notes_" value=""/>
							<td colspan="2" align="left"><spring:bind path="ticket.notes">
							<textarea name="notes" id="notes" cols="20" rows="3" ${editMode} >${ticket.notes}</textarea>
								</spring:bind>
								<script>
								var $notes;
								$(document).ready(function(){
									$notes = $('#notes');								
									$notes.data('oldVal',  $notes.val() );
									//alert("oldValue --> "  + $notes.data('oldVal'));
									$("#oldValues").addOldValuesToArray($notes.data('oldVal'));
								});
								
							    $('#notes').change(function(){						            
						            $notes.data('newVal',  $(this).val() );
						           // alert("newValue--> "  + $notes.data('newVal'));	            
						            
							    	if($notes.data('oldVal') != $notes.data('newVal')){
							            $("#amendmentNotes").addToArray($notes.data('newVal'));
							            //alert($("#amendmentNotes").val());
							            
						            }else{
						            	$("#amendmentNotes").removeFromArray($("#amendmentNotes").val());
							            //alert($("#amendmentNotes").val());
						            }
								});
								</script>
							</td>
						</tr>
						
			<!-- AMENDMENT!!!! -->
						<tr align="left">
							<td>Amendment:</td>
							<td colspan="2" align="left"><spring:bind path="ticket.analistAmendment">
									<textarea name="analistAmendment" id="analistAmendment" cols="20" rows="3" >${ticket.analistAmendment}</textarea>
									</spring:bind>
							</td>
						</tr>
			<!-- END AMENDMENT -->
						<core:if test="${element.newAirplane == 'Y'}">
							<tr>
								<td align="left"><strong>New Airplane </strong></td>
								<td align="left"><spring:bind path="ticket.newAirplaneCode">
										<input type="text" name="newAirplaneCode" value="${ticket.newAirplaneCode}" disabled="disabled" />
									</spring:bind>
								</td>
							</tr>
						</core:if>
						<tr align="left">
							<td width="18%">Released by:</td>
							<td colspan="2" align="left">
							    <spring:bind path="ticket.releasedBy">
									<input type="text" name="releasedBy" value="${ticket.releasedBy}" ${editMode} />
								</spring:bind>
							</td>
						</tr>
						<tr align="left">
							<td width="18%">User:</td>
							<td colspan="2" align="left"><spring:bind path="ticket.user.userName">
									<input type="text" name="user.userName" value="${ticket.user.userName}" disabled="disabled" />
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td colspan="2" align="center">&nbsp;</td>
						</tr>
					</table>
					<table width="258" border="0" align="center">
						<tr>
							<td width="82"><input type="submit"   id= "submit_button" name="operation" value="Modify Ticket" /></td>
							<script>
							//Before the submit we will  join all the hidden input into the ammendment input, separeted by coma
							$('#submit_button').click(function() {
								$('input[type="hidden"]').each(function(){
										if($(this).val().length > 0){
											//alert($(this).attr("name"));
											$("#amendment").addAllToArray($(this).attr("name")+"-->"+$(this).val());	
										}
									});
									//alert($("#amendment").val());
									//alert($("#oldValues").val());
									$("#analistAmendment").addAllToArray('    ----->   ${sessionScope.user.login}');
									//console.log("Amendments!!!!!!  " + $('#analistAmendment').val());
							    $('#ticketUpdateForm').submit();
							});

							</script>
							
							<div  style="display:none"> 
							<!--  -->
										<input id="amendment" name="amendment"  value=""/>
										<input id="oldValues" name="oldValues"  value=""/>
									
							</div>
							<script>
								//This section assembles the array that is going to the controller
								//Thanks to nick Craver --> http://stackoverflow.com/users/13249/nick-craver
								var arr;
								jQuery.fn.extend({
								    addToArray: function(value) {
								    	return this.filter(":input").val(function(i, v) {
										   arr = v.split('');
										   $(this).removeAllFromArray();
										   
								           arr.push(value);
								           return arr.join(',');
								        }).end();
								    },
								    removeFromArray: function(value) {
								    	return this.filter(":input").val(function(i, v) {
								           return $.grep(v.split(','), function(val) {  
								                    return val != value;
								                  }).join(',');
								        }).end();
								    },
								    
								    removeAllFromArray: function() {
								    	 return this.filter(":input").val(function(i, v) {
								         return arr.length = 0;
								        }).end();
								    },
								    
								    addAllToArray : function (value) {
								    	return this.filter(":input").val(function(i, v) {
								    		if($(this).val().length == 0){
								    			arr = v.split('');	   
	 								           }else {
	 								        	  arr = v.split('^');	   
	 								           }   
									           arr.push(value);
									           return arr.join('^');
									        }).end();
									},
									
									addOldValuesToArray: function(value) {
								    	return this.filter(":input").val(function(i, v) {
										   arr = v.split(',');
								           arr.push(value);
								           return arr.join(',');
								        }).end();
								    }
								});
							</script>
							<td width="70" align="center"></td>
							<!--  <td width="92" align="center"><input type="submit" name="operation"  value="Cancel Ticket" ${editMode} /></td>-->
							<div  style="display:none"> 
							 <input type="submit" id="submit_button_checked" name="operation"  value="Ticket Checked" /></td> 
							</div> 
						</tr>
					</table>
				</fieldset>
			</form>
		</td>
	</tr>
</table>