package com.jdoilfield.operationalsystem.iata;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.AbstractView;

import com.jdoilfield.operationalsystem.domain.remote.IataInvoice;
import com.jdoilfield.operationalsystem.persistence.api.IataInvoiceDAO;
import com.pranical.commons.exceptions.PersistenceException;





/**
 * 
 * @author hernan
 * 
 */
public class GenerateIATAXMLInvoice_2_0_2 extends AbstractView {
	private Logger logger = LoggerFactory.getLogger(GenerateInvoiceIATAStandard2_2.class);
	private IataInvoiceDAO iataInvoiceDao;
	private List<IataInvoice> dataToXML;
	private String invoiceNumberRequest;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		logger.info("---> ON THE XML ON IATA XML INVOICE--->");
		logger.info("request.getParameter  invoiceNumber: --> " + request.getParameter("invoiceNumber"));
		//Make the business
		invoiceNumberRequest = request.getParameter("invoiceNumber");
		fillInvoiceToXML(invoiceNumberRequest);
		GenerateInvoiceIATAStandard2_2 iataInvoice = new GenerateInvoiceIATAStandard2_2();
		//Bogus ---> Si la factura no existe (Pedirle a Jose Antonio que cree otra vez la factura) da un error ya qyue no existe InvoiceNumber
		iataInvoice.createXMLInvoice(dataToXML);
		response.getOutputStream().print(iataInvoice.createXMLInvoice(dataToXML));
	}
	
	//Find the data with the DAO
	private List<IataInvoice> fillInvoiceToXML(String invoiceNumberRequest){
		this.invoiceNumberRequest = invoiceNumberRequest;
		try {
			if(invoiceNumberRequest != null){
				dataToXML = iataInvoiceDao.findInvoice(null, null, invoiceNumberRequest);
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return dataToXML;
	}
	
	public IataInvoiceDAO getIataInvoiceDao() {
		return iataInvoiceDao;
	}

	public void setIataInvoiceDao(IataInvoiceDAO iataInvoiceDao) {
		this.iataInvoiceDao = iataInvoiceDao;
	}

}
