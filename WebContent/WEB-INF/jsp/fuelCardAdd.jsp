<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
	<!-- BEGIN OF PART THAT COMES FROM THE FUELCARDS, WHEN THE USER PRESS THE VALIDATE BUTTON -->
	<script type="text/javascript">
	Number.prototype.padLeft = function(base,chr){
		   var  len = (String(base || 10).length - String(this).length)+1;
		   return len > 0? new Array(len).join(chr || '0')+this : this;
	}

	var d = new Date;
	var currentGetDate = ((d.getDate() <= 9) ? '0' + d.getDate() : d.getDate());
	var dformat = [ d.getFullYear().padLeft(),
    (d.getMonth()+1).padLeft(),
    currentGetDate].join('-') +
    ' ' +
    [ d.getHours().padLeft(),
    d.getMinutes().padLeft(),
    d.getSeconds().padLeft()].join(':');

	var btnClicked = 'false';
    var isValidCard = '${sessionScope.fuelCardStatus}';
    var btnClicked = '${sessionScope.btnValidate}';
    var endDate = '${sessionScope.endDate}';

    /*//console.log("btn_ has been clicked: " + btnClicked);
    //console.log("FUEL CARD STATUS: " + isValidCard);
    //console.log("FUEL CARD END DATE: " + endDate.replace('-','/'));
    //console.log("CURRENT DATE: " + dformat.replace('-','/'));*/

    var cardNameClient = '${sessionScope.cardCodeName}';
    var aircraftCode = '${sessionScope.aircraftCode}';
    /*//console.log("THE CLIENT NAME IS: " + cardNameClient);
    //console.log("THE AIRCRAFT IS: " + aircraftCode);*/

    if(btnClicked.indexOf("true") != -1){
            if(isValidCard.indexOf("Activ") != -1){
                    window.location = 'creditFC.htm';
                    ////console.log("FUEL CARD ACTIVO from JS");
            }
            if(isValidCard.indexOf("Inactiv") != -1){
                    window.location = 'noCredit.htm';
                    ////console.log("FUEL CARD INACTIVO from JS");
            }
			if(endDate < dformat){
				window.location = 'noCredit.htm';
                ////console.log("FUEL CARD INACTIVO DUEDATE from JS");
            }
    }
    
    if(isValidCard.indexOf("noMoreAirplanesAvailable") != -1){
        window.location = 'fuelCards.htm';
        //console.log("FUEL CARD INVALID from JS");
	}
    
    if(isValidCard.indexOf("INVALID") != -1){
        window.location = 'noCredit.htm';
        //console.log("FUEL CARD INVALID from JS");
	}

	</script>
	<!-- END OF PART THAT COMES FROM THE FUELCARDS, WHEN THE USER PRESS THE VALIDATE BUTTON -->
	<tr>
	<core:set var="fuelCardStatus" value="" scope="session"/>
	
	
		<td colspan="3" align="center">
			<table width="600" align="center" border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<td align="right">
						<p>&nbsp;</p> <a href="fuelCards.htm"> <img
							src="images/back.gif"
							title="<fmt:message key='icons.tooltip.back'/>" border="0"
							alt="back" /> Back
					</a>
					</td>
				</tr>
			</table>
			<div class="redText">${msg}</div>
			<form name="form" onsubmit="checkform()" method="post" action="">
				<script>
				 $('form').submit(function () {
		               //Dates
		               var startDate = $('#fromDateID').val().replace('-','/');
		               var endDate = $('#endDateID').val().replace('-','/');
		               
		               var txtInitDate = $.trim($('#fromDateID').val());
		               var txtEndDate = $.trim($('#endDateID').val());
		               
					   // Get the International value and trim it
		               var txtInternational = $.trim($('#txtInterId').val());
		               var txtClient = $.trim($('#cardCodeNameID').val());
		               // Check if empty of not
		                
		               if (txtClient  === '' ) {
		                	jAlert("The value of Client cannot be empty", 'Alert Dialog');
		                    return false;
		               }
		                
		               if (txtInternational  === '' ) {
		                	jAlert("The value of International cannot be empty", 'Alert Dialog');
		                    return false;
		                }
		                
		                if (txtInitDate  === '' ) {
		                	jAlert("The value of From Date cannot be empty", 'Alert Dialog');
		                    return false;
		                }
		                
		                if (txtEndDate  === '' ) {
		                	jAlert("The value of End Date cannot be empty", 'Alert Dialog');
		                    return false;
		                }
		                
		                // Validate that init date is greater thatn end date.
		                if(startDate > endDate){
		                   // do stuff here...
		                	jAlert("The From Date is greater than the End Date", 'Alert Dialog');
		                    return false;
		                }
		                
		                // Validate Airplane
		                var selectedAirplane = $.trim($('#aircraftCodeId').val());
						if (selectedAirplane === '0'){
							jAlert("Select an airplane please.", 'Alert Dialog');
		                    return false;
						}
		                // Validate Status
						var selectedStatus = $.trim($('#statusId').val());
						if (selectedStatus === ''){
							jAlert("Select an status please.", 'Alert Dialog');
		                    return false;
						}
		                
		            });
				</script>
				<fieldset class="fieldsetInterno">
					<legend>Add Fuel Card </legend>
					<table width="70%" border="0" cellpadding="0" cellspacing="0">
						<spring:hasBindErrors name="fuelCardAdd">
							<core:if test="${errors.errorCount>0}">
								<tr align="left">
									<td colspan="4"><spring:hasBindErrors name="fuelCardAdd">
											<core:forEach items="${errors.allErrors}" var="error"
												varStatus="c">
												<div class="redText">
													-
													<spring:message message="${error}" />
												</div>
											</core:forEach>
										</spring:hasBindErrors></td>
								</tr>
							</core:if>
						</spring:hasBindErrors>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						
						<!--  CLIENT  -->
						<tr align="left">
							<td width="28%">Client:</td>
							<td width="61%" align="left" colspan="2">
							<spring:bind
									path="fuelCardAdd.cardCodeName">
									<input type="text" id="cardCodeNameID" name="cardCodeName" maxlength="100"
										size="45" value="${fuelCardAdd.businessPartner.cardname}" readonly/>
							</spring:bind></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<!--  END CLIENT  -->
						
						<!--  AIRCRAFT  -->
						<tr align="left">
							<td>Aircraft:</td>
							<td><spring:bind path="fuelCardAdd.aircraftCode">
									<select name="aircraftCode" ${editMode} id="aircraftCodeId">
										<option value="0">Select an aircraft:</option>
										<%-- <core:if test="${(fn:length(fuelCardAdd.airplanes) >= 0)}">
											<core:out value="${(fn:length(fuelCardAdd.airplanes))}"></core:out>
											<script>
												////console.log("Airplanes:" +  "${(fn:length(fuelCardAdd.airplanes))}");
											</script>
										</core:if> --%>
										<core:forEach items='${fuelCardAdd.airplanes}' var="airplane"
											varStatus="r">
											<core:choose>
												<core:when
													test="${fuelCardAdd.aircraftCode == airplane.id.code}">
													<option value="${airplane.id.code}" selected="selected">${airplane.id.code}</option>
												</core:when>
												<core:otherwise>
													<option value="${airplane.id.code}">${airplane.id.code}</option>
												</core:otherwise>
											</core:choose>
										</core:forEach>
									</select>
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<!--  END AIRCRAFT  -->
						
						<!--  CARD CODE  -->
						<tr align="left">
							<td>Fuel Card Code:</td>
							<td><spring:bind path="fuelCardAdd.fuelCardCode">
									<input type="text" name="fuelCardCode"
										value="${fuelCardAdd.fuelCardCode}" readonly/>
								</spring:bind></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<!--  END CARD CODE  -->
						
						<!--  STATUS  -->
						<tr align="left">
							<td>Status:</td>
							<td>
								<spring:bind path="fuelCardAdd.status">
									<script>
										//console.log("FuelCard status = " + '${fuelCardAdd.status}');
									</script>
									<select id="selectStatus">
										<option value="Activo" selected="selected">Activo</option>
										<option value="Inactivo">Inactivo</option>
										<option value="Bloqueado">Bloqueado</option>
										<option value="${fuelCardUpdate.status}" selected="selected">${fuelCardUpdate.status}</option>
									</select>
								</spring:bind>
								
								<input id="statusId" type="text" name="status" style="display: none"/>
								<script type="text/javascript">
									$('#selectStatus').change(function(){
										$('#statusId').val(this.value);
									});
								</script>
							</td>
						</tr>
						<tr>
						<!--  END STATUS  -->
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<!-- DATE -->
						<tr>
							<td align="left" width="18%">From:</td>
							<td align="left" width="17%"><spring:bind
									path="fuelCardAdd.stringInitDate">
									<input type="text" id="fromDateID" name="stringInitDate"
										maxlength="10"   value="${fuelCardAdd.stringInitDate}"
										class="inputFecha" onload="currentDate()" readonly/>
								</spring:bind> 
							</td>
							<script>
							$(document).ready(function(){
								Number.prototype.padLeft = function(base,chr){
										   var  len = (String(base || 10).length - String(this).length)+1;
										   return len > 0? new Array(len).join(chr || '0')+this : this;
								}
								
								var d = new Date,
						        dformat = [ d.getFullYear().padLeft(),
						                   (d.getMonth()+1).padLeft(),
						                   ((d.getDate() <= 9) ? '0' + d.getDate() : d.getDate())].join('-')+
						                   ' ' +
						                  [ d.getHours().padLeft(),
						                    d.getMinutes().padLeft(),
						                    d.getSeconds().padLeft()].join(':');
	
						     	$('#fromDateID').val(dformat);
							});
							</script>
						<tr>
						
						<tr>
							<td align="left" width="13%">to:</td>
							<td align="left" width="36%"><spring:bind
									path="fuelCardAdd.stringEndDate">
									<input type="text" id="endDateID" name="stringEndDate" maxlength="10"
										value="${fuelCardAdd.stringEndDate}" class="inputFecha"
										onchange="setToDate(this.value)" readonly />
								</spring:bind> 
								<a onclick="displayCalendarEndDate(document.forms[0].stringEndDate,'yyyy-mm-dd hh:ii:ss',this,true)">
									&nbsp; &nbsp; <img class="ocultar_print"
									src="images/almanaque.gif"
									title="<fmt:message key='icons.tooltip.calendar'/>" border="0"
									width="20" height="16" alt="almanaque" />
								</a>
							</td>
						</tr>

						<!-- END DATE -->
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr align="left">
							<td>International:</td>
							<td><spring:bind path="fuelCardAdd.international">
									<input type="text" name="international" maxlength="80"
										value="${fuelCardAdd.international}" id="txtInterId"/>
								</spring:bind></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr align="left">
							<td>Observations:</td>
							<td><spring:bind path="fuelCardAdd.observations">
									<textarea name="observations">${fuelCardAdd.observations}</textarea>
								</spring:bind></td>
						</tr>

						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr align="left">
							<td>Random:</td>
							<td><spring:bind path="fuelCardAdd.fuelCardRandomCode">
									<input type="text" name="fuelCardRandomCode" maxlength="80"
										value="${fuelCardAdd.fuelCardRandomCode}" disabled="disabled" />
								</spring:bind></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
					</table>
					<table width="220" border="0" align="center">
						<tr>
							<td><input type="submit" name="submit" value="Save" /></td>
							<td align="center">&nbsp;</td>
							<td align="center"><input type="reset" name="reset"
								value="Reset" /></td>
						</tr>
					</table>
				</fieldset>
			</form>
		</td>
	</tr>
</table>
