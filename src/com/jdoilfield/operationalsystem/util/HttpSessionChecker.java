package com.jdoilfield.operationalsystem.util;

import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpSessionChecker implements HttpSessionListener{
	protected final Logger logger;

	public HttpSessionChecker(){
		this.logger = LoggerFactory.getLogger(HttpSessionChecker.class);
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		System.out.printf("Session ID %s created at %s%n", event.getSession().getId(), new Date());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		String sessionNULA =  "sessionNULA";
		System.out.printf("Session ID %s destroyed at %s%n", event.getSession().getId(), new Date() 
			+" from: " + event.getSession().isNew());
		event.getSession().removeAttribute("page");
		event.getSession().removeAttribute("search");
		event.getSession().setAttribute("sessionNULA", sessionNULA);
		
		//event.getSession().invalidate();
		
	}

}
