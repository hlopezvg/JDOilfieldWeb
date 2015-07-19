//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.11.24 at 02:38:17 PM VET 
//


package com.iata.iatafuelcodedirectory.generated;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.iata.iatafuelcodedirectory.BaseBasis;
import com.iata.iatafuelcodedirectory.QuantityType;


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
 *         &lt;element ref="{}SubItemInvoiceQuantity"/>
 *         &lt;element ref="{}SubItemQuantityType"/>
 *         &lt;element ref="{}SubItemQuantityFlag"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "subItemInvoiceQuantity",
    "subItemQuantityType",
    "subItemQuantityFlag"
})
@XmlRootElement(name = "SubItemQuantity")
public class SubItemQuantity {

    @XmlElement(name = "SubItemInvoiceQuantity", required = true)
    protected BigDecimal subItemInvoiceQuantity;
    @XmlElement(name = "SubItemQuantityType", required = true)
    protected QuantityType subItemQuantityType;
    @XmlElement(name = "SubItemQuantityFlag", required = true)
    protected BaseBasis subItemQuantityFlag;

    /**
     * Gets the value of the subItemInvoiceQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubItemInvoiceQuantity() {
        return subItemInvoiceQuantity;
    }

    /**
     * Sets the value of the subItemInvoiceQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubItemInvoiceQuantity(BigDecimal value) {
        this.subItemInvoiceQuantity = value;
    }

    /**
     * Gets the value of the subItemQuantityType property.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getSubItemQuantityType() {
        return subItemQuantityType;
    }

    /**
     * Sets the value of the subItemQuantityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setSubItemQuantityType(QuantityType value) {
        this.subItemQuantityType = value;
    }

    /**
     * Gets the value of the subItemQuantityFlag property.
     * 
     * @return
     *     possible object is
     *     {@link BaseBasis }
     *     
     */
    public BaseBasis getSubItemQuantityFlag() {
        return subItemQuantityFlag;
    }

    /**
     * Sets the value of the subItemQuantityFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link BaseBasis }
     *     
     */
    public void setSubItemQuantityFlag(BaseBasis value) {
        this.subItemQuantityFlag = value;
    }

}