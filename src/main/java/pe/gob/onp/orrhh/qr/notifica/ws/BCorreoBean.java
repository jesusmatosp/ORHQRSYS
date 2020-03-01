/**
 * BCorreoBean.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.onp.orrhh.qr.notifica.ws;

public class BCorreoBean  implements java.io.Serializable {
    private pe.gob.onp.orrhh.qr.notifica.ws.BAdjuntoCorreoBean[] archivosAdjuntos;

    private java.lang.String asunto;

    private pe.gob.onp.orrhh.qr.notifica.ws.BCabeceraCorreoBean cabeceraCorreoBean;

    private pe.gob.onp.orrhh.qr.notifica.ws.BImagenCorreoBean[] imagenesAdjuntas;

    private java.lang.String mensaje;

    public BCorreoBean() {
    }

    public BCorreoBean(
           pe.gob.onp.orrhh.qr.notifica.ws.BAdjuntoCorreoBean[] archivosAdjuntos,
           java.lang.String asunto,
           pe.gob.onp.orrhh.qr.notifica.ws.BCabeceraCorreoBean cabeceraCorreoBean,
           pe.gob.onp.orrhh.qr.notifica.ws.BImagenCorreoBean[] imagenesAdjuntas,
           java.lang.String mensaje) {
           this.archivosAdjuntos = archivosAdjuntos;
           this.asunto = asunto;
           this.cabeceraCorreoBean = cabeceraCorreoBean;
           this.imagenesAdjuntas = imagenesAdjuntas;
           this.mensaje = mensaje;
    }


    /**
     * Gets the archivosAdjuntos value for this BCorreoBean.
     * 
     * @return archivosAdjuntos
     */
    public pe.gob.onp.orrhh.qr.notifica.ws.BAdjuntoCorreoBean[] getArchivosAdjuntos() {
        return archivosAdjuntos;
    }


    /**
     * Sets the archivosAdjuntos value for this BCorreoBean.
     * 
     * @param archivosAdjuntos
     */
    public void setArchivosAdjuntos(pe.gob.onp.orrhh.qr.notifica.ws.BAdjuntoCorreoBean[] archivosAdjuntos) {
        this.archivosAdjuntos = archivosAdjuntos;
    }

    public pe.gob.onp.orrhh.qr.notifica.ws.BAdjuntoCorreoBean getArchivosAdjuntos(int i) {
        return this.archivosAdjuntos[i];
    }

    public void setArchivosAdjuntos(int i, pe.gob.onp.orrhh.qr.notifica.ws.BAdjuntoCorreoBean _value) {
        this.archivosAdjuntos[i] = _value;
    }


    /**
     * Gets the asunto value for this BCorreoBean.
     * 
     * @return asunto
     */
    public java.lang.String getAsunto() {
        return asunto;
    }


    /**
     * Sets the asunto value for this BCorreoBean.
     * 
     * @param asunto
     */
    public void setAsunto(java.lang.String asunto) {
        this.asunto = asunto;
    }


    /**
     * Gets the cabeceraCorreoBean value for this BCorreoBean.
     * 
     * @return cabeceraCorreoBean
     */
    public pe.gob.onp.orrhh.qr.notifica.ws.BCabeceraCorreoBean getCabeceraCorreoBean() {
        return cabeceraCorreoBean;
    }


    /**
     * Sets the cabeceraCorreoBean value for this BCorreoBean.
     * 
     * @param cabeceraCorreoBean
     */
    public void setCabeceraCorreoBean(pe.gob.onp.orrhh.qr.notifica.ws.BCabeceraCorreoBean cabeceraCorreoBean) {
        this.cabeceraCorreoBean = cabeceraCorreoBean;
    }


    /**
     * Gets the imagenesAdjuntas value for this BCorreoBean.
     * 
     * @return imagenesAdjuntas
     */
    public pe.gob.onp.orrhh.qr.notifica.ws.BImagenCorreoBean[] getImagenesAdjuntas() {
        return imagenesAdjuntas;
    }


    /**
     * Sets the imagenesAdjuntas value for this BCorreoBean.
     * 
     * @param imagenesAdjuntas
     */
    public void setImagenesAdjuntas(pe.gob.onp.orrhh.qr.notifica.ws.BImagenCorreoBean[] imagenesAdjuntas) {
        this.imagenesAdjuntas = imagenesAdjuntas;
    }

    public pe.gob.onp.orrhh.qr.notifica.ws.BImagenCorreoBean getImagenesAdjuntas(int i) {
        return this.imagenesAdjuntas[i];
    }

    public void setImagenesAdjuntas(int i, pe.gob.onp.orrhh.qr.notifica.ws.BImagenCorreoBean _value) {
        this.imagenesAdjuntas[i] = _value;
    }


    /**
     * Gets the mensaje value for this BCorreoBean.
     * 
     * @return mensaje
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }


    /**
     * Sets the mensaje value for this BCorreoBean.
     * 
     * @param mensaje
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BCorreoBean)) return false;
        BCorreoBean other = (BCorreoBean) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.archivosAdjuntos==null && other.getArchivosAdjuntos()==null) || 
             (this.archivosAdjuntos!=null &&
              java.util.Arrays.equals(this.archivosAdjuntos, other.getArchivosAdjuntos()))) &&
            ((this.asunto==null && other.getAsunto()==null) || 
             (this.asunto!=null &&
              this.asunto.equals(other.getAsunto()))) &&
            ((this.cabeceraCorreoBean==null && other.getCabeceraCorreoBean()==null) || 
             (this.cabeceraCorreoBean!=null &&
              this.cabeceraCorreoBean.equals(other.getCabeceraCorreoBean()))) &&
            ((this.imagenesAdjuntas==null && other.getImagenesAdjuntas()==null) || 
             (this.imagenesAdjuntas!=null &&
              java.util.Arrays.equals(this.imagenesAdjuntas, other.getImagenesAdjuntas()))) &&
            ((this.mensaje==null && other.getMensaje()==null) || 
             (this.mensaje!=null &&
              this.mensaje.equals(other.getMensaje())));
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
        if (getArchivosAdjuntos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArchivosAdjuntos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArchivosAdjuntos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAsunto() != null) {
            _hashCode += getAsunto().hashCode();
        }
        if (getCabeceraCorreoBean() != null) {
            _hashCode += getCabeceraCorreoBean().hashCode();
        }
        if (getImagenesAdjuntas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getImagenesAdjuntas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getImagenesAdjuntas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMensaje() != null) {
            _hashCode += getMensaje().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BCorreoBean.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "bCorreoBean"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("archivosAdjuntos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "archivosAdjuntos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "bAdjuntoCorreoBean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("asunto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "asunto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cabeceraCorreoBean");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cabeceraCorreoBean"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "bCabeceraCorreoBean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("imagenesAdjuntas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "imagenesAdjuntas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "bImagenCorreoBean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensaje");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mensaje"));
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
