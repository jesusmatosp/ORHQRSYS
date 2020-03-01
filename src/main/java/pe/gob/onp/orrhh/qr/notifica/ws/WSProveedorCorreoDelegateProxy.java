package pe.gob.onp.orrhh.qr.notifica.ws;

public class WSProveedorCorreoDelegateProxy implements pe.gob.onp.orrhh.qr.notifica.ws.WSProveedorCorreoDelegate {
  private String _endpoint = null;
  private pe.gob.onp.orrhh.qr.notifica.ws.WSProveedorCorreoDelegate wSProveedorCorreoDelegate = null;
  
  public WSProveedorCorreoDelegateProxy() {
    _initWSProveedorCorreoDelegateProxy();
  }
  
  public WSProveedorCorreoDelegateProxy(String endpoint) {
    _endpoint = endpoint;
    _initWSProveedorCorreoDelegateProxy();
  }
  
  private void _initWSProveedorCorreoDelegateProxy() {
    try {
      wSProveedorCorreoDelegate = (new pe.gob.onp.orrhh.qr.notifica.ws.WSProveedorCorreoServiceLocator()).getWSProveedorCorreoPort();
      if (wSProveedorCorreoDelegate != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wSProveedorCorreoDelegate)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wSProveedorCorreoDelegate)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wSProveedorCorreoDelegate != null)
      ((javax.xml.rpc.Stub)wSProveedorCorreoDelegate)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public pe.gob.onp.orrhh.qr.notifica.ws.WSProveedorCorreoDelegate getWSProveedorCorreoDelegate() {
    if (wSProveedorCorreoDelegate == null)
      _initWSProveedorCorreoDelegateProxy();
    return wSProveedorCorreoDelegate;
  }
  
  public pe.gob.onp.orrhh.qr.notifica.ws.BCorreoResponse enviarCorreoFormatoHTML(pe.gob.onp.orrhh.qr.notifica.ws.BCorreoServidor bCorreoServidor, pe.gob.onp.orrhh.qr.notifica.ws.BCorreoBean paramCorreoBean) throws java.rmi.RemoteException, pe.gob.onp.orrhh.qr.notifica.ws.Exception{
    if (wSProveedorCorreoDelegate == null)
      _initWSProveedorCorreoDelegateProxy();
    return wSProveedorCorreoDelegate.enviarCorreoFormatoHTML(bCorreoServidor, paramCorreoBean);
  }
  
  public pe.gob.onp.orrhh.qr.notifica.ws.BCorreoResponse enviarCorreoFormatoTexto(pe.gob.onp.orrhh.qr.notifica.ws.BCorreoServidor bCorreoServidor, pe.gob.onp.orrhh.qr.notifica.ws.BCorreoBean paramCorreoBean) throws java.rmi.RemoteException, pe.gob.onp.orrhh.qr.notifica.ws.Exception{
    if (wSProveedorCorreoDelegate == null)
      _initWSProveedorCorreoDelegateProxy();
    return wSProveedorCorreoDelegate.enviarCorreoFormatoTexto(bCorreoServidor, paramCorreoBean);
  }
  
  
}