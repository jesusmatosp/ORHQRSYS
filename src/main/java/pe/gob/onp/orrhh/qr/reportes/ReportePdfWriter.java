package pe.gob.onp.orrhh.qr.reportes;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.Table;

import pe.gob.onp.orrhh.qr.bean.DetailReporteResumenBean;
import pe.gob.onp.orrhh.qr.bean.ReporteDetalladoBean;
import pe.gob.onp.orrhh.qr.bean.ReporteResumenBean;
import pe.gob.onp.orrhh.qr.dto.PersonaDTO;

public class ReportePdfWriter {
	
	private static String[] columns = {"#", "Cod Evento", "DNI", "Ape. Paterno", "Ape. Materno", "Nombres",  "Sexo", "Edad", "Puesto", "Regimen", "Area Operativa"};
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
	private ReporteDetalladoBean reporte;
    
	public ReportePdfWriter(ReporteDetalladoBean reporte) {
		this.reporte = reporte;
	}
	
	public ReportePdfWriter() {
		
	}
	
	private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

	public byte[] generarReporteDetalladoPDF() {
		byte[] pdfBytes = null;
		Document document = new Document();
		// document.setPageSize(PageSize.A4.rotate());
		
		Rectangle one = new Rectangle(1500, 800);
		// Rectangle two = new Rectangle(700,400);
		
		document.setPageSize(one);
		document.setMargins(10, 10, 10, 10);

		try {
			String path = new File(".").getCanonicalPath();
        	// String FILE_NAME = path + "/itext-test-file.pdf";
        	// PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
        	PdfWriter writer = PdfWriter.getInstance(document, byteArrayOutputStream);
        	 // add header and footer
            HeaderFooterPageEvent event = new HeaderFooterPageEvent();
            writer.setPageEvent(event);
        	
            document.open();
            
            addMetaData(document);
          //  addContent(document);
            addTitlePage(document);
            createTable(document);
            document.close();
            
            pdfBytes = byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return pdfBytes;
	}
	
	private void addMetaData(Document document) {
        document.addTitle("Reporte Detallado de Asistencia - ONP");
        document.addSubject("Sistema de Asistencia - QR - ONP");
        document.addKeywords("ONP, Asistencia, QR, Perú");
        document.addAuthor("ONP");
        document.addCreator("ONP");
    }
	
	private static void addTitlePage(Document document)
            throws DocumentException {
        Paragraph preface = new Paragraph();
        // We add one empty line
        addEmptyLine(preface, 2);
        // Lets write a big header
        // preface.add(new Paragraph("Oficina de Normalización Previsional (ONP) - Dpto. RRHH", smallBold));
        // Will create: Report generated by: _name, _date
         preface.add(new Paragraph("", catFont));
         addEmptyLine(preface, 2);
         document.add(preface);
        
        float [] pointColumnWidths = {150F, 150F, 150F};   
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100f); 
        // Adding cells to the table       
        PdfPCell c1 = new PdfPCell(new Paragraph("Reporte de Asistencia Detallada", catFont));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setBorder(Rectangle.NO_BORDER);
        PdfPCell cellOne = new PdfPCell(new Phrase(""));
        cellOne.setBorder(Rectangle.NO_BORDER);
        table.addCell(cellOne);       
        table.addCell(c1);       
        table.addCell(cellOne);
        document.add(table);
        preface.add(new Paragraph("", catFont));
        document.add(preface);
       // preface.add(new Paragraph("Reporte de Asistencia Detallada", catFont));
       // addEmptyLine(preface, 3);
       // document.add(preface);
    }
	
	private void addContent(Document document) throws DocumentException {
//        Anchor anchor = new Anchor("Reporte Detalle Persona", catFont);
//        anchor.setName("Reporte Detalle Persona");
//        // Second parameter is the number of the chapter
//        Chapter catPart = new Chapter(new Paragraph(anchor), 1);
//        Paragraph subPara = new Paragraph("Reporte Detalle Persona", subFont);
//        Section subCatPart = catPart.addSection(subPara);
//        // add a table
//       // createTable(subCatPart);
//        // now add all this to the document
//        document.add(catPart);
    }
	
	private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
	
	private void createTable(Document document) throws DocumentException {
		// Crear Columnas:
		List<String> c = new ArrayList<String>();
		for (int i = 0; i < columns.length; i++) {
			c.add(columns[i]);
		}
		// columnas dinamicas:
		for (String _columnas : reporte.getColumnas()) {
			c.add(_columnas);
		}
		c.add("Reg x Persona");
		
        PdfPTable table = new PdfPTable(c.size());
        table.setWidthPercentage(100f);
        // Create cells
       
        for(int i = 0; i < c.size(); i++) {
        	PdfPCell c1 = new PdfPCell(new Phrase(c.get(i).toString()));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);
        }
        table.setHeaderRows(1);
        
        int rowNum = 1;
        List<ReporteResumenBean> lstResumen = reporte.getData();
        
        for(ReporteResumenBean resumen: lstResumen) {   
        	PersonaDTO personaDTO = resumen.getPersona();
        	table.addCell("" + rowNum);
        	table.addCell("" + resumen.getIdEvento());
        	table.addCell(personaDTO.getDni());
        	table.addCell(personaDTO.getApellidoPaterno());
        	table.addCell(personaDTO.getApellidoMaterno());
        	table.addCell(personaDTO.getNombres());
        	table.addCell(personaDTO.getSexo());
        	table.addCell(personaDTO.getEdad().substring(0,2));
        	table.addCell(personaDTO.getPuesto());
        	table.addCell(personaDTO.getRegimen());
        	table.addCell(personaDTO.getAreaCorporativa());
        	List<DetailReporteResumenBean> lstDetalle = resumen.getDetalle();
            for(DetailReporteResumenBean detalle: lstDetalle) {
            	table.addCell(detalle.getAsistencia());
            }
        	table.addCell("" + resumen.getTotalAsistido());
		    rowNum++;
        }
        document.add(table);
    }

	 private void addHeader(PdfWriter writer){
	        PdfPTable header = new PdfPTable(2);
	        try {
	            // set defaults
	            header.setWidths(new int[]{2, 24});
	            header.setTotalWidth(527);
	            header.setLockedWidth(true);
	            header.getDefaultCell().setFixedHeight(40);
	            header.getDefaultCell().setBorder(Rectangle.BOTTOM);
	            header.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);

	            // add image
	            URL url = getClass().getClassLoader().getResource("logo_onp.png");
	            Image logo = Image.getInstance(url);
	            header.addCell(logo);

	            // add text
	            PdfPCell text = new PdfPCell();
	            text.setPaddingBottom(15);
	            text.setPaddingLeft(10);
	            text.setBorder(Rectangle.BOTTOM);
	            text.setBorderColor(BaseColor.LIGHT_GRAY);
	            text.addElement(new Phrase("iText PDF Header Footer Example", new Font(Font.FontFamily.HELVETICA, 12)));
	            text.addElement(new Phrase("https://memorynotfound.com", new Font(Font.FontFamily.HELVETICA, 8)));
	            header.addCell(text);

	            // write content
	            header.writeSelectedRows(0, -1, 34, 803, writer.getDirectContent());
	        } catch(DocumentException de) {
	            throw new ExceptionConverter(de);
	        } catch (MalformedURLException e) {
	            throw new ExceptionConverter(e);
	        } catch (IOException e) {
	            throw new ExceptionConverter(e);
	        }
	    }
	
	public ReporteDetalladoBean getReporte() {
		return reporte;
	}

	public void setReporte(ReporteDetalladoBean reporte) {
		this.reporte = reporte;
	}
}
