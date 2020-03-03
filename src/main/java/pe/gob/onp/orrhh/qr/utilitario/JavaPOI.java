package pe.gob.onp.orrhh.qr.utilitario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.gob.onp.orrhh.qr.dto.PersonaDTO;
import pe.gob.onp.orrhh.qr.utilitario.exception.PersonaException;

public class JavaPOI {
	private static final Logger LOG = LoggerFactory.getLogger(JavaPOI.class);
	
	public List<PersonaDTO> leerExcelFilePersona(File excelFile) throws PersonaException {
		List<PersonaDTO> personas = null;
		InputStream excelStream = null;
		try {
			excelStream = new FileInputStream(excelFile);
			XSSFWorkbook hssfWorbook = new XSSFWorkbook(excelStream);
			XSSFSheet hssfSheet = hssfWorbook.getSheetAt(0);
			XSSFRow hssfRow;
			int rows = hssfSheet.getLastRowNum();
			personas = new ArrayList<PersonaDTO>();
			if(rows == 0 || rows == 1) throw new PersonaException("El archivo no puede estar vacío");
			for(int r  = 1; r < rows+1; r++){
				hssfRow = hssfSheet.getRow(r);
				if(hssfRow == null){
					break;
				}else{	
					PersonaDTO personaDTO = new PersonaDTO();
					DataFormatter df = new DataFormatter();
					String dniValue = df.formatCellValue(hssfRow.getCell(0));
					personaDTO.setDni(dniValue);
					if(personaDTO.getDni().equalsIgnoreCase("BLANK") || personaDTO.getDni().isEmpty() || personaDTO.getDni().equals("")) break;
					personaDTO.setApellidoPaterno(obtenerCelda(hssfRow, 1));
					personaDTO.setApellidoMaterno(obtenerCelda(hssfRow, 2));
					personaDTO.setNombres(obtenerCelda(hssfRow, 3));
					personaDTO.setSexo(obtenerCelda(hssfRow, 4));
					personaDTO.setEdad(obtenerCelda(hssfRow, 5));
					personaDTO.setPuesto(obtenerCelda(hssfRow, 6));
					personaDTO.setRegimen(obtenerCelda(hssfRow, 7));
					df = new DataFormatter();
					String CellValue = df.formatCellValue(hssfRow.getCell(8));
					//personaDTO.setFechaIngreso(DateUtilitario.convertStringToDate(CellValue, "MM/dd/YY"));
					personaDTO.setFechaIngreso(DateUtilitario.convertStringToDate(CellValue, "dd/MM/YYYY"));
					personaDTO.setAreaCorporativa(obtenerCelda(hssfRow, 9));
					personaDTO.setCorreoCorporativo(obtenerCelda(hssfRow, 10));
					personaDTO.setCorreoPersonal(obtenerCelda(hssfRow, 11));
					personaDTO.setFechaCarga(DateUtilitario.getCurrentDate());
					personaDTO.validarDatosPersona(r);
					personas.add(personaDTO);
				}
			}
		} catch (PersonaException personaException) {
			throw new PersonaException(personaException.getLocalizedMessage());
		} catch (FileNotFoundException fileNotFoundException) {
			LOG.error("The file not exists (No se encontró el fichero): " + fileNotFoundException);
        } catch (IOException ex) {
        	LOG.error("Error in file procesing (Error al procesar el fichero): " + ex);
        } catch (Exception e) {
			LOG.error("Error generico: " + e.getLocalizedMessage());
		}finally {
            try {
                excelStream.close();
            } catch (IOException ex) {
            	LOG.error("Error in file processing after close it (Error al procesar el fichero después de cerrarlo): " + ex);
            }
        }
		return personas;
	}
	
	public String obtenerCelda(XSSFRow hssfRow, int index){
		String cellValue = hssfRow.getCell(index) == null?"":
            (hssfRow.getCell(index).getCellType() == Cell.CELL_TYPE_STRING)?hssfRow.getCell(index).getStringCellValue():
            (hssfRow.getCell(index).getCellType() == Cell.CELL_TYPE_NUMERIC)?"" + hssfRow.getCell(index).getNumericCellValue():
            (hssfRow.getCell(index).getCellType() == Cell.CELL_TYPE_BOOLEAN)?"" + hssfRow.getCell(index).getBooleanCellValue():
            (hssfRow.getCell(index).getCellType() == Cell.CELL_TYPE_BLANK)?"BLANK":
            (hssfRow.getCell(index).getCellType() == Cell.CELL_TYPE_FORMULA)?"FORMULA":
            (hssfRow.getCell(index).getCellType() == Cell.CELL_TYPE_ERROR)?"ERROR":"";
            return cellValue;
	}
}
