package pe.gob.onp.orrhh.qr.utilitario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilitario {

	public static Date convertStringToDate(String sDate, String format) throws ParseException {
		Date date1=new SimpleDateFormat(format).parse(sDate);  
		return date1;
	}

	public static Date convertStringToDate(String sDate) throws ParseException {
		Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate);  
		return date1;
	}
	
	public static Date getCurrentDate() {
		return new Date();
	}
}
