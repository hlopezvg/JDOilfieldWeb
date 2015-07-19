<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<style type="text/css">
.celdaFirmaCentrada {
	font-size: 12px;
	font-style: normal;
	font-weight: normal;
	font-family: "Arial";
	text-transform: normal;
	color: #000000;
	background-color: #FFFFFF;
	text-align: center;
	display: table-cell;
}

.celdaTitulo {
	font-size: 12px;
	font-style: normal;
	font-weight: bold;
	font-family: "Arial";
	text-transform: normal;
	color: #000000;
	background-color: #FFFFFF;
	text-align: left;
	display: table-cell;
}

.celdaTipo {
	font-size: 12px;
	font-style: normal;
	font-weight: normal;
	font-family: "Arial";
	text-transform: normal;
	color: #000000;
	background-color: #FFFFFF;
	text-align: left;
	display: table-cell;
}

.piepag {
	font-family: "Courier New", Courier, mono;
	font-size: 12px;
	font-weight: normal;
}

.tabla {
	border: thin solid #000000;
}

.titulo {
	font-weight: bold;
	font-family: "Arial";
	font-size: 18px;
	text-align: left;
}

.izquierda {
	text-align: left;
}

.fuente {
	font-size: 12px;
	font-style: normal;
	font-family: "Arial";
}
</style>
<table>
	<tr>
		<td>
			<table width="100%">
				<tr>
					<td align="left"><img src="images/nuevoLogoJ&amp;D_RIF_encabezado.png" width="100" height="100" alt="logo JDOilfield" /></td>
				</tr>
				<tr>
					<td align="center">
						<span class="titulo">FUEL REQUEST</span>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%" border='1' align="left" cellspacing="0" class="tabla">
				<tr>
					<td class="celdaTitulo">FR N&ordm;:</td>
					<td width="434" class="celdaTipo">
						<core:choose>
							<core:when test="${empty element.idFuelRequest}">NOT ASIGNED YET</core:when>
							<core:otherwise>"${element.idFuelRequest}"</core:otherwise>
						</core:choose>
					</td>
				</tr>
				<tr>
					<td width="177" class="celdaTitulo">Lugar y Fecha/ Place and Date:</td>
					<td class="celdaTipo">${element.systemDate}</td>
				</tr>
				<tr>
					<td class="celdaTitulo">Para/To:</td>
					<td class="celdaTipo">${element.providerName}</td>
				</tr>
				<tr>
					<td class="celdaTitulo">Attn.:</td>
					<td class="celdaTipo">
						<core:forEach items='${element.attention}' var="ap" varStatus="counter">
							<li style="padding: 2px; margin-left: 50px; text-align: left; text-indent: 10px">${ap.name}</li>
						</core:forEach>
					</td>
				</tr>
				<tr>
					<td class="celdaTitulo">De/From:</td>
					<td class="celdaTipo">J&amp;D Oilfield International S.A. (IATA Cod.: JDO)</td>
				</tr>
				<tr>
					<td class="celdaTitulo">Ref.:</td>
					<td class="celdaTipo">JFG:._ ${element.cardcodeClient}</td>
				</tr>
				<tr>
					<td class="celdaTitulo">Copia/ Copy:</td>
					<td class="celdaTipo">J&amp;D Oilfield International S.A</td>
				</tr>
				<tr>
					<td class="celdaTipo" colspan="2">
						<div>
							<h4 class="celdaTipo">
								Por favor suministren combustible al siguiente cliente nuestro, en base al contrato que tenemos con:
								${element.providerName}
							</h4>
						</div>
						<div>
							<h4 class="celdaTipo">
								Please fuel our following customer with the contract we have
								with: ${element.providerName}
							</h4>
						</div>
					</td>
				</tr>
				<tr>
					<td class="celdaTitulo">Cliente/ Customer:</td>
					<td class="celdaTipo">${element.cardNameClient}</td>
				</tr>
				<tr>
					<td class="celdaTitulo">Cuenta No. / A/C No.:</td>
					<td class="celdaTipo">${element.acNumber}</td>
				</tr>
				<tr>
					<td class="celdaTitulo">Fecha/ Date:</td>
					<td class="celdaTipo">FROM ${element.initDate} TO ${element.endDate}</td>
				</tr>
				<tr>
					<td class="celdaTitulo">Lugar/ Locations:</td>
					<td class="celdaTipo">
						<ul>
							<core:forEach items='${element.airportFuelRequests}' var="ap" varStatus="counter">
								<li style="padding: 2px; margin-left: 50px; text-align: left; text-indent: 10px">${ap.code} - ${ap.name}</li>
							</core:forEach>
						</ul>
					</td>
				</tr>
				<tr>
					<td class="celdaTitulo">Vuelo (Matr&iacute;culas)/ Flight:</td>
					<td class="celdaTipo">${element.flight}</td>
				</tr>
				<tr>
					<td class="celdaTitulo">E.T.A:</td>
					<td class="celdaTipo">${element.eta}</td>
				</tr>
				<tr>
					<td class="celdaTitulo">Hora Local/ Local Time:</td>
					<td class="celdaTipo">Between 0000 and 2400 Hrs.</td>
				</tr>
				<tr>
					<td class="celdaTitulo">Destino/ Dest.:</td>
					<td class="celdaTipo">${element.destination}</td>
				</tr>
				<tr>
					<td class="celdaTitulo">Estimado de Suministro/ Uplift:</td>
					<td class="celdaTipo">${element.uplift}</td>
				</tr>
				<tr>
					<td class="celdaTitulo">Producto/ Product:</td>
					<td class="celdaTipo">${element.productItemName}</td>
				</tr>
				<tr>
					<td class="celdaTitulo">Observaciones/ Remarks:</td>
					<td class="celdaTipo">Please Fax Copy of Fuel ticket when the fuel is supply to (058) 212 951 4231 / 953
						7530</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td align="center" height="80px" style="vertical-align: top;">
			<p class="fuente" >Atentamente / Best Regards,</p>
		</td>
	</tr>
	<tr>
		<td align="center">
			<div class="celdaFirmaCentrada" style="width: 200px">&nbsp;</div>
			<div>Gerente de Operaciones</div>
			<div>Operations Manager</div>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%" border="1" cellspacing="0">
				<tr>
					<td width="183" class="celdaFirmaCentrada">3625 NW 82nd Ave. Suite 309 Miami, Fla. 33166. Phone: (305)
						4360025/26 Fax: (305) 4360027 jdoifield@bellsouth.net</td>
					<td width="233" class="celdaFirmaCentrada">Av. Francisco de Miranda, Torre EASO, Piso 12, Oficina 12 A, El
						Rosal, Chacao, Edo. Miranda, Caracas, Venezuela. Telf.: (058)212 953.75.30 - 212 951.42.31 Fax: (058)-0424 833
						7113</td>
					<td width="205" class="celdaFirmaCentrada">Av. Principal de Lechería con Calle el Dorado , Centro
						Empresarial Lechería, Piso 6, Oficina 605 . Lechería, Edo. Anzoátegui, Venezuela. Telf. (58) 281 418 46 79
						venezuela@jdoilfield.com</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td align="center">
			<div class="piepag">
				ESTE DOCUMENTO FUE GENERADO AUTOMATICAMENTE POR JD Mobile System. POR FAVOR NO RESPONDER A ESTE CORREO.
			</div>
			<div class="piepag">
				THIS DOCUMENT IS AUTOMATICALLY GENERATED BY JD Mobile System. PLEASE DO NOT RESPOND TO THIS MAIL.
			</div>
		</td>
	</tr>
</table>
