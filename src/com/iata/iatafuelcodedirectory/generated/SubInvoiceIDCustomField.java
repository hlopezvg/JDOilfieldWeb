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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}SubInvoiceIDCustomFieldValue"/>
 *         &lt;element ref="{}SubInvoiceIDCustomFieldDescription" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ID" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *             &lt;minInclusive value="1"/>
 *             &lt;maxInclusive value="99"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "subInvoiceIDCustomFieldValue",
    "subInvoiceIDCustomFieldDescription"
})
@XmlRootElement(name = "SubInvoiceIDCustomField")
public class SubInvoiceIDCustomField {

    @XmlElement(name = "SubInvoiceIDCustomFieldValue", required = true)
    protected String subInvoiceIDCustomFieldValue;
    @XmlElement(name = "SubInvoiceIDCustomFieldDescription")
    protected String subInvoiceIDCustomFieldDescription;
    @XmlAttribute(name = "ID", required = true)
    protected int id;

    /**
     * Gets the value of the subInvoiceIDCustomFieldValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubInvoiceIDCustomFieldValue() {
        return subInvoiceIDCustomFieldValue;
    }

    /**
     * Sets the value of the subInvoiceIDCustomFieldValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubInvoiceIDCustomFieldValue(String value) {
        this.subInvoiceIDCustomFieldValue = value;
    }

    /**
     * Gets the value of the subInvoiceIDCustomFieldDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubInvoiceIDCustomFieldDescription() {
        return subInvoiceIDCustomFieldDescription;
    }

    /**
     * Sets the value of the subInvoiceIDCustomFieldDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubInvoiceIDCustomFieldDescription(String value) {
        this.subInvoiceIDCustomFieldDescription = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setID(int value) {
        this.id = value;
    }

}
