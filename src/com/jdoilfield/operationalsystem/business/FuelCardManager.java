package com.jdoilfield.operationalsystem.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.collections.list.FixedSizeList;
import org.apache.log4j.Logger;

import com.jdoilfield.operationalsystem.domain.ResultList;
import com.jdoilfield.operationalsystem.domain.Search;
import com.jdoilfield.operationalsystem.domain.remote.Airplane;
import com.jdoilfield.operationalsystem.domain.remote.BusinessPartner;
import com.jdoilfield.operationalsystem.domain.remote.FuelCard;
import com.jdoilfield.operationalsystem.persistence.api.AirplaneDAO;
import com.jdoilfield.operationalsystem.persistence.api.BusinessPartnerDAO;
import com.jdoilfield.operationalsystem.persistence.api.FuelCardDAO;
import com.jdoilfield.operationalsystem.persistence.wsclient.ServiceFuelCard;
import com.jdoilfield.operationalsystem.util.Constants;
import com.jdoilfield.operationalsystem.util.MessageConstants;
import com.jdoilfield.operationalsystem.util.Utilities;
import com.jdoilfield.ws.fuelcardservice.domain.FuelCardMobile;
import com.pranical.commons.exceptions.LogicException;
import com.pranical.commons.exceptions.PersistenceException;

public class FuelCardManager implements ManagerInterface<FuelCard> {

	private FuelCardDAO fuelCardDao;
	private AirplaneDAO airplaneDao;
	private BusinessPartnerDAO businessPartnerDao;
	private ServiceFuelCard serviceFuelCard;
	private static Logger logger = Logger.getLogger(FuelCardManager.class);
	private String randomCodeGenerated;

	/**
	 * Retorna una nueva instancia de FuelCard
	 * 
	 * @return
	 */
	@Override
	public FuelCard getNewInstance() throws LogicException {
		// TODO Auto-generated method stub
		return new FuelCard();
	}

	/**
	 * Retorna una coleccion con las listas requeridas para llenar los combos en
	 * la vista de Agregar y Modificar FuelCard
	 * 
	 * @return
	 */
	@Override
	public Hashtable<String, Object> loadLists() throws LogicException {
			return null;
	}

	/**
	 * Retorna una coleccion con las listas requeridas para llenar los combos en
	 * la vista de busqueda de FuelCards.
	 * 
	 * @return
	 */
	@Override
	public Hashtable<String, Object> loadSearchList() throws LogicException {
		Hashtable<String, Object> data = new Hashtable<String, Object>();

		try {
			List<BusinessPartner> clients = businessPartnerDao.findByType(Constants.CUSTOMER);
			data.put("clients", clients);
		} catch (PersistenceException e) {
			logger.error(
					"Ocurrio un error al intentar obtener la lista del combo de la vista ingresar o modificar un usuario del modulo de FuelCard ",
					e);
			throw new LogicException(e.getMessage(), e);
		}
		return data;
	}

	/**
	 * Retorna una lista con los fuel cards del sistema, para paginación.
	 * 
	 * @param s   Objeto que encapsula los parametros de búsqueda
	 * @param page  Indice que indica desde donde se realizara la busqueda
	 * @return ResultList Objeto que encapsula la lista resultado, e informacion
	 *         relacionada con la consulta
	 * @throws LogicException
	 */
	public ResultList getResultList(Search s, int page) throws LogicException {

		ResultList fuelCardList = null;

		try {

			fuelCardList = fuelCardDao.find(s, ((page - 1) * s.getNumRows())); 

		} catch (PersistenceException e) {
			logger.error(
					"Ocurrio un error al intentar realizar la busqueda de los fuel cards",
					e);
			throw new LogicException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(
					"Ocurrio un error al intentar realizar la busqueda de los fuel cards",
					e);
			throw new LogicException(e.getMessage(), e);
		}
		return fuelCardList;
	}

	@Override
	public List<FuelCard> getList() throws LogicException {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Retorna un Fuel Card dado su id o un user Dado su Id
	 * @param login Id del fueldcard a editar
	 * @return
	 */
	@Override
	public FuelCard getElement(String fuelCardCode) throws LogicException {
		FuelCard fuelCard = null;
		
		try {
			fuelCard = fuelCardDao.findByFuelCard(fuelCardCode);
			logger.info(fuelCard);
		} catch(PersistenceException exception){
			logger.error("Ocurrio un error al intentar consultar el fuelCard: "+fuelCardCode, exception);
			throw new LogicException(exception.getMessage(), exception);
		}catch(Exception exception){
			logger.error("Ocurrio un error al intentar actualizar el fuelCard: "+fuelCardCode, exception);
			throw new LogicException(exception.getMessage(), exception);
		}
		return fuelCard;	
	}
	
	/**
	 * Especially design for get a custom element during the add, 
	 * that way we can combined the Add and Udpate at the same time. 
	 */
	@Override
	/*
	 * id The id of the client, CardCodeClient
	 * fuelCardCode the id of the fuelCardCode
	 * (non-Javadoc)
	 * @see com.jdoilfield.operationalsystem.business.ManagerInterface#getCustomElementById(java.lang.String, java.lang.String)
	 */
	public Object getCustomElementById(String fuelCardCode, String cardCodeClient, String id) throws LogicException {
		BusinessPartner businessPartner = null;
		FuelCard fuelCard = null;
		List<Airplane> airplanes = new ArrayList<Airplane>();
		List<FuelCard> lstFuelCards = new ArrayList<FuelCard>();
		List<String> cardCodeIds = new ArrayList<String>();
		List<String> airCraftCodes = new ArrayList<String>();
		cardCodeIds.add(cardCodeClient);
		boolean canAddFC = true;
		
		try{
			logger.info("FuelCardManger:getCustomElementById--> fuelCardCode : " + fuelCardCode);
			logger.info("FuelCardManger:getCustomElementById--> cardCodeClient : " + cardCodeClient);
			logger.info("FuelCardManger:getCustomElementById--> id : " + id);

			businessPartner = businessPartnerDao.findById(cardCodeClient);
			airplanes = airplaneDao.findAllByUser(cardCodeIds);
			List <Airplane> airplanesFixed = FixedSizeList.decorate(airplanes);
			
			logger.info("THE PARTNER ID TO SEARCH ITS AIRPLANES: " + cardCodeIds);
			logger.info("SIZE OF THE AIRPLANE LIST: " + airplanes.size());
			for(Airplane airp : airplanes){
				logger.info("AIRPLANES CODES___: " +  airp.getId().getCode());
				airCraftCodes.add(airp.getId().getCode());
				logger.info("AIRPLANES LIST ARRAY INDEX___: " +  airplanes.indexOf(airp));
			}
			//Let's validate that this airplanes has no Fuel Card associated.
			lstFuelCards = fuelCardDao.getAllFuelCardByCardCodeClient(cardCodeClient);
			logger.info("The number of fuel cards associated to: " + cardCodeClient + " are: " + lstFuelCards.size());
			
			//Creating
			if (fuelCardCode.length() == 0 && fuelCardCode.equals("")){
				logger.info("ADDING FC...--------------------");
				//
				for(FuelCard fuelCardInList: lstFuelCards){
					logger.info("Airplanes to evaluate from the list of fuelcards: " + fuelCardInList.getAircraftCode());
					logger.info("Fuel Card Status: " + fuelCardInList.getStatus());
					if(airCraftCodes.contains(fuelCardInList.getAircraftCode())){
						logger.info("---- THERE IS AN AIRCRAFT: " + fuelCardInList.getAircraftCode() + " WHICH BELONGS TO THE CUSTOMER: " + cardCodeClient + 
								" THAT HAS A FUEL CARD ALREADY REGISTERED -----" );
						logger.info("INDEX TO BE REMOVED: " + airCraftCodes.indexOf(fuelCardInList.getAircraftCode()));
						logger.info("SIZE OF AIRPLANES FIXED LIST CHECK: " + airplanesFixed.size());
						//
						if(fuelCardInList.getStatus().equals("Bloqueado")){
							logger.info("THERE IS AN AIRCRAFT THAT IS BLOCKED, WE ARE NOT GOING TO REMOVE IT FROM THE AVAILABLE LIST: " + 
									fuelCardInList.getAircraftCode());
						}else {
							airplanesFixed.set(airCraftCodes.indexOf(fuelCardInList.getAircraftCode()), new Airplane());
						}
					}
				}
				
				//Remove unnecessary elements
				List<Airplane> list = new ArrayList<Airplane>();

			    for(Airplane air : airplanesFixed) {
			       if(air != null){
			    	   if(air.getId() != null && air.getId().getCode().length() > 0) {
					          list.add(air);   
			    	   }  
			       }
			    }
			    airplanesFixed = list;
				//
				if(airplanesFixed.size() == 0) {
					canAddFC = false;
					logger.info("CANNOT ADD MORE FUEL CARDS, THERE ARE NO MORE AIRPLANES AVAILABLE");
				}
					
				
				//
				if(canAddFC){
					fuelCard = new FuelCard();
					fuelCard.setBusinessPartner(businessPartner);
					fuelCard.setAirplanes(airplanesFixed);
					//This Part is design for the FuelCardCode Generation
					fuelCard.setFuelCardRandomCode(getFuelCardRadom());
					//
					String fuelCardCodeRandom = generateFuelCardCode(businessPartner.getCountry(), businessPartner.getCardcode()); 
					logger.info("This is the fuelCardCode generate automatically: " + fuelCardCodeRandom);
					fuelCard.setFuelCardCode(fuelCardCodeRandom);
				} else { 
					fuelCard = new FuelCard();
					fuelCard.setObservations("/*-@@@@@ALL_AIRCRAFTS_HAVE_FUELCARD_ASSOCIATED@@@@@_/*");
					fuelCard.setCardCodeName(businessPartner.getCardname());
					logger.info("SETTING OBSERVATION's VALUE TO: /*-@@@@@ALL_AIRCRAFTS_HAVE_FUELCARD_ASSOCIATED@@@@@_/*");
				}
			//Editing	
			} else {
				logger.info("EDITING FC...--------------------");
				fuelCard = this.getElement(fuelCardCode);
				fuelCard.setAirplanes(airplanes);
				fuelCard.setBusinessPartner(businessPartner);
				logger.info("FuelCardManager:getCustomElementById: Updating a fuelCard: " + fuelCard.getFuelCardCode() + " Airplane: " + fuelCard.getAircraftCode()
						+ " The number of airplanes for the customer are: " + airplanes != null ? airplanes.size() : "No airplanes for this client");
			}	
			
		}catch(PersistenceException e){
			logger.error("Ocurrio un error al processar el BusinessPartner: "+cardCodeClient, e);
			throw new LogicException(e.getMessage(), e);
		}catch(Exception e){
			logger.error("Ocurrio un error al intentar consultar el BusinessPartner: "+cardCodeClient, e);
			throw new LogicException(e.getMessage(), e);
		}
		return fuelCard;	
	}
	
	/**
	 * Gestiona la incorporación de un nuevo fuelcard al sistema.
	 * @param fuelCard FuelCard a agregar
	 */
	public String add(FuelCard fuelCard) {
		String result = "";
		String responseErrorCode = null;
		
		try{
			logger.info("FuelCardValues client card code: " + fuelCard.getCardCodeClient());
			logger.info("FuelCardValues client name: " + fuelCard.getCardCodeName());
			logger.info("FuelCardValues aircraft code: " + fuelCard.getAircraftCode());
			logger.info("FuelCardValues fuel card code: " + fuelCard.getFuelCardCode());
			logger.info("FuelCardValues status: " + fuelCard.getStatus());
			logger.info("FuelCardValues string init date: " + fuelCard.getStringInitDate());
			logger.info("FuelCardValues string end date: " + fuelCard.getStringEndDate());
			logger.info("FuelCardValues international: " + fuelCard.getInternational());
			logger.info("FuelCardValues Observations: " + fuelCard.getObservations());
			logger.info("FuelCardValues Random: " + fuelCard.getFuelCardRandomCode());

			
			/* The code below is not working properly
			 *fuelCardDao.add(fuelCard);*/
			
			//We are adding a new implementation for fuelCardService.
			responseErrorCode = serviceFuelCard.addFuelCard(fillFuelCardMobileData(fuelCard));
			//if (responseErrorCode.equals("")){
					logger.info("Response detected in FuelCardManager: " + responseErrorCode);
			//};
			
			result = MessageConstants.FUEL_CARD_INSERT_SUCCESS;
			logger.info("AFTER THE ADD A FUEL CARD..");
		}catch(PersistenceException e){
			logger.error("Ocurrio un error al intentar ingresar el fuelCard: "+fuelCard.getFuelCardCode()+" a la BD", e);
			result = MessageConstants.FUEL_CARD_INSERT_ERROR;
		}catch(Exception exception){
			logger.error("ERROR ADDING A FUEL CARD", exception);
			/*logger.error("Ocurrio un error al intentar ingresar el fuelCard: "+  fuelCard.getFuelCardCode() +"a la BD", e);*/
			result = MessageConstants.FUEL_CARD_INSERT_ERROR;
		}catch (Throwable ex){
			result = MessageConstants.FUEL_CARD_INSERT_ERROR;
			logger.error("Ocurrio un error on FuelCardRemote", ex);
		}
		return result;
	}
	
	private FuelCardMobile fillFuelCardMobileData(FuelCard fuelCard ){
		FuelCardMobile fuelCardMobile = new FuelCardMobile();
		
		//Lets just add only on attribute
		fuelCardMobile.setFuelCardIdMobile(fuelCard.getId());
		fuelCardMobile.setCardCodeName(fuelCard.getCardCodeName());
		fuelCardMobile.setCardCodeClient(fuelCard.getCardCodeClient());
		fuelCardMobile.setAircraftCode(fuelCard.getAircraftCode());
		fuelCardMobile.setFuelCardCode(fuelCard.getFuelCardCode());
		fuelCardMobile.setStatus(fuelCard.getStatus());
		fuelCardMobile.setInitDate(fuelCard.getStringInitDate());
		fuelCardMobile.setEndDate(fuelCard.getStringEndDate());
		fuelCardMobile.setInternational(fuelCard.getInternational());
		fuelCardMobile.setObservations(fuelCard.getObservations());
		fuelCardMobile.setFuelCardRandomCode(fuelCard.getFuelCardRandomCode());

		
		logger.info("********FuelCard Data Set to FuelCardMobile Via Web Component*********");
		logger.info("FuelCardId: " + fuelCard.getId());
		logger.info("CardCodeName: " + fuelCard.getCardCodeName());
		logger.info("ClientCode: " + fuelCard.getCardCodeClient());
		logger.info("Aircraft: " + fuelCard.getAircraftCode());
		logger.info("FuelCardCode: " + fuelCard.getFuelCardCode());
		logger.info("Status: " + fuelCard.getStatus());
		logger.info("Init Date: " + fuelCard.getStringInitDate());
		logger.info("End Date: " + fuelCard.getStringEndDate());
		logger.info("International: " + fuelCard.getInternational());
		logger.info("Observations: " + fuelCard.getObservations());
		logger.info("FuelCardValues Random: " + fuelCard.getFuelCardRandomCode());

		//End of settings.
		return fuelCardMobile ;
	}

	@Override
	public String update(FuelCard fuelCard) {
		String responseErrorCode  = "";
		logger.info("We are going to Update the fuelCard");
		try {
			
			logger.info("FuelCardValues client card code: " + fuelCard.getCardCodeClient());
			logger.info("FuelCardValues client name: " + fuelCard.getCardCodeName());
			logger.info("FuelCardValues aircraft code: " + fuelCard.getAircraftCode());
			logger.info("FuelCardValues fuel card code: " + fuelCard.getFuelCardCode());
			logger.info("FuelCardValues status: " + fuelCard.getStatus());
			logger.info("FuelCardValues string init date: " + fuelCard.getStringInitDate());
			logger.info("FuelCardValues string end date: " + fuelCard.getStringEndDate());
			logger.info("FuelCardValues international: " + fuelCard.getInternational());
			logger.info("FuelCardValues Observations: " + fuelCard.getObservations());
			logger.info("FuelCardValues Random: " + fuelCard.getFuelCardRandomCode());
			
			
			responseErrorCode = serviceFuelCard.updateFuelCard(fillFuelCardMobileData(fuelCard));
			responseErrorCode  = MessageConstants.FUEL_CARD_UPDATE_SUCCESS;
		} catch (Exception exception) {
			responseErrorCode  = MessageConstants.FUEL_CARD_UPDATE_ERROR;
			logger.error("An error ocurred while updating the fuelCard", exception);
		} catch (Throwable exception) {
			responseErrorCode  = MessageConstants.FUEL_CARD_UPDATE_ERROR;
			logger.error("An error ocurred while updating the fuelCard", exception);
		}
		// TODO TEMP RETURN SUCCESS VALUE
		return responseErrorCode ;
	}

	@Override
	public String delete(String fuelCardCode) {
		String responseErrorCode  = "";
		logger.info("We are going to Delete the fuelCard with fuelCardCode: " + fuelCardCode);
		
		try {
			responseErrorCode = serviceFuelCard.deleteFuelCard(fillFuelCardMobileData(this.getElement(fuelCardCode)));
			responseErrorCode  = MessageConstants.FUEL_CARD_DELETE_SUCCESS;
		} catch (Exception exception) {
			responseErrorCode  = MessageConstants.FUEL_CARD_DELETE_ERROR;
			logger.error("An error ocurred while updating the fuelCard", exception);
		} catch (Throwable exception) {
			responseErrorCode  = MessageConstants.FUEL_CARD_DELETE_ERROR;
			logger.error("An error ocurred while updating the fuelCard", exception);
		}
		// TODO TEMP RETURN SUCCESS VALUE
		return responseErrorCode ;
	}

	@Override
	public FuelCard validatefuelCardCode(String fuelCardCode)
			throws LogicException {
		FuelCard fuelCard = null;
		logger.info("THIS IS THE FUEL CARD CODE WE NEED TO VALIDATE: " + fuelCardCode);
		try {
			fuelCard = fuelCardDao.findByFuelCard(fuelCardCode);
			if (fuelCard == null){
				//fuelCard.setStatus(Constants.HAS_NO_CARD_ID);
				logger.info("THIS USER HAS NO AN ACTIVE FUEL CARD");
				return fuelCard;
				
			}

			logger.info("NOT NULL CARD");
			logger.info("STATUS: " + fuelCard.getStatus());
			if(fuelCard.getStatus().contains("Activo")){
				logger.info("THIS IS A VALID CARD");
				//fuelCard.setStatus(Constants.VALID_CARD_ID);
				return fuelCard;
			}
			
			if(fuelCard.getStatus().contains(("Inactivo"))){
				logger.info("THIS IS AN INVALID CARD");
				//fuelCard.setStatus(Constants.INVALID_CARD_ID);
				return fuelCard;
			}
		} catch (PersistenceException ex) {
			logger.error(ex.toString());
		}
		return fuelCard;
	}

	/**
	 * Retorna una coleccion con las listas requeridas para llenar los combos en
	 * la vista de busqueda de fuelCards, que tambien serviran para poder pasar
	 * el valor del cardCodeClient hacia el addCardCode, asi se podran buscar
	 * los valores del airplane cuando se vaya a agregar un nuevo FuelCard
	 * 
	 * @return
	 */
	@Override
	public Hashtable<String, Object> loadLists(String fuelCardId)
			throws LogicException {

		Hashtable<String, Object> data = new Hashtable<String, Object>();
		Collection<String> cardCodeClient = new ArrayList<String>();
		cardCodeClient.add(fuelCardId);
		List<Airplane> airplanes = null;

		try {
			/*
			 * Se invoca al metodo de persistencia que realizan la busqueda de
			 * los airplanes a ser mostrados en el combo de aeronaves al agregar
			 * un nuevo FuelCard
			 */
			airplanes = airplaneDao.findAllByUser(cardCodeClient);
			data.put("airplanes", airplanes);

		} catch (PersistenceException e) {
			logger.error(
					"Ocurrio un error al intentar obtener las listas de los combos de busqueda de Airplanes",
					e);
			throw new LogicException(e.getMessage(), e);
		}
		return data;
	}
	
	/*
	 * Method design for the random code, for the fuelCardCode
	 */
	private String generateFuelCardCode (String country, String businessPartnerCardCode){
		StringBuilder randomCode = new StringBuilder();
		//First Country
		//randomCode.append(country);
		randomCode.append("5000");
		//TODO validate with Jose Antonio how to get the country code from BusinessPartner VIEW
		//Then 8 values from the random
		randomCode.append(randomCodeGenerated);
		//Last the Business Partner CardCode
		randomCode.append(businessPartnerCardCode);
		//
		return randomCode.toString();
	}
	
	/*
	 * 
	 */
	public String getFuelCardRadom() {
		String random = "";
		String randomToValidate = "";
		random = Utilities.generateAutomaticPasswordOrFuelCard(true);
		try {
			randomToValidate = fuelCardDao.findRandomCode(random);
			if(randomToValidate != null && randomToValidate.length() > 0){
				logger.info("THE FUEL CARD CODE IS TAKEN");
				random = getFuelCardRadom();
			}
		} catch (PersistenceException exception) {
			logger.info("DUPLICATED FUEL CARD RANDOM", exception);
		}
		randomCodeGenerated = random;
		return random;
	}
	
	
	public FuelCardDAO getFuelCardDao() {
		return fuelCardDao;
	}

	public void setFuelCardDao(FuelCardDAO fuelCardDao) {
		this.fuelCardDao = fuelCardDao;
	}

	public BusinessPartnerDAO getBusinessPartnerDao() {
		return businessPartnerDao;
	}

	public void setBusinessPartnerDao(BusinessPartnerDAO businessPartnerDao) {
		this.businessPartnerDao = businessPartnerDao;
	}

	public AirplaneDAO getAirplaneDao() {
		return airplaneDao;
	}

	public void setAirplaneDao(AirplaneDAO airplaneDao) {
		this.airplaneDao = airplaneDao;
	}

	public ServiceFuelCard getServiceFuelCard() {
		return serviceFuelCard;
	}

	public void setServiceFuelCard(ServiceFuelCard serviceFuelCard) {
		this.serviceFuelCard = serviceFuelCard;
	}
}
