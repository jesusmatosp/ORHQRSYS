package pe.gob.onp.orrhh.qr.utilitario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;

public class DateUtilitario {

	public static Date convertStringToDate(String sDate, String format) throws ParseException {
		Date date1=new SimpleDateFormat(format).parse(sDate);  
		return date1;
	}

	public static Date convertStringToDate(String sDate) throws ParseException {
		Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate);  
		return date1;
	}
	
	public static Integer getDiaSemana(Date date) {
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return new Integer(calendar.get(Calendar.DAY_OF_WEEK));
	}
	
	public static String getHoraActual(Date date) {
		Calendar cal = Calendar.getInstance();
        cal.setTime(date);  
        int hours = cal.get(Calendar.HOUR_OF_DAY);
        int minutes = cal.get(Calendar.MINUTE);
        Formatter obj = new Formatter();
        String strhoras = String.valueOf(obj.format("%02d", hours));
        obj = new Formatter();
        String strminutos = String.valueOf(obj.format("%02d", minutes));
        return strhoras + ":" + strminutos;
	}
	
	public static Date getCurrentDate() {
		return new Date();
	}
}
