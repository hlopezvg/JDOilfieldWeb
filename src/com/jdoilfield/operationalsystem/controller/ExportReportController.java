package com.jdoilfield.operationalsystem.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.jdoilfield.operationalsystem.util.Utilities;
/**
 * 
 * @author hernan
 *
 */
public class ExportReportController extends AbstractController {
	protected HttpSession session;


	private static BufferedImage tituloReporte = null;
	private static BufferedImage encabezadoReporte = null;
	private String viewToImplement;
	private Logger logger = LoggerFactory.getLogger(ExportReportController.class);

	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		    session = request.getSession();
		    response.setHeader("Expires", "0");
		    response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
		    response.setHeader("Pragma", "public");
		    String extensionType = request.getParameter("output");
		    //logger.info("request.getParameter: --> " + extensionType);
		    String initDate = request.getParameter("initDate");
		    //logger.info("request.getParameter: --> " + initDate);
		    String endDate = request.getParameter("endDate");
		    //logger.info("request.getParameter: --> " + endDate);
		    String type = request.getParameter("type");
		    //logger.info("request.getParameter: --> " + type);
		    String status = request.getParameter("status");
		    //logger.info("request.getParameter  status: --> " + status);
		    String cardCode = request.getParameter("cardCode");
		    logger.info("request.getParameter from ExportController cardCode: --> " +cardCode);
		    String airplaneCode = request.getParameter("airplaneCode");
		    logger.info("request.getParameter from ExportController airplaneCode: --> " +cardCode);
		    
		    if ((!("pdf".equals(extensionType))) && (!("xls".equals(extensionType))) &&
		      (!("xml".equals(extensionType))) && (!("csv".equals(extensionType)))){
		    	extensionType = "html";
		    }else{
		    	viewToImplement = "reportTicket";
		    }
		    if("xml".equals(extensionType)){
		    	viewToImplement = "generateIATAXMLInvoice_2_0_2";
		    }
		    StringBuilder fileName = new StringBuilder();

		
		// Filling the search parameters
		Map<String, String> searchDateType = new HashMap<String, String>();
		searchDateType.put("initDate", initDate);
		searchDateType.put("endDate", endDate);
		searchDateType.put("type", type);
		searchDateType.put("status", status);
		searchDateType.put("cardCode", cardCode);
		searchDateType.put("airplaneCode", airplaneCode);
		
		
		fileName.append(Utilities.formatDate(new Date(), "yyyyMMdd_HHmmss"));
	    fileName.append(".").append(extensionType);
	    response.setHeader("content-disposition", "attachment; filename=\"" + fileName + "\"");


	    loadImages(request);
	    return new ModelAndView(viewToImplement, "searchDateType",
	    		searchDateType);

	}
	
	private synchronized void loadImages(HttpServletRequest request)
		    throws IOException
		  {
		    if ((tituloReporte == null) || (encabezadoReporte == null)) {
		      this.logger.debug("Cargando imagenes");

		      /*String titleImage = MessageManager.getMensaje(getApplicationContext(), request, "TITLE.REPORT.IMAGE");
		      String headerImage = MessageManager.getMensaje(getApplicationContext(), request, "HEADER.REPORT.IMAGE");
		      
		      tituloReporte = ImageIO.read(ExportReportController.class.getClassLoader().getResource(titleImage));
		      encabezadoReporte = ImageIO.read(ExportReportController.class.getClassLoader().getResource(headerImage));*/
		    }
		  }
}
