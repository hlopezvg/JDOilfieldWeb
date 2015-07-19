<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<table width="100%" align="center" border="0" cellpadding="0"
	cellspacing="0">
	<tr>
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
			<form name="form" method="post" action="" id="formFuelCardUpdate">
				<script type="text/javascript">
					$(document).ready(
							function() {
								var fcBlocked = '${fuelCardUpdate.status}';
								console.log("Status from FuelCardUpdate: "
										+ fcBlocked);
								if (fcBlocked === 'Bloqueado') {
									$("#txtFuelCardId")
											.css('background', 'red');
									//$('#txtFuelCardId').css({ 'color': 'white', 'font-size': '150%' });	
								}

							});

					$("#formFuelCardUpdate")
							.submit(
									function(event) {
										//Check Dates
										var startDate = $('#fromDateID').val()
												.replace('-', '/');
										var endDate = $('#endDateID').val()
												.replace('-', '/');
										// Validate that init date is greater thatn end date.
										if (startDate > endDate) {
											jAlert(
													"The From Date is greater than the End Date",
													'Alert Dialog');
											return false;
										}
										var txtClient = $.trim($(
												'#cardCodeNameID').val());
										if (txtClient === '') {
											jAlert(
													"The value of Client cannot be empty",
													'Alert Dialog');
											return false;
										}

										// Get the International value and trim it
										var txtInternational = $.trim($(
												'#txtInterId').val());
										// Check if empty of not
										if (txtInternational === '') {
											jAlert(
													"The value of International cannot be empty",
													'Alert Dialog');
											return false;
										}

										var txtInitDate = $.trim($(
												'#fromDateID').val());
										var txtEndDate = $.trim($('#endDateID')
												.val());
										if (txtInitDate === '') {
											jAlert(
													"The value of From Date cannot be empty",
													'Alert Dialog');
											return false;
										}

										if (txtEndDate === '') {
											jAlert(
													"The value of End Date cannot be empty",
													'Alert Dialog');
											return false;
										}

										// Validate that init date is greater thatn end date.
										if (startDate > endDate) {
											// do stuff here...
											jAlert(
													"The From Date is greater than the End Date",
													'Alert Dialog');
											return false;
										}

										// Validate Airplane
										var selectedAirplane = $.trim($(
												'#aircraftCodeId').val());
										if (selectedAirplane === '0') {
											jAlert(
													"Select an airplane please.",
													'Alert Dialog');
											return false;
										}
										// Validate Status
										var selectedStatus = $.trim($(
												'#selectStatus').val());
										if (selectedStatus === '') {
											jAlert("Select an status please.",
													'Alert Dialog');
											return false;
										}

										// Validate Observations
										var txtObservations = $
												.trim($('#txtIdObservations')
														.val().length);
										if (txtObservations === '0') {
											jAlert(
													"The value of Observation cannot be empty",
													'Alert Dialog');
											return false;
										}
									});
				</script>
				<!-- THIS IS FOR  editMode/viewMode -->
				<core:set var="editMode" value='disabled="disabled"' />
				<core:choose>
					<core:when test="${(sessionScope.user.roleId != 1)} ">
						<core:set var="viewMode" value='style="display: none;"' />
					</core:when>
					<core:otherwise>
						<core:set var="viewMode" value="" />
					</core:otherwise>
				</core:choose>
				<!-- THIS IS FOR  editMode/viewMode -->


				<fieldset class="fieldsetInterno">
					<legend>Update Fuel Card </legend>
					<table width="70%" border="0" cellpadding="0" cellspacing="0">
						<spring:hasBindErrors name="fuelCardUpdate">
							<core:if test="${errors.errorCount>0}">
								<tr align="left">
									<td colspan="4"><spring:hasBindErrors
											name="fuelCardUpdate">
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
							<td width="61%" align="left" colspan="2"><spring:bind
									path="fuelCardUpdate.cardCodeName">
									<input type="text" id="cardCodeNameID" name="cardCodeName"
										maxlength="100" readonly="readonly" size="45"
										value="${fuelCardUpdate.cardCodeName}" />
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
							<td><spring:bind path="fuelCardUpdate.aircraftCode">
									<select name="aircraftCode" ${editMode}>
										<option value="0">Select an aircraft:</option>
										<core:if test="${(fn:length(fuelCardUpdate.airplanes) >= 0)}">
											<core:out value="${(fn:length(fuelCardUpdate.airplanes))}"></core:out>
											<script>
												//console.log("Airplanes:" +  "${(fn:length(fuelCardUpdate.airplanes))}");
											</script>
										</core:if>
										<core:forEach items='${fuelCardUpdate.airplanes}'
											var="airplane" varStatus="r">
											<core:choose>
												<core:when
													test="${fuelCardUpdate.aircraftCode == airplane.id.code}">
													<option value="${airplane.id.code}" selected="selected">${airplane.id.code}</option>
												</core:when>
												<core:otherwise>
													<option value="${airplane.id.code}">${airplane.id.code}</option>
												</core:otherwise>
											</core:choose>
										</core:forEach>
									</select>
								</spring:bind></td>
						</tr>
						<tr>

						</tr>
						<!--  END AIRCRAFT -->
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<!--  CARD CODE  -->
						<tr align="left">
							<td>Fuel Card Code:</td>
							<td><input type="text"
								value="${fuelCardUpdate.fuelCardCode}" id="txtFuelCardId"
								readonly /></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<!--  END CARD CODE  -->

						<!--  STATUS  -->
						<tr align="left">
							<td>Status:</td>
							<td><spring:bind path="fuelCardUpdate.status">
									<select name="status" id="selectStatus">
										<option value="Activo">Activo</option>
										<option value="Inactivo">Inactivo</option>
										<option value="Bloqueado">Bloqueado</option>
										<option value="${fuelCardUpdate.status}" selected="selected">${fuelCardUpdate.status}</option>
									</select>
								</spring:bind></td>
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
									path="fuelCardUpdate.stringInitDate">
									<input type="text" id="fromDateID" name="stringInitDate"
										readonly="readonly" maxlength="10"
										value="${fuelCardUpdate.stringInitDate}" class="inputFecha" />
								</spring:bind> <script type="text/javascript">
									$(document).ready(function() {
										//alert('LOADING ready');
									});
								</script></td>
						<tr>
						<tr>
							<td align="left" width="13%">to:</td>
							<td align="left" width="36%"><spring:bind
									path="fuelCardUpdate.stringEndDate">
									<input type="text" name="stringEndDate" id="endDateID"
										readonly="readonly" maxlength="10"
										value="${fuelCardUpdate.stringEndDate}" class="inputFecha" />
									<a
										onclick="displayCalendarEndDate(document.forms[0].stringEndDate,'yyyy-mm-dd hh:ii:ss',this,true)">
										&nbsp; &nbsp; <img class="ocultar_print"
										src="images/almanaque.gif"
										title="<fmt:message key='icons.tooltip.calendar'/>" border="0"
										width="20" height="16" alt="almanaque" />
									</a>
									<script type="text/javascript">
										$(document).ready(function() {
											//alert('LOADING ready');
										});
									</script>
								</spring:bind></td>
						</tr>

						<!-- END DATE -->
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr align="left">
							<td>International:</td>
							<td><spring:bind path="fuelCardUpdate.international">
									<input type="text" name="international" maxlength="80"
										value="${fuelCardUpdate.international}" id="txtInterId" />
								</spring:bind></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr align="left">
							<td>Observations:</td>
							<td><spring:bind path="fuelCardUpdate.observations">
									<textarea name="observations" id="txtIdObservations">${fuelCardUpdate.observations}</textarea>
								</spring:bind></td>
						</tr>

						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr align="left">
							<td>Random:</td>
							<td><spring:bind path="fuelCardUpdate.fuelCardRandomCode">
									<input type="text" name="fuelCardRandomCode" maxlength="80"
										value="${fuelCardUpdate.fuelCardRandomCode}"
										disabled="disabled" />
								</spring:bind></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
					</table>
					<table width="220" border="0" align="center">
						<tr>
							<td><input type="submit" name="submit" value="Update"
								${viewMode} /></td>
							<td align="center">&nbsp;</td>
							<td align="center"><input type="reset" name="reset"
								value="Reset" ${viewMode} /></td>
						</tr>
					</table>
				</fieldset>
			</form>
		</td>
	</tr>
</table>
