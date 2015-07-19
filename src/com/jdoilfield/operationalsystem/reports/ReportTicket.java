package com.jdoilfield.operationalsystem.reports;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.jdoilfield.operationalsystem.domain.local.Ticket;
import com.jdoilfield.operationalsystem.domain.remote.ConsumerReport;
import com.jdoilfield.operationalsystem.domain.remote.DomesticClientReport;
import com.jdoilfield.operationalsystem.persistence.api.ConsumerReportDAO;
import com.jdoilfield.operationalsystem.persistence.api.DomesticClientReportDAO;
import com.jdoilfield.operationalsystem.persistence.api.TicketDAO;
/**
 * 
 * @author hernan
 *
 */
public class ReportTicket extends AbstractExcelView {
	//This values must be on the 
	private TicketDAO ticketDao;
	private DomesticClientReportDAO domesticClientReportDao;
	//private ConsumerReportDAO consumerReportDao; 
	//End of values
	private Logger logger = LoggerFactory.getLogger(ReportTicket.class);
	
	@Override
	protected void buildExcelDocument(Map<String, Object> paramMap,
			HSSFWorkbook paramHSSFWorkbook,
			HttpServletRequest paramHttpServletRequest,
			HttpServletResponse paramHttpServletResponse) throws Exception {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		Map<String,String> searchDateType = (Map<String,String>) paramMap.get("searchDateType");
		//Validate first if is type that comes from the request webMobile or domesticOP
		if(searchDateType.get("type").endsWith("webMobile")){
			//LETS BUILD THE REPORT FOR WEB MOBILE 
			// create a wordsheet
			HSSFSheet sheet = paramHSSFWorkbook.createSheet("Ticket Report Via WEB or MOBILE");

			HSSFRow header = sheet.createRow(0);
			header.createCell(0).setCellValue("Ticket");
			header.createCell(1).setCellValue("VIA");
			header.createCell(2).setCellValue("Ticket Date");
			header.createCell(3).setCellValue("User");
			header.createCell(4).setCellValue("Client Name");
			header.createCell(5).setCellValue("Client Code");
			
			//Extract the Data from Ticket//
			List<Ticket> lstTicket = ticketDao.getReportViaWebOrMobile(searchDateType.get("initDate"), searchDateType.get("endDate"), searchDateType.get("type"));
			Iterator<Ticket> it = lstTicket.iterator();
			
			
			int rowNum = 1;
			Ticket t = new Ticket();
			while(it.hasNext()) {
				// create the row data
				t = it.next();
				HSSFRow row = sheet.createRow(rowNum++);
				//logger.info("the code: --> " + t.getTicketCode().toString());
				//logger.info("VIA: --> " + t.getSourceDeviceId().toString());
				row.createCell(0).setCellValue(t.getTicketCode().toString());
				row.createCell(1).setCellValue(t.getSourceDeviceId().toString());
				row.createCell(2).setCellValue(t.getDatetimeString());
				row.createCell(3).setCellValue(t.getUser().getUserName().toString());
				//New Requeriment asked by Simon
				row.createCell(4).setCellValue(t.getCardnameClient().toString());
				row.createCell(5).setCellValue(t.getClientCode().toString());
			}
		}else if(searchDateType.get("type").endsWith("domesticOP")){
			//LETS BUILD THE REPORT FOR DOMESTIC OP 
			// create a wordsheet
			HSSFSheet sheet = paramHSSFWorkbook.createSheet("Ticket Report Domestic Clients");

			HSSFRow header = sheet.createRow(0);
			header.createCell(0).setCellValue("Razón Social");
			header.createCell(1).setCellValue("Codigo SAP");
			header.createCell(2).setCellValue("boletas");
			header.createCell(3).setCellValue("Ticket Date");
			header.createCell(4).setCellValue("Fecha de Sincronización");
			header.createCell(5).setCellValue("Litros Consumidos");
			header.createCell(6).setCellValue("Galones Consumidos");
			header.createCell(7).setCellValue("Producto");
			header.createCell(8).setCellValue("Precio de Compra");
			header.createCell(9).setCellValue("Precio Venta de Combustible");
			header.createCell(10).setCellValue("Orden de Venta");
			header.createCell(11).setCellValue("Orden de Compra");
			header.createCell(12).setCellValue("Estatus de boletas orden de Venta");
			header.createCell(13).setCellValue("Número de Fáctura");
			header.createCell(14).setCellValue("Matricula del Avión");
			header.createCell(15).setCellValue("Proveedor");
			header.createCell(16).setCellValue("CMP AEREO");
			header.createCell(17).setCellValue("% de Servicio");
			header.createCell(18).setCellValue("Fecha de la Fáctura");
			header.createCell(19).setCellValue("Usuario");
			
			//Extract the Data from DomesticClients//
			List<DomesticClientReport>  domesticClients = domesticClientReportDao.getReportViaWebOrMobile(searchDateType.get("initDate"), 
									searchDateType.get("endDate"), searchDateType.get("type"), searchDateType.get("status"));
			Iterator<DomesticClientReport>  it_ = domesticClients.iterator();
		
			int rowNum = 1;
			DomesticClientReport dmcReport = new DomesticClientReport();
			//Find the User
			Ticket ticket = ticketDao.findById(Integer.getInteger(dmcReport.getTicket()));
			//
			
			while(it_.hasNext()) {
				dmcReport = it_.next();
				HSSFRow row = sheet.createRow(rowNum++);
				//logger.info("the DATA FROM REPOT NAC: --> " + dmcReport.getCardname());
				//Razon social
				row.createCell(0).setCellValue(dmcReport.getCardname() == null ? "N/A" : dmcReport.getCardname().toString());
				//Codigo SAP
				row.createCell(1).setCellValue(dmcReport.getBaseCard() == null ? "N/A" : dmcReport.getBaseCard().toString());
				//Boleta
				row.createCell(2).setCellValue(dmcReport.getTicket() == null ? "N/A" : dmcReport.getTicket().toString());
				//Fecha de ticket
				row.createCell(3).setCellValue(dmcReport.getTickeDate() == null ? "N/A" : dmcReport.getTickeDate().toString());
				//Fecha syncronizacion
				row.createCell(4).setCellValue(dmcReport.getSyncDate() == null ? "N/A" : dmcReport.getSyncDate().toString());
				//Litros
				row.createCell(5).setCellValue(dmcReport.getQuantityLiter() == null ? "N/A" : dmcReport.getQuantityLiter().toString());
				//Galones
				row.createCell(6).setCellValue(dmcReport.getQuantityGals() == null ? "N/A" : dmcReport.getQuantityGals().toString());
				//Producto
				row.createCell(7).setCellValue(dmcReport.getItemProduct() == null ? "N/A" : dmcReport.getItemProduct().toString());
				//Precio de Compra
				row.createCell(8).setCellValue(dmcReport.getItemPrice() == null ? "N/A" : dmcReport.getItemPrice().toString());
				//Precio de venta
				row.createCell(9).setCellValue(dmcReport.getItemSellPrice() == null ? "N/A" :dmcReport.getItemSellPrice().toString());
				//Orden de venta
				row.createCell(10).setCellValue(dmcReport.getDocEntry() == null ? "N/A" :dmcReport.getDocEntry().toString());
				//Orden de compra
				row.createCell(11).setCellValue(dmcReport.getDocNum().toString() == null ? "N/A" : dmcReport.getDocNum().toString());
				//Estatus boleta
				row.createCell(12).setCellValue(dmcReport.getLineStatus().toString() == null ? "N/A" : dmcReport.getLineStatus().toString());
				//numero factura
				row.createCell(13).setCellValue(dmcReport.getDocNumOINV() == null ? "N/A" :  dmcReport.getDocNumOINV().toString());
				//Matricula Avion
				row.createCell(14).setCellValue(dmcReport.getAircraftCode() == null ? "N/A" : dmcReport.getAircraftCode().toString());
				//Provedor
				row.createCell(15).setCellValue(dmcReport.getProvider().toString() == null ? "N/A" : dmcReport.getProvider().toString());
				//CMP AERO
				row.createCell(16).setCellValue(dmcReport.getCmpAero() == null ? "N/A" : dmcReport.getCmpAero().toString());
				//% de Servicio
				row.createCell(17).setCellValue(dmcReport.getServiceFee() == null ? "N/A" : dmcReport.getServiceFee().toString());
				//fecha factura
				row.createCell(18).setCellValue(dmcReport.getInvoiceIssueDate() == null ? "N/A" : dmcReport.getInvoiceIssueDate().toString());
				//Usuario
				if(ticket != null) {
					row.createCell(19).setCellValue(ticket.getUser().getUserName().toString() == null ? "N/A" : ticket.getUser().getUserName().toString());
				} else {
					row.createCell(19).setCellValue("N/A");
				}
			   }
		} else if(searchDateType.get("type").endsWith("consumptionREP")){
			//LETS BUILD THE REPORT FOR FUEL CONSUMTION 
			// create a wordsheet
			/*HSSFSheet sheet = paramHSSFWorkbook.createSheet("Ticket Consumer Clients");

			HSSFRow header = sheet.createRow(0);
			header.createCell(0).setCellValue("Razón Social");
			header.createCell(1).setCellValue("Tikcet");
			header.createCell(2).setCellValue("Ticket Date");
			header.createCell(3).setCellValue("Fecha de Sincronización");
			header.createCell(4).setCellValue("Litros Consumidos");
			header.createCell(5).setCellValue("Galones Consumidos");
			header.createCell(6).setCellValue("Producto");
			header.createCell(7).setCellValue("Precio Venta de Combustible");
			header.createCell(8).setCellValue("Status de boleta");
			header.createCell(9).setCellValue("Número de Fáctura");
			header.createCell(10).setCellValue("Fecha de la Fáctura");
			header.createCell(11).setCellValue("Matricula del Avión");
			header.createCell(12).setCellValue("Proveedor");
			header.createCell(13).setCellValue("CMP AEREO");
			//Extract the Data from ConsumerReport//
			List<ConsumerReport>  consumerReport = consumerReportDao.getConsumerReportByCardCodeAirplaneAndDates(searchDateType.get("cardCode"), 
									searchDateType.get("airplaneCode"), searchDateType.get("initDate"), searchDateType.get("endDate"));
			Iterator<ConsumerReport>  reportIterator = consumerReport.iterator();
			int rowNum = 1;
			ConsumerReport conReport;
			while(reportIterator.hasNext()) {
				conReport = reportIterator.next();
				HSSFRow row = sheet.createRow(rowNum++);
				//Razon social
				row.createCell(0).setCellValue(conReport.getCardName() == null ? "N/A" : conReport.getCardName().toString());
				//Boleta
				row.createCell(1).setCellValue(conReport.getTicket() == null ? "N/A" : conReport.getTicket().toString());
				//Fecha de ticket
				row.createCell(2).setCellValue(conReport.getTicketDate() == null ? "N/A" : conReport.getTicketDate().toString());
				//Fecha syncronizacion
				row.createCell(3).setCellValue(conReport.getSyncDate() == null ? "N/A" : conReport.getSyncDate().toString());
				//Litros
				row.createCell(4).setCellValue(conReport.getQuantityLiters() == null ? "N/A" : conReport.getQuantityLiters().toString());
				//Galones
				row.createCell(5).setCellValue(conReport.getQuantityGals() == null ? "N/A" : conReport.getQuantityGals().toString());
				//Producto
				row.createCell(6).setCellValue(conReport.getItemProduct() == null ? "N/A" : conReport.getItemProduct().toString());
				//Precio de venta
				row.createCell(7).setCellValue(conReport.getItemSellPrice() == null ? "N/A" : conReport.getItemSellPrice().toString());
				//Estatus boleta
				row.createCell(8).setCellValue(conReport.getLineStatus().toString() == null ? "N/A" : conReport.getLineStatus().toString());
				//numero factura
				row.createCell(9).setCellValue(conReport.getDocNumInvoice() == null ? "N/A" :  conReport.getDocNumInvoice().toString());
				//fecha factura
				row.createCell(10).setCellValue(conReport.getInvoiceIssueDate() == null ? "N/A" : conReport.getInvoiceIssueDate().toString());
				//Matricula Avion
				row.createCell(11).setCellValue(conReport.getAirCraftCode() == null ? "N/A" : conReport.getAirCraftCode().toString());
				//Provedor
				row.createCell(12).setCellValue(conReport.getProvider().toString() == null ? "N/A" : conReport.getProvider().toString());
				//CMP AERO
				row.createCell(13).setCellValue(conReport.getCmpAero() == null ? "N/A" : conReport.getCmpAero().toString());
				
			}	*/	
		}
		  
	}

	public TicketDAO getTicketDao() {
		return ticketDao;
	}

	public void setTicketDao(TicketDAO ticketDao) {
		this.ticketDao = ticketDao;
	}

	public DomesticClientReportDAO getDomesticClientReportDao() {
		return domesticClientReportDao;
	}

	public void setDomesticClientReportDao(
			DomesticClientReportDAO domesticClientReportDao) {
		this.domesticClientReportDao = domesticClientReportDao;
	}

	/*public ConsumerReportDAO getConsumerReportDao() {
		return consumerReportDao;
	}

	public void setConsumerReportDao(ConsumerReportDAO consumerReportDao) {
		this.consumerReportDao = consumerReportDao;
	}*/
}
