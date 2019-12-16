package pe.gob.onp.orrhh.qr.utilitario;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class JasperDataSource implements JRDataSource {

	private List<Object> lista = new ArrayList<Object>();
	private int index = -1;
	@SuppressWarnings("unchecked")
	private Class clase = null;
	
	public JasperDataSource(Class<?> clase) {
		// TODO Apendice de constructor generado automaticamente
		this.clase = clase;
	}

	public Object getFieldValue(JRField jrField) throws JRException {
		// TODO Apendice de metodo generado automaticamente
		Object data = null;  
		Object record = null;  

		 Method[] methods = clase.getMethods();
		  //Object obj = record.getClass().newInstance();
		  for(Method method : methods){
		    if( isGetter(method) && method.getName().equalsIgnoreCase("get"+jrField.getName()) ) {
		    	try {
					record = lista.get(index); //.getNombre(); 
					data = method.invoke(record, null);
				} catch (IllegalArgumentException e) {
					// TODO Bloque catch generado automaticamente
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Bloque catch generado automaticamente
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Bloque catch generado automaticamente
					e.printStackTrace();
				}
		    }
		  }
	    return data;
	}

	public boolean next() throws JRException {
		// TODO Apendice de metodo generado automaticamente
		return ++index < lista.size();
	}
	
	public void addListData( List<Object> data)
	{
	    this.lista = data;
	}
	
	public void addRecord(Object data)
	{
	    this.lista.add(data);
	}
	
	private static boolean isGetter(Method method){
		  if(!method.getName().startsWith("get"))      return false;
		  if(method.getParameterTypes().length != 0)   return false;  
		  if(void.class.equals(method.getReturnType())) return false;
		  return true;
	}

}