/**
 * WSProveedorCorreoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.onp.orrhh.qr.notifica.ws;

public class WSProveedorCorreoServiceLocator extends org.apache.axis.client.Service implements pe.gob.onp.orrhh.qr.notifica.ws.WSProveedorCorreoService {

    public WSProveedorCorreoServiceLocator() {
    }


    public WSProveedorCorreoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSProveedorCorreoServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WSProveedorCorreoPort
    private java.lang.String WSProveedorCorreoPort_address = "http://onpwasihsd01.onp.gob.pe:80/wsONPNotificacion/WSProveedorCorreoService";

    public java.lang.String getWSProveedorCorreoPortAddress() {
        return WSProveedorCorreoPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSProveedorCorreoPortWSDDServiceName = "WSProveedorCorreoPort";

    public java.lang.String getWSProveedorCorreoPortWSDDServiceName() {
        return WSProveedorCorreoPortWSDDServiceName;
    }

    public void setWSProveedorCorreoPortWSDDServiceName(java.lang.String name) {
        WSProveedorCorreoPortWSDDServiceName = name;
    }

    public pe.gob.onp.orrhh.qr.notifica.ws.WSProveedorCorreoDelegate getWSProveedorCorreoPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSProveedorCorreoPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSProveedorCorreoPort(endpoint);
    }

    public pe.gob.onp.orrhh.qr.notifica.ws.WSProveedorCorreoDelegate getWSProveedorCorreoPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            pe.gob.onp.orrhh.qr.notifica.ws.WSProveedorCorreoPortBindingStub _stub = new pe.gob.onp.orrhh.qr.notifica.ws.WSProveedorCorreoPortBindingStub(portAddress, this);
            _stub.setPortName(getWSProveedorCorreoPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWSProveedorCorreoPortEndpointAddress(java.lang.String address) {
        WSProveedorCorreoPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (pe.gob.onp.orrhh.qr.notifica.ws.WSProveedorCorreoDelegate.class.isAssignableFrom(serviceEndpointInterface)) {
                pe.gob.onp.orrhh.qr.notifica.ws.WSProveedorCorreoPortBindingStub _stub = new pe.gob.onp.orrhh.qr.notifica.ws.WSProveedorCorreoPortBindingStub(new java.net.URL(WSProveedorCorreoPort_address), this);
                _stub.setPortName(getWSProveedorCorreoPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WSProveedorCorreoPort".equals(inputPortName)) {
            return getWSProveedorCorreoPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "WSProveedorCorreoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "WSProveedorCorreoPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WSProveedorCorreoPort".equals(portName)) {
            setWSProveedorCorreoPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
