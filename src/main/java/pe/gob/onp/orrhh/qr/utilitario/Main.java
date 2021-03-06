package pe.gob.onp.orrhh.qr.utilitario;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.gob.onp.orrhh.qr.notifica.ws.BCabeceraCorreoBean;
import pe.gob.onp.orrhh.qr.notifica.ws.BCorreoBean;
import pe.gob.onp.orrhh.qr.notifica.ws.BCorreoResponse;
import pe.gob.onp.orrhh.qr.notifica.ws.BCorreoServidor;
import pe.gob.onp.orrhh.qr.notifica.ws.BImagenCorreoBean;

import java.io.FileInputStream;
import java.io.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.*;
import java.util.Iterator;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class Main {

	public static Properties prop;
	public static InputStream input;		
	private static Logger logger = LoggerFactory.getLogger(Main.class);
	
	public void init() {
		try {
			prop = new Properties();
			input = null;
			input = getClass().getClassLoader().getResourceAsStream("config.properties");
			prop.load(input);	
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}
	
	public static void main(String[] args) {
		Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream("TableCellAlignment.pdf"));
            doc.open();

            // Setting table's cells horizontal alignment
            PdfPTable table = new PdfPTable(3);
            PdfPCell cell1 = new PdfPCell(new Phrase("Cell 1"));
            cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell1);
            PdfPCell cell2 = new PdfPCell(new Phrase("Cell 2"));
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell2);
            PdfPCell cell3 = new PdfPCell(new Phrase("Cell 3"));
            cell3.setHorizontalAlignment(Element.ALIGN_RIGHT);
            table.addCell(cell3);
            table.completeRow();

            // Setting table's cells vertical alignment
            PdfPCell[] cells = new PdfPCell[3];
            int[] alignments = new int[]{
                    Element.ALIGN_TOP,
                    Element.ALIGN_MIDDLE,
                    Element.ALIGN_BOTTOM
            };
            for (int i = 0; i < cells.length; i++) {
                cells[i] = new PdfPCell(new Phrase("Cell " + (i + 1)));
                cells[i].setMinimumHeight(50);
                cells[i].setVerticalAlignment(alignments[i]);
                table.addCell(cells[i]);
            }
            table.completeRow();

            doc.add(table);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            doc.close();
        }

//		// TODO Auto-generated method stub
//		try {
//			Main m = new Main();
//			m.init();
//			
//			String correosDestinatarioONP = new String();
//			BCorreoBean paramCorreoBean = new BCorreoBean();
//			paramCorreoBean.setAsunto("ONP M\u00f3vil - Comunicaci\u00f3n recibida correctamente");
//			BCorreoServidor bCorreoServidor=new BCorreoServidor();
//			bCorreoServidor.setServidorCorreo(prop.getProperty("HOST_SERVIDOR_CORREO"));
//			bCorreoServidor.setPuertoServidor(prop.getProperty("PUERTO_SERVIDOR_CORREO"));
//			bCorreoServidor.setSmtpAuth(false);
//			byte[] byteData = null;
//			byte[] byteDataTable = null;
//	
//			BCabeceraCorreoBean cabeceraCorreoBean = new BCabeceraCorreoBean();
//			cabeceraCorreoBean.setCorreoRemitente(prop.getProperty("correoRemitente"));
//				
//			String[] correosDestinatarios = new String[1];				
//			
//			correosDestinatarios[0] = "jarsanchez01@gmail.com";
//			
//			cabeceraCorreoBean.setCorreoDestino(correosDestinatarios);
//		
//			List<BImagenCorreoBean> lstBCorreoImagen = new ArrayList<BImagenCorreoBean>();
//			
//			BImagenCorreoBean[] lstImagenes = new BImagenCorreoBean[2];			
//	
//	//		byteData=recuperarBytesDesdeArchivo("img/onp.png");
//	//		byteDataTable=recuperarBytesDesdeArchivo("img/table.png");		
//	//		
//			
//			BImagenCorreoBean bCorreoImagen = null;
//	
//			bCorreoImagen = new BImagenCorreoBean();
//			bCorreoImagen.setNombreVariable("img1");
//			bCorreoImagen.setArchivoAdjunto(byteData);
//			lstImagenes[0] = bCorreoImagen;
//			
//			bCorreoImagen = new BImagenCorreoBean();
//			bCorreoImagen.setNombreVariable("img2");
//			bCorreoImagen.setArchivoAdjunto(byteDataTable);
//			lstImagenes[1]=bCorreoImagen;
//			paramCorreoBean.setImagenesAdjuntas(lstImagenes);
//			
//			paramCorreoBean.setMensaje("Hola mundo!!");
//			paramCorreoBean.setCabeceraCorreoBean(cabeceraCorreoBean);				
//			
//			BCorreoResponse bCorreoResponse = new BCorreoResponse(); 
//			
//			pe.gob.onp.orrhh.qr.notifica.ws.WSProveedorCorreoDelegateProxy proxyEnvioCorreo =
//					new pe.gob.onp.orrhh.qr.notifica.ws.WSProveedorCorreoDelegateProxy();
//			proxyEnvioCorreo.setEndpoint(prop.getProperty("WSenvioCorreo"));
//			proxyEnvioCorreo.enviarCorreoFormatoHTML(bCorreoServidor, paramCorreoBean);
//		
//			String nombreServicio = "";
//			paramCorreoBean = new BCorreoBean();
//			boolean  resideExtranjero = false;
//			if (resideExtranjero){
//				correosDestinatarioONP = prop.getProperty("correoDestinatarioONPExtranjero");	
//				nombreServicio = "Resido en el Extranjero";
//			}else{
//				correosDestinatarioONP = prop.getProperty("correoDestinatarioONP");	
//				nombreServicio = "Cont\u00e1ctanos";
//			}	
//			
//			
//			
//			paramCorreoBean.setAsunto("ONP Móvil - Servicio "+ nombreServicio +" - Nueva comunicación recibida");
//						
//			cabeceraCorreoBean = new BCabeceraCorreoBean();
//			cabeceraCorreoBean.setCorreoRemitente(prop.getProperty("correoRemitente"));
//			
//			
//				
//			String[] correosDeNotificacionONP = correosDestinatarioONP.split(Pattern.quote("|"));
//			
//			cabeceraCorreoBean.setCorreoDestino(correosDeNotificacionONP);
//			
//			paramCorreoBean.setImagenesAdjuntas(lstImagenes);
//			
//			paramCorreoBean.setMensaje("Correo de prueba");
//			paramCorreoBean.setCabeceraCorreoBean(cabeceraCorreoBean);				
//						
//			
//			proxyEnvioCorreo.enviarCorreoFormatoHTML(bCorreoServidor, paramCorreoBean);
//			
//			System.out.println("OK! - 200 - Se enviaron correctamente los correos!!!");
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
        
	}

}
