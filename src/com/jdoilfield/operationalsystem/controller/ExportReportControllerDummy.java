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

import com.jdoilfield.operationalsystem.business.ManagerInterface;
import com.jdoilfield.operationalsystem.domain.ResultList;
import com.jdoilfield.operationalsystem.domain.Search;
import com.jdoilfield.operationalsystem.util.Utilities;

public class ExportReportControllerDummy extends AbstractController
{
  private String successView;
  protected HttpSession session; 
  private ManagerInterface manager;

  private static BufferedImage tituloReporte = null;
  private static BufferedImage encabezadoReporte = null;
  private Logger logger = LoggerFactory.getLogger(ExportReportControllerDummy.class);
  
  protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
		  throws Exception  {
	  
    this.session = request.getSession();
    Search search = (Search)this.session.getAttribute("search");
    logger.info("the sessions brings: --> " + search.getDate());
    
    
    response.setHeader("Expires", "0");
    response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
    response.setHeader("Pragma", "public");

    String formatParam = request.getParameter("format");
    if ((!("pdf".equals(formatParam))) && 
      (!("xls".equals(formatParam))) && 
      (!("csv".equals(formatParam))))
    {
      //formatParam = "html";
    	formatParam = "xls";
    }

    StringBuilder fileName = new StringBuilder();

    

	//dummy data
			Map<String,String> revenueData = new HashMap<String,String>();
			revenueData.put("Jan-2010", "$100,000,000");
			revenueData.put("Feb-2010", "$110,000,000");
			revenueData.put("Mar-2010", "$130,000,000");
			revenueData.put("Apr-2010", "$140,000,000");
			revenueData.put("May-2010", "$200,000,000");
	 //
    
    
    
    
    fileName.append(Utilities.formatDate(new Date(), "yyyyMMdd_HHmmss"));
    fileName.append(".").append(formatParam);
    response.setHeader("content-disposition", "attachment; filename=\"" + fileName + "\"");

    loadImages(request);

	ResultList results= this.manager.getResultList(search, 1);
	request.setAttribute("results", results);
    //return new ModelAndView(this.successView, null);
	return new ModelAndView("reportTicket", "", revenueData);
    
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

  public String getSuccessView() {
	    return this.successView;
	  }

	  public void setSuccessView(String successView) {
	    this.successView = successView;
	  }

public ManagerInterface getManager() {
	return manager;
}

public void setManager(ManagerInterface manager) {
	this.manager = manager;
}
}

