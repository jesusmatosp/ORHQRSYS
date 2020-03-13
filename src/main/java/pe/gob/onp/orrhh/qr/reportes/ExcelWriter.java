package pe.gob.onp.orrhh.qr.reportes;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pe.gob.onp.orrhh.qr.bean.DetailReporteResumenBean;
import pe.gob.onp.orrhh.qr.bean.ReporteDetalladoBean;
import pe.gob.onp.orrhh.qr.bean.ReporteResumenBean;
import pe.gob.onp.orrhh.qr.dto.PersonaDTO;

public class ExcelWriter {

	private static String[] columns = {"#", "Cod Evento", "DNI", "Ape. Paterno", "Ape. Materno", "Nombres", 
		"Sexo", "Edad", "Puesto", "Regimen", "Area Operativa"};
	
	
	public byte[] generarReporteDetalladoExcel(ReporteDetalladoBean reporte) throws IOException, InvalidFormatException {
		
		// Crear Columnas:
		List<String> c = new ArrayList<String>();
		for(int i = 0; i < columns.length; i++) {
			c.add(columns[i]);
		}
		// columnas dinamicas:
		for(String _columnas: reporte.getColumnas()) {
			c.add(_columnas);
		}
		
		c.add("Reg x Persona");

		// Reporte Excel
		// Create a Workbook
        Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file
        /* CreationHelper helps us create instances of various things like DataFormat, 
           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
        CreationHelper createHelper = workbook.getCreationHelper();

        // Create a Sheet
        Sheet sheet = workbook.createSheet("Asistencia Detallada");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.ORANGE.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Create cells
        for(int i = 0; i < c.size(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(c.get(i).toString());
            cell.setCellStyle(headerCellStyle);
        }

        // Create Cell Style for formatting Date
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

        // Create Other rows and cells with employees data
        int rowNum = 1;
        
        List<ReporteResumenBean> lstResumen = reporte.getData();
        
        for(ReporteResumenBean resumen: lstResumen) {     	
            Row row = sheet.createRow(rowNum++);
        	PersonaDTO personaDTO = resumen.getPersona();
            
            row.createCell(0)
                    .setCellValue(rowNum);

            row.createCell(1)
                    .setCellValue(resumen.getIdEvento());

            row.createCell(2)
            		.setCellValue(personaDTO.getDni());
            
            row.createCell(3)
                    .setCellValue(personaDTO.getApellidoPaterno());
            
            row.createCell(4)
            		.setCellValue(personaDTO.getApellidoMaterno());
            
            row.createCell(5)
    				.setCellValue(personaDTO.getNombres());
            
            row.createCell(6)
            		.setCellValue(personaDTO.getSexo());
            
            row.createCell(7)
    				.setCellValue(personaDTO.getEdad().substring(0,2));
            
            row.createCell(8)
    				.setCellValue(personaDTO.getPuesto());
            
            row.createCell(9)
    				.setCellValue(personaDTO.getRegimen());
            
            row.createCell(10)
    				.setCellValue(personaDTO.getAreaCorporativa());
            
            int columnNum = 11;
            List<DetailReporteResumenBean> lstDetalle = resumen.getDetalle();
            for(DetailReporteResumenBean detalle: lstDetalle) {
            	row.createCell(columnNum).setCellValue(detalle.getAsistencia());
            	columnNum++;
            }
            
            row.createCell(columnNum)
            	.setCellValue(resumen.getTotalAsistido());
        }
        
        rowNum = 1;
        
        

		// Resize all columns to fit the content size
        for(int i = 0; i < c.size(); i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("reporte-detallado-asistencia.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
        
        return filetoByteArray("reporte-detallado-asistencia.xlsx");
	}
	
	private byte[] filetoByteArray(String path) {
        byte[] data;
        try {
            InputStream input = new FileInputStream(path);
            int byteReads;
            ByteArrayOutputStream output = new ByteArrayOutputStream(1024);
            while ((byteReads = input.read()) != -1) {
                output.write(byteReads);
            }
            data = output.toByteArray();
            output.close();
            input.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
}
