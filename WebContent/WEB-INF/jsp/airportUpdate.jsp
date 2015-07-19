<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td align="center" colspan="3">
			<table width="600" align="center" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td align="right">
						<p>&nbsp;</p> <a href="airports.htm"> <img src="images/back.gif"
							title="<fmt:message key='icons.tooltip.back'/>" width="16" height="16" border="0" alt="back"/> Back</a>
					</td>
				</tr>
			</table>
			<div class="redText">${msg}</div>
			<form name="form" action="" method="post">
				<fieldset class="fieldsetInterno">
					<legend>Update Airport </legend>
					<table width="70%" border="0" cellpadding="0" cellspacing="0">
						<tr align="left">
							<td colspan="2"><spring:hasBindErrors name="airport">
									<core:forEach items="${errors.allErrors}" var="error" varStatus="c">
										<div class="redText">
											-
											<spring:message message="${error}" />
										</div>
									</core:forEach>
								</spring:hasBindErrors>
							</td>
						</tr>
						<tr align="left">
							<td width="28%">Code:</td>
							<td width="31%" align="left"><spring:bind path="airport.code">
									<input type="text" name="code" maxlength="10" value="${airport.code}" />
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr align="left">
							<td>Name:</td>
							<td><spring:bind path="airport.name">
									<input type="text" name="name" maxlength="100" size="40" value="${airport.name}" />
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<!-- THIS IS COUNTRY SECTION'S  -->
						<tr align="left">
							<td>Country:</td>
							<td><spring:bind path="airport.country">
									<input type="text" name="country" maxlength="100" size="40" value="${airport.country}" />
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<!-- END OF COUNTRIE'S SECTION  -->
						<!-- THIS IS CITIES SECTION'S  -->
						<tr align="left">
							<td>City:</td>
							<td><spring:bind path="airport.city">
									<input type="text" name="city" maxlength="100" size="40" value="${airport.city}" />
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<!-- END OF COUNTRIE'S SECTION  -->
						<!-- THIS IS LOCATION'S SECTION  -->
						<tr align="left">
							<td>Location:</td>
							<td><spring:bind path="airport.location">
									<input type="text" name="location" maxlength="100" size="40" value="${airport.location}" />
								</spring:bind>
							</td>
						</tr>
						<!-- END OF LOCATION SECTION  -->
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<!-- END OF COUNTRIE'S SECTION  -->
						<!-- THIS IS IATA_CODE'S SECTION  -->
						<tr align="left">
							<td>IATA:</td>
							<td><spring:bind path="airport.codeIata">
									<input type="text" name="codeIata" maxlength="100" size="40" value="${airport.codeIata}" />
								</spring:bind>
							</td>
						</tr>
						<!-- END OF IATAS_CODE SECTION  -->
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td align="center">&nbsp;</td>
						</tr>
					</table>
					<table width="220" border="0" align="center">
						<tr>
							<td><input type="submit" name="submit" value="Save" /></td>
							<td align="center">&nbsp;</td>
							<td align="center"><input type="reset" name="reset" value="Reset" /></td>
						</tr>
					</table>
				</fieldset>
			</form>
		</td>
	</tr>
</table>