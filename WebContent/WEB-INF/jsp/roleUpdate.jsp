<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="3" align="center">
			<table width="600" align="center" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td align="right">
						<p>&nbsp;</p> <a href="roles.htm"> <img src="images/back.gif"
							title="<fmt:message key='icons.tooltip.back'/>" width="16" height="16" border="0" alt="back" /> Back</a>
					</td>
				</tr>
			</table>
			<div class="redText">${msg}</div>
			<form name="form" action="" method="post">
				<br />
				<fieldset class="fieldsetInterno">
					<legend>Role </legend>
					<table width="60%" border="0" cellpadding="0" cellspacing="0">
						<tr align="left">
							<td colspan="2"><spring:hasBindErrors name="role">
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
							<td width="28%">Role Name:</td>
							<td width="31%" align="left">
								<spring:bind path="role.name">
									<input type="text" name="name" value="${role.name}" disabled="disabled" />
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr align="left">
							<td>Description:</td>
							<td><spring:bind path="role.description">
									<input type="text" name="description" value="${role.description}" disabled="disabled" />
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
					</table>
					<table width="100%" border="0" cellpadding="1" cellspacing="1" class="borde lista">
						<tr>
							<th colspan="3">&nbsp;</th>
							<th colspan="4">Permisolog&iacute;a</th>
						</tr>
						<tr>
							<th width="5%">&nbsp;</th>
							<th width="12%">Type</th>
							<th width="20%">Component</th>
							<th width="39%">Description</th>
							<th width="8%">Insert</th>
							<th width="8%">Update</th>
							<th width="8%">Delete</th>
						</tr>
						<!-- RECORRIDO DE COMPONENTES  -->
						<core:forEach items='${role.roleComponents}' var="comp" varStatus="c">

							<tr class="row1" align="left">
								<td align="center">
									<!-- Checkbox que indica que se permite la consulta -->
									<spring:bind
										path="role.roleComponents[${c.index}].consult">
										<input type="hidden" name="_<core:out value="${status.expression}"/>" />
										<input type="checkbox" name="<core:out value="${status.expression}"/>" value="true" <core:if test="${status.value}">checked="checked"</core:if> />
									</spring:bind>
								</td>
								<td>${comp.component.type.nameItem}</td>
								<td>${comp.component.name}</td>
								<td>${comp.component.description}</td>
								<td align="center">
									<!-- Checkbox que indica que se permite la insercion --> <core:if test='${comp.component.insert}'>
										<spring:bind path="role.roleComponents[${c.index}].insert">
											<input type="hidden" name="_<core:out value="${status.expression}"/>" />
											<input  type="checkbox" name="<core:out value="${status.expression}"/>"
												value="true" <core:if test="${status.value}">checked="checked"</core:if> />
										</spring:bind>
									</core:if>
								</td>
								<td align="center">
									<!-- Checkbox que indica que se permite la actualizacion --> <core:if test='${comp.component.update}'>
										<spring:bind path="role.roleComponents[${c.index}].update">
											<input type="hidden" name="_<core:out value="${status.expression}"/>" />
											<input  type="checkbox" name="<core:out value="${status.expression}"/>"
												value="true" <core:if test="${status.value}">checked="checked"</core:if> />
										</spring:bind>
									</core:if>
								</td>
								<td align="center">
									<!-- Checkbox que indica que se permite la eliminación --> <core:if test='${comp.component.delete}'>
										<spring:bind path="role.roleComponents[${c.index}].delete">
											<input type="hidden" name="_<core:out value="${status.expression}"/>" />
											 <!-- OJO si deshabilito el marys trick, habilito el (input disabled="disabled") -->
											<input  type="checkbox" name="<core:out value="${status.expression}"/>"
												value="true" <core:if test="${status.value}">checked="checked"</core:if> />
										</spring:bind>
									</core:if>
								</td>
							</tr>
						</core:forEach>
					</table>
					 <!-- Mary's trick -->
             <table width="220" border="0" align="center">
              <tr>
                <td> <input type="submit" name="submit" value="Save" /></td>
                <td align="center"></td>
                <td align="center"><input type="reset" name="reset" value="Reset" /></td>
              </tr>
            </table>  
            <!-- END  Mary's trick -->
           </fieldset>
                <p>&nbsp;</p>
			</form>
		</td>
	</tr>
</table>