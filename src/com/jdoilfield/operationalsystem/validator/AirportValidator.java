package com.jdoilfield.operationalsystem.validator;

import com.jdoilfield.operationalsystem.domain.local.Airport;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AirportValidator
  implements Validator
{
  private static final Integer MAXIMUM_CODE_LENGTH = Integer.valueOf(10);
  private static final Integer MAXIMUM_NAME_LENGTH = Integer.valueOf(100);
  private static final String CODE = "Code";
  private static final String NAME = "Name";
  private static final String COUNTRY = "Country";
  private static final String CITY = "City";
  private static final String LOCATION = "Location";
  private static final String IATA = "Iata";

  public boolean supports(Class c)
  {
    return c.equals(Airport.class);
  }

  public void validate(Object command, Errors errors) {
    Airport airport = (Airport)command;

    ValidationUtils.rejectIfEmpty(errors, "code", "errors.required", new String[] { "Code" });
    ValidationUtils.rejectIfEmpty(errors, "name", "errors.required", new String[] { "Name" });
    ValidationUtils.rejectIfEmpty(errors, "country", "errors.required", new String[] { "Country" });
    ValidationUtils.rejectIfEmpty(errors, "city", "errors.required", new String[] { "City" });
    ValidationUtils.rejectIfEmpty(errors, "location", "errors.required", new String[] { "Location" });
    ValidationUtils.rejectIfEmpty(errors, "codeIata", "errors.required", new String[] { "Iata" });

    if ((airport.getCode() != null) && (airport.getCode().trim().length() > MAXIMUM_CODE_LENGTH.intValue())) {
      errors.rejectValue("code", "errors.maxlength", new String[] { "Code", MAXIMUM_CODE_LENGTH.toString() }, 
        "");
    }

    if ((airport.getName() != null) && (airport.getName().trim().length() > MAXIMUM_NAME_LENGTH.intValue()))
      errors.rejectValue("name", "errors.maxlength", new String[] { "Name", MAXIMUM_NAME_LENGTH.toString() }, 
        "");
  }
}