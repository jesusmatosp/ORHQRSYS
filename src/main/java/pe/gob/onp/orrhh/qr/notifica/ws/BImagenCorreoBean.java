/**
 * BImagenCorreoBean.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.onp.orrhh.qr.notifica.ws;

public class BImagenCorreoBean  implements java.io.Serializable {
    private byte[] archivoAdjunto;

    private java.lang.String nombreVariable;

    private java.lang.String urlImagen;

    public BImagenCorreoBean() {
    }

    public BImagenCorreoBean(
           byte[] archivoAdjunto,
           java.lang.String nombreVariable,
           java.lang.String urlImagen) {
           this.archivoAdjunto = archivoAdjunto;
           this.nombreVariable = nombreVariable;
           this.urlImagen = urlImagen;
    }


    /**
     * Gets the archivoAdjunto value for this BImagenCorreoBean.
     * 
     * @return archivoAdjunto
     */
    public byte[] getArchivoAdjunto() {
        return archivoAdjunto;
    }


    /**
     * Sets the archivoAdjunto value for this BImagenCorreoBean.
     * 
     * @param archivoAdjunto
     */
    public void setArchivoAdjunto(byte[] archivoAdjunto) {
        this.archivoAdjunto = archivoAdjunto;
    }


    /**
     * Gets the nombreVariable value for this BImagenCorreoBean.
     * 
     * @return nombreVariable
     */
    public java.lang.String getNombreVariable() {
        return nombreVariable;
    }


    /**
     * Sets the nombreVariable value for this BImagenCorreoBean.
     * 
     * @param nombreVariable
     */
    public void setNombreVariable(java.lang.String nombreVariable) {
        this.nombreVariable = nombreVariable;
    }


    /**
     * Gets the urlImagen value for this BImagenCorreoBean.
     * 
     * @return urlImagen
     */
    public java.lang.String getUrlImagen() {
        return urlImagen;
    }


    /**
     * Sets the urlImagen value for this BImagenCorreoBean.
     * 
     * @param urlImagen
     */
    public void setUrlImagen(java.lang.String urlImagen) {
        this.urlImagen = urlImagen;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BImagenCorreoBean)) return false;
        BImagenCorreoBean other = (BImagenCorreoBean) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.archivoAdjunto==null && other.getArchivoAdjunto()==null) || 
             (this.archivoAdjunto!=null &&
              java.util.Arrays.equals(this.archivoAdjunto, other.getArchivoAdjunto()))) &&
            ((this.nombreVariable==null && other.getNombreVariable()==null) || 
             (this.nombreVariable!=null &&
              this.nombreVariable.equals(other.getNombreVariable()))) &&
            ((this.urlImagen==null && other.getUrlImagen()==null) || 
             (this.urlImagen!=null &&
              this.urlImagen.equals(other.getUrlImagen())));
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
        if (getArchivoAdjunto() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArchivoAdjunto());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArchivoAdjunto(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNombreVariable() != null) {
            _hashCode += getNombreVariable().hashCode();
        }
        if (getUrlImagen() != null) {
            _hashCode += getUrlImagen().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BImagenCorreoBean.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "bImagenCorreoBean"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("archivoAdjunto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "archivoAdjunto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreVariable");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombreVariable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlImagen");
        elemField.setXmlName(new javax.xml.namespace.QName("", "urlImagen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
