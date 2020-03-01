/**
 * BCorreoServidor.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.onp.orrhh.qr.notifica.ws;

public class BCorreoServidor  implements java.io.Serializable {
    private java.lang.String puertoServidor;

    private java.lang.String servidorCorreo;

    private boolean smtpAuth;

    public BCorreoServidor() {
    }

    public BCorreoServidor(
           java.lang.String puertoServidor,
           java.lang.String servidorCorreo,
           boolean smtpAuth) {
           this.puertoServidor = puertoServidor;
           this.servidorCorreo = servidorCorreo;
           this.smtpAuth = smtpAuth;
    }


    /**
     * Gets the puertoServidor value for this BCorreoServidor.
     * 
     * @return puertoServidor
     */
    public java.lang.String getPuertoServidor() {
        return puertoServidor;
    }


    /**
     * Sets the puertoServidor value for this BCorreoServidor.
     * 
     * @param puertoServidor
     */
    public void setPuertoServidor(java.lang.String puertoServidor) {
        this.puertoServidor = puertoServidor;
    }


    /**
     * Gets the servidorCorreo value for this BCorreoServidor.
     * 
     * @return servidorCorreo
     */
    public java.lang.String getServidorCorreo() {
        return servidorCorreo;
    }


    /**
     * Sets the servidorCorreo value for this BCorreoServidor.
     * 
     * @param servidorCorreo
     */
    public void setServidorCorreo(java.lang.String servidorCorreo) {
        this.servidorCorreo = servidorCorreo;
    }


    /**
     * Gets the smtpAuth value for this BCorreoServidor.
     * 
     * @return smtpAuth
     */
    public boolean isSmtpAuth() {
        return smtpAuth;
    }


    /**
     * Sets the smtpAuth value for this BCorreoServidor.
     * 
     * @param smtpAuth
     */
    public void setSmtpAuth(boolean smtpAuth) {
        this.smtpAuth = smtpAuth;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BCorreoServidor)) return false;
        BCorreoServidor other = (BCorreoServidor) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.puertoServidor==null && other.getPuertoServidor()==null) || 
             (this.puertoServidor!=null &&
              this.puertoServidor.equals(other.getPuertoServidor()))) &&
            ((this.servidorCorreo==null && other.getServidorCorreo()==null) || 
             (this.servidorCorreo!=null &&
              this.servidorCorreo.equals(other.getServidorCorreo()))) &&
            this.smtpAuth == other.isSmtpAuth();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getPuertoServidor() != null) {
            _hashCode += getPuertoServidor().hashCode();
        }
        if (getServidorCorreo() != null) {
            _hashCode += getServidorCorreo().hashCode();
        }
        _hashCode += (isSmtpAuth() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BCorreoServidor.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "bCorreoServidor"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("puertoServidor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "puertoServidor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("servidorCorreo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "servidorCorreo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smtpAuth");
        elemField.setXmlName(new javax.xml.namespace.QName("", "smtpAuth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
