package com.jdoilfield.operationalsystem.business;

import java.util.Hashtable;
import java.util.List;

import com.jdoilfield.operationalsystem.domain.ResultList;
import com.jdoilfield.operationalsystem.domain.Search;
import com.jdoilfield.operationalsystem.domain.remote.FuelCard;
import com.pranical.commons.exceptions.LogicException;

/**
 * Interface que define las operaciones basicas de los objetos de negocio
 * 
 */
public interface ManagerInterface<E> {

	/**
	 * Retorna una coleccion con las listas requeridas para llenar los combos
	 * en las vistas de agregacion y modificacion
	 * @return
	 */
	public Hashtable<String, Object> loadLists() throws LogicException;
	/**
	 * Retorna una coleccion con las listas requeridas para llenar los combos
	 * en las vistas de Busqueda
	 * @return
	 */
	public Hashtable<String, Object> loadSearchList() throws LogicException;
	/**
	 * Retorna una lista con los elementos, para la paginacion. 
	 * @param s Objeto que encapsula los parametros de búsqueda
	 * @param page Indice que indica desde donde se realizara la busqueda
	 * @param client cliente logueado
	 * @return
	 * @throws LogicException
	 */
	public ResultList getResultList(Search s, int page) throws LogicException;
	/**
	 * Retorna una lista de todos los elementos. 
	 * @return
	 */
	public List<E> getList() throws LogicException;

	/**
	 * Retorna un elemento dado su id
	 * @param id 
	 * @return
	 * @throws LogicException
	 */
	public E getElement(String id) throws LogicException;
	/**
	 * Gestiona la agregación de un nuevo elemento.
	 * @param e
	 * @return Resultado de la operacion
	 */
	public String add(E e);
	/**
	 * Gestiona la modificación de un elemento existente.
	 * @param e
	 */
	public String update(E e);
	/**
	 * Gestiona la eliminacion de un elemento en el sistema.
	 * @param id
	 */
	public String delete(String id) ;
	/**
	 * Retorna una nueva instancia
	 */
	public E getNewInstance() throws LogicException;
	/**
	 * Retorna el fuel CardCode
	 */
	public FuelCard validatefuelCardCode(String fuelCardId) throws LogicException;
	/**
	 * Load the list of objects based on their Ids
	 */
	public Hashtable<String, Object> loadLists(String objectId) throws LogicException; 
	/**
	 * Retruns a general Object by a combination of Ids.
	 */
	public Object getCustomElementById(String fuelCardCode, String cardCodeClient, String id) throws LogicException;
}