package com.jdoilfield.operationalsystem.util;

public interface MessageConstants {

	String GENERAL_ERROR = "errors";
	String LOAD_ERROR    = "errors.load";
	String SEARCH_ERROR  = "errors.search";
	String AUTH_ERROR    = "errors.auth";
	String AUTH_LOGIN_PASS_INVALID  = "errors.auth.invalid";
	//Key
	String USER_INSERT_SUCCESS = "success.insert.user";
	String USER_INSERT_ERROR   = "errors.insert.user";
	String USER_UPDATE_SUCCESS = "success.update.user";
	String USER_UPDATE_ERROR   = "errors.update.user";
	String USER_DELETE_SUCCESS = "success.delete.user";
	String USER_DELETE_ERROR   = "errors.delete.user";
	
	String ROLE_INSERT_SUCCESS = "success.insert.role";
	String ROLE_INSERT_ERROR   = "errors.insert.role";
	String ROLE_UPDATE_SUCCESS = "success.update.role";
	String ROLE_UPDATE_ERROR   = "errors.update.role";
	String ROLE_DELETE_SUCCESS = "success.delete.role";
	String ROLE_DELETE_ERROR   = "errors.delete.role";
	
	String AIRPORT_INSERT_SUCCESS = "success.insert.airport";
	String AIRPORT_INSERT_ERROR   = "errors.insert.airport";
	String AIRPORT_UPDAT_SUCCESS  = "success.update.airport";
	String AIRPORT_UPDATE_ERROR   = "errors.update.airport";
	String AIRPORT_DELETE_SUCCESS = "success.delete.airport";
	String AIRPORT_DELETE_ERROR   = "errors.delete.airport";
	
	String AIRPORT_EXIST = "error.airport.code.exist";
	String USER_EXIST    = "error.user.login.exist";
	
	String TICKET_UPDATE_SUCCESS  = "success.update.ticket";
	String TICKET_UPDATE_ERROR    = "errors.update.ticket";
	String TICKET_CANCEL_SUCCESS  = "success.cancel.ticket";
	String TICKET_CANCEL_ERROR    = "errors.cancel.ticket";
	String TICKET_ADD_SUCCESS     = "success.insert.ticket";
	String TICKET_ADD_ERROR_LOCAL = "errors.insert.ticket.local";
	String TICKET_ADD_ERROR_REMOTE = "errors.insert.ticket.remote";
	String TICKET_ALREADY_EXIST    = "already.exist.ticket";
	String TICKET_CHECKED_SUCCESS  = "success.checked.ticket";
	String TICKET_CHECKED_ERROR    = "errors.checked.ticket";
	String TICKET_NONE_ACTION      = "none.action.ticket";
	
	String PAYMENT_REGISTRY_SUCCESS = "success.insert.payment";
	String PAYMENT_REGISTRY_ERROR   = "errors.insert.payment";
	
	String PASSWORD_CHANGE_SUCCESS    = "success.update.password";
	String PASSWORD_CHANGE_ERROR      = "errors.update.password";
	String PASSWORDS_NOT_EQUAL        = "errors.notequal.password";
	String CURRENT_PASSWORD_NOT_MATCH = "errors.notmatch.password";
	
	String FUEL_REQUEST_INSERT_SUCCESS = "success.insert.fuelrequest";
	String FUEL_REQUEST_INSERT_ERROR   = "errors.insert.fuelrequest";
	String FUEL_REQUEST_UPDATE_SUCCESS  = "success.update.fuelrequest";
	String FUEL_SEND_MAIL_SUCCESS  =     "success.send.fuelrequest";
	String FUEL_REQUEST_UPDATE_ERROR   = "errors.update.fuelrequest";
	String FUEL_REQUEST_DELETE_SUCCESS = "success.delete.fuelrequest";
	String FUEL_REQUEST_DELETE_ERROR   = "errors.delete.fuelrequest";
	
	String FUEL_CARD_INSERT_SUCCESS = "success.insert.fuelcard";
	String FUEL_CARD_INSERT_ERROR   = "errors.insert.fuelcard";
	String FUEL_CARD_UPDATE_SUCCESS  = "success.update.fuelcard";
	String FUEL_CARD_UPDATE_ERROR   = "errors.update.fuelcard";
	String FUEL_CARD_DELETE_SUCCESS = "success.delete.fuelcard";
	String FUEL_CARD_DELETE_ERROR   = "errors.delete.fuelcard";
	
	
	String REQUIRED_FIELD   = "errors.required";
	
	String CODE_EXIST       = "errors.exist.code";
	String MAX_LENGHT_ERROR = "errors.maxlength";
	String MIN_LENGHT_ERROR = "errors.minlength";
	String INVALID_EMAIL    = "errors.email";
	String INVALID_DATE     = "errors.date";
	String INVALID_RANGE    = "errors.range";
	String INVALID_QUANTITY_LTS    = "error.ticket.quantitylts";
	
	//REPORTS MESSAGE
	String TITLE_REPORT_IMAGE="TITLE.REPORT.IMAGE";
	String HEADER_REPORT_IMAGE="HEADER.REPORT.IMAGE";
}
