<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<script type="text/javascript">//<![CDATA[
	var name;
	var liStyle="padding:2px;margin-left:50px;text-align: left;text-indent:10px";

	function addProvider(){
		var select_pvr=document.getElementById("providers");
		
		addProviderToLu(select_pvr);
	}

	function addProviderToLu(select) { 
		//var liStyle="padding:2px;margin-left:50px;text-align: left;text-indent:10px";
		var name = select.options[select.selectedIndex].title;
		var id = select.options[select.selectedIndex].value;
	  
		var newElementPVR = document.createElement("li");
		newElementPVR.setAttribute("id","provider_"+id);
		newElementPVR.setAttribute("style",liStyle);
		newElementPVR.innerHTML="<span>"+name+"</span>";	

		var deleteLink = document.createElement("a");
		deleteLink.setAttribute("href","#");
		//deleteLink.setAttribute("onclick","removeProviderLi('provider_"+id+"','"+itemCountPRV+"'); return false;");
		deleteLink.setAttribute("title","Remove provider");
		deleteLink.innerHTML="<b>[ x ]</b>";
		var onC="removeProviderLi('provider_"+id+"','"+itemCountPRV+"'); return false;";
		deleteLink.onclick=new Function(onC);
		newElementPVR.appendChild(deleteLink);	

		var lu = document.getElementById('providersToAdd');
		if(id != null && id != "" && name != null && name != "") {
			//Validamos que no se repita el mismo campo seleccionado
			//alert("name a validar: "  + name);
			var allReadyAdd = validateSingleValue(lu, name);
			
			if(allReadyAdd){
				alert('Provider all ready selected, choose another one');
				
				return false;
			} else {
				addProviderInput(id, name);
				selection = id;
				lu.appendChild(newElementPVR);
				
				var li = document.getElementById("no_providers_li");
				if(li != null) {
					li.parentNode.removeChild(li);
				}
				
				if(name == "Todos / All") {
					document.form.providers.disabled = "disabled";
  	  	  		};
			};
		};
	}

	function removeProviderLi(id, i) {
		var li = document.getElementById(id);
    	 
		itemCountPRV--;
		li.parentNode.removeChild(li);
		
		var input=document.getElementById("providersToAdd.list"+"["+i+"].cardcodeProvider");
		
		input.value="-1";	
		input.parentNode.removeChild(input);
		
		if(name == "Todos / All") {
			document.form.airports.disabled = false;
		};
		
		if(itemCountPRV == 0) {
			var newElementPVR = document.createElement("li");
			newElementPVR.setAttribute("id","no_providers_li");
			newElementPVR.setAttribute("style",liStyle);
			newElementPVR.innerHTML="<span>No providers selected</span>";
			
			var lu = document.getElementById('providersToAdd');
			lu.appendChild(newElementPVR);
		}
     }


	function addProviderInput(id, name){
		var newElementCP = document.createElement("input");
		newElementCP.setAttribute("type", "hidden");
		newElementCP.setAttribute("name","providersToAdd.list"+"["+itemCountPRV+"].cardcodeProvider");
		newElementCP.setAttribute("id"  ,"providersToAdd.list"+"["+itemCountPRV+"].cardcodeProvider");
		newElementCP.setAttribute("value", id);

		var newElement2 = document.createElement("input");
		newElement2.setAttribute("type", "hidden");
		newElement2.setAttribute("name","providersToAdd.list"+"["+itemCountPRV+"].cardNameProvider");
		newElement2.setAttribute("id"  ,"providersToAdd.list"+"["+itemCountPRV+"].cardNameProvider");
		newElement2.setAttribute("value", name);

		var holderPVR = document.getElementById('hidden_input_holder_providers');
		
		holderPVR.appendChild(newElementCP);
		holderPVR.appendChild(newElement2);
		
		itemCountPRV++;
	}

     //Esta funcion se debe acomodar en el onsubmit del form
	function mandatoryProviderField(){
		if(itemCountPRV <= 0) {
			alert('Must select a provider');
			
			return false;
		} else {
			return true;
		}
	}
     
	function validateSingleValue(ul, compareName){
		var allReadyAdd = false;
		
		for(var i=0; i < ul.childNodes.length; i++){
			if(ul.childNodes[i].nodeType == 1){		
				if(ul.childNodes[i].firstChild.innerHTML == compareName){
					allReadyAdd = true;
					
					return allReadyAdd; 
				};
			};
		};
		
		return allReadyAdd;
	}
//]]></script>

<script type="text/javascript">//<![CDATA[
	var name_ar;

	function addAirport(){
		var select=document.getElementById("airports");
		
		addAirportToLu(select);
	}

	function addAirportToLu(select){
		//var liStyle="padding:2px;margin-left:50px;text-align: left;text-indent:10px";
		name_ar = select.options[select.selectedIndex].title;
		var id = select.options[select.selectedIndex].value;

		var newElement = document.createElement("li");
		newElement.setAttribute("id","airport_"+id);
		newElement.setAttribute("style",liStyle);
		newElement.innerHTML="<span>"+name_ar+"</span>";	

		var deleteLink = document.createElement("a");
		deleteLink.setAttribute("href","#");
		//deleteLink.setAttribute("onclick","removeAirportLi('airport_"+id+"','"+itemCountAR+"')");
		deleteLink.setAttribute("title","Remove airport");
		deleteLink.innerHTML="<b>[ x ]</b>";
		var onC="removeAirportLi('airport_"+id+"','"+itemCountAR+"'); return false;";
		deleteLink.onclick=new Function(onC);
		newElement.appendChild(deleteLink);	

		var lu = document.getElementById('airportsToAdd');
		if(id != null && id != "" && name_ar != null && name_ar != ""){
			//Validamos que no se repita el mismo campo seleccionado
			var allReadyAdd = validateSingleValue(lu, name_ar);
			if(allReadyAdd){
				alert('Airport all ready selected, choose another one');
				
				return false;
			}else{
				addAirportInput(id, name_ar);
				selection = id;
				lu.appendChild(newElement);
				
				var li = document.getElementById("no_airports_li");
				if(li != null) {
					li.parentNode.removeChild(li);
				}
				
				if(name_ar == "Todos / All") {
					document.form.airports.disabled = "disabled";
				};
			};
		};
	}

	function removeAirportLi(id, i){
		//alert("estoy en el  metodo de removeAirportLi");
		itemCountAR--;
		var li = document.getElementById(id);
		li.parentNode.removeChild(li);

		var input =document.getElementById("airportsToAdd.list"+"["+i+"].id");
		input.value="-1";
		input.parentNode.removeChild(input);
	
		if(name_ar == "Todos / All"){
			document.form.airports.disabled = false;
		};
		
		if(itemCountAR == 0) {
			var newElementPVR = document.createElement("li");
			newElementPVR.setAttribute("id","no_airports_li");
			newElementPVR.setAttribute("style",liStyle);
			newElementPVR.innerHTML="<span>No airports selected</span>";
			
			var lu = document.getElementById('airportsToAdd');
			lu.appendChild(newElementPVR);
		}
	}
	
	function addAirportInput(id, name) {
		var newElement = document.createElement("input");
		newElement.setAttribute("type", "hidden");
		newElement.setAttribute("name","airportsToAdd.list"+"["+itemCountAR+"].id");
		newElement.setAttribute("id"  ,"airportsToAdd.list"+"["+itemCountAR+"].id");
		newElement.setAttribute("value", id);

		var holder_ar = document.getElementById('hidden_input_holder');
		holder_ar.appendChild(newElement);

		itemCountAR++;
	}
          
	function mandatoryAirportField(){
		if(itemCountAR <= 0) {
			alert('Must select an airport');
			
			return false;
		} else {
			return true;
		}
	}

//]]></script>

<script type="text/javascript">//<![CDATA[
	var name;
	
	function addProduct(){
		var select=document.getElementById("products");
		
		addProductToLu(select);
	}

	function addProductToLu(select){ 
		//var liStyle="padding:2px;margin-left:50px;text-align: left;text-indent:10px";
		var name = select.options[select.selectedIndex].title;
		var id = select.options[select.selectedIndex].value;

		var newElement = document.createElement("li");
		newElement.setAttribute("id","product_"+id);
		newElement.setAttribute("style",liStyle);
		newElement.innerHTML="<span>"+name+"</span>";

		var deleteLink = document.createElement("a");
		deleteLink.setAttribute("href","#");
		//deleteLink.setAttribute("onclick","removeProductLi('product_"+id+"','"+itemCountPro+"')");
		deleteLink.setAttribute("title","Remove product");
		deleteLink.innerHTML="<b>[ x ]</b>";
		var onC="removeProductLi('product_"+id+"','"+itemCountPro+"'); return false;";
		deleteLink.onclick=new Function(onC);
		newElement.appendChild(deleteLink);	

		var lu = document.getElementById('productsToAdd');
		if(id != null && id != "" && name != null && name != ""){
			var allReadyAdd = validateSingleValue(lu, name);
			if(allReadyAdd){
				alert('Product all ready selected, choose another one');
				
				return false;
			}else{
				addProductInput(id, name);
				selection = id;
				lu.appendChild(newElement);
				
				var li = document.getElementById("no_product_li");
				if(li != null) {
					li.parentNode.removeChild(li);
				}
				
				if(name == "Todos / All"){
					document.form.products.disabled = "disabled";
				};
			};
		};
	}

	function removeProductLi(id, i){
		itemCountPro--;
		var li = document.getElementById(id);
		li.parentNode.removeChild(li);

		var input =document.getElementById("productsToAdd.list"+"["+i+"].productID");
		input.value="-1";	
		input.parentNode.removeChild(input);
		
		if(name == "Todos / All"){
			document.form.products.disabled = false;
		};
		
		if(itemCountPro == 0) {
			var newElementPVR = document.createElement("li");
			newElementPVR.setAttribute("id","no_product_li");
			newElementPVR.setAttribute("style",liStyle);
			newElementPVR.innerHTML="<span>No products selected</span>";
			
			var lu = document.getElementById('productsToAdd');
			lu.appendChild(newElementPVR);
		}
	}

	function addProductInput(id, name){
		var newElement = document.createElement("input");
		newElement.setAttribute("type", "hidden");
		newElement.setAttribute("name","productsToAdd.list"+"["+itemCountPro+"].productID");
		newElement.setAttribute("id"  ,"productsToAdd.list"+"["+itemCountPro+"].productID");
		newElement.setAttribute("value", id);

		var newElement4 = document.createElement("input");
		newElement4.setAttribute("type", "hidden");
		newElement4.setAttribute("name","productsToAdd.list"+"["+itemCountPro+"].productNAME");
		newElement4.setAttribute("id"  ,"productsToAdd.list"+"["+itemCountPro+"].productNAME");
		newElement4.setAttribute("value", name);

		var holder = document.getElementById('hidden_input_holder_products');
		holder.appendChild(newElement);
		holder.appendChild(newElement4);

		itemCountPro++;
	}
//]]></script>

<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="3" align="center">
			<table width="600" align="center" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td align="right">
						<a href="fuelRequest.htm"> <img src="images/back.gif"
							title="<fmt:message key='icons.tooltip.back'/>" width="16" height="16" border="0" alt="back"/> Back</a>
					</td>
				</tr>
			</table>
			<div class="redText">${msg}</div>
			<form name="form" action="" method="post">
				<spring:bind path="fuelRequest.cardcodeClient">
					<input type="hidden" name="cardcodeClient" value="${fuelRequest.businessPartner.cardcode}" />
				</spring:bind>
				<spring:bind path="fuelRequest.cardNameClient">
					<input type="hidden" name="cardNameClient" value="${fuelRequest.businessPartner.cardname}" />
				</spring:bind>
				<spring:bind path="fuelRequest.cardNameProvider">
					<input type="hidden" id="cardNameProvider" name="cardNameProvider" value="" />
				</spring:bind>
				<fieldset class="fieldsetInterno">
					<legend>Fuel Request Scheduled</legend>
					<table width="95%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td colspan="2" align="left">
								<spring:hasBindErrors name="fuelRequest">
									<core:forEach items="${errors.allErrors}" var="error" varStatus="c">
										<div class="redText">- <spring:message message="${error}" /></div>
									</core:forEach>
								</spring:hasBindErrors> 
							</td>
						</tr>
						<!-- INSERCION DE LOS DATOS DE FUEL REQUEST PARA EL CLIENTE -->
						<tr>
							<td width="28%" align="left">FR N°:</td>
							<td width="31%" align="left">
								<core:choose>
									<core:when test="${empty fuelRequest.idFuelRequest}">NOT ASIGNED YET</core:when>
									<core:otherwise>"${fuelRequest.idFuelRequest}"</core:otherwise>
								</core:choose>
							</td>
						</tr>
						<tr>
							<td align="left">&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<!-- EL TR PARA EL PROVEDOR -->
						<tr>
							<td width="28%" align="left">Provider:</td>
							<td colspan="2" align="left">
								<select name="providers" id="providers">
									<option value="${null}">Select one</option>
									<core:forEach items='${lists.providers}' var="provider">
										<core:choose>
											<core:when test="${provider.cardcode==fuelRequest.cardCodeProvider}">
												<option value="${provider.cardcode}" selected="selected">${provider.cardname}</option>
											</core:when>
											<core:otherwise>
												<option value="${provider.cardcode}" title="${provider.cardname}">${provider.cardname}</option>
											</core:otherwise>
										</core:choose>
									</core:forEach>
								</select>
							</td>
							<td><input type="button" style="float: left" onclick="addProvider()" value="Add Provider" /></td>
						</tr>
						<tr>
							<td></td>
							<td align="right">
								<ul id="providersToAdd">
									<core:if test="${empty fuelRequest.providerFuelRequests}">
										<li id="no_providers_li"><span>No providers selected</span></li>
									</core:if>
									<core:forEach items='${fuelRequest.providerFuelRequests}' var="providerFR" varStatus="status">
										<li id="provider_${providerFR.cardcodeProvider}"
											style="padding: 2px; margin-left: 50px; text-align: left; text-indent: 10px">
											${providerFR.cardNameProvider} 
											<a href="#" onclick="removeProviderLi('provider_${providerFR.cardcodeProvider}','${status.index}')"
											title="Remove provider">[x]</a>
										</li>
									</core:forEach>
								</ul>
								<div id="hidden_input_holder_providers">
									<core:set var="itemsPVR" value="0" />
									<core:forEach items='${fuelRequest.providerFuelRequests}' var="providerFR" varStatus="status">
										<input id="providersToAdd.list[${status.index}].cardcodeProvider" type="hidden"
											name="providersToAdd.list[${status.index}].cardcodeProvider" value="${providerFR.cardcodeProvider}" />
										<input id="providersToAdd.list[${status.index}].cardNameProvider" type="hidden"
											name="providersToAdd.list[${status.index}].cardNameProvider" value="${providerFR.cardNameProvider}" />
										<core:set var="itemsPVR" value="${status.count}" />
									</core:forEach>									
								</div>
								<script type="text/javascript">//<![CDATA[
									var itemCountPRV=${itemsPVR};
								//]]></script>
							</td>
						</tr>
						
						<!-- FIN EL TR PARA EL PROVEDOR -->
						<!-- NEW LINE  -->
						<tr>
							<td align="left">&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<!--  END NEW LINE -->
						<!-- TR DEL ATTN -->
						<tr>
							<td width="28%" align="left">Attn:</td>
							<td width="31%" align="left">
								<spring:bind path="fuelRequest.providerContact">
									<core:set var='initName' scope='session' value='${fn:trim("Ing. Jeannette Pérez")}'>
									</core:set>
									<core:set var='contact' scope='session' value='${fn:trim(fuelRequest.providerContact)}'>
									</core:set>
									<textarea name="providerContact" rows="2" cols="5">${fuelRequest.providerContact != null ? contact : "Ing. Jeannette Pérez"}</textarea>
								</spring:bind>
							</td>
						</tr>
						<!-- FIN   TR DEL ATTN -->
						<tr>
							<td>
								<div><span id="selectedOption"></span> <span id="hiddenOption"></span></div>
							</td>
						</tr>
						<!-- NEW LINE  -->
						<tr>
							<td align="left">&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<!--  END NEW LINE -->
						<!-- TR DEL FROM -->
						<tr>
							<td width="28%" align="left">From:</td>
							<td width="31%" align="left">J&amp;D Oilfield International S.A. (IATA Cod. JDO)</td>
						</tr>
						<!-- FIN   TR DEL FROM -->
						<!-- NEW LINE  -->
						<tr>
							<td align="left">&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<!--  END NEW LINE -->

						<!-- TR DEL COPY -->
						<tr>
							<td width="28%" align="left">Copy:</td>
							<td width="31%" align="left">J&amp;D Oilfield International File</td>
						</tr>
						<!-- FIN   TR DEL COPY -->

						<!-- NEW LINE  -->
						<tr>
							<td align="left">&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<!--  END NEW LINE -->


						<!-- TR DEL CLIENTE -->
						<tr>
							<td width="28%" align="left">Client:</td>
							<td width="31%" align="left">${fuelRequest.businessPartner.cardname}</td>
						</tr>
						<!-- FIN TR DEL CLIENTE -->

						<!-- NEW LINE  -->
						<tr>
							<td align="left">&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<!-- END NEW LINE  -->


						<!-- TR DE AC/N° -->
						<tr>
							<td width="28%" align="left">A/C N°:</td>
							<td colspan="2" align="left">
								<spring:bind path="fuelRequest.acNumber">
									<select name="acNumber" id="acNumber">
										<option value="${null}">Select one</option>
										<core:forEach items='${lists.acNumbers}' var="acNumbers">
											<core:choose>
												<core:when test="${acNumbers.nameItem==fuelRequest.acNumber}">
													<option value="${acNumbers.nameItem}" selected="selected">${acNumbers.nameItem}</option>
												</core:when>
												<core:otherwise>
													<option value="${acNumbers.nameItem}">${acNumbers.nameItem}</option>
												</core:otherwise>
											</core:choose>
										</core:forEach>
									</select>
								</spring:bind>
							</td>
						</tr>
						<!-- FIN DE TR AC/N° -->

						<!-- NEW LINE  -->
						<tr>
							<td align="left">&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<!-- END NEW LINE  -->

						<!-- TR DE LA FECHA ACTUAL DEL SISTEMA -->
						<tr>
							<td width="28%" align="left">Date:</td>
							<td width="31%" align="left">${fuelRequest.systemDate}</td>
						</tr>
						<!-- FIN  TR DE LA FECHA ACTUAL DEL SISTEMA -->

						<!-- NEW LINE  -->
						<tr>
							<td align="left">&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<!-- END NEW LINE  -->

						<!-- TR DEL LOCATIONS  -->
						<tr>
							<td align="left">Locations:</td>
							<td align="left">
								<select id="airports" name="airports">
									<option value="${null}">Select one</option>
									<core:forEach items='${lists.airports}' var="airport">
										<%-- ${airport.compressName} --%>
										<core:choose>
											<core:when test="${fn:length(airport.name)>40}">
												<option value="${airport.id}" title="${airport.name}">${fn:substring(airport.name,0,40)}...</option>
											</core:when>
											<core:otherwise>
												<option value="${airport.id}" title="${airport.name}">${airport.name}</option>
											</core:otherwise>
										</core:choose>
									</core:forEach>
								</select>
							</td>
							<td><input type="button" style="float: left" value="Add Airport" onclick="addAirport();" /></td>
						</tr>
						<tr>
							<td></td>
							<td align="right">
								<table>
									<tr>
										<td>
											<ul id="airportsToAdd">
												<core:if test="${empty fuelRequest.airportFuelRequests}">
													<li id="no_airports_li"><span>No airports selected</span></li>
												</core:if>
												<core:forEach items='${fuelRequest.airportFuelRequests}' var="ap" varStatus="counter">
													<li id="airport_${ap.id}" style="padding: 2px; margin-left: 50px; text-align: left; text-indent: 10px">${ap.name}
														<a href="#" onclick="removeAirportLi('airport_${ap.id}','${counter.index}')" title="Remove airport">[x]</a>
													</li>
												</core:forEach>
											</ul>
											<div id="hidden_input_holder">
												<core:set var="itemsAR" value="0" />
												<core:forEach items='${fuelRequest.airportFuelRequests}' var="ap" varStatus="counter">
													<input id="airportsToAdd.list[${counter.index}].id" type="hidden"
														name="airportsToAdd.list[${counter.index}].id" value="${ap.id}" />
													<core:set var="itemsAR" value="${counter.count}" />
												</core:forEach>
											</div>
											<script type="text/javascript">//<![CDATA[
												var itemCountAR=${itemsAR};
											//]]></script>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<!-- FIN TR DEL LOCATIONS  -->
						<!-- NEW LINE  -->
						<tr>
							<td align="left">&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<!-- END NEW LINE  -->
						<!-- TR DEL FLIGHT  -->
						<tr>
							<td width="28%" align="left">Flight:</td>
							<td width="31%" align="left">
								<spring:bind path="fuelRequest.flight">
									<input type="text" name="flight" maxlength="60" value="${fuelRequest.flight}" />
								</spring:bind>
							</td>
						</tr>
						<!-- TR DEL FLIGHT  -->

						<!-- NEW LINE  -->
						<tr>
							<td align="left">&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<!-- END NEW LINE  -->


						<!-- TR DEL ETA  -->
						<tr>
							<td width="28%" align="left">E.T.A:</td>
							<td width="31%" align="left"><spring:bind path="fuelRequest.eta">
									<input type="text" name="eta" maxlength="60" value="${fuelRequest.eta}" />
								</spring:bind></td>
						</tr>
						<!-- FIN DEL TR DEL ETA  -->

						<!-- NEW LINE  -->
						<tr>
							<td align="left">&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<!-- END NEW LINE  -->


						<!-- TR DEL LOCAL_TIME -->
						<tr>
							<td width="28%" align="left">Local Time:</td>
							<td width="31%" align="left">Between 0000 and 2400 Hrs</td>
						</tr>
						<tr>
							<td align="left">&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<!-- END NEW LINE  -->


						<!-- TR DEL DESTINATION -->
						<tr>
							<td width="28%" align="left">Destination:</td>
							<td width="31%" align="left"><spring:bind path="fuelRequest.destination">
									<input type="text" name="destination" maxlength="160" value="${fuelRequest.destination}" />
								</spring:bind></td>
						</tr>
						<!--  FIN DEL TR DEL DESTINATION -->

						<!-- NEW LINE  -->
						<tr>
							<td align="left">&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<!-- END NEW LINE  -->

						<!-- TR DEL UPLIFT  -->
						<tr>
							<td width="28%" align="left">Uplift:</td>
							<td width="31%" align="left"><spring:bind path="fuelRequest.uplift">
									<input type="text" name="uplift" maxlength="80" value="${fuelRequest.uplift}" />
								</spring:bind></td>
						</tr>
						<!-- FIN TR DEL UPLIFT  -->

						<!-- NEW LINE  -->
						<tr>
							<td align="left">&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<!-- END NEW LINE  -->

						<!-- TR DEL PRODUCT -->
						<tr>
							<td width="28%" align="left">Product:</td>
							<td colspan="2" align="left"><select id="products" name="products">
									<option value="${null}">Select one</option>
									<core:forEach items='${lists.products}' var="product">
										<core:choose>
											<core:when test="${product.itemname==fuelRequest.productItemCode}">
												<option value="${product.itemcode}" selected="selected">${product.itemname}</option>
											</core:when>
											<core:otherwise>
												<option value="${product.itemcode}" title="${product.itemname}">${product.itemname}</option>
											</core:otherwise>
										</core:choose>
									</core:forEach>
								</select>
							</td>
							<td><input type="button" style="float: left" value="Add Product" onclick="addProduct();" /></td>
						</tr>
						<tr>
							<td></td>
							<td align="left">
								<ul id="productsToAdd">
									<core:if test="${empty fuelRequest.productFuelRequests}">
										<li id="no_product_li"><span>No products selected</span></li>
									</core:if>
									<core:forEach items='${fuelRequest.productFuelRequests}' var="prFR" varStatus="status">
										<li id="product_${prFR.productID}"
											style="padding: 2px; margin-left: 50px; text-align: left; text-indent: 10px">${prFR.productNAME}
											<a href="#" onclick="removeProductLi('product_${prFR.productID}','${status.index}')" title="Remove Product">[x]</a>
										</li>
									</core:forEach>
								</ul>
								<div id="hidden_input_holder_products">
									<core:set var="items" value="0" />
									<core:forEach items='${fuelRequest.productFuelRequests}' var="prFR" varStatus="status">
										<input id="productsToAdd.list[${status.index}].productID" type="hidden"
											name="productsToAdd.list[${status.index}].productID" value="${prFR.productID}" />
										<input id="productsToAdd.list[${status.index}].productNAME" type="hidden"
											name="productsToAdd.list[${status.index}].productNAME" value="${prFR.productNAME}" />
										<core:set var="items" value="${status.count}" />
									</core:forEach>
									<script type="text/javascript">//<![CDATA[        
										var itemCountPro=${items};
									//]]></script>
								</div>
							</td>
						</tr>
						<!-- NEW LINE  -->
						<tr>
							<td align="left">&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<!-- END NEW LINE  -->
						<!-- TR DEL CONTRACT PERIODS -->
						<tr>
							<td align="left">Contract Periods:</td>
							<td colspan="2" align="left" valign="baseline">From: <spring:bind path="fuelRequest.initDateString">
									<input type="text" name="initDateString" size="10"
										value="<fmt:formatDate  value='${fuelRequest.initDate}' pattern='yyyy-MM-dd' />" />
								</spring:bind> <a onclick="displayCalendar(document.forms[0].initDateString,'yyyy-mm-dd',this,true)"> <img
									src="images/almanaque.gif" alt="<fmt:message key='icons.tooltip.calendar'/>" width="20" height="16"
									border="0" align="bottom" /> </a> To: <spring:bind path="fuelRequest.endDateString">
									<input type="text" name="endDateString" size="10"
										value="<fmt:formatDate  value='${fuelRequest.endDate}' pattern='yyyy-MM-dd' />" />
								</spring:bind> <a onclick="displayCalendar(document.forms[0].endDateString,'yyyy-mm-dd',this,true)"> <img
									src="images/almanaque.gif" alt="<fmt:message key='icons.tooltip.calendar'/>" border="0" width="20"
									height="16" /> </a>
							</td>
						</tr>
						<!-- FIN TR DEL CONTRACT PERIODS -->
						<tr>
							<td align="left">&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<!-- INICIO TR REMARKS FUEL REQUEST-->
						<tr>
							<td width="28%" align="left">Remarks:</td>
							<td width="31%" align="left"><spring:bind path="fuelRequest.remarks">
									<core:set var='init' scope='session'
										value='${fn:trim("Please Fax Copy of Fuel ticket when the fuel is supply to (058) 212 951 4231 / 953 7530")}'>
									</core:set>
									<core:set var='rema' scope='session' value='${fn:trim(fuelRequest.remarks)}'>
									</core:set>
									<textarea name="remarks" rows="2" cols="5">${fuelRequest.remarks != null ? rema : "Please Fax Copy of Fuel ticket when the fuel is supply to (058) 212 951 4231 / 953 7530"}</textarea>
								</spring:bind></td>
						</tr>
						<!-- FIN  TR REMARKS FUEL REQUEST-->
						<tr>
							<td align="left">&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td align="left">To be sent at:</td>
							<td align="left">
								<table width="100%" border="0">
									<core:forEach items='${lists.periodTypes}' var="types" varStatus="vs">
										<tr align="left">
											<td align="left" width="100%">
												<spring:bind path="fuelRequest.periodType">
													<input type="radio" name="periodType" value="${types.idItem}"
														<core:if test='${types.idItem == fuelRequest.periodType}'>checked="checked"</core:if> />
															${types.nameItem} 
												</spring:bind>
											</td>
										</tr>
									</core:forEach>
								</table>
							</td>
						</tr>
						<tr>
							<td align="left">&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
					</table>
					<core:choose>
						<core:when test="${empty fuelRequest.idFuelRequest}">
							<input type="submit" name="operation" value="Schedule Fuel Request" />&nbsp;	            	
	            	</core:when>
						<core:otherwise>
							<input type="submit" name="operation" value="Reschedule Fuel Request" />
							<input type="button" name="operation" value="Anulate Fuel Request"
								onclick="window.location.href='fuelRequestInactivate.htm?id=${fuelRequest.idFuelRequest}'" />
						</core:otherwise>
					</core:choose>
				</fieldset>
			</form>
		</td>
	</tr>
</table>
