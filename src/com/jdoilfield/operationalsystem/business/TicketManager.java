package com.jdoilfield.operationalsystem.business;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jdoilfield.operationalsystem.domain.ResultList;
import com.jdoilfield.operationalsystem.domain.Search;
import com.jdoilfield.operationalsystem.domain.local.Airport;
import com.jdoilfield.operationalsystem.domain.local.Lov;
import com.jdoilfield.operationalsystem.domain.local.Ticket;
import com.jdoilfield.operationalsystem.domain.local.TicketHistory;
import com.jdoilfield.operationalsystem.domain.local.User;
import com.jdoilfield.operationalsystem.domain.remote.Airplane;
import com.jdoilfield.operationalsystem.domain.remote.BusinessPartner;
import com.jdoilfield.operationalsystem.domain.remote.FuelCard;
import com.jdoilfield.operationalsystem.domain.remote.Product;
import com.jdoilfield.operationalsystem.persistence.api.AirplaneDAO;
import com.jdoilfield.operationalsystem.persistence.api.AirportDAO;
import com.jdoilfield.operationalsystem.persistence.api.BusinessPartnerDAO;
import com.jdoilfield.operationalsystem.persistence.api.FuelCardDAO;
import com.jdoilfield.operationalsystem.persistence.api.IataInvoiceDAO;
import com.jdoilfield.operationalsystem.persistence.api.LovDAO;
import com.jdoilfield.operationalsystem.persistence.api.ProductDAO;
import com.jdoilfield.operationalsystem.persistence.api.TicketDAO;
import com.jdoilfield.operationalsystem.persistence.api.TicketHistoryDAO;
import com.jdoilfield.operationalsystem.persistence.api.UserDAO;
import com.jdoilfield.operationalsystem.persistence.wsclient.ServiceTicket;
import com.jdoilfield.operationalsystem.util.Constants;
import com.jdoilfield.operationalsystem.util.MessageConstants;
import com.jdoilfield.operationalsystem.util.SpringMailSender;
import com.jdoilfield.operationalsystem.util.Utilities;
import com.jdoilfield.ws.ticketservice.domain.MobileTicket;
import com.pranical.commons.exceptions.LogicException;
import com.pranical.commons.exceptions.PersistenceException;
import com.jdoilfield.operationalsystem.util.Constants;


/**
 * Realiza las  operaciones de negocio relacionadas con la Consulta de Tickets, 
 * e invoca a los metodos de persistencia para realizar dichas operaciones.
 * @author 
 */
public class TicketManager implements ManagerInterface<Ticket> {
	
	private TicketDAO ticketDao;
	private IataInvoiceDAO iataInvoiceDao;
	private TicketHistoryDAO ticketHistoryDao; 
	//private RemoteTicketDAO remoteTicketDao;
	private BusinessPartnerDAO businessPartnerDao;	
	private FuelCardDAO fuelCardDao; 
	private LovDAO lovDao;	
	private ProductDAO productDao;
	private AirportDAO airportDao;	
	private AirplaneDAO airplaneDao; 
	private UserDAO userDao;	
	private SpringMailSender mailSender;	
	private ServiceTicket serviceTicket;
	
	protected final Logger logger = LoggerFactory.getLogger(TicketManager.class);
	public Ticket getNewInstance() throws LogicException{
		
		return new Ticket();
	}
	
	/**	
	 * Agrega un nuevo ticket mediante la invocacion del servicio del mismo servicio
	 * que se usa para los mobiles
	 * @return
	 */
	
	public String add(Ticket ticket) {
		String result = null;
		String responseErrorCode = null;
		try {
			//Fill the mobile Ticket with the Ticket Data came from the jsp and then call the service
			responseErrorCode = serviceTicket.addTicket(fillMobileTicketData(ticket));
			
			if(responseErrorCode.equals(Constants.TICKET_ALREADY_EXIST)){
				result =  MessageConstants.TICKET_ALREADY_EXIST;
			}
			if(responseErrorCode.equals(Constants.TICKET_OK)) {
				result =  MessageConstants.TICKET_ADD_SUCCESS;
			}
			
			if(responseErrorCode.equals(Constants.TICKET_NOT_SAVED_TICKET_LOCAL)){
				result =  MessageConstants.TICKET_ADD_ERROR_LOCAL;
			}
			if(responseErrorCode.equals(Constants.TICKET_NOT_SAVED_TICKET_REMOTE)){
				result =  MessageConstants.TICKET_ADD_ERROR_REMOTE;
			}
			
		} catch (Throwable e) {
			  e.printStackTrace();
		}
		return result;
	}
	
	/*
	 * 
	 */
	private MobileTicket fillMobileTicketData(Ticket ticket){
		MobileTicket mobileTicket = new MobileTicket();
		
		

		mobileTicket.setTicketCode(ticket.getTicketCode());
		mobileTicket.setCardCodeClient(ticket.getClientCode());
		mobileTicket.setCardNameClient(ticket.getCardnameClient());
		//status
		//overdraft
		//mobileTicket.setDateTime(Utilities.formatDate(new Date(), "yyyy-MM-dd hh:mm:ss"));
		
		mobileTicket.setDateTime(ticket.getDatetimeString());
		
		mobileTicket.setCardCodeProvider(ticket.getProviderCode());
		mobileTicket.setCardNameProvider(ticket.getCardnameProvider());
		mobileTicket.setAirportId(ticket.getAirportId());
		mobileTicket.setAirplaneCode(ticket.getAirplaneCode());
		mobileTicket.setItemCode(ticket.getProductCode());
		mobileTicket.setItemName(ticket.getItemname());
		mobileTicket.setQuantityLts(ticket.getQuantityLtsString());
		mobileTicket.setQuantityGal(Utilities.convertLtsToGals(ticket.getQuantityLtsString()));
		//Esto fue modificado para el ejemplo de ENERGIZAR, donde se comento para que funcionara la opcion de litros
		//mobileTicket.setQuantityGal(Utilities.convertLtsToGals(ticket.getQuantityLtsString()));
		
		//This was modified for LTD
		//mobileTicket.setQuantityLts(Utilities.convertLtsToGals(ticket.getQuantityLtsString()));
		//mobileTicket.setQuantityGal(ticket.getQuantityLtsString());
		//End of LTD
		
		mobileTicket.setNotes(ticket.getNotes());
		mobileTicket.setReleaseBy(ticket.getReleasedBy());
		//Esto viene a definir el usuario que inserto la boleta
		mobileTicket.setUserId(ticket.getUser().getId());
		
		
		
		
		mobileTicket.setNewAirplane("N");
		mobileTicket.setNewAirplaneCode(ticket.getNewAirplaneCode());
		//
		//mobileTicket.setTicketIdMobile(ticket.getTicketIdMobile());
		mobileTicket.setTicketIdMobile(Integer.valueOf("1"));
		//
		logger.info("********Ticket Data Via Web Component*********");
		logger.info("TicketCode: " + ticket.getTicketCode());
		logger.info("ClientCode: " + ticket.getClientCode());
		logger.info("CardName: " + ticket.getCardnameClient());
		logger.info("ProviderCode: " + ticket.getProviderCode());
		logger.info("ProviderName: " + ticket.getCardnameProvider());
		logger.info("AirportID: " + ticket.getAirportId());
		logger.info("AirplaneCode: " + ticket.getAirplaneCode());
		logger.info("ProductCode: " + ticket.getProductCode());
		logger.info("ProductName: " + ticket.getItemname());
		logger.info("Liters: " + ticket.getQuantityLtsString());
		logger.info("Galones:" + ticket.getQuantityGal());
		logger.info("Notes: " + ticket.getNotes());
		logger.info("Released: " + ticket.getReleasedBy());
		//logger.info("NewAirplane(Y/N): " + ticket.getNewAirplane());
		logger.info("NewAirplaneCode: " + ticket.getNewAirplaneCode());
		logger.info("Date: " + ticket.getDatetimeString());
		logger.info("Codigo Logged User:" + ticket.getUser().getId());
		
		
		return mobileTicket;
	}  
	
	
	
	
	/**
	 * Retorna un ticket dado su id
	 * @return 
	 */
	public Ticket getElement(String id) throws LogicException{
		Ticket ticket = null;
		
		try{
			ticket = ticketDao.findById(Integer.parseInt(id));
		
		}catch(PersistenceException e){
			logger.error("Ocurrio un error al intentar consultar el ticket: "+id, e);
			throw new LogicException(e.getMessage(), e);
		}catch(Exception e){
			logger.error("Ocurrio un error al intentar actualizar el ticket: "+id, e);
			throw new LogicException(e.getMessage(), e);
		}
		return ticket;	
	}
	/**
	 * Gestiona la modificaci�n de un ticket existente en el sistema.
	 * @param t Ticket a modificar
	 */
	public String update(Ticket t) {
		String result = "";		
		try{
			User userTicket = userDao.findById(t.getIdUser());
			logger.info("-----------supervisor email: " + userTicket.getSupervisorUser().getEmail());
			
			if(t.getAmendment() != null && t.getAmendment().length() > 0){
				StringTokenizer amendmentStr = new StringTokenizer(t.getAmendment(),"^");
				String cadena = "";
				while(amendmentStr.hasMoreElements()){
					cadena = amendmentStr.nextElement().toString();
					if(cadena.contains("datetimeString_")){
						logger.info("se modifico la fecha con el valor: " + cadena.substring((cadena.indexOf("-->") + 3), cadena.length()));
					}
					if(cadena.contains("providerCode_")){
						logger.info("se modifico el proveedor con el valor: " + cadena.substring((cadena.indexOf("-->") + 3), cadena.length()));
					}
					if(cadena.contains("airportId_")){
						logger.info("se modifico el aeropuerto con el valor: " + cadena.substring((cadena.indexOf("-->") + 3), cadena.length()));
					}
					if(cadena.contains("airplaneCode_")){
						logger.info("se modifico el airplane con el valor: " + cadena.substring((cadena.indexOf("-->") + 3), cadena.length()));
					}					
					if(cadena.contains("productCode_")){
						logger.info("se modifico el product con el valor: " + cadena.substring((cadena.indexOf("-->") + 3), cadena.length()));
					}					
					if(cadena.contains("quantityLtsString_")){
						logger.info("se modifico el quantityLt con el valor: " + cadena.substring((cadena.indexOf("-->") + 3), cadena.length()));
					}															
					if(cadena.contains("notes_")){
						logger.info("se modifico las notas con el valor: " + cadena.substring((cadena.indexOf("-->") + 3), cadena.length()));
					}
				}
			}
			
			
			if(t.getOperation() != null && t.getOperation().equals("Modify Ticket")){
				//Validate here that only ROLE ADMIN, CHIEF OP and ADMIN OP can update the the ticket.

			
				try{
					t.setStatus(Constants.UPDATE_NOTIFICATION);
					
					//Checked it's a new requeriments
					logger.info("SESSION ROLE ID -- > " +t.getSessionRoleId());
					if (Integer.parseInt(t.getSessionRoleId()) == Constants.ROLE_ADMIN
							|| Integer.parseInt(t.getSessionRoleId()) == Constants.ROLE_ADMIN_OP
							|| Integer.parseInt(t.getSessionRoleId()) == Constants.OPERATION_SHIEF) {
						t.setChecked('Y');
					}
					BusinessPartner bp = businessPartnerDao.findById(t.getProviderCode());
					Product pro = productDao.findById(t.getProductCode());
					
					t.setItemname(pro.getItemname());
					t.setCardnameProvider(bp.getCardname());
					t.setQuantityLts(new BigDecimal(t.getQuantityLtsString()));

					
					if(t.getQuantityLts()!=null){
						
						
						t.setQuantityGalString(""+(double)(t.getQuantityLts().doubleValue() / Constants.GALON_CONVERSION));
						
						double d = (double)(t.getQuantityLts().doubleValue()/ Constants.GALON_CONVERSION);
						
						BigDecimal dd = new BigDecimal(d);
						dd = dd.movePointRight(6);
						dd = new BigDecimal(dd.longValue());
						dd = dd.movePointLeft(6);
					
						t.setQuantityGal(dd);
					}
					//Validate here that the input 
					if(t.getAnalistAmendment() != null && t.getAnalistAmendment().length() >0 
							|| t.getAmendment() != null && t.getAmendment().length() >0){
						/**
						 * 
						 */

//						logger.info((t.getTicketCode()));
//						logger.info(t.getProviderCode());
//						logger.info(t.getItemname());						
//						logger.info(t.getClientCode());
//						logger.info(t.getStatus()+"");
//						logger.info(t.getOverdraft()+"");
//						logger.info(t.getSourceDeviceId());
//						logger.info(t.getDatetime()+"");
//						logger.info(t.getDatetimeMobile()+"");
//						logger.info(t.getProviderCode());
//						logger.info(t.getAirportId()+"");
//						logger.info(t.getAirplaneCode());
//						logger.info(t.getProductCode());
//						logger.info(t.getQuantityLts()+"");
//						logger.info(t.getQuantityGal()+"");
//						logger.info(t.getNotes());
//						//
//						logger.info(t.getReleasedBy().equals("") || t.getReleasedBy().length() > 0 ? t.getReleasedBy()+"none" : t.getReleasedBy());
//						//
//						logger.info(t.getUser().getId()+"");
//						logger.info(t.getAirplaneCode());
//						logger.info(t.getTicketIdMobile()+"");
//						logger.info(t.getDatetime()+"");
//						logger.info(t.getNewAirplane());
						
						TicketHistory tH = new TicketHistory();
						tH.setTicketCode(t.getTicketCode());
						tH.setProviderCode(t.getProviderCode());
						tH.setQuantityLts(t.getQuantityLts());
						tH.setQuantityGal(t.getQuantityGal());
						t.setIdUser(t.getIdUser() == null ? 0 : t.getIdUser());
						tH.setAirplaneCode(t.getAirplaneCode() == null ? "" : t.getAirplaneCode());
						tH.setNewAirplaneCode(t.getNewAirplaneCode() == null ? "" : t.getNewAirplaneCode());
						tH.setProductCode(t.getProductCode());
						tH.setNotes(t.getNotes());
						tH.setClientCode(t.getClientCode());
						tH.setNewAirplane(t.getNewAirplane() == null ? "" : t.getNewAirplane());
						tH.setReleasedBy(t.getReleasedBy() == null ? "" : t.getReleasedBy());
						tH.setStatus(t.getStatus());
						tH.setSourceDeviceId(t.getSourceDeviceId());
						//
						tH.setDatetime(t.getDatetimeMobile() == null ? new Date() : t.getDatetimeMobile());
						//
						tH.setDatetimeMobile(t.getDatetimeMobile() == null ? new Date() : t.getDatetimeMobile());
						tH.setDatetimeString(t.getDatetimeString() == null ? "" : t.getDatetimeString());
						tH.setAirportId(t.getAirport().getId() == null ? 0 : t.getAirport().getId());
						tH.setAirport(t.getAirport() == null ? new Airport("none",0) : t.getAirport());
						tH.setCardnameClient(t.getCardnameClient()== null ? "" : t.getCardnameClient());
						tH.setCardnameProvider(t.getCardnameProvider() == null ? "" : t.getCardnameProvider());
						tH.setItemname(t.getItemname());						
						tH.setAmendment(t.getAmendment() == null ? "" : t.getAmendment());		
						tH.setChecked(t.getChecked() == ' ' ? 'N' : t.getChecked());
						tH.setIdUser(t.getUser().getId());
						tH.setNewAirplane(t.getNewAirplane() == null ? "N" : t.getNewAirplane());
						tH.setOverdraftString(t.getOverdraftString() == null ? "" : t.getOverdraftString());
						tH.setOverdraft(Character.valueOf(t.getOverdraft())  == null ? 'N' : t.getOverdraft());
						tH.setSourceDeviceId(t.getSourceDeviceId() == null ? "" : t.getSourceDeviceId());
						tH.setTicketIdMobile(t.getTicketIdMobile() == '0' ? 0 :t.getTicketIdMobile());
						tH.setIdApprove(t.getIdApprove() == null ? Integer.valueOf("0") : t.getIdApprove());
						
						/**
						 * 
						 */
						ticketHistoryDao.add(tH);
						/**
						 * 
						 */
						ticketDao.update(t);
						result =  MessageConstants.TICKET_UPDATE_SUCCESS;
						
						logger.info("Se ha actualizado el ticket: "+t.getTicketCode());
						
						if(userTicket.getSupervisorUser().getEmail()!=null){
							
							try{
								Map<String, Object> p = new HashMap<String, Object>();
								p.put("ticket", t);
								/*mailSender.sendMimeMessage( new String[]{userTicket.getSupervisorUser().getEmail()},
														" Ticket Update Notification",
														Constants.TICKET_MODIFY_TEMPLATE,p);*/
								logger.info("El email de notificacion de modificacion de Ticket.");
							}catch(Throwable e){
								logger.error("No se logro enviar el correo de notificacion de modificacion de Ticket. Para el ticket:" +
										" Code: " + t.getTicketCode(), e);
							}
						}
					}else{
						result = MessageConstants.TICKET_NONE_ACTION;
					}	

					
				}catch(Exception e){
					logger.error("Ocurrio un error al intentar actualizar el ticket: "+t.getTicketCode(), e);
					result = MessageConstants.TICKET_UPDATE_ERROR;
				}
	
			}else if(t.getOperation() != null && t.getOperation().equals("Cancel Ticket")){
				
				try{
					ticketDao.updateStatus(t.getId(), Constants.CANCEL_NOTIFICATION);
					result =  MessageConstants.TICKET_CANCEL_SUCCESS;
					
					logger.info("Se ha anulado el ticket: "+t.getTicketCode());
					
					if(userTicket.getSupervisorUser().getEmail()!=null){
						try{
							Map<String, Object> p = new HashMap<String, Object>();
							p.put("ticket", t);
							/*mailSender.sendMimeMessage(new String[]{userTicket.getSupervisorUser().getEmail()},
												" Ticket Cancel Notification",
													Constants.TICKET_CANCEL_TEMPLATE,p);
							logger.info("El email de notificacion de cancelacion de Ticket");*/
						}catch(Throwable e){
							logger.error("No se logro enviar el correo de notificacion de anulacion de Ticket. Para el ticket: " + t.getTicketCode(), e);
						}
					}

				}catch(PersistenceException e){
					logger.error("Ocurrio un error al intentar anular el ticket: "+t.getTicketCode(), e);
					result = MessageConstants.TICKET_CANCEL_ERROR;
				}
				
				result =  MessageConstants.TICKET_CANCEL_SUCCESS;
				
			}else if(t.getOperation() != null && t.getOperation().equals("Ticket Checked")){
				//TODO LIST
				/**
				 * Acomodar el message
				 * acomodar el Constants
				 * Acomodar el codigo de abajo para Checked Ticket
				 */
				
				//
				try{
					//Checked it's a new requeriments
					t.setChecked('Y');
					
					ticketDao.updateStatus(t.getId(), Constants.CHECKED_NOTIFICATION);
					result =  MessageConstants.TICKET_CHECKED_SUCCESS;
					
					logger.info("Se ha chequeado solamente el ticket: "+t.getTicketCode());
					ticketDao.update(t);
					if(userTicket.getSupervisorUser().getEmail()!=null){
						try{
							Map<String, Object> p = new HashMap<String, Object>();
							p.put("ticket", t);
							/*mailSender.sendMimeMessage(new String[]{userTicket.getSupervisorUser().getEmail()},
												" Ticket Cancel Notification",
													Constants.TICKET_CANCEL_TEMPLATE,p);
							logger.info("El email de notificacion de cancelacion de Ticket");*/
						}catch(Throwable e){
							logger.error("No se logro enviar el correo de notificacion de anulacion de Ticket. Para el ticket: " + t.getTicketCode(), e);
						}
					}

				}catch(PersistenceException e){
					logger.error("Ocurrio un error al intentar chequear el ticket: "+t.getTicketCode(), e);
					result = MessageConstants.TICKET_CHECKED_ERROR;
				}
				
				result =  MessageConstants.TICKET_CHECKED_SUCCESS;
			}
			
			
		}catch(PersistenceException e){
			logger.error("Ocurrio un error al intentar anular el ticket: "+t.getTicketCode(), e);
			result = MessageConstants.TICKET_CANCEL_ERROR;
		}
		return result;
	}
	
	/**
	 * Retorna una lista con los tickets del sistema, para paginaci�n. 
	 * @param s Objeto que encapsula los parametros de b�squeda
	 * @param page Indice que indica desde donde se realizara la busqueda
	 * @return ResultList Objeto que encapsula la lista resultado, 
	 * e informacion relacionada con la consulta
	 * @throws LogicException
	 */
	public ResultList getResultList(Search s, int page) throws LogicException {
		
		ResultList list = null;
		logger.info("login--->>>>>>>>>>>>>>>>>>>>>>" + s.getLogin());

		try{

			list = ticketDao.find(s, ((page-1)*s.getNumRows()));
		
			if(s.getCodeClient()!=null && !s.getCodeClient().equals("0")){
			
				BusinessPartner bp = businessPartnerDao.findById(s.getCodeClient());
				list.setBusinessPartner(bp);
			}
			
		}catch(PersistenceException e){
			logger.error("Ocurrio un error al realizar la busqueda de los tickets", e);
			throw new LogicException(e.getMessage(), e);
		}catch(Exception e){
			logger.error("Ocurrio un error al realizar la busqueda de los tickets", e);
			throw new LogicException(e.getMessage(), e);
		}
		return list;	
	}
	
	/**
	 * Retorna una coleccion con las listas requeridas para llenar los combos
	 * en la vista de Modificar Boleta
	 * @return
	 */
	public Hashtable<String, Object> loadLists() throws LogicException {
		
		Hashtable<String, Object> data = new Hashtable<String, Object>();
		
		
		try{
	    	/* Se invocan a los metodos de persistencia que realizan la busqueda de  
    		 * los roles a ser mostrados en el combo de roles,
    		 * los usuarios a ser mostrados en el combo de supervisores,
    		 * y los clientes a ser mostrados en el combo de clientes */
	      	List<Airport> airports = airportDao.findAll();
	    	List<BusinessPartner> providers = businessPartnerDao.findByType(Constants.SUPLIER);
	    	List<BusinessPartner> customers = businessPartnerDao.findByType(Constants.CUSTOMER);
	    	List<Product> products = productDao.findAll();
	    	List<Airplane> airplanes = airplaneDao.findAll();
	    	List docNum = iataInvoiceDao.findAllDocNum();
	    	
			data.put("airports", airports);
			data.put("providers", providers);
			data.put("products", products);
			data.put("customers", customers);
			data.put("airplanes", airplanes);
			data.put("docNum", docNum);

		}catch(PersistenceException e){
			logger.error("Ocurrio un error al intentar obtener las listas de los combos de la vista de modificacion de Tickets", e);
			throw new LogicException(e.getMessage(), e);
		}
		return data;	
	}
	
	
	/**
	 * Retorna una coleccion con las listas requeridas para llenar los combos
	 * en la vista de busqueda de boletas
	 * @return
	 */
	public Hashtable<String, Object> loadSearchList() throws LogicException {
		
		Hashtable<String, Object> data = new Hashtable<String, Object>();
		
	
		try{
			List<BusinessPartner> clients = businessPartnerDao.findByType(Constants.CUSTOMER);
			List<BusinessPartner> providers = businessPartnerDao.findByType(Constants.SUPLIER);
			List<Lov> status = lovDao.getValues(Constants.LOV_STATUS_TICKET_AMENDMENT);
			List<Airport> airports = airportDao.findAll();
			List<Airplane> airplanes = airplaneDao.findAll();
			//This is for fill the combo with the InvoiceNumber from the view CMP_Invoice_IATA
			List docNum = iataInvoiceDao.findAllDocNum();
			
			data.put("providers", providers);
			data.put("airports", airports);
			data.put("clients", clients);
			data.put("airplanes", airplanes);
			data.put("status", status);
			//invoiceNumber
			data.put("docNum", docNum);
			

		}catch(PersistenceException e){
			logger.error("Ocurrio un error al intentar obtener las listas de los combos de busqueda de Tickets", e);
			throw new LogicException(e.getMessage(), e);
		}
		catch(Exception e){
			logger.error("Ocurrio un error al intentar obtener las listas de los combos de busqueda de Tickets", e);
			throw new LogicException(e.getMessage(), e);
		}
		return data;	
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.jdoilfield.operationalsystem.business.ManagerInterface#getList()
	 */

	@Override
	public FuelCard validatefuelCardCode(String fuelCardId) {
 		return null;
	}
	
	/*  Load the lists for provider/clients which are associated with the provider.
	 * (non-Javadoc)
	 * @see com.jdoilfield.operationalsystem.business.ManagerInterface#getList()
	 */
	@Override
	public Hashtable<String, Object> loadLists(String fuelCardId)
			throws LogicException {
		
		return null;
	}
	
	
	public List<Ticket> getList() throws LogicException{return null;}

	public String delete(String id) { return null;}
	
	public BusinessPartnerDAO getBusinessPartnerDao() {
		return businessPartnerDao;
	}

	public void setBusinessPartnerDao(
			BusinessPartnerDAO businessPartnerDao) {
		this.businessPartnerDao = businessPartnerDao;
	}

	public LovDAO getLovDao() {
		return lovDao;
	}

	public void setLovDao(LovDAO lovDao) {
		this.lovDao = lovDao;
	}

	public ProductDAO getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDAO productDao) {
		this.productDao = productDao;
	}

	public AirportDAO getAirportDao() {
		return airportDao;
	}

	public void setAirportDao(AirportDAO airportDao) {
		this.airportDao = airportDao;
	}

	public TicketDAO getTicketDao() {
		return ticketDao;
	}

	public void setTicketDao(TicketDAO ticketDao) {
		this.ticketDao = ticketDao;
	}

	public SpringMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(SpringMailSender mailSender) {
		this.mailSender = mailSender;
	}
	public UserDAO getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}


	public AirplaneDAO getAirplaneDao() {
		return airplaneDao;
	}

	public void setAirplaneDao(AirplaneDAO airplaneDao) {
		this.airplaneDao = airplaneDao;
	}

	public ServiceTicket getServiceTicket() {
		return serviceTicket;
	}

	public void setServiceTicket(ServiceTicket serviceTicket) {
		this.serviceTicket = serviceTicket;
	}

	public TicketHistoryDAO getTicketHistoryDao() {
		return ticketHistoryDao;
	}

	public void setTicketHistoryDao(TicketHistoryDAO ticketHistoryDao) {
		this.ticketHistoryDao = ticketHistoryDao;
	}

	public IataInvoiceDAO getIataInvoiceDao() {
		return iataInvoiceDao;
	}

	public void setIataInvoiceDao(IataInvoiceDAO iataInvoiceDao) {
		this.iataInvoiceDao = iataInvoiceDao;
	}

	public FuelCardDAO getFuelCardDao() {
		return fuelCardDao;
	}

	public void setFuelCardDao(FuelCardDAO fuelCardDao) {
		this.fuelCardDao = fuelCardDao;
	}

	@Override
	public Object getCustomElementById(String fuelCardCode,
			String cardCodeClient, String id) throws LogicException {
		// TODO Auto-generated method stub
		return null;
	}
}