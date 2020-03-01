/**
 * BCabeceraCorreoBean.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.onp.orrhh.qr.notifica.ws;

public class BCabeceraCorreoBean  implements java.io.Serializable {
    private java.lang.String claveRemitente;

    private java.lang.String[] correoCopia;

    private java.lang.String[] correoCopiaOculta;

    private java.lang.String[] correoDestino;

    private java.lang.String correoRemitente;

    private java.lang.String nombreRemiente;

    public BCabeceraCorreoBean() {
    }

    public BCabeceraCorreoBean(
           java.lang.String claveRemitente,
           java.lang.String[] correoCopia,
           java.lang.String[] correoCopiaOculta,
           java.lang.String[] correoDestino,
           java.lang.String correoRemitente,
           java.lang.String nombreRemiente) {
           this.claveRemitente = claveRemitente;
           this.correoCopia = correoCopia;
           this.correoCopiaOculta = correoCopiaOculta;
           this.correoDestino = correoDestino;
           this.correoRemitente = correoRemitente;
           this.nombreRemiente = nombreRemiente;
    }


    /**
     * Gets the claveRemitente value for this BCabeceraCorreoBean.
     * 
     * @return claveRemitente
     */
    public java.lang.String getClaveRemitente() {
        return claveRemitente;
    }


    /**
     * Sets the claveRemitente value for this BCabeceraCorreoBean.
     * 
     * @param claveRemitente
     */
    public void setClaveRemitente(java.lang.String claveRemitente) {
        this.claveRemitente = claveRemitente;
    }


    /**
     * Gets the correoCopia value for this BCabeceraCorreoBean.
     * 
     * @return correoCopia
     */
    public java.lang.String[] getCorreoCopia() {
        return correoCopia;
    }


    /**
     * Sets the correoCopia value for this BCabeceraCorreoBean.
     * 
     * @param correoCopia
     */
    public void setCorreoCopia(java.lang.String[] correoCopia) {
        this.correoCopia = correoCopia;
    }

    public java.lang.String getCorreoCopia(int i) {
        return this.correoCopia[i];
    }

    public void setCorreoCopia(int i, java.lang.String _value) {
        this.correoCopia[i] = _value;
    }


    /**
     * Gets the correoCopiaOculta value for this BCabeceraCorreoBean.
     * 
     * @return correoCopiaOculta
     */
    public java.lang.String[] getCorreoCopiaOculta() {
        return correoCopiaOculta;
    }


    /**
     * Sets the correoCopiaOculta value for this BCabeceraCorreoBean.
     * 
     * @param correoCopiaOculta
     */
    public void setCorreoCopiaOculta(java.lang.String[] correoCopiaOculta) {
        this.correoCopiaOculta = correoCopiaOculta;
    }

    public java.lang.String getCorreoCopiaOculta(int i) {
        return this.correoCopiaOculta[i];
    }

    public void setCorreoCopiaOculta(int i, java.lang.String _value) {
        this.correoCopiaOculta[i] = _value;
    }


    /**
     * Gets the correoDestino value for this BCabeceraCorreoBean.
     * 
     * @return correoDestino
     */
    public java.lang.String[] getCorreoDestino() {
        return correoDestino;
    }


    /**
     * Sets the correoDestino value for this BCabeceraCorreoBean.
     * 
     * @param correoDestino
     */
    public void setCorreoDestino(java.lang.String[] correoDestino) {
        this.correoDestino = correoDestino;
    }

    public java.lang.String getCorreoDestino(int i) {
        return this.correoDestino[i];
    }

    public void setCorreoDestino(int i, java.lang.String _value) {
        this.correoDestino[i] = _value;
    }


    /**
     * Gets the correoRemitente value for this BCabeceraCorreoBean.
     * 
     * @return correoRemitente
     */
    public java.lang.String getCorreoRemitente() {
        return correoRemitente;
    }


    /**
     * Sets the correoRemitente value for this BCabeceraCorreoBean.
     * 
     * @param correoRemitente
     */
    public void setCorreoRemitente(java.lang.String correoRemitente) {
        this.correoRemitente = correoRemitente;
    }


    /**
     * Gets the nombreRemiente value for this BCabeceraCorreoBean.
     * 
     * @return nombreRemiente
     */
    public java.lang.String getNombreRemiente() {
        return nombreRemiente;
    }


    /**
     * Sets the nombreRemiente value for this BCabeceraCorreoBean.
     * 
     * @param nombreRemiente
     */
    public void setNombreRemiente(java.lang.String nombreRemiente) {
        this.nombreRemiente = nombreRemiente;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BCabeceraCorreoBean)) return false;
        BCabeceraCorreoBean other = (BCabeceraCorreoBean) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.claveRemitente==null && other.getClaveRemitente()==null) || 
             (this.claveRemitente!=null &&
              this.claveRemitente.equals(other.getClaveRemitente()))) &&
            ((this.correoCopia==null && other.getCorreoCopia()==null) || 
             (this.correoCopia!=null &&
              java.util.Arrays.equals(this.correoCopia, other.getCorreoCopia()))) &&
            ((this.correoCopiaOculta==null && other.getCorreoCopiaOculta()==null) || 
             (this.correoCopiaOculta!=null &&
              java.util.Arrays.equals(this.correoCopiaOculta, other.getCorreoCopiaOculta()))) &&
            ((this.correoDestino==null && other.getCorreoDestino()==null) || 
             (this.correoDestino!=null &&
              java.util.Arrays.equals(this.correoDestino, other.getCorreoDestino()))) &&
            ((this.correoRemitente==null && other.getCorreoRemitente()==null) || 
             (this.correoRemitente!=null &&
              this.correoRemitente.equals(other.getCorreoRemitente()))) &&
            ((this.nombreRemiente==null && other.getNombreRemiente()==null) || 
             (this.nombreRemiente!=null &&
              this.nombreRemiente.equals(other.getNombreRemiente())));
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
        if (getClaveRemitente() != null) {
            _hashCode += getClaveRemitente().hashCode();
        }
        if (getCorreoCopia() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCorreoCopia());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCorreoCopia(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCorreoCopiaOculta() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCorreoCopiaOculta());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCorreoCopiaOculta(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCorreoDestino() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCorreoDestino());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCorreoDestino(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCorreoRemitente() != null) {
            _hashCode += getCorreoRemitente().hashCode();
        }
        if (getNombreRemiente() != null) {
            _hashCode += getNombreRemiente().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BCabeceraCorreoBean.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.notifica.onp.gob.pe/", "bCabeceraCorreoBean"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claveRemitente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claveRemitente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("correoCopia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "correoCopia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("correoCopiaOculta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "correoCopiaOculta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("correoDestino");
        elemField.setXmlName(new javax.xml.namespace.QName("", "correoDestino"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("correoRemitente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "correoRemitente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreRemiente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombreRemiente"));
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
