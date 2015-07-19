package com.jdoilfield.operationalsystem.validator;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jdoilfield.operationalsystem.domain.local.Ticket;
import com.jdoilfield.operationalsystem.util.MessageConstants;
import com.jdoilfield.operationalsystem.util.Utilities;

public class TicketValidator implements Validator {
		
	private static final String TICKET_CODE = "Ticket";
	private static final String PROVIDER = "Provider";
	private static final String CLIENT = "Client";
	private static final String AIRPLANE = "Airplane";
	private static final String AIRPORT = "Airport";
	private static final String NOTES = "Notes";
	private static final String DATETIME = "Date";
	private static final String AIRPLANECODE = "Airplanes";
	
	private static final String PRODUCT = "Product";	
	private static final String QUANTITY = "Quantity Lts";
	
	private static final Integer MAX_AIRPLANE_LENGTH = 10;
	private static final Integer MAX_NOTES_LENGTH = 200;
	
	@SuppressWarnings("unchecked")
	public boolean supports(Class c) {
		return c.equals(Ticket.class);
	}
	
	public void validate(Object command, Errors errors) {
		Ticket ticket = (Ticket) command;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "ticketCode", MessageConstants.REQUIRED_FIELD, new String[]{TICKET_CODE});
		/*ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "providerCode", MessageConstants.REQUIRED_FIELD, new String[]{PROVIDER});
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "airportId", MessageConstants.REQUIRED_FIELD, new String[]{AIRPORT});*/
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "datetimeString", MessageConstants.REQUIRED_FIELD, new String[]{DATETIME});

		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "quantityLtsString", MessageConstants.REQUIRED_FIELD, new String[]{QUANTITY});
		
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "airplaneCode", MessageConstants.REQUIRED_FIELD, new String[]{AIRPLANECODE});
		
		
		//Validate that client combo has been selected
		if(ticket.getClientCode() == null){
			errors.rejectValue("clientCode", 
		 			MessageConstants.REQUIRED_FIELD, 
		 			new String[]{CLIENT},"");
		}
		if(ticket.getClientCode() != null &&  ticket.getClientCode().equals("-1")){
			errors.rejectValue("clientCode", 
		 			MessageConstants.REQUIRED_FIELD, 
		 			new String[]{CLIENT},"");
		}
		//Validate that a Provider has been selected
		if(ticket.getProviderCode().equals("-1")){
			errors.rejectValue("providerCode", 
		 			MessageConstants.REQUIRED_FIELD, 
		 			new String[]{PROVIDER},"");
		}
		
		//Validate that a Product has been selected
		if(ticket.getProductCode().equals("-1")){
			errors.rejectValue("productCode", 
		 			MessageConstants.REQUIRED_FIELD, 
		 			new String[]{PRODUCT},"");
		}
		
		//Validate that an Airport has been selected
		if(ticket.getAirport() != null && ticket.getAirport().equals("-1")){
			errors.rejectValue("airportId", 
		 			MessageConstants.REQUIRED_FIELD, 
		 			new String[]{AIRPORT},"");
		}
		
		//Validate that an Airplane has been selected
				if(ticket.getAirplaneCode().equals("-1")){
					errors.rejectValue("airplaneCode", 
				 			MessageConstants.REQUIRED_FIELD, 
				 			new String[]{AIRPLANECODE},"");
				}
		
		//Validate that a new Airplane has been selected and that the new Ariplane code has been written on the field
		/*if(ticket.getNewAirplane().equals("Y") && ticket.getAirplaneCode().equals("")){
			errors.rejectValue("newYNAirplane", 
		 			MessageConstants.REQUIRED_FIELD, 
		 			new String[]{AIRPLANE},"");
		} 	*/
		
		/*if(!ticket.getNewYNAirplane().equals("-1") && ticket.getNewAirplaneCode().equals("")) {
			errors.rejectValue("newAirplaneCode", 
		 			MessageConstants.REQUIRED_FIELD, 
		 			new String[]{AIRPLANE},"");
		}*/
		
		
		/*if(ticket.getQuantityLtsString()!=null && ticket.getQuantityLtsString().length()>0){
			StringTokenizer st = null;
			/*if(ticket.getQuantityLtsString().indexOf(',') > 0){
				 st = new StringTokenizer(ticket.getQuantityLtsString(), ",");
			}*/
			
			/*if(ticket.getQuantityLtsString().indexOf('.') > 0){
				st = new StringTokenizer(ticket.getQuantityLtsString(), ".");
			}

			
			boolean wrong = false;
			try{
				
				String s = st.nextToken();
				Long.parseLong(s);
				
				if(s.length()>19){
					wrong=true;
				}
				s = st.nextToken();
				Long.parseLong(s);
				
				if(s.length()>6){
					wrong=true;
				}

				ticket.setQuantityLts(new BigDecimal(s));
				
			}catch (NumberFormatException e) {
				wrong=true;
			}
			if(wrong){
				 errors.rejectValue("quantityLtsString", MessageConstants.INVALID_QUANTITY_LTS, 
		 					new String[]{ticket.getQuantityLtsString()}, "");
			}
			
		}*/
		
		
		if(ticket.getDatetimeString()!=null && ticket.getDatetimeString().length()>0){
			if(!Utilities.isValidDateTime(ticket.getDatetimeString())){
				 errors.rejectValue("datetimeString", MessageConstants.INVALID_DATE, 
				 					new String[]{ticket.getDatetimeString()}, "");
			}
		}
		
		if(ticket.getAirplaneCode().length()>MAX_AIRPLANE_LENGTH){
			 errors.rejectValue("airplaneCode", 
					 			MessageConstants.MAX_LENGHT_ERROR, 
					 			new String[]{AIRPLANE, MAX_AIRPLANE_LENGTH.toString()},
					 			"");
		}
		if(ticket.getNotes().length()>MAX_NOTES_LENGTH){
			 errors.rejectValue("notes", 
					 			MessageConstants.MAX_LENGHT_ERROR, 
					 			new String[]{NOTES, MAX_NOTES_LENGTH.toString()},
					 			"");
		}
	}
}