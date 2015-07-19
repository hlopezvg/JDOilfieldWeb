package com.jdoilfield.operationalsystem.controller;

import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.jdoilfield.operationalsystem.business.ManagerInterface;
import com.jdoilfield.operationalsystem.domain.ResultList;
import com.jdoilfield.operationalsystem.domain.Search;
import com.jdoilfield.operationalsystem.domain.remote.BusinessPartner;
import com.jdoilfield.operationalsystem.persistence.hibernate.impl.TicketDAOImpl;
import com.jdoilfield.operationalsystem.util.MessageConstants;
import com.jdoilfield.operationalsystem.util.MessageManager;
import com.pranical.commons.exceptions.LogicException;

/**
 * Controlador de las peticiones de busqueda
 * 
 * @author Mary
 */
@SuppressWarnings("deprecation")
@RequestMapping
public class SearchController extends SimpleFormController {

	private ManagerInterface manager;
	private ModelAndView modelView;
	private String searchFuelRequest;
	private Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	public ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws ServletException {
		
		Search search = (Search) command;
		HttpSession session = request.getSession(); // Se obtiene la sesion
		/*
		 * logger.info(session.getAttribute("msg"));
		 * logger.info(session.getAttribute("searchLists"));
		 * logger.info(session.getAttribute("caduco"));
		 * logger.info(session.getAttribute("search"));
		 * logger.info(session.getAttribute("sessionNULA"));
		 */
		logger.info("USER...: " + session.getAttribute("user"));
		/*
		 * logger.info(session.isNew());
		 * logger.info("valor del login en el search" + search.getLogin());
		 */

		int page = 1;
		// logger.info("***********isBindOnNewForm:  " +
		// super.isBindOnNewForm());

		try {
			super.showNewForm(request, response);

			modelView = new ModelAndView(getFormView());
			logger.info("USER AFTER GET FOR  VIEW: "
					+ session.getAttribute("user"));

			if (session.getAttribute("user") != null) {
				// search = (Search)command; //Se obtienen los parametros de
				// busqueda

				if (session != null) {
					if (session.getAttribute("infoClient") != null) {
						BusinessPartner bp = (BusinessPartner) session
								.getAttribute("infoClient");
						search.setCodeClient(bp.getCardcode());
						if (session.getAttribute("domesticClients") != null) {
							logger.info(session.getAttribute("domesticClients")
									.toString());
						}
					}
				}
				try {
					/*
					 * Se invoca al metodo del negocio que realiza la consulta
					 * de acuerdo a los parametros de busqueda
					 */
					modelView = new ModelAndView(getSuccessView());
					ResultList results = manager.getResultList(search, 1);
					request.setAttribute("results", results);

				} catch (LogicException e) {
					request.setAttribute("msg", MessageManager.getMensaje(
							getApplicationContext(), request,
							MessageConstants.SEARCH_ERROR));
				}
				try {
					/*
					 * Se invoca al metodo del negocio obtiene la lista de
					 * valores de los combos de busqueda
					 */
					if (session.getAttribute("searchLists") == null) {
						/*
						 * Si la consulta no se ha realizado (por ejemplo en un
						 * formBackingObject ejecutado justo antes del onSubmit)
						 * se procede a realizarla
						 */
						Hashtable searchLists = manager.loadSearchList();
						session.setAttribute("searchLists", searchLists);
					}

				} catch (LogicException e) {
					request.setAttribute("msg", MessageManager.getMensaje(
							getApplicationContext(), request,
							MessageConstants.LOAD_ERROR));
					logger.error("Depurando SearchController: " + e);
					e.printStackTrace();
				}

				request.setAttribute("numPage", page); // Se le retorna a la
														// vista el numero de
														// pagina consultada
				session.setAttribute("search", search);
				modelView.addObject("search", search);
				System.out.println("SET THE SEARCH TO THE ATTRIBUTE");
			} else {
				search = null;
				session.invalidate();
				return new ModelAndView("index");
			}
		} catch (Exception e) {
			request.setAttribute("msg", MessageManager.getMensaje(
					getApplicationContext(), request,
					MessageConstants.LOAD_ERROR));
			logger.error("Depurando SearchController: " + e);
			e.printStackTrace();
		}
		request.setAttribute("search", search);
		return modelView;

	}

	protected Object formBackingObject(HttpServletRequest request)
			throws ServletException {

		Search search = new Search();
		BusinessPartner bp = null;
		int page = 1;
		HttpSession session = request.getSession(); // Se obtiene la sesion
		
		logger.info("ESTOY EN EL formBackingObject DEL SEARCH CONTROLLER");
	
		// Para validar el user de DOMESTIC_CLIENTS
		if (session.getAttribute("domesticClients") != null
				&& session.getAttribute("domesticClients").equals(
						"domesticClients")) {
			search.setLogin("domesticClients");
		}

		try {
			/*
			 * Si el parametro page es null, se esta ingresando a la consulta a
			 * traves del link del menu, por lo cual se procede a limpiar los
			 * parametros de busqueda de la sesion.
			 */
			if (request.getParameter("page") == null) {
				if (session != null) {
					session.setAttribute("search", search);
				}
				if (request.getParameter("m") != null) {
					session.setAttribute("m",
							Integer.parseInt(request.getParameter("m")));
				}

				try {
					/*
					 * Se invoca al metodo del negocio obtiene la lista de
					 * valores de los combos de busqueda
					 */
					Hashtable<String, Object> searchLists = manager.loadSearchList();
					session.setAttribute("searchLists", searchLists);
				} catch (LogicException e) {
					request.setAttribute("msg", MessageManager.getMensaje(
							getApplicationContext(), request,
							MessageConstants.LOAD_ERROR));
					logger.error("Depurando SearchController: " + e);
					e.printStackTrace();
				}
			} else {
				// Se obtiene el numero de pagina a consultar
				page = Integer.parseInt(request.getParameter("page"));
			}

			/*
			 * Se invoca al metodo del negocio que realiza la Busqueda, en caso
			 * que sea la primera consulta o cuando se presionan los link de
			 * paginacion
			 */
			if (request.getParameter("SubmitButton") == null) {

				if (session != null) {
					if (session.getAttribute("search") != null) {
						search = (Search) session.getAttribute("search");
					}
					if (session.getAttribute("infoClient") != null) {
						bp = (BusinessPartner) session
								.getAttribute("infoClient");
						search.setCodeClient(bp.getCardcode());
						logger.info("SETTING THE CARDCODECLIENT: " + bp.getCardcode());
					}
				}
				try {

					ResultList results = manager.getResultList(search, page);
					request.setAttribute("results", results);
					// System.out.println("Antes del  searchFuelRequest");

					if (searchFuelRequest != null
							&& searchFuelRequest.equals("searchFuelRequest")) {
						// search.setListBusinessPartner(results.getList());
						System.out.println("TAMAÑO ES: "
								+ results.getList().size());
					}

				} catch (LogicException e) {
					request.setAttribute("msg", MessageManager.getMensaje(
							getApplicationContext(), request,
							MessageConstants.SEARCH_ERROR));
				}
			}

			request.setAttribute("search", search);
			request.setAttribute("numPage", page);

		} catch (Exception e) {
			request.setAttribute("msg", MessageManager.getMensaje(
					getApplicationContext(), request,
					MessageConstants.LOAD_ERROR));
			logger.error("Depurando SearchController: " + e);
			e.printStackTrace();
		}
		return search;
	}

	public ManagerInterface getManager() {
		return manager;
	}

	public void setManager(ManagerInterface manager) {
		this.manager = manager;
	}

	public String getSearchFuelRequest() {
		return searchFuelRequest;
	}

	public void setSearchFuelRequest(String searchFuelRequest) {
		this.searchFuelRequest = searchFuelRequest;
	}
}