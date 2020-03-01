/**
 * WSProveedorCorreoPortBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.onp.orrhh.qr.notifica.ws;

//RGS
import org.apache.axis.message.SOAPHeaderElement;

import pe.gob.onp.orrhh.qr.core.BackendConstantes;

import javax.xml.soap.SOAPElement;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//RGS

public class WSProveedorCorreoPortBindingStub extends org.apache.axis.client.Stub implements pe.gob.onp.orrhh.qr.notifica.ws.WSProveedorCorreoDelegate {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    //RGS
    public static Properties prop;
	public static InputStream input;
	//RGS
    
    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[2];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("enviarCorreoFormatoHTML");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "bCorreoServidor"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "bCorreoServidor"), pe.gob.onp.orrhh.qr.notifica.ws.BCorreoServidor.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "paramCorreoBean"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "bCorreoBean"), pe.gob.onp.orrhh.qr.notifica.ws.BCorreoBean.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "bCorreoResponse"));
        oper.setReturnClass(pe.gob.onp.orrhh.qr.notifica.ws.BCorreoResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "Exception"),
                      "pe.gob.onp.notifica.ws.Exception",
                      new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "Exception"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("enviarCorreoFormatoTexto");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "bCorreoServidor"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "bCorreoServidor"), pe.gob.onp.orrhh.qr.notifica.ws.BCorreoServidor.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "paramCorreoBean"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "bCorreoBean"), pe.gob.onp.orrhh.qr.notifica.ws.BCorreoBean.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "bCorreoResponse"));
        oper.setReturnClass(pe.gob.onp.orrhh.qr.notifica.ws.BCorreoResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "Exception"),
                      "pe.gob.onp.notifica.ws.Exception",
                      new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "Exception"), 
                      true
                     ));
        _operations[1] = oper;

    }

    public WSProveedorCorreoPortBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public WSProveedorCorreoPortBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public WSProveedorCorreoPortBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "bAdjuntoCorreoBean");
            cachedSerQNames.add(qName);
            cls = pe.gob.onp.orrhh.qr.notifica.ws.BAdjuntoCorreoBean.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "bCabeceraCorreoBean");
            cachedSerQNames.add(qName);
            cls = pe.gob.onp.orrhh.qr.notifica.ws.BCabeceraCorreoBean.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "bCorreoBean");
            cachedSerQNames.add(qName);
            cls = pe.gob.onp.orrhh.qr.notifica.ws.BCorreoBean.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "bCorreoResponse");
            cachedSerQNames.add(qName);
            cls = pe.gob.onp.orrhh.qr.notifica.ws.BCorreoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "bCorreoServidor");
            cachedSerQNames.add(qName);
            cls = pe.gob.onp.orrhh.qr.notifica.ws.BCorreoServidor.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "bImagenCorreoBean");
            cachedSerQNames.add(qName);
            cls = pe.gob.onp.orrhh.qr.notifica.ws.BImagenCorreoBean.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "Exception");
            cachedSerQNames.add(qName);
            cls = pe.gob.onp.orrhh.qr.notifica.ws.Exception.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public pe.gob.onp.orrhh.qr.notifica.ws.BCorreoResponse enviarCorreoFormatoHTML(pe.gob.onp.orrhh.qr.notifica.ws.BCorreoServidor bCorreoServidor, pe.gob.onp.orrhh.qr.notifica.ws.BCorreoBean paramCorreoBean) throws java.rmi.RemoteException, pe.gob.onp.orrhh.qr.notifica.ws.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "enviarCorreoFormatoHTML"));

       //RGS
        try {
			prop = new Properties();
			input = null;
			input = getClass().getClassLoader().getResourceAsStream(BackendConstantes.NOMBRE_ARCHIVO_PROPERTIES);
			prop.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
             
        
        try{
        	
        // Create the top-level WS-Security SOAP header XML name.
        QName headerName = new QName(
        "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "Security");
        SOAPHeaderElement header = new SOAPHeaderElement(headerName);
        //  no intermediate actors are involved.
        header.setActor(null);
        // not important, "wsse" is standard
        header.setPrefix("wsse");
        header.setMustUnderstand(true);

        // Add the UsernameToken element to the WS-Security header
        SOAPElement utElem = header.addChildElement("UsernameToken");
        SOAPElement userNameElem = utElem.addChildElement("Username");         
        userNameElem.setValue(prop.getProperty("username"));
        SOAPElement passwordElem = utElem.addChildElement("Password");        
        passwordElem.setValue(prop.getProperty("password"));

        // Finally, attach the header to the binding.
        _call.addHeader(header);    
        
        }catch (SOAPException se){
       	 
        }
   
        //RGS
        
        
        setRequestHeaders(_call);
        setAttachments(_call);
        try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {bCorreoServidor, paramCorreoBean});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (pe.gob.onp.orrhh.qr.notifica.ws.BCorreoResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (pe.gob.onp.orrhh.qr.notifica.ws.BCorreoResponse) org.apache.axis.utils.JavaUtils.convert(_resp, pe.gob.onp.orrhh.qr.notifica.ws.BCorreoResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof pe.gob.onp.orrhh.qr.notifica.ws.Exception) {
              throw (pe.gob.onp.orrhh.qr.notifica.ws.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public pe.gob.onp.orrhh.qr.notifica.ws.BCorreoResponse enviarCorreoFormatoTexto(pe.gob.onp.orrhh.qr.notifica.ws.BCorreoServidor bCorreoServidor, pe.gob.onp.orrhh.qr.notifica.ws.BCorreoBean paramCorreoBean) throws java.rmi.RemoteException, pe.gob.onp.orrhh.qr.notifica.ws.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "enviarCorreoFormatoTexto"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {bCorreoServidor, paramCorreoBean});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (pe.gob.onp.orrhh.qr.notifica.ws.BCorreoResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (pe.gob.onp.orrhh.qr.notifica.ws.BCorreoResponse) org.apache.axis.utils.JavaUtils.convert(_resp, pe.gob.onp.orrhh.qr.notifica.ws.BCorreoResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof pe.gob.onp.orrhh.qr.notifica.ws.Exception) {
              throw (pe.gob.onp.orrhh.qr.notifica.ws.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
