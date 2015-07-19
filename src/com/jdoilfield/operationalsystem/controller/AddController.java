package com.jdoilfield.operationalsystem.controller;

import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.jdoilfield.operationalsystem.business.ManagerInterface;
import com.jdoilfield.operationalsystem.domain.remote.FuelCard;
import com.jdoilfield.operationalsystem.util.MessageManager;
import com.pranical.commons.exceptions.LogicException;

public class AddController extends SimpleFormController
{
  private ManagerInterface manager;
  private ModelAndView modelView;

  public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors)
    throws ServletException
  {
    HttpSession session = request.getSession();
    try
    {
      logger.info("EN EL ADD CONTROLLER ON SUBMIT");
      this.modelView = new ModelAndView(new RedirectView(getSuccessView()));

      Object o = command;

      String resultKey = this.manager.add(o);

      session.setAttribute("msg", MessageManager.getMensaje(getApplicationContext(), request, resultKey));

      this.modelView.addObject(this.manager.getNewInstance());
    }
    catch (Exception e) {
      session.setAttribute("msg", 
        MessageManager.getMensaje(getApplicationContext(), request, "errors"));
    }
    return this.modelView;
  }

  protected Object formBackingObject(HttpServletRequest request)
    throws ServletException
  {
    Object o = new Object();

    HttpSession session = request.getSession();
    Hashtable lists = null;
    
    FuelCard fuelCard = null;
    
    logger.info("EN EL ADD CONTROLLER");
    
    try {
    	if (this.manager != null && this.manager.getNewInstance() != null){
    		o = this.manager.getNewInstance();
    	}
      //
      if (request.getParameter("fuelCard") == null){
    	  logger.info("Fuel Card is NULL, we are going to evaluate if the cardCodeClient has been passed to the session");
    	  if(request.getParameter("cardCodeClient") != null){
    		  String cardCodeClient = request.getParameter("cardCodeClient");
    		  logger.info("The CardCodeClient comming from FueldCards is: " + cardCodeClient);
    		  String btnValidate = request.getParameter("btnValidate");
    		  logger.info("The User has pressed validate button: " + btnValidate);
    		  session.setAttribute("btnValidate", btnValidate);
    		  o = this.manager.getCustomElementById("", cardCodeClient, "");
    		  //
    		  logger.info("CLEANING THE SESSION");
			  session.setAttribute("fuelCardStatus", "");
    		  //
    		  
    		  if(((FuelCard) o).getObservations() != null &&  ((FuelCard) o).getObservations().equals("/*-@@@@@ALL_AIRCRAFTS_HAVE_FUELCARD_ASSOCIATED@@@@@_/*")){
    			  logger.info("RECEIVING THE OBERVATIONS: /*-@@@@@ALL_AIRCRAFTS_HAVE_FUELCARD_ASSOCIATED@@@@@_/*");
    			  session.setAttribute("fuelCardStatus", "noMoreAirplanesAvailable");
	    		  session.setAttribute("msg", "Can't add more Fuel Cards to the selected client: " + ((FuelCard) o).getCardCodeName());
    		  }
    	  }
    	  if(manager != null){
    		  lists = this.manager.loadLists();
        	  session.setAttribute("lists", lists);  
    	  }
      }else {
    	  fuelCard = this.manager.validatefuelCardCode(request.getParameter("fuelCard"));
    	  logger.info("ADD CONTROLLER VALUE OF FUEL CARD: " + fuelCard);
    	  if (fuelCard != null){
    		  String btnValidate = request.getParameter("btnValidate");
	          session.setAttribute("fuelCardStatus", fuelCard.getStatus());
	          session.setAttribute("btnValidate", btnValidate);
	          session.setAttribute("endDate", fuelCard.getEndDate());
	          logger.info("fueldCardStatus: " + fuelCard.getStatus() + " |   The User has pressed validate button: "  + btnValidate 
	        		  							+ " | " +  "  EndDate: " + fuelCard.getEndDate());
	          //Pass The CardCodeName and aircraftCode to the noCredit.jsp, to let the provider see those values.
	          session.setAttribute("cardCodeName", fuelCard.getCardCodeName());
	          session.setAttribute("aircraftCode", fuelCard.getAircraftCode());
	          logger.info("CardCodeName + AircraftCode: " + fuelCard.getCardCodeName() + " " + fuelCard.getAircraftCode());
    	  } else {
    		  //If the user cannot add more fuelCards because each one of the airplanes it own, has an active fuelCard.
	          logger.info("FueldCard Status is INVALID");
    		  session.setAttribute("fuelCardStatus", "INVALID");
    		  session.setAttribute("cardCodeName", "");
	          session.setAttribute("aircraftCode", "");
	          session.setAttribute("msg", "Can't add more Fuel Cards to the selected client");
    	  }
      }
      
    }
    catch (LogicException exception) {
    	logger.error("ERROR ON ADD_CONTROLLER", exception);
    	request.setAttribute("msg", MessageManager.getMensaje(getApplicationContext(), request, "errors.load"));
    } catch (Exception exception) {
    	logger.error("ERROR ON ADD_CONTROLLER", exception);
    	request.setAttribute("msg", MessageManager.getMensaje(getApplicationContext(), request, "errors.load"));
    }
    
    return o;
  }

  public void setManager(ManagerInterface manager)
  {
    this.manager = manager;
  }

  public ManagerInterface getManager()
  {
    return this.manager;
  }
}