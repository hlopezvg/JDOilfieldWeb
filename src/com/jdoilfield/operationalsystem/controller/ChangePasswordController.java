package com.jdoilfield.operationalsystem.controller;

import com.jdoilfield.operationalsystem.business.UserManager;
import com.jdoilfield.operationalsystem.domain.local.PasswordChange;
import com.jdoilfield.operationalsystem.domain.local.User;
import com.jdoilfield.operationalsystem.util.MessageManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

@SuppressWarnings("deprecation")
public class ChangePasswordController extends SimpleFormController
{
  private UserManager manager;
  private ModelAndView modelView;

  public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors)
    throws ServletException
  {
    HttpSession session = request.getSession();
    try
    {
      PasswordChange passwordChange = (PasswordChange)command;

      if ((session != null) && 
        (session.getAttribute("user") != null))
      {
        User user = (User)session.getAttribute("user");

        String resultKey = this.manager.changePassword(user, passwordChange.getPassword(), passwordChange.getConfirmPassword());

        request.setAttribute("msg", 
          MessageManager.getMensaje(getApplicationContext(), request, resultKey));
      }

      this.modelView = new ModelAndView(getSuccessView());
      this.modelView.addObject(new PasswordChange());
    }
    catch (Exception e) {
      request.setAttribute("msg", 
        MessageManager.getMensaje(getApplicationContext(), request, "errors"));
    }
    return this.modelView;
  }

  protected PasswordChange formBackingObject(HttpServletRequest request) throws ServletException
  {
    PasswordChange o = new PasswordChange();

    return o;
  }

  public UserManager getManager() {
    return this.manager;
  }

  public void setManager(UserManager manager) {
    this.manager = manager;
  }
}