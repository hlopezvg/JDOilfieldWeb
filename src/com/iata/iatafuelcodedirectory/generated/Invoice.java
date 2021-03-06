//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.11.24 at 02:38:17 PM VET 
//


package com.iata.iatafuelcodedirectory.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{}InvoiceHeader"/>
 *         &lt;element ref="{}SubInvoiceHeader" maxOccurs="200"/>
 *         &lt;element ref="{}InvoiceSummary"/>
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
    "invoiceHeader",
    "subInvoiceHeader",
    "invoiceSummary"
})
@XmlRootElement(name = "Invoice")
public class Invoice {

    @XmlElement(name = "InvoiceHeader", required = true)
    protected InvoiceHeader invoiceHeader;
    @XmlElement(name = "SubInvoiceHeader", required = true)
    protected List<SubInvoiceHeader> subInvoiceHeader;
    @XmlElement(name = "InvoiceSummary", required = true)
    protected InvoiceSummary invoiceSummary;

    /**
     * Gets the value of the invoiceHeader property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceHeader }
     *     
     */
    public InvoiceHeader getInvoiceHeader() {
        return invoiceHeader;
    }

    /**
     * Sets the value of the invoiceHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceHeader }
     *     
     */
    public void setInvoiceHeader(InvoiceHeader value) {
        this.invoiceHeader = value;
    }

    /**
     * Gets the value of the subInvoiceHeader property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subInvoiceHeader property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubInvoiceHeader().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubInvoiceHeader }
     * 
     * 
     */
    public List<SubInvoiceHeader> getSubInvoiceHeader() {
        if (subInvoiceHeader == null) {
            subInvoiceHeader = new ArrayList<SubInvoiceHeader>();
        }
        return this.subInvoiceHeader;
    }

    /**
     * Gets the value of the invoiceSummary property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceSummary }
     *     
     */
    public InvoiceSummary getInvoiceSummary() {
        return invoiceSummary;
    }

    /**
     * Sets the value of the invoiceSummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceSummary }
     *     
     */
    public void setInvoiceSummary(InvoiceSummary value) {
        this.invoiceSummary = value;
    }

}
