package com.jdoilfield.operationalsystem.business;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jdoilfield.operationalsystem.domain.ResultList;
import com.jdoilfield.operationalsystem.domain.Search;
import com.jdoilfield.operationalsystem.domain.local.Lov;
import com.jdoilfield.operationalsystem.domain.local.Payment;
import com.jdoilfield.operationalsystem.domain.local.User;
import com.jdoilfield.operationalsystem.domain.remote.Account;
import com.jdoilfield.operationalsystem.domain.remote.BusinessPartner;
import com.jdoilfield.operationalsystem.domain.remote.Currency;
import com.jdoilfield.operationalsystem.domain.remote.Document;
import com.jdoilfield.operationalsystem.persistence.api.AccountDAO;
import com.jdoilfield.operationalsystem.persistence.api.BankDAO;
import com.jdoilfield.operationalsystem.persistence.api.BusinessPartnerDAO;
import com.jdoilfield.operationalsystem.persistence.api.CurrencyDAO;
import com.jdoilfield.operationalsystem.persistence.api.DocumentDAO;
import com.jdoilfield.operationalsystem.persistence.api.LovDAO;
import com.jdoilfield.operationalsystem.persistence.api.PaymentDAO;
import com.jdoilfield.operationalsystem.persistence.api.RemotePaymentDAO;
import com.jdoilfield.operationalsystem.persistence.wsclient.ServicePayment;
import com.jdoilfield.operationalsystem.util.Constants;
import com.jdoilfield.operationalsystem.util.MessageConstants;
import com.jdoilfield.operationalsystem.util.SpringMailSender;
import com.pranical.commons.exceptions.LogicException;
import com.pranical.commons.exceptions.PersistenceException;

/**
 * Realiza las operaciones de negocio relacionadas con la Consulta y
 * notificacion de Pagos, e invoca a los metodos de persistencia para realizar
 * dichas operaciones.
 * 
 * @author Mary
 */
public class PaymentManager {
	private PaymentDAO paymentDao;
	private RemotePaymentDAO remotePaymentDao;
	private LovDAO lovDao;
	private DocumentDAO documentDao;
	private BusinessPartnerDAO businessPartnerDao;
	private CurrencyDAO currencyDao;
	private BankDAO bankDao;
	private AccountDAO accountDao;
	private SpringMailSender mailSender;
	private ServicePayment servicePayment;
	private String result;
	protected final Logger logger = LoggerFactory.getLogger(PaymentManager.class);

	/**
	 * Gestiona la agregaci�n de una nueva notificacion de pago al sistema.
	 * 
	 * @param p Pago
	 */
	public String add(Payment payment, BusinessPartner bp, User user) {

		boolean success = false;
		try {
			logger.info("metodo agregar pago");
			StringTokenizer s = new StringTokenizer(payment.getAccount(), "/");
			payment.setBank(s.nextToken());
			payment.setAccount(s.nextToken());
			payment.setCardcode(bp.getCardcode());
			payment.setCardname(bp.getCardname());
			logger.info("bp.getCardcode()" + bp.getCardcode());
			logger.info("bp.getCardname()" + bp.getCardname());
			paymentDao.add(payment);
			logger.info("despues de ingregar pago en postgres");
			success = true;
		} catch (PersistenceException e) {
			logger.error(
					"Ocurrio un error al intentar ingresar el pago en La BD de Postgres. "
							+ " Cliente: " + bp.getCardcode()
							+ " realizado el dia: " + payment.getPaymentDate()
							+ " por la cantidad de: " + payment.getAmount(), e);
			result = MessageConstants.PAYMENT_REGISTRY_ERROR;

		} catch (Throwable e) {
			logger.error(
					"Ocurrio un error al intentar ingresar el pago en La BD de Postgres. "
							+ " Cliente: " + bp.getCardcode()
							+ " realizado el dia: " + payment.getPaymentDate()
							+ " por la cantidad de: " + payment.getAmount(), e);
			result = MessageConstants.PAYMENT_REGISTRY_ERROR;
		}

		if (success) {

			try {
				// invocar el servicio
				// PaymentServiceClient client = new PaymentServiceClient();

				// client.setEndPoint("http://localhost:8080/axis2/services/PaymentServiceManager");

				// client.processPayment(payment);
				logger.info("antes de invocar el WS");
				servicePayment.addPayment(payment);
				logger.info("despues de invocar el WS");
				if (user.getSupervisorUser().getEmail() != null) {
					try {

						Map<String, Object> pro = new HashMap<String, Object>();
						pro.put("payment", payment);
						logger.info("antes de envio de email, correo del supervisor: "
								+ user.getSupervisorUser().getEmail());
						mailSender.sendMimeMessage(new String[] { user
								.getSupervisorUser().getEmail() },
								" Payment Notification",
								Constants.NEW_PAYMENT_TEMPLATE, pro);
						logger.info("El email de notificacion del pago ha sido enviado correctamente al supervisor del usuario: "
								+ user.getLogin()
								+ " con correo: "
								+ user.getEmail());

						if (user.getEmail() != null) {
							try {

								pro = new HashMap<String, Object>();
								pro.put("payment", payment);
								pro.put("user", user);
								// //////Agregar la lista/////////////
								String to[] = addListMail(
										new String[] { user.getEmail() },
										"notificacion.pagos@jdoilfield.com");

								mailSender.sendMimeMessage(to, null,
										"Payment Notification",
										Constants.NEW_PAYMENT_CLIENT_TEMPLATE,
										pro);

								// ////////Fin Anadiendo la lista///////////////

								logger.info("El email "
										+ user.getEmail()
										+ " de notificacion del pago ha sido enviado correctamente al usuario: "
										+ user.getLogin());

							} catch (Throwable e) {
								logger.error(
										"No se logro enviar el correo de notificacion de pago al usuario "
												+ user.getLogin()
												+ ". Para el pago:"
												+ " Cliente: "
												+ bp.getCardcode()
												+ " realizado el dia: "
												+ payment.getPaymentDate()
												+ " por la cantidad de: "
												+ payment.getAmount(), e);
							}
						}
					} catch (Throwable e) {
						logger.error(
								"No se logro enviar el correo de notificacion de pago al contacto J&D del usuario "
										+ user.getLogin()
										+ ". Para el pago:"
										+ " Cliente: "
										+ bp.getCardcode()
										+ " realizado el dia: "
										+ payment.getPaymentDate()
										+ " por la cantidad de: "
										+ payment.getAmount(), e);
					}
				}

				result = MessageConstants.PAYMENT_REGISTRY_SUCCESS;

			} catch (Throwable e) {
				logger.error(
						"Ocurrio un error al intentar ingresar el pago en La BD de SQLServer. "
								+ " Para el Cliente: " + bp.getCardcode()
								+ " realizado el dia: "
								+ payment.getPaymentDate()
								+ " por la cantidad de: " + payment.getAmount(),
						e);
				result = MessageConstants.PAYMENT_REGISTRY_ERROR;

				try {
					paymentDao.remove(payment);
				} catch (Throwable ee) {
				}
			}
		}

		return result;
	}

	/**
	 * 
	 */
	private String[] addListMail(String array[], String correo) {
		String lista[] = new String[array.length + 1];
		logger.info((new StringBuilder("tamano de la lista:")).append(
				lista.length).toString());
		logger.info("///////-----------------////////////////");
		logger.info((new StringBuilder("tamano del array:")).append(
				array.length).toString());
		System.arraycopy(array, 0, lista, 0, lista.length - 1);
		lista[lista.length - 1] = correo;
		return lista;
	}

	/**
	 * Retorna una nueva instancia de Document
	 */
	public Payment getNewInstance() throws LogicException {

		return new Payment();
	}

	/**
	 * Retorna una lista de notificaciones de pago, dependiendo de los
	 * parametros busqueda
	 * 
	 * @param s
	 *            Objeto que encapsula los parametros de b�squeda
	 * @param page
	 *            Indice que indica desde donde se realizara la busqueda
	 * @return
	 * @throws LogicException
	 */
	public ResultList getResultList(Search s, int page) throws LogicException {

		ResultList list = null;

		try {

			list = paymentDao.find(s, ((page - 1) * s.getNumRows()));

			if (s.getCodeClient() != null && !s.getCodeClient().equals("0")) {

				BusinessPartner bp = (BusinessPartner) businessPartnerDao
						.findById(s.getCodeClient());
				list.setBusinessPartner(bp);
			}

		} catch (PersistenceException e) {
			logger.error(
					"Ocurrio un error al realizar la busqueda de los pagos ", e);
			throw new LogicException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(
					"Ocurrio un error al realizar la busqueda de los pagos ", e);
			throw new LogicException(e.getMessage(), e);

		}
		return list;
	}

	/**
	 * Retorna una coleccion con las listas requeridas para llenar los combos en
	 * la vista de busqueda de pagos
	 * 
	 * @return
	 */
	public Hashtable<String, Object> loadSearchList() throws LogicException {

		Hashtable<String, Object> data = new Hashtable<String, Object>();

		try {
			/*
			 * Se invoca al metodo de persistencia que realizan la busqueda de
			 * los clientes a ser mostrado en el combo del formulario de
			 * busqueda
			 */
			List<BusinessPartner> clients = businessPartnerDao
					.findByType(Constants.CUSTOMER);
			data.put("clients", clients);

		} catch (PersistenceException e) {
			logger.error(
					"Ocurrio un error obtener las listas de los combos de busqueda de los Pagos",
					e);
			throw new LogicException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(
					"Ocurrio un error obtener las listas de los combos de busqueda de los Pagos",
					e);
			throw new LogicException(e.getMessage(), e);

		}
		return data;
	}

	/**
	 * Retorna una coleccion con las listas requeridas para llenar los combos en
	 * la vista de registro de notificacion de pagos
	 * 
	 * @return
	 */
	public Hashtable<String, Object> loadLists(String client)
			throws LogicException {
		Hashtable<String, Object> data = new Hashtable<String, Object>();

		List<Document> documents = null;

		try {
			if (client != null) {
				documents = documentDao.findInvoices(client);
				data.put("documents", documents);
			}

			List<Lov> paymentsTypes = lovDao
					.getValues(Constants.LOV_PAYMENT_TYPE);
			List<Currency> currencies = currencyDao.findAll();
			List<Account> accounts = accountDao.findAll();

			data.put("paymentsTypes", paymentsTypes);
			data.put("accounts", accounts);
			data.put("currencies", currencies);

		} catch (PersistenceException e) {
			logger.error(
					"Ocurrio un error obtener las listas de los combos de Registro de Pagos",
					e);
			throw new LogicException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(
					"Ocurrio un error obtener las listas de los combos de Registro de Pagos",
					e);
			throw new LogicException(e.getMessage(), e);

		}
		return data;
	}

	public PaymentDAO getPaymentDao() {
		return paymentDao;
	}

	public void setPaymentDao(PaymentDAO paymentDao) {
		this.paymentDao = paymentDao;
	}

	public RemotePaymentDAO getRemotePaymentDao() {
		return remotePaymentDao;
	}

	public void setRemotePaymentDao(RemotePaymentDAO remotePaymentDao) {
		this.remotePaymentDao = remotePaymentDao;
	}

	public LovDAO getLovDao() {
		return lovDao;
	}

	public void setLovDao(LovDAO lovDao) {
		this.lovDao = lovDao;
	}

	public DocumentDAO getDocumentDao() {
		return documentDao;
	}

	public void setDocumentDao(DocumentDAO documentDao) {
		this.documentDao = documentDao;
	}

	public BusinessPartnerDAO getBusinessPartnerDao() {
		return businessPartnerDao;
	}

	public void setBusinessPartnerDao(BusinessPartnerDAO businessPartnerDao) {
		this.businessPartnerDao = businessPartnerDao;
	}

	public CurrencyDAO getCurrencyDao() {
		return currencyDao;
	}

	public void setCurrencyDao(CurrencyDAO currencyDao) {
		this.currencyDao = currencyDao;
	}

	public BankDAO getBankDao() {
		return bankDao;
	}

	public void setBankDao(BankDAO bankDao) {
		this.bankDao = bankDao;
	}

	public AccountDAO getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDAO accountDao) {
		this.accountDao = accountDao;
	}

	public SpringMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(SpringMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public ServicePayment getServicePayment() {
		return servicePayment;
	}

	public void setServicePayment(ServicePayment servicePayment) {
		this.servicePayment = servicePayment;
	}

}