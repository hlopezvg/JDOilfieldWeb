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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.iata.iatafuelcodedirectory.TransportationType;


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
 *         &lt;element ref="{}ItemTransportationRouting" minOccurs="0"/>
 *         &lt;element ref="{}ItemTransportationReferenceCode" minOccurs="0"/>
 *         &lt;element ref="{}ItemTransportationReferenceValue" minOccurs="0"/>
 *         &lt;element ref="{}ItemTransportationAmount" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ItemTransportationType" type="{http://www.IATA.com/IATAFuelCodeDirectory}TransportationType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "itemTransportationRouting",
    "itemTransportationReferenceCode",
    "itemTransportationReferenceValue",
    "itemTransportationAmount"
})
@XmlRootElement(name = "ItemTransportation")
public class ItemTransportation {

    @XmlElement(name = "ItemTransportationRouting")
    protected String itemTransportationRouting;
    @XmlElement(name = "ItemTransportationReferenceCode")
    protected String itemTransportationReferenceCode;
    @XmlElement(name = "ItemTransportationReferenceValue")
    protected String itemTransportationReferenceValue;
    @XmlElement(name = "ItemTransportationAmount")
    protected BigDecimal itemTransportationAmount;
    @XmlAttribute(name = "ItemTransportationType")
    protected TransportationType itemTransportationType;

    /**
     * Gets the value of the itemTransportationRouting property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemTransportationRouting() {
        return itemTransportationRouting;
    }

    /**
     * Sets the value of the itemTransportationRouting property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemTransportationRouting(String value) {
        this.itemTransportationRouting = value;
    }

    /**
     * Gets the value of the itemTransportationReferenceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemTransportationReferenceCode() {
        return itemTransportationReferenceCode;
    }

    /**
     * Sets the value of the itemTransportationReferenceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemTransportationReferenceCode(String value) {
        this.itemTransportationReferenceCode = value;
    }

    /**
     * Gets the value of the itemTransportationReferenceValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemTransportationReferenceValue() {
        return itemTransportationReferenceValue;
    }

    /**
     * Sets the value of the itemTransportationReferenceValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemTransportationReferenceValue(String value) {
        this.itemTransportationReferenceValue = value;
    }

    /**
     * Gets the value of the itemTransportationAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getItemTransportationAmount() {
        return itemTransportationAmount;
    }

    /**
     * Sets the value of the itemTransportationAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setItemTransportationAmount(BigDecimal value) {
        this.itemTransportationAmount = value;
    }

    /**
     * Gets the value of the itemTransportationType property.
     * 
     * @return
     *     possible object is
     *     {@link TransportationType }
     *     
     */
    public TransportationType getItemTransportationType() {
        return itemTransportationType;
    }

    /**
     * Sets the value of the itemTransportationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportationType }
     *     
     */
    public void setItemTransportationType(TransportationType value) {
        this.itemTransportationType = value;
    }

}
