/**
 * BAdjuntoCorreoBean.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.onp.orrhh.qr.notifica.ws;

public class BAdjuntoCorreoBean  implements java.io.Serializable {
    private byte[] archivoAdjunto;

    private java.lang.String nombreArchivo;

    private java.lang.String pathAdjunto;

    public BAdjuntoCorreoBean() {
    }

    public BAdjuntoCorreoBean(
           byte[] archivoAdjunto,
           java.lang.String nombreArchivo,
           java.lang.String pathAdjunto) {
           this.archivoAdjunto = archivoAdjunto;
           this.nombreArchivo = nombreArchivo;
           this.pathAdjunto = pathAdjunto;
    }


    /**
     * Gets the archivoAdjunto value for this BAdjuntoCorreoBean.
     * 
     * @return archivoAdjunto
     */
    public byte[] getArchivoAdjunto() {
        return archivoAdjunto;
    }


    /**
     * Sets the archivoAdjunto value for this BAdjuntoCorreoBean.
     * 
     * @param archivoAdjunto
     */
    public void setArchivoAdjunto(byte[] archivoAdjunto) {
        this.archivoAdjunto = archivoAdjunto;
    }


    /**
     * Gets the nombreArchivo value for this BAdjuntoCorreoBean.
     * 
     * @return nombreArchivo
     */
    public java.lang.String getNombreArchivo() {
        return nombreArchivo;
    }


    /**
     * Sets the nombreArchivo value for this BAdjuntoCorreoBean.
     * 
     * @param nombreArchivo
     */
    public void setNombreArchivo(java.lang.String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }


    /**
     * Gets the pathAdjunto value for this BAdjuntoCorreoBean.
     * 
     * @return pathAdjunto
     */
    public java.lang.String getPathAdjunto() {
        return pathAdjunto;
    }


    /**
     * Sets the pathAdjunto value for this BAdjuntoCorreoBean.
     * 
     * @param pathAdjunto
     */
    public void setPathAdjunto(java.lang.String pathAdjunto) {
        this.pathAdjunto = pathAdjunto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BAdjuntoCorreoBean)) return false;
        BAdjuntoCorreoBean other = (BAdjuntoCorreoBean) obj;
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
            ((this.nombreArchivo==null && other.getNombreArchivo()==null) || 
             (this.nombreArchivo!=null &&
              this.nombreArchivo.equals(other.getNombreArchivo()))) &&
            ((this.pathAdjunto==null && other.getPathAdjunto()==null) || 
             (this.pathAdjunto!=null &&
              this.pathAdjunto.equals(other.getPathAdjunto())));
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
        if (getNombreArchivo() != null) {
            _hashCode += getNombreArchivo().hashCode();
        }
        if (getPathAdjunto() != null) {
            _hashCode += getPathAdjunto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BAdjuntoCorreoBean.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "bAdjuntoCorreoBean"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("archivoAdjunto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "archivoAdjunto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreArchivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombreArchivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pathAdjunto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pathAdjunto"));
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
