package pe.gob.onp.orrhh.qr.utilitario;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

import pe.gob.onp.orrhh.qr.dto.PersonaDTO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		File file = new File("C://temp//proceso_onp.xlsx");
//		JavaPOI javaPoi = new JavaPOI();
//		List<PersonaDTO> personas = javaPoi.leerExcelFilePersona(file);
//		for(PersonaDTO p: personas) {
//			System.out.println("DNI: " + p.getDni() + ", " + p.getNombres() + " " + p.getApellidoPaterno() + " " + p.getApellidoMaterno());
//		}
//		Date now = new Date();
//		 
//        SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
//        System.out.println(simpleDateformat.format(now));
// 
//        simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
//        System.out.println(simpleDateformat.format(now));
// 
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(now);
//        System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); // the day of the week in numerical format
//        
//        
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(now);  
//        int hours = cal.get(Calendar.HOUR_OF_DAY);
//        int minutes = cal.get(Calendar.MINUTE);
//        
//        System.out.println("Hora:" + hours + " - Minutos: " + minutes);
//        
//        int numero = 35;
//        Formatter obj = new Formatter();
//        String numeroCeros = String.valueOf(obj.format("%02d", numero));
//        System.out.println(numeroCeros);
		System.out.println(DateUtilitario.getHoraActual(DateUtilitario.getCurrentDate()));
        
	}

}
