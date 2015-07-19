package com.jdoilfield.operationalsystem.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.StringTokenizer;

public class Utilities {
	
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat sdtf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	static SimpleDateFormat fileDateTimeDf = new SimpleDateFormat(Constants.FILE_DATE_TIME_FORMAT);
	static SimpleDateFormat fileDateDf = new SimpleDateFormat(Constants.FILE_DATE_FORMAT);

    /**
     * Redondea el n�mero flotante pasado como par�metro a los decimales 
     * especificados por el par�metro decimales 
     * @param flotante N�mero flotante que se desea redondear
     * @param decimales N�mero de decimales a los cuales se desea redondear el 
     *                  flotante
     * @return El flotante pasado como par�metro redondeado
     */
    public static double roundFloat(double flotante, int decimales) {
        int factor = (int) Math.pow(10, decimales); 

        Double fround = (double) (Math.round(flotante*factor))/factor;

        return fround;
    }
    
	  public static boolean isValidDate(String date) {
		    try {
		     
		    	if(date!=null && date.length()==10){
		    		 //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				     sdf.setLenient(false);   // this is important!
				     sdf.parse(date);
		    	}else{
		    		return false;
		    	}
		    			
		    }
		    catch (ParseException e) {
		    	return false;
		    }
		    catch (IllegalArgumentException e) {
		    	return false;
		    }
		    return true;
	  }
	  public static boolean isValidDateTime(String date) {
		    try {
		     
		    	if(date!=null && date.length()==19){
		    		
		    		 //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		    		sdtf.setLenient(false);   // this is important!
		    		sdtf.parse(date);
		    	}else{
		    		return false;
		    	}
		    			
		    }
		    catch (ParseException e) {
		    	return false;
		    }
		    catch (IllegalArgumentException e) {
		    	return false;
		    }
		    return true;
	  }
		private static String convertToHex(byte[] data) {
	        StringBuffer buf = new StringBuffer();
	        for (int i = 0; i < data.length; i++) {
	        	int halfbyte = (data[i] >>> 4) & 0x0F;
	        	int two_halfs = 0;
	        	do {
		        	if ((0 <= halfbyte) && (halfbyte <= 9))
		                buf.append((char) ('0' + halfbyte));
		            else
		            	buf.append((char) ('a' + (halfbyte - 10)));
		        	halfbyte = data[i] & 0x0F;
	        	} while(two_halfs++ < 1);
	        }
	        return buf.toString();
	    }
	 
		public static String MD5(String text) 
		throws NoSuchAlgorithmException, UnsupportedEncodingException  {
			MessageDigest md;
			md = MessageDigest.getInstance("MD5");
			byte[] md5hash = new byte[32];
			md.update(text.getBytes("iso-8859-1"), 0, text.length());
			md5hash = md.digest();
			return convertToHex(md5hash);
		}
		
		public static Date convertStringToDate(String date){
			GregorianCalendar g =new GregorianCalendar(
					Integer.parseInt(date.substring(0,4)),
					(Integer.parseInt(date.substring(5,7))-1),
					Integer.parseInt(date.substring(8,10)),
					Integer.parseInt(date.substring(11,13)),
					Integer.parseInt(date.substring(14,16)),
					Integer.parseInt(date.substring(17,19)));
			return g.getTime();
		}
		

	public static Date parseStringToDate(String date) {
		if (date != null && date.length() > 0) {
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
		
	public static Date parseStringToDateTime(String date) {
		if (date != null && date.length() > 0) {
			try {
				return sdtf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
		
		public static Calendar parseDateToCalendar(Date date){
			String fecha = "";
			DateFormat df = DateFormat.getInstance();
	        df = new SimpleDateFormat("yyyy-MM-dd");
	        if(date != null)
	        fecha = df.format(date);
	        
	        Calendar cal = null;
			
	        if(date!= null){
				StringTokenizer token = new StringTokenizer(fecha,"-");
				String anio = token.nextToken();
				String mes = token.nextToken();
				String dia = token.nextToken();
				
				cal = Calendar.getInstance();
				cal.set(Integer.parseInt(anio), Integer.parseInt(mes) -1, Integer.parseInt(dia));
				//df.format(cal.getTime());
			}			
	         return cal;
		}
		
		/**This method allow  to get the number of days that can exist when comparing two dates
		 * using calendars as parameters, you should pass the initDate first and the endDate after
		 * this methods doesn't swap dates in order to validate parameters.
		 * 
		 * @return The number of days bewtween two calendars
		 */
		public static int getNumberOfDaysBewtweenTwoCalendars(Calendar initDate, Calendar endDate){
			/**if (d1.after(d2)) { // swap dates so that d1 is start and d2 is end
			java.util.Calendar swap = d1;
			d1 = d2;
			d2 = swap;
			}**/
			int days = 0;
			if(initDate != null && endDate != null){
				days = endDate.get(Calendar.DAY_OF_YEAR) - initDate.get(Calendar.DAY_OF_YEAR);
				int endYear = endDate.get(Calendar.YEAR);
				if(initDate.get(Calendar.YEAR) != endYear){
					initDate = (Calendar) initDate.clone();
					do{
						days += initDate.getActualMaximum(Calendar.DAY_OF_YEAR);
						initDate.add(Calendar.DAY_OF_YEAR, 1);
					}while(initDate.get(Calendar.YEAR) != endYear);
				}
			}
			return days;
		}
		
		/** Mary-Jesus
		 * Retorna una cadena de caracteres correspondiente a la fecha introducida
		 * @param date
		 * @return retorna la Fecha si es valida, null en caso contrario
		 */
		public static String formatDate(Date date,String format) {
			String rString=null;
			try {

				if(date!=null && format!=null && format.length()>0){
					if(Constants.FILE_DATE_TIME_FORMAT.equals(format)){
						rString = fileDateTimeDf.format(date);
					}else{
						if(Constants.FILE_DATE_FORMAT.equals(format)){
							rString = fileDateDf.format(date);
						}else{
							
							SimpleDateFormat tempDateDf = new SimpleDateFormat(format);
							rString = tempDateDf.format(date);
						}
					}
				}else{
					return null;
				}
			}catch (IllegalArgumentException e) {
				return null;
			}
			catch (Exception e) {
				return null;
			}
			
			return rString;
		}
		
		/**
		 * 
		 * @param liters
		 * @return String that contains the convertion 
		 */
		public static String convertLtsToGals(String liters){
			//1 Liter = 0.2642 US Gallons
			//1 gal =3.7854 Litser
			//lts   -->  X
			return BigDecimal.valueOf(Double.parseDouble(liters) / Constants.GALON_CONVERSION).setScale(2,RoundingMode.HALF_UP).toString();
		}
		
		/*
		 * 
		 */
		
		public static String generateAutomaticPasswordOrFuelCard(boolean isFuelCard){
			String base = "";
			StringBuilder result = new StringBuilder();
			Random random = new Random();
			
			if(isFuelCard){
				base = "0123456789";
				for(int i = 0; i < (base.length()- 2); i++){
				      result.append(base.charAt(random.nextInt(base.length())));
				}
				return result.toString();
				
			}else{
				base = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabsdefghijklmnopqrstuvwxyz/*-+_)(*&^%$#@!";
				for(int i = 0; i < (base.length() - 70); i++){
			      result.append(base.charAt(random.nextInt(base.length())));
			    }
			    
				return result.toString();	
			}
		}
		

}