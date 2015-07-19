package com.jdoilfield.operationalsystem.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.jdoilfield.operationalsystem.business.UserManager;
import com.jdoilfield.operationalsystem.domain.local.PasswordRecovery;
import com.jdoilfield.operationalsystem.util.MessageConstants;
import com.jdoilfield.operationalsystem.util.MessageManager;

public class PasswordRecoveryController extends SimpleFormController {
	
	private UserManager manager;
    private ModelAndView modelView;
    private Logger log = LoggerFactory.getLogger(PasswordRecoveryController.class);
    
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
			Object command, BindException errors)
            throws ServletException {
		
		HttpSession session = request.getSession();
		String view = null;
		
		try{
			PasswordRecovery forgotPassword = (PasswordRecovery) command;
			String resultKey = manager.recoverPassword(forgotPassword.getMail());
			log.info("THIS IS THE RESULT FROM KEY: " + resultKey);
			if(resultKey.equals("NO_USER_FOUND_WITH_THIS_EMAIL")  || resultKey.equals("CONTACT_THE_ADMIN")){
				view = "forgotPassword_contact_error.htm";
				log.info("forgotPassword_contact_error.htm");
			}
			
			if(resultKey.equals("USER_FOUND_PROCEED_TO_RESET_AND_SEND_EMAIL")){
				view = "forgotPassword_contact_success.htm";
				log.info("forgotPassword_contact_success.htm");
			}
			
		}catch(Exception e){
			request.setAttribute("msg",	
					MessageManager.getMensaje(getApplicationContext(),request, MessageConstants.GENERAL_ERROR));
    	}
		return new ModelAndView(new RedirectView(view));
	}
	
	protected PasswordRecovery formBackingObject(HttpServletRequest request) throws ServletException {

		PasswordRecovery o = new PasswordRecovery(); 

        return o;
	}
	 
	public UserManager getManager() {
		return manager;
	}

	public void setManager(UserManager manager) {
		this.manager = manager;
	}
}