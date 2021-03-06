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
import com.iata.iatafuelcodedirectory.PUOMBase;
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
 *         &lt;element ref="{}ItemQuantityType"/>
 *         &lt;element ref="{}ItemQuantityFlag"/>
 *         &lt;element ref="{}ItemQuantityQty"/>
 *         &lt;element ref="{}ItemQuantityUOM"/>
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
    "itemQuantityType",
    "itemQuantityFlag",
    "itemQuantityQty",
    "itemQuantityUOM"
})
@XmlRootElement(name = "ItemQuantity")
public class ItemQuantity {

    @XmlElement(name = "ItemQuantityType", required = true)
    protected QuantityType itemQuantityType;
    @XmlElement(name = "ItemQuantityFlag", required = true)
    protected BaseBasis itemQuantityFlag;
    @XmlElement(name = "ItemQuantityQty", required = true)
    protected BigDecimal itemQuantityQty;
    @XmlElement(name = "ItemQuantityUOM", required = true)
    protected PUOMBase itemQuantityUOM;

    /**
     * Gets the value of the itemQuantityType property.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getItemQuantityType() {
        return itemQuantityType;
    }

    /**
     * Sets the value of the itemQuantityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setItemQuantityType(QuantityType value) {
        this.itemQuantityType = value;
    }

    /**
     * Gets the value of the itemQuantityFlag property.
     * 
     * @return
     *     possible object is
     *     {@link BaseBasis }
     *     
     */
    public BaseBasis getItemQuantityFlag() {
        return itemQuantityFlag;
    }

    /**
     * Sets the value of the itemQuantityFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link BaseBasis }
     *     
     */
    public void setItemQuantityFlag(BaseBasis value) {
        this.itemQuantityFlag = value;
    }

    /**
     * Gets the value of the itemQuantityQty property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getItemQuantityQty() {
        return itemQuantityQty;
    }

    /**
     * Sets the value of the itemQuantityQty property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setItemQuantityQty(BigDecimal value) {
        this.itemQuantityQty = value;
    }

    /**
     * Gets the value of the itemQuantityUOM property.
     * 
     * @return
     *     possible object is
     *     {@link PUOMBase }
     *     
     */
    public PUOMBase getItemQuantityUOM() {
        return itemQuantityUOM;
    }

    /**
     * Sets the value of the itemQuantityUOM property.
     * 
     * @param value
     *     allowed object is
     *     {@link PUOMBase }
     *     
     */
    public void setItemQuantityUOM(PUOMBase value) {
        this.itemQuantityUOM = value;
    }

}
