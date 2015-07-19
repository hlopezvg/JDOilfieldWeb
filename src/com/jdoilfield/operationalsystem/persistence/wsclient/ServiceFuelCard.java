package com.jdoilfield.operationalsystem.persistence.wsclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jdoilfield.ws.fuelcardservice.FuelCardServiceInterface;
import com.jdoilfield.ws.fuelcardservice.domain.FuelCardMobile;
import com.jdoilfield.ws.fuelcardservice.dto.FuelCardServiceRequest;
import com.jdoilfield.ws.fuelcardservice.dto.FuelCardServiceResponse;

public class ServiceFuelCard {

	private FuelCardServiceInterface fuelCardServiceClient;
	private FuelCardServiceResponse result;
	protected final Logger logger = LoggerFactory.getLogger(ServiceFuelCard.class);
	
	public String addFuelCard(FuelCardMobile fuelCard) throws Throwable{
		try{
			FuelCardServiceRequest fuelCardServiceRequest = new FuelCardServiceRequest();
			fuelCardServiceRequest.setFuelCardMobile(fuelCard);
		
			result = this.fuelCardServiceClient.processFuelCard(fuelCardServiceRequest);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return result.getErrorCode();
	}
	
	/*
	 * Update
	 */
	public String updateFuelCard(FuelCardMobile fuelCard) throws Throwable{
		try{
			FuelCardServiceRequest fuelCardServiceRequest = new FuelCardServiceRequest();
			fuelCardServiceRequest.setFuelCardMobile(fuelCard);
		
			result = this.fuelCardServiceClient.updateFuelCard(fuelCardServiceRequest);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return result.getErrorCode();
	}
	
	/*
	 * Remove/Delete
	 */

	public String deleteFuelCard(FuelCardMobile fuelCard) throws Throwable{
		try{
			FuelCardServiceRequest fuelCardServiceRequest = new FuelCardServiceRequest();
			fuelCardServiceRequest.setFuelCardMobile(fuelCard);
		
			result = this.fuelCardServiceClient.deleteFuelCard(fuelCardServiceRequest);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return result.getErrorCode();
	}
	
		
	public void setFuelCardServiceClient(FuelCardServiceInterface fuelCardServiceClient) {
		this.fuelCardServiceClient = fuelCardServiceClient;
	}
	
}