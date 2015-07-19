package com.jdoilfield.operationalsystem.validator;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.jdoilfield.operationalsystem.business.FuelCardManager;
import com.jdoilfield.operationalsystem.domain.remote.FuelCard;

public class FuelCardValidator implements Validator{
	private static Logger logger = Logger.getLogger(FuelCardValidator.class);

	@Override
	public boolean supports(Class<?> class_) {
		logger.info("FUEL CARD VALIDATOR SUPPORTS");
		return class_.equals(FuelCard.class);
	}

	@Override
	public void validate(Object command, Errors errors) {
		logger.info("FUEL CARD VALIDATOR VALIDATE");
		// TODO Auto-generated method stub
		
	}

}
