package com.jdoilfield.operationalsystem.business;

import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;

import com.jdoilfield.operationalsystem.domain.ResultList;
import com.jdoilfield.operationalsystem.domain.Search;
import com.jdoilfield.operationalsystem.domain.local.Airport;
import com.jdoilfield.operationalsystem.domain.remote.FuelCard;
import com.jdoilfield.operationalsystem.persistence.api.AirportDAO;
import com.jdoilfield.operationalsystem.util.Constants;
import com.jdoilfield.operationalsystem.util.MessageConstants;
import com.pranical.commons.exceptions.LogicException;
import com.pranical.commons.exceptions.PersistenceException;

/**
 * Realiza las  operaciones de negocio relacionadas con el Manejo de Aeropuertos, 
 * e invoca a los metodos de persistencia para realizar dichas operaciones.
 * @author Reinaldo
 */
public class AirportManager implements ManagerInterface<Airport> {

	private AirportDAO airportDao;
	
	private static Logger logger = Logger.getLogger(AirportManager.class);

	private String result;
	
	/**
	 * Retorna una nueva instancia de Aeropuerto. 
	 * @return
	 */
	public Airport getNewInstance() throws LogicException{
		
		return new Airport();
	}
	
	/**
	 * Retorna una lista con los aeropuertos registrados. 
	 * @return
	 */
	public List<Airport> getList() throws LogicException {
		List<Airport> airports = null;
		try{
			airports = airportDao.findAll();
		
		}catch(PersistenceException e){
			logger.error("Ocurrio un error al buscar la lista de aeropuertos", e);
			throw new LogicException(e.getMessage(), e);
		}catch(Exception e){
			logger.error("Ocurrio un error al buscar la lista de aeropuertos ", e);
			throw new LogicException(e.getMessage(), e);
		}
		return airports;	
	}
	
	/**
	 * Retorna una lista con los aeropuertos que coincidan 
	 * com los parametros de busqueda 
	 * @param s Objeto que encapsula los parametros de b�squeda
	 * @param index Indice que indica desde donde se realizara la busqueda
	 * @return
	 * @throws LogicException
	 */
	public ResultList getResultList(Search s, int page) throws LogicException {
		
		ResultList list = null;

		try{
			if(s!=null){
				list = airportDao.find(s, ((page-1)*s.getNumRows()));
			}
		}catch(PersistenceException e){
			logger.error("Ocurrio un error al realizar la busqueda de aeropuertos", e);
			throw new LogicException(e.getMessage(), e);
		}catch(Exception e){
			logger.error("Ocurrio un error al realizar la busqueda de aeropuertos", e);
			throw new LogicException(e.getMessage(), e);
		}
		return list;	
	}

	/**
	 * Retorna un aeropuerto dado su id
	 * @return
	 */
	public Airport getElement(String id) throws LogicException{
		Airport airport = null;

		try{
			airport = airportDao.findById(Integer.parseInt(id));
			
		}catch(PersistenceException e){
			logger.error("Ocurrio un error al buscar el aeropuerto= "+id, e);
			throw new LogicException(e.getMessage(), e);
		}catch(Exception e){
			logger.error("Ocurrio un error al buscar el aeropuerto= "+id, e);
			throw new LogicException(e.getMessage(), e);
		}
		return airport;	
	}
	/**
	 * Gestiona la agregaci�n de un nuevo aeropuerto al sistema.
	 * @param r
	 */
	public String add(Airport a) {
		try{
			if (!airportDao.existAirport(a)) {
				
				System.out.println("ESTE es el Airport a ingresar: " + a.toString());
				
				airportDao.add(a);
				logger.info("Se ha insertado el aeropuerto con el nombre "+ a.getName());
				result = MessageConstants.AIRPORT_INSERT_SUCCESS;
				
			}else{
				result = MessageConstants.AIRPORT_EXIST;
			}
				
		}catch(PersistenceException e){
			logger.error("Ocurrio un error intentar ingresar un aeropuerto", e);
			result = MessageConstants.AIRPORT_INSERT_ERROR;
		}catch(Exception e){
			logger.error("Ocurrio un error intentar ingresar un aeropuerto", e);
			result = MessageConstants.AIRPORT_INSERT_ERROR;
		}
		
		return result;
	}
	/**
	 * Gestiona la modificaci�n de un aeropuerto existente en el sistema.
	 * @param r
	 */
	public String update(Airport a) {
		
		try{

			if (!airportDao.existAirport(a)) {
				a.setOperation(Constants.UPDATED_ROW);
				airportDao.update(a);
				result = MessageConstants.AIRPORT_UPDAT_SUCCESS;
				
				logger.info("Se ha actualizado el aeropuerto "+a.getCode());
			}else{
				result = MessageConstants.AIRPORT_EXIST;
			}
			
		}catch(PersistenceException e){
			logger.error("Ocurrio un error intentar actualizar el aeropuerto= "+a.getCode(), e);
			result = MessageConstants.AIRPORT_UPDATE_ERROR;
		}catch(Exception e){
			logger.error("Ocurrio un error intentar actualizar un aeropuerto= "+a.getCode(), e);
			result = MessageConstants.AIRPORT_UPDATE_ERROR;
		}
		return result;
	}
	/**
	 * Gestiona la eliminacion de un aeropuerto en el sistema.
	 * @param r
	 */
	public String delete(String id) {
		
		try{

			airportDao.remove(Integer.parseInt(id));
			result = MessageConstants.AIRPORT_DELETE_SUCCESS;
			
			logger.info("Se ha eliminado el aeropuerto "+id);
			
		}catch(PersistenceException e){
			logger.error("Ocurrio un error intentar eliminar el aeropuerto= "+id, e);
			result = MessageConstants.AIRPORT_DELETE_ERROR;
		}catch(Exception e){
			logger.error("Ocurrio un error intentar eliminar un aeropuerto= "+id, e);
			result = MessageConstants.AIRPORT_DELETE_ERROR;
		}
		return result;
	}
	
	public Hashtable<String, Object> loadLists() throws LogicException{return null;}
	public Hashtable<String, Object> loadSearchList() throws LogicException{return null;}
	
	public AirportDAO getAirportDao() {
		return airportDao;
	}

	public void setAirportDao(AirportDAO airportDao) {
		this.airportDao = airportDao;
	}

	@Override
	public FuelCard validatefuelCardCode(String fuelCardId)
			throws LogicException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hashtable<String, Object> loadLists(String fuelCardId)
			throws LogicException {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Object getCustomElementById(String fuelCardCode,
			String cardCodeClient, String id) throws LogicException {
		// TODO Auto-generated method stub
		return null;
	}
	
}