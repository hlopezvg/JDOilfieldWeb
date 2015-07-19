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
import com.iata.iatafuelcodedirectory.TaxTypeBase;


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
 *         &lt;element ref="{}InvoiceTaxDetailType"/>
 *         &lt;element ref="{}InvoiceTaxDetailDescription" minOccurs="0"/>
 *         &lt;element ref="{}InvoiceTaxDetailRate"/>
 *         &lt;element ref="{}InvoiceTaxDetailAmount"/>
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
    "invoiceTaxDetailType",
    "invoiceTaxDetailDescription",
    "invoiceTaxDetailRate",
    "invoiceTaxDetailAmount"
})
@XmlRootElement(name = "InvoiceTaxDetail")
public class InvoiceTaxDetail {

    @XmlElement(name = "InvoiceTaxDetailType", required = true)
    protected TaxTypeBase invoiceTaxDetailType;
    @XmlElement(name = "InvoiceTaxDetailDescription")
    protected String invoiceTaxDetailDescription;
    @XmlElement(name = "InvoiceTaxDetailRate", required = true)
    protected BigDecimal invoiceTaxDetailRate;
    @XmlElement(name = "InvoiceTaxDetailAmount", required = true)
    protected BigDecimal invoiceTaxDetailAmount;

    /**
     * Gets the value of the invoiceTaxDetailType property.
     * 
     * @return
     *     possible object is
     *     {@link TaxTypeBase }
     *     
     */
    public TaxTypeBase getInvoiceTaxDetailType() {
        return invoiceTaxDetailType;
    }

    /**
     * Sets the value of the invoiceTaxDetailType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxTypeBase }
     *     
     */
    public void setInvoiceTaxDetailType(TaxTypeBase value) {
        this.invoiceTaxDetailType = value;
    }

    /**
     * Gets the value of the invoiceTaxDetailDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceTaxDetailDescription() {
        return invoiceTaxDetailDescription;
    }

    /**
     * Sets the value of the invoiceTaxDetailDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceTaxDetailDescription(String value) {
        this.invoiceTaxDetailDescription = value;
    }

    /**
     * Gets the value of the invoiceTaxDetailRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInvoiceTaxDetailRate() {
        return invoiceTaxDetailRate;
    }

    /**
     * Sets the value of the invoiceTaxDetailRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInvoiceTaxDetailRate(BigDecimal value) {
        this.invoiceTaxDetailRate = value;
    }

    /**
     * Gets the value of the invoiceTaxDetailAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInvoiceTaxDetailAmount() {
        return invoiceTaxDetailAmount;
    }

    /**
     * Sets the value of the invoiceTaxDetailAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInvoiceTaxDetailAmount(BigDecimal value) {
        this.invoiceTaxDetailAmount = value;
    }

}