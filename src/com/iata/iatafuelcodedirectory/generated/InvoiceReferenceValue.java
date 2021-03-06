//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.11.24 at 02:38:17 PM VET 
//


package com.iata.iatafuelcodedirectory.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import com.iata.iatafuelcodedirectory.InvoiceReferenceType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.IATA.com/IATABaseDataTypeDirectory>AN35Base">
 *       &lt;attribute name="InvoiceReferenceType" use="required" type="{http://www.IATA.com/IATAFuelCodeDirectory}InvoiceReferenceType" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value"
})
@XmlRootElement(name = "InvoiceReferenceValue")
public class InvoiceReferenceValue {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "InvoiceReferenceType", required = true)
    protected InvoiceReferenceType invoiceReferenceType;

    /**
     * AlphaNumeric Base min1 max35
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the invoiceReferenceType property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceReferenceType }
     *     
     */
    public InvoiceReferenceType getInvoiceReferenceType() {
        return invoiceReferenceType;
    }

    /**
     * Sets the value of the invoiceReferenceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceReferenceType }
     *     
     */
    public void setInvoiceReferenceType(InvoiceReferenceType value) {
        this.invoiceReferenceType = value;
    }

}
