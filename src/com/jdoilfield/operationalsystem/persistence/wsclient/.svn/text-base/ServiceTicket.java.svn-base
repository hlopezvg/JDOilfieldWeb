package com.jdoilfield.operationalsystem.persistence.wsclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jdoilfield.operationalsystem.business.TicketManager;
import com.jdoilfield.ws.ticketservice.TicketServiceInterface;
import com.jdoilfield.ws.ticketservice.domain.MobileTicket;
import com.jdoilfield.ws.ticketservice.dto.TicketServiceRequest;
import com.jdoilfield.ws.ticketservice.dto.TicketServiceResponse;

public class ServiceTicket {
	private TicketServiceInterface ticketServiceClient;
	private TicketServiceResponse result;
	protected final Logger logger = LoggerFactory.getLogger(TicketManager.class);
	
	public String addTicket(MobileTicket ticket) throws Throwable{
	
		try{
			TicketServiceRequest trSrRequest = new TicketServiceRequest();
			trSrRequest.setTicket(ticket);
			
			//Colocamos esto temporalmente aqui, hay que validar bien esta ubicacion
			trSrRequest.setDeviceId("VIAWEB");
			//Colocamos el user que este logueado
			//trSrRequest.setId(12);
			trSrRequest.setId(ticket.getUserId().intValue());
			
			
			result = this.ticketServiceClient.processTicket(trSrRequest);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return result.getErrorCode();
	}
	

	public void setTicketServiceClient(TicketServiceInterface ticketServiceClient) {
		this.ticketServiceClient = ticketServiceClient;
	}
		
}
