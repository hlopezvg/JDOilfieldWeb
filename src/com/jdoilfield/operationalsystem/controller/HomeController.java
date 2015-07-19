package com.jdoilfield.operationalsystem.controller;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.jdoilfield.operationalsystem.business.BusinessPartnerManager;
import com.jdoilfield.operationalsystem.business.RoleManager;
import com.jdoilfield.operationalsystem.business.UserManager;
import com.jdoilfield.operationalsystem.domain.local.RoleComponent;
import com.jdoilfield.operationalsystem.domain.local.User;
import com.jdoilfield.operationalsystem.domain.remote.BusinessPartner;
import com.jdoilfield.operationalsystem.util.Constants;
import com.jdoilfield.operationalsystem.util.MessageConstants;
import com.jdoilfield.operationalsystem.util.MessageManager;
import com.pranical.commons.exceptions.LogicException;

/**
 * Controlador de inicio de la aplicacion
 * @author Mary
 */
public class HomeController extends AbstractController {
	
	private HttpSession session;
	private UserManager userManager;
	private RoleManager roleManager;
	private BusinessPartnerManager businessPartnerManager;
	private Logger logger;
	
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	logger = LoggerFactory.getLogger(HomeController.class);
    	
    	Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	session = request.getSession(); //Se obtiene la sesion
    	
    	logger.info("HOME CONTROLLER");
    	
    	if(session.getAttribute("user") == null){
    		String username="";
        	if (obj instanceof UserDetails) {
        		username = ((UserDetails)obj).getUsername();
        	} else {
        		username = obj.toString();
        	}
        	
        	User u=null;
        	try {
    			u = userManager.findByUserName(username);
 
    			logger.info("++++++++++++++HOME CONTROLLER userINFO: " + u.getClientCode());

    			if(u!=null){

    				session.setAttribute("user", u);
    				
    				List<RoleComponent> rc=null;
    				try {
    					if(u.getRoleSecondaryId() != null){
    						if (u.getRoleId() == Constants.ROLE_ADMIN && u.getRoleSecondaryId().intValue() == Constants.OPERATION_SHIEF)
    							u.setRoleId(Constants.OPERATION_SHIEF);
        					if (u.getRoleId() == Constants.ROLE_ADMIN && u.getRoleSecondaryId().intValue() == Constants.ROLE_OPERATOR) 
        						u.setRoleId(Constants.ROLE_OPERATOR);
    					}
    					
    					rc = roleManager.getComponents(u.getRoleId());
    				} catch (LogicException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    				
    				Hashtable<Integer,RoleComponent> components = new Hashtable<Integer,RoleComponent>();
    				Iterator<RoleComponent> i =  rc.iterator();
    				RoleComponent c = null;
    				
    				while(i.hasNext()){
    					 c = (RoleComponent)i.next();
    					 components.put(c.getComponent().getId(), c);
    				}
    				
    				session.setAttribute("menuSort",rc);
    				session.setAttribute("menu",components);

    				if(u.getRoleId() == Constants.CLIENT_ROLE || u.getRoleId() == Constants.CLIENT_OPE_ROLE){
    					BusinessPartner bp=new BusinessPartner();
    					
    					bp = (BusinessPartner)businessPartnerManager.getElement(u.getClientCode());
    					if (bp == null){
    						bp = new BusinessPartner();
    						bp.setCardcode("JD_STAFF");
    					}
    					session.setAttribute("infoClient", bp);
    					
    					logger.info("++++++++++++++HOME CONTROLLER SETTING INFOCLIENT BP: " + bp);
    					
    				}
    				//Esta parte se uso para la definicion de doble role!
    				if(u.getRoleId() == Constants.ROLE_ADMIN && u.getRoleId() == Constants.OPERATION_SHIEF){
    					session.setAttribute("dualRole", "dualRole");
    				}
    				
    				//Esta parte se hace para el role de solo visualizar clientes nacionales
    				if(u.getRoleId() == Constants.ROLE_VIEW_LOCAL_CUSTOMER){
    					session.setAttribute("domesticClients", "domesticClients");
    				}
    	    	}
    				
    		}catch(LogicException e){
    			request.setAttribute("msg",	
    					MessageManager.getMensaje(getApplicationContext(),request, MessageConstants.AUTH_ERROR));
        	}catch(Exception e){
    			request.setAttribute("msg",	
    					MessageManager.getMensaje(getApplicationContext(),request, MessageConstants.AUTH_ERROR));
        	}
	
    	}
    	
		session.setAttribute("m",null);
		
        return new ModelAndView("home");
    }

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public RoleManager getRoleManager() {
		return roleManager;
	}

	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
	}

	public BusinessPartnerManager getBusinessPartnerManager() {
		return businessPartnerManager;
	}

	public void setBusinessPartnerManager(
			BusinessPartnerManager businessPartnerManager) {
		this.businessPartnerManager = businessPartnerManager;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}