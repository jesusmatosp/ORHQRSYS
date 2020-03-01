/**
 * WSProveedorCorreoDelegate.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.onp.orrhh.qr.notifica.ws;

public interface WSProveedorCorreoDelegate extends java.rmi.Remote {
    public BCorreoResponse enviarCorreoFormatoHTML(BCorreoServidor bCorreoServidor, BCorreoBean paramCorreoBean) throws java.rmi.RemoteException, pe.gob.onp.orrhh.qr.notifica.ws.Exception;
    public BCorreoResponse enviarCorreoFormatoTexto(BCorreoServidor bCorreoServidor, BCorreoBean paramCorreoBean) throws java.rmi.RemoteException, pe.gob.onp.orrhh.qr.notifica.ws.Exception;
}
