package com.jdoilfield.operationalsystem.util;

/**
 * Interface con los valores constantes de la aplicacion
 * @author mary
 */
public interface Constants {

	/*Formato de fecha utilizado en la aplicacion */
	String dateFormat="yyyy-MM-dd HH:mm:ss";
	String dateFormatSQLServer="dd/MM/yyyy hh:mm:ss a";
	String FILE_DATE_FORMAT="yyyyMMdd";
	String FILE_DATE_TIME_FORMAT="yyyyMMdd_HHmmss";
	
	// ************ Operaciones ***********
	/** Valor que tiene el campo 'operation' para los registros recien insertados */
	char INSERTED_ROW='I';
	/** Valor que tiene el campo 'operation' para los registros que han sido actualizados */
	char UPDATED_ROW='U';
	/** Valor que tiene el campo 'operation' para los registros eliminados */
	char DELETED_ROW='D';

	// ************ Tipos de componentes ***********
	int COMPONENT_WEB    = 9;
	int COMPONENT_MOBILE = 10;

	// ************ Algunos Roles ***********
	int ROLE_ADMIN              = 1;
	int CLIENT_ROLE             = 2;
	int ROLE_OPERATOR           = 3;
	int CLIENT_OPE_ROLE         = 4;
	int OPERATION_SHIEF         = 5;
	int ROLE_ADMIN_OP           = 6;
	int ROLE_COBRANZA            =7;
	int ROLE_VIEW_LOCAL_CUSTOMER =8;
	
	// ************ Algunos status de boletas ***********
	int UPDATE_NOTIFICATION  = 4;
	int CANCEL_NOTIFICATION  = 5;
	int CHECKED_NOTIFICATION = 6;
	
	String TICKET_ALREADY_EXIST = "115";
	String TICKET_NOT_SAVED_TICKET_LOCAL = "112";
	String TICKET_NOT_SAVED_TICKET_REMOTE = "113";
	String TICKET_OK = "000";
	
	// ************ Grupos para lista de valores ***********
	/** Id de grupo para los estatus del ticket */
	int LOV_STATUS_TICKET = 1;
	/** Id de grupo para los estatus del ticket */
	int LOV_CURRENCY = 2;
	/** Id de grupo para los tipos de components existentes (web, movil) */
	int LOV_COMPONENT_TYPE = 3;
	/** Id de grupo para los tipos de pago */
	int LOV_PAYMENT_TYPE = 4;
	/** Id de grupo para los tipos de periodo de FuelRequest */
	int LOV_PERIOD_TYPE = 5;
	/** Id de grupo para las modificaciones en ticket para amendment */
	int LOV_STATUS_TICKET_AMENDMENT = 8;
	
	// *********** Tipos de Business Partner *************
	String CUSTOMER = "Cliente";
	String SUPLIER  = "Proveedor";

	// ******** Nombres de las platillas de correo  *************
	String NEW_PAYMENT_TEMPLATE = "newPayment";
	String NEW_PAYMENT_CLIENT_TEMPLATE = "clientNewPayment";
	String TICKET_CANCEL_TEMPLATE = "ticketCancel";
	String TICKET_MODIFY_TEMPLATE = "ticketModify";
	String FUEL_REQUEST_TEMPLATE = "fuelRequestNotification";
	
	// *********** Factor de conversion a galon *************
	double GALON_CONVERSION = 3.7854;
	double LITERS_CONVERSION = 0.2642;
	
	int INITIAL_YEAR = 2008;

	String[] months = {"January","February", "March","April", "May", "June",
						"July", "August", "September", "October", "November", "December"};

	// ************* Reports Fuel Request *********************
	String FORMAT_PDF = "pdf";
	String FORMAT_XLS = "xls";
	String FORMAT_CSV = "csv";
	String FORMAT_HTML = "html";
	String DOT=".";
	
	// ************** Providers *******************************
	String VALID_CARD_ID = "0";
	String INVALID_CARD_ID = "1";
	String HAS_NO_CARD_ID = "2";
	
}