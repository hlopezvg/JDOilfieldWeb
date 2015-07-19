package com.jdoilfield.operationalsystem.business;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.apache.log4j.Logger;

import com.jdoilfield.operationalsystem.domain.ResultList;
import com.jdoilfield.operationalsystem.domain.Search;
import com.jdoilfield.operationalsystem.domain.local.Role;
import com.jdoilfield.operationalsystem.domain.local.User;
import com.jdoilfield.operationalsystem.domain.remote.BusinessPartner;
import com.jdoilfield.operationalsystem.domain.remote.FuelCard;
import com.jdoilfield.operationalsystem.persistence.api.BusinessPartnerDAO;
import com.jdoilfield.operationalsystem.persistence.api.RoleDAO;
import com.jdoilfield.operationalsystem.persistence.api.UserDAO;
import com.jdoilfield.operationalsystem.util.Constants;
import com.jdoilfield.operationalsystem.util.MessageConstants;
import com.jdoilfield.operationalsystem.util.SpringMailSender;
import com.jdoilfield.operationalsystem.util.Utilities;
import com.pranical.commons.exceptions.LogicException;
import com.pranical.commons.exceptions.PersistenceException;

/**
 * Realiza las  operaciones de negocio relacionadas con la Administracion de Usuarios, 
 * e invoca a los metodos de persistencia para realizar dichas operaciones.
 * 
 */
public class UserManager implements ManagerInterface<User> {

	private UserDAO userDao;
	private RoleDAO roleDao;
	private BusinessPartnerDAO businessPartnerDao;
	private SpringMailSender mailSender;
	private static Logger logger = Logger.getLogger(UserManager.class);
	private String result;
	
	/**
	 * Gestiona la incorporación de un nuevo usuario al sistema.
	 * @param u Usuario a agregar
	 */
	public String add(User u) {  
		boolean noSupervisor=false;
		try{
			if (!userDao.existUser(u)) {
				
				Role r = new Role();
				r.setId(u.getRoleId());
				u.setRole(r);
				u.setPassword(Utilities.MD5(u.getPassword()));
				
				if(u.getClientCode().length()==0 ){
					u.setClientCode(null);
				}
				if(u.getIdSupervisor()!=null && u.getIdSupervisor()==0 ){
					u.setIdSupervisor(null);
					noSupervisor=true;
				}
				userDao.add(u);
				if(noSupervisor){
					u.setIdSupervisor(u.getId());
					userDao.update(u);
				}
				result =  MessageConstants.USER_INSERT_SUCCESS;
				
				logger.info("Se ha insertado el usuario: "+u.getLogin());
				
			}else{
				result = MessageConstants.USER_EXIST;
			}
			
		}catch(PersistenceException e){
			logger.error("Ocurrio un error al intentar ingresar el usuario: "+u.getLogin()+"a la BD", e);
			result = MessageConstants.USER_INSERT_ERROR;

		}catch(Exception e){
			logger.error("Ocurrio un error al intentar ingresar el usuario: "+u.getLogin()+"a la BD", e);
			result = MessageConstants.USER_INSERT_ERROR;
		}
		
		
		return result;
	}
	
	/**
	 * Gestiona la modificación de un usuario existente en el sistema.
	 * @param u Usuario a actualizar
	 */
	public String update(User u) {
		
		try{
			
			if (!userDao.existUser(u)) {
					
				if(u.getClientCode().length()==0 ){
					u.setClientCode(null);
				}
				
				if(u.getIdSupervisor()!=null && u.getIdSupervisor()==0 ){
					u.setIdSupervisor(u.getId());
				}
				User userBd = userDao.findById(u.getId());

				if(u.getPassword()==null || u.getPassword().trim().length()==0){
					u.setPassword(userBd.getPassword());
				}else{
					u.setPassword(Utilities.MD5(u.getPassword()));
				}

				u.setOperation(Constants.UPDATED_ROW);
				
				userDao.update(u);
				result = MessageConstants.USER_UPDATE_SUCCESS;
				
				logger.info("Se ha modificado el usuario: "+u.getLogin());
				
			}else{
				result = MessageConstants.USER_EXIST;
			}
			
		}catch(PersistenceException e){
			logger.error("Ocurrio un error al intentar actualizar el usuario: "+u.getLogin()+"a la BD", e);
			result = MessageConstants.USER_UPDATE_ERROR;
		}catch(Exception e){
			logger.error("Ocurrio un error al intentar actualizar el usuario: "+u.getLogin()+"a la BD", e);
			result = MessageConstants.USER_UPDATE_ERROR;
		}
		
		return result;
	}
	/**
	 * Gestiona la eliminacion de un usuario en el sistema.
	 * @param login Usuario a eliminar
	 */
	public String delete(String id) {
		
		try{
				
			userDao.remove(Integer.parseInt(id));
			
			result = MessageConstants.USER_DELETE_SUCCESS;
			
		}catch(PersistenceException e){
			logger.error("Ocurrio un error al intentar eliminar el usuario: "+id, e);
			result = MessageConstants.USER_DELETE_ERROR;
		}catch(Exception e){
			logger.error("Ocurrio un error al intentar eliminar el usuario: "+id, e);
			result = MessageConstants.USER_DELETE_ERROR;
		}
		return result;

	}
	/**
	 * Retorna un usuario dado su id
	 * @param login Id del usuario a buscar
	 * @return
	 */
	public User getElement(String id) throws LogicException{
		
		User user = null;
		
		try{
			user = userDao.findById(Integer.parseInt(id));
		
		}catch(PersistenceException e){
			logger.error("Ocurrio un error al intentar consultar el usuario: "+id, e);
			throw new LogicException(e.getMessage(), e);
		}catch(Exception e){
			logger.error("Ocurrio un error al intentar consultar el usuario: "+id, e);
			throw new LogicException(e.getMessage(), e);
		}
		return user;	
	}
	
	/**
	 * Retorna una lista con los usuarios del sistema, para paginación. 
	 * @param s Objeto que encapsula los parametros de búsqueda
	 * @param page Indice que indica desde donde se realizara la busqueda
	 * @return ResultList Objeto que encapsula la lista resultado, 
	 * e informacion relacionada con la consulta
	 * @throws LogicException
	 */
	public ResultList getResultList(Search s, int page) throws LogicException {
		
		ResultList userList = null;

		try{

			userList = userDao.find(s, ((page-1)*s.getNumRows()));
		
		}catch(PersistenceException e){
			logger.error("Ocurrio un error al intentar realizar la busqueda de los usuarios", e);
			throw new LogicException(e.getMessage(), e);
		}catch(Exception e){
			logger.error("Ocurrio un error al intentar realizar la busqueda de los usuarios", e);
			throw new LogicException(e.getMessage(), e);
		}
		return userList;	
	}
	
	/**
	 * Retorna una lista con los usuarios del sistema. 
	 * @return
	 */
	public List<User> getList() throws LogicException {
		
		List<User> list = null;
		
		try{
			
			list = userDao.findAll();
			
		}catch(PersistenceException e){
			logger.error("Ocurrio un error al intentar obtener la lista de usuarios", e);
			throw new LogicException(e.getMessage(), e);
		}
		return list;	
	}	
	/**
	 * Retorna una coleccion con las listas requeridas para llenar los combos
	 * en la vista de Agregar y Modificar usuario
	 * @return
	 */
	public Hashtable<String, Object> loadLists() throws LogicException {
		
		Hashtable<String, Object> data = new Hashtable<String, Object>();
		
		try{
	    	/* Se invocan a los metodos de persistencia que realizan la busqueda de  
    		 * los roles a ser mostrados en el combo de roles,
    		 * los usuarios a ser mostrados en el combo de supervisores,
    		 * y los clientes a ser mostrados en el combo de clientes */
	    	List<Role> roles = roleDao.findAll();
	    	
	    	List<BusinessPartner> partners = businessPartnerDao.findByType(Constants.CUSTOMER);
	    	
	    	List<User> supervisors = userDao.findByRole(Constants.OPERATION_SHIEF);
	    
			data.put("roles", roles);
			data.put("partners", partners);
			data.put("supervisors", supervisors);

		}catch(PersistenceException e){
			logger.error("Ocurrio un error al intentar obtener las listas de los combos de la vista ingresar o modificar Usuario ", e);
			throw new LogicException(e.getMessage(), e);
		}
		return data;	
	}
	
	/**
	 * Retorna una coleccion con las listas requeridas para llenar los combos
	 * en la vista de busqueda de usuarios
	 * @return
	 */
	public Hashtable<String, Object> loadSearchList() throws LogicException {
		
		Hashtable<String, Object> data = new Hashtable<String, Object>();
		
		List<Role> roles = null;
		
		try{
			/* Se invoca al metodo de persistencia que realizan la busqueda de  
    		 * los roles a ser mostrados en el combo de roles */
			roles = roleDao.findAll();
			data.put("roles", roles);

		}catch(PersistenceException e){
			logger.error("Ocurrio un error al intentar obtener las listas de los combos de busqueda de Usuarios", e);
			throw new LogicException(e.getMessage(), e);
		}
		return data;	
	}
	/**
	 * Retorna un usuario dado su id
	 * @param login Id del usuario a buscar
	 * @return
	 */
	public String changePassword(User u,  String password, String newpassword) {
		try{

			if(u.getPassword().equals(Utilities.MD5(password))){
				 userDao.changePassword(u.getId(), Utilities.MD5(newpassword));
				 result = MessageConstants.PASSWORD_CHANGE_SUCCESS;
			}else{
				 result = MessageConstants.CURRENT_PASSWORD_NOT_MATCH;
			}
		
		}catch(PersistenceException e){
			logger.error("Ocurrio un error al intentar cambiar el password del usuario: "+u.getId(), e);
			result = MessageConstants.PASSWORD_CHANGE_ERROR;
		}catch(Exception e){
			logger.error("Ocurrio un error al intentar cambiar el password del usuario: "+u.getId(), e);
			result = MessageConstants.PASSWORD_CHANGE_ERROR;
		}
		return result;
	}
	
	public User findByUserName(String username)throws LogicException {
		
		User u =null;
		
		try {
			u = userDao.findByUserName(username);
			
		} catch (PersistenceException e) {
			logger.error("Ocurrio un error al intentar obtener la informacion de usuario del login: "+username, e);
		}
		
		return u;
	}
	
	/**
	 * See if the user exists bases on his password.
	 * @param email
	 * @return message
	 */
	public String recoverPassword(String email){
		logger.info("LETS SEND A NEW ONE IF FORGOTTEN");
		User user = null;
		String result_ = null;
		String newPassword = null;
		try {
			user = userDao.findByEmailAddress(email);
			if (user != null){
				logger.info("The user name is: " + user.getUserName() + "  LOGIN: " + user.getLogin());
				newPassword = Utilities.generateAutomaticPasswordOrFuelCard(false);
				userDao.changePassword(user.getId(), Utilities.MD5(newPassword));
				user.setPassword(newPassword);
				sendNewPassword(user);
				logger.info("EL NUEVO PASSWORD ES: " + newPassword);
				result_ = "USER_FOUND_PROCEED_TO_RESET_AND_SEND_EMAIL";
			}
		} catch (NoResultException ex) {
			result_ = "NO_USER_FOUND_WITH_THIS_EMAIL";
		} catch (NonUniqueResultException ex) {
			result_ = "CONTACT_THE_ADMIN";
		} catch (Exception ex) {
			logger.error("AN ERROR OCURRED WHILE FINDING USER BY EMAIL" , ex);
		}
		return result_;
	}
	
	/**
	 * Send new password via email.
	 * @param user
	 */   
	
	private void sendNewPassword (User user) {
		try {
			Map props = new HashMap();
			props.put("user", user);
			logger.info("Sending mail recovery to: " + user.getEmail()	);

			String[] correosTO = { user.getEmail() };
			String[] correosCC = { "soporte@jdoilfield.com" };
			mailSender.sendMimeMessage(correosTO, correosCC, " Password Recovery Notification:",	"passwordRecoveryNotification", props);

		} catch (Exception ex) {
			logger.error("Error sending forgot password", ex);
		}
	}
	
	/**
	 * Retorna una nueva instancia de Usuario
	 */
	public User getNewInstance() throws LogicException{
		return new User();
	}
	
	public UserDAO getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	public RoleDAO getRoleDao() {
		return roleDao;
	}
	public void setRoleDao(RoleDAO roleDao) {
		this.roleDao = roleDao;
	}
	public BusinessPartnerDAO getBusinessPartnerDao() {
		return businessPartnerDao;
	}
	public void setBusinessPartnerDao(BusinessPartnerDAO businessPartnerDao) {
		this.businessPartnerDao = businessPartnerDao;
	}
	public SpringMailSender getMailSender() {
		return mailSender;
	}
	public void setMailSender(SpringMailSender mailSender) {
		this.mailSender = mailSender;
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