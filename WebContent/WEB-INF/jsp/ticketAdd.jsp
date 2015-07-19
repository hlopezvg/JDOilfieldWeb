<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<table width="100%" align="center" border="0" cellpadding="0"
	cellspacing="0">
	<tr>
		<td colspan="3" align="center">
			<div class="redText">${msg}</div>
			<table width="600" align="center" border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<td align="right"><a href="tickets.htm?page=1"><img
							src="images/back.gif"
							title="<fmt:message key='icons.tooltip.back'/>" width="16"
							height="16" border="0" alt="back" />Back</a></td>
				</tr>
			</table> <core:url value="addTicket" var="addTicketUrl" />
			<form name="form" onsubmit="validateAllOnWayOut()" method="post"
				onload="">
				<br />

				<script>
					var companyList;

					function validateAllOnWayOut() {
						updateClientName();
						updateProviderName();
						updateProductName();
					}
				</script>
				<fieldset class="fieldsetInterno">
					<legend>New Ticket </legend>
					<table width="90%" border="0" cellpadding="4" cellspacing="4">
						<tr align="left">
							<td colspan="2"><spring:hasBindErrors name="ticket">
									<core:forEach items="${errors.allErrors}" var="error">
										<div class="redText">
											<spring:message message="${error}" />
										</div>
									</core:forEach>
								</spring:hasBindErrors></td>
						</tr>
						<!-- TICKET CODE -->
						<tr align="left">
							<td width="18%">Ticket code:</td>
							<td colspan="2" align="left"><spring:bind
									path="ticket.ticketCode">
									<input type="text" name="ticketCode"
										value="${ticket.ticketCode}" />
								</spring:bind></td>
						</tr>
						<!--END TICKET CODE -->

						<!-- CUSTOMER -->
						<tr align="left">
							<td>Customers:</td>
							<td colspan="2"><spring:bind path="ticket.clientCode">
									<select id="clientCode" name="clientCode"
										onchange="updateClientName()">
										<core:choose>
											<core:when
												test="${(sessionScope.user.roleId == 4) || (sessionScope.user.roleId == 2)}">
												<option value="${user.clientCode}" title="${user.userName}">
													${user.userName}</option>
												<script>
													clientLogged = true;
												</script>
											</core:when>
											<core:otherwise>
												<option value="-1">Select one</option>
												<script>
													clientLogged = false;
												</script>

												<core:forEach items='${lists.customers}' var="customer">
													<core:choose>
														<core:when
															test="${ticket.clientCode == customer.cardcode}">
															<option value="${customer.cardcode}"
																title="${customer.cardname}" selected="selected">${customer.cardname}</option>
														</core:when>
														<core:otherwise>
															<option value="${customer.cardcode}"
																title="${customer.cardname}">${customer.cardname}</option>
														</core:otherwise>
													</core:choose>
												</core:forEach>
												<script>
													updateClientName();
												</script>

												<!--  <core:forEach items='${lists.customers}' var="customer">
						    	  	<option value="${customer.cardcode}"  title="${customer.cardname}"> ${customer.cardname} </option>
						     </core:forEach>-->

											</core:otherwise>
										</core:choose>
									</select>
								</spring:bind></td>
						</tr>
						<div id="hidden_input_holder_cardname_client"
							style="display: none">
							<input id="cardnameClient" type="text" name="cardnameClient" />
						</div>


						<!-- SCRIPT CLIENT NAME -->
						<script>
							function updateClientName() {
								var select = document
										.getElementById('clientCode');
								var name = select.options[select.selectedIndex].title;
								var holder = document
										.getElementById('cardnameClient');
								holder.value = name;
								$.airplaneAutocomplete();
							}
						</script>

						<!-- END OF SCRIPT CLIENT NAME -->
						<!-- END CUSTOMER -->


						<!-- DATE -->
						<tr align="left">
							<td>Date:</td>
							<td width="30%" colspan="2" align="left"><spring:bind
									path="ticket.datetimeString">
									<!-- <input readonly="readonly" type="text" name="datetimeString" value="<fmt:formatDate  value='${ticket.datetime}' pattern='yyyy-MM-dd hh:mm:ss' />" />-->
									<input readonly="readonly" type="text" name="datetimeString"
										value='${ticket.datetimeString}'/">
								</spring:bind> <a
								onclick="displayCalendar(document.forms[0].datetimeString,'yyyy-mm-dd hh:ii:ss',this,true); clearFields()">
									<img src="images/almanaque.gif"
									alt="<fmt:message key='icons.tooltip.calendar'/>" border="0"
									width="20" height="16" />
							</a></td>
						</tr>
						<script>
							
						</script>
						<!-- END DATE -->

						<!-- PROVIDER -->
						<tr align="left">
							<td>Provider:</td>
							<td colspan="2"><spring:bind path="ticket.providerCode">
									<select id="providerCode" name="providerCode"
										onchange="updateProviderName()">
										<option value="-1">Select one</option>

										<core:forEach items='${lists.providers}' var="provider"
											varStatus="r">

											<core:choose>
												<core:when
													test="${ticket.providerCode == provider.cardcode}">
													<option value="${provider.cardcode}" selected="selected">${provider.cardname}</option>
												</core:when>
												<core:otherwise>
													<option value="${provider.cardcode}">${provider.cardname}</option>
												</core:otherwise>
											</core:choose>
											<!--  <option value="${provider.cardcode}"> ${provider.cardname} </option>-->

										</core:forEach>

									</select>
								</spring:bind></td>
						</tr>
						<div id="hidden_input_holder_cardname_provider"
							style="display: none">
							<input id="cardnameProvider" type="text" name="cardnameProvider" />
						</div>

						<!-- SCRIPT PROVIDER NAME -->
						<script>
							function updateProviderName() {
								var select = document
										.getElementById('providerCode');
								var nameProvider = select.options[select.selectedIndex].text;
								//alert(nameProvider);
								var holderProvider = document
										.getElementById('cardnameProvider');
								holderProvider.value = nameProvider;
								//alert(holderProvider.value);

							}
						</script>
						<!-- END OF SCRIPT PROVIDER NAME -->
						<!-- END PROVIDER -->

						<!-- AIRPORT  -->
						<tr align="left">
							<td>Airport:</td>
							<td colspan="2">

								<div style="display: none">
									<select id="airportId_">
										<core:forEach items='${lists.airports}' var="airport">
											<option value="${airport.id}">${airport.name}</option>
										</core:forEach>
									</select>
								</div>

								<div id="hidden_input_holder_airportId" style="display: none">
									<input id="airportId" type="text" name="airportId" value="-1" />
								</div>

								<div class="ui-widget">
									<input id="tags" />
								</div>
								<!-- //IATA LABEL  -->
								<td align="left">
								IATA:
								<div class="ui-widget">
									<input id="tags_iata" />
								</div>
								<!-- //IATA LABEL  -->
							</td>
							</td>
						</tr>
						<!-- INIT JQUERY AUTOCOMPLETE -->
						<script>
							$(function() {
								var airports = new Array();
								airportsIata = new Array();
								<core:forEach items='${lists.airports}' var="airport">
								//airports.push('${airport.codeIata}' +" "+  '${airport.name}');
								airports.push('${airport.name}');
								airportsIata.push('${airport.codeIata}');
								</core:forEach>

								$("#tags").autocomplete({
									source : airports
								});
								$("#tags").autocomplete({
									change : function(event, ui) {
										updateIDAirport(ui.item.value);
									}
								});
								
								//tags_iata
								$("#tags_iata").autocomplete({
									source : airportsIata
								});
								$("#tags_iata").autocomplete({
									change : function(event, ui) {
										updateIDAirport(ui.item.value,true);
									},
									select : function(event, ui){
										updateIDAirport(ui.item.value,true);
									}
								});
								//end tags_iata 
							});

							function updateIDAirport(airportName) {
								//var nombre = airportName.substring(4,airportName.length);
								nombre = airportName;
								nombre.replace(/^\s+|\s+$/g, "");

								var select = document
										.getElementById("airportId_");
								for ( var i = 0; i < select.length; i++) {
									if (select.options[i].text == nombre) {
										var holderAirportId = document
												.getElementById('airportId');
										holderAirportId.value = select.options[i].value;
										//alert(holderAirportId.value);
									}
								}
								
								//IATA CODE LABEL
								function updateAirportUsingIata(airportName){
									$('#tags').val(airportName);
								}
								//END IATA CODE LABEL
							}
						</script>
						<!-- END JQUERY AUTOCOMPLETE -->

						<!-- END  AIRPORT  -->

						<!-- AIRPLANE -->
						<tr align="left">
							<td>Airplanes:</td>
							<td>
								<div id="hidden_input_holder_airplane_code"
									style="display: none">
									<input id="airplaneCode" type="text" name="airplaneCode"
										value="${ticket.airplaneCode}" />
								</div>

								<div class="ui-widget">
									<input size="17px" id="tags_airplanes" />
								</div>
							</td>
						</tr>

						<!-- INIT JQUERY AUTOCOMPLETE -->
						<script>
							$(function() {
								$.airplaneAutocomplete = function() {
									var airplanes = new Array();
									var cardCode = "${user.clientCode}";
									//if(clientLogged == false) alert("Admin is logued");	 		     	   
									var select = document
											.getElementById('clientCode');
									var cardCodeClient = select.options[select.selectedIndex].value;

									<core:forEach items='${lists.airplanes}' var="airplane">
									var groupKey = '${airplane.id.cardcode}';

									if (clientLogged == false) {
										//ADMIN is logued
										//alert(cardCodeClient);
										if (groupKey == cardCodeClient) {
											//alert('${airplane.id.code}');
											airplanes
													.push('${airplane.id.code}');
										}
									}
									if (clientLogged == true) {
										if (groupKey == cardCode) {
											//alert('${airplane.id.code}');
											airplanes
													.push('${airplane.id.code}');
										}
									}

									</core:forEach>

									$("#tags_airplanes").autocomplete({
										source : airplanes
									});

									$("#tags_airplanes").autocomplete({
										change : function(event, ui) {
											updateAirplaneCODE(ui.item.value);

										}
									});
								};
								$.airplaneAutocomplete();
							});

							function updateAirplaneCODE(airplaneCode) {
								var holderAirplaneCode = document
										.getElementById('airplaneCode');
								holderAirplaneCode.value = airplaneCode;
								//alert(holderAirplaneCode.value);
							}
						</script>
						<!-- END JQUERY AUTOCOMPLETE -->
						<!-- END AIRPLANE  -->



						<!-- PRODUCT -->
						<tr align="left">
							<td>Product:</td>
							<td colspan="2" align="left"><spring:bind
									path="ticket.productCode">
									<select id="productCode" name="productCode"
										onchange="updateProductName()">
										<option value="-1">Select one</option>
										<core:forEach items='${lists.products}' var="product">

											<core:choose>
												<core:when test="${ticket.productCode == product.itemcode}">
													<option value="${product.itemcode}" selected="selected">${product.itemname}</option>
												</core:when>
												<core:otherwise>
													<option value="${product.itemcode}">${product.itemname}</option>
												</core:otherwise>
											</core:choose>

											<!-- <option value="${product.itemcode}" title="${product.itemname}"> ${product.itemname} </option>-->
										</core:forEach>
									</select>
								</spring:bind></td>
						</tr>
						<div id="hidden_input_holder_item_name" style="display: none">
							<input id="itemname" type="text" name="itemname" />
						</div>
						<!-- SCRIPT PRODUCT NAME -->
						<script>
							function updateProductName() {
								var select = document
										.getElementById('productCode');
								var nameProduct = select.options[select.selectedIndex].text;
								//alert(nameProduct);
								var holderItemname = document
										.getElementById('itemname');
								holderItemname.value = nameProduct;
								//alert(holderItemname.value);
							}
						</script>
						<!-- END OF SCRIPT PRODUCT NAME -->
						<!-- END PRODUCT -->

						<!-- QUANTITY LTS -->
						<tr align="left">
							<td>Quantity Lts:</td>
							<td colspan="2" align="left"><spring:bind
									path="ticket.quantityLtsString">
									<input maxlength="25" type="text" name="quantityLtsString"
										value="${ticket.quantityLtsString}" />
								</spring:bind></td>
						</tr>
						<!-- END QUANTITY LTS -->

						<!-- NOTES -->
						<tr align="left">
							<td>Notes:</td>
							<td colspan="2" align="left"><spring:bind
									path="ticket.notes">
									<textarea name="notes">${ticket.notes}</textarea>
								</spring:bind></td>
						</tr>
						<!-- NOTES -->

						<!--  NEW AIRPLANE -->
						<!-- <tr>
	           <td align="left"><strong>New Airplane </strong></td>
	           <td colspan="2" align="left">
					 <select id="newAirplane"  name="newAirplane"  onchange="showNewAirplaneCode(this)">
						  <option value="-1">Select one</option>
						  <option title="N">N</option>
						  <option title="Y">Y</option>
					 </select>			
			  </td>
	         </tr> -->

						<div id="hidden_input_holder_new_airplane">

							<!-- DYNAMIC SIDE -->
							<tr id="newAirplaneCodeDiv" style="display: none">
								<td align="left"><strong>New Airplane Code </strong></td>
								<td colspan="2" align="left"><input maxlength="25"
									type="text" name="newAirplaneCode" /></td>
							</tr>
							<div id="hidden_input_holder_new_airplane_code">

								<!-- END DYNAMIC -->
								<script>
									function showNewAirplaneCode(select) {
										var answer = select.options[select.selectedIndex].title;
										var newAirplaneCode = document
												.createElement("input");
										var holderAirplaneCode = document
												.getElementById('hidden_input_holder_new_airplane_code');
										//alert(answer);
										if (answer == 'Y') {
											document
													.getElementById('newAirplaneCodeDiv').style.display = "";

											newAirplaneCode.setAttribute(
													"type", "hidden");
											newAirplaneCode.setAttribute(
													"name", "newAirplaneCode");
											newAirplaneCode.setAttribute("id",
													"newAirplaneCode");
											newAirplaneCode.setAttribute(
													"value", answer);
											holderAirplaneCode
													.appendChild(newAirplaneCode);
										}
										if (answer == 'N') {
											document
													.getElementById('newAirplaneCodeDiv').style.display = "none";
											holderAirplaneCode
													.removeChild(newAirplaneCode);
										}
									}
								</script>
								<!--  END NEW AIRPLANE -->

								<tr align="left">
									<td width="18%">Released by:</td>
									<td colspan="2" align="left"><spring:bind
											path="ticket.releasedBy">
											<input type="text" name="releasedBy"
												value="${ticket.releasedBy}" />
										</spring:bind></td>
								</tr>

								<!--SECCTION DESIGN FOR ESTABLISH ID ON THE REQUEST       -->

								<div id="userId" style="display: none">
									<input id="userId" type="text" name="user.id"
										value="${user.id}" />
								</div>
								<!-- END OF THE ID ON THE REQUEST -->


								<tr>
									<td>&nbsp;</td>
									<td colspan="2" align="center">&nbsp;</td>
								</tr>
					</table>

					<table width="258" border="0" align="center">
						<tr>
							<td width="82" align="center"><input type="submit"
								name="operation" value="Add Ticket" /></td>
							<!--<td width="70" align="center"></td>
                 <td width="92" align="center">
            	    <input type="submit" name="operation" value="Cancel Ticket" />
                </td> -->
						</tr>
					</table>
				</fieldset>
				<p>&nbsp;</p>
			</form>
		</td>
	</tr>
</table>
<br />

</body>
</html>