package pe.gob.onp.orrhh.qr.utilitario;

import java.io.File;
import java.util.List;

import pe.gob.onp.orrhh.qr.dto.PersonaDTO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("C://temp//proceso_onp.xlsx");
		JavaPOI javaPoi = new JavaPOI();
		List<PersonaDTO> personas = javaPoi.leerExcelFilePersona(file);
		for(PersonaDTO p: personas) {
			System.out.println("DNI: " + p.getDni() + ", " + p.getNombres() + " " + p.getApellidoPaterno() + " " + p.getApellidoMaterno());
		}
	}

}
