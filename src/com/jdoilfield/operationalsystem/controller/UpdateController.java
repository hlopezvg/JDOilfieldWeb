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
import com.jdoilfield.operationalsystem.util.MessageManager;
import com.pranical.commons.exceptions.LogicException;

public class UpdateController extends SimpleFormController
{
  private ManagerInterface manager;
  private ModelAndView modelView;
  private String behaviour;

  public UpdateController()
  {
    this.modelView = null;
    this.behaviour = "none";
  }

  public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws ServletException
  {
    HttpSession session = request.getSession();

    Object o = command;

    String result = this.manager.update(o);

    this.modelView = new ModelAndView(new RedirectView(getSuccessView()));
    this.modelView.addObject(o);

    session.setAttribute("msg", MessageManager.getMensaje(getApplicationContext(), request, result));

    return this.modelView;
  }

  protected Object formBackingObject(HttpServletRequest request) throws ServletException {
    Object o = new Object();
    HttpSession session = request.getSession();
    Hashtable lists = null;
    
    try {
      if ((this.behaviour.equalsIgnoreCase("none")) && (request.getParameter("id") != null)) {
        this.logger.debug("Displaying update form...");
        String login = request.getParameter("id");
        o = this.manager.getElement(login);
      }

      if (this.behaviour.equalsIgnoreCase("fuelRequest")) {
        if ((request.getParameter("id") != null) && (request.getParameter("id").length() > 0)) {
          String id = request.getParameter("id");
          o = this.manager.getElement(id);
        } else {
          String client = request.getParameter("client");
          o = this.manager.getElement("CLIENT_" + client);
          this.logger.debug("en el updatecontroller colocando CLIENTE_");
        }
      }
      
      if (this.behaviour.equalsIgnoreCase("fuelCardCodeUpdate")) {
          if ((request.getParameter("cardCodeClient") != null) && (request.getParameter("cardCodeClient").length() > 0)) {
            this.logger.debug("en el updatecontroller llamando el manager.getCustomElementById(id,cardCodeClient)");
            String fuelCardCode = request.getParameter("fuelCardCode");
            String cardCodeClient = request.getParameter("cardCodeClient");
        	String id = request.getParameter("id");
            o = this.manager.getCustomElementById(fuelCardCode, cardCodeClient, id);
          }
        }
      
      
      lists = this.manager.loadLists();
      session.setAttribute("lists", lists);
    } catch (LogicException e) {
      request.setAttribute("msg", MessageManager.getMensaje(getApplicationContext(), request, "errors.load"));
    } catch (Exception e) {
      request.setAttribute("msg", MessageManager.getMensaje(getApplicationContext(), request, "errors.load"));
    }

    return o;
  }

  public void setManager(ManagerInterface manager) {
    this.manager = manager;
  }

  public ManagerInterface getManager() {
    return this.manager;
  }

  public String getBehaviour() {
    return this.behaviour;
  }

  public void setBehaviour(String behaviour) {
    this.behaviour = behaviour;
  }
}