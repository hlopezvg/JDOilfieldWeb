package com.jdoilfield.operationalsystem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IndexController
  implements Controller
{
  private String successView;

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    HttpSession session = request.getSession();
    session.invalidate();
    
    return new ModelAndView(this.successView);
  }

  public String getSuccessView() {
    return this.successView;
  }

  public void setSuccessView(String successView) {
    this.successView = successView;
  }
}
