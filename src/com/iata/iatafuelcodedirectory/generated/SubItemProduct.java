//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.11.24 at 02:38:17 PM VET 
//


package com.iata.iatafuelcodedirectory.generated;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.iata.iatafuelcodedirectory.CurrencyCodeBase;
import com.iata.iatafuelcodedirectory.PUOMBase;
import com.iata.iatafuelcodedirectory.RateTypeBase;


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
 *         &lt;element ref="{}SubItemProductID"/>
 *         &lt;element ref="{}SubItemDescription" minOccurs="0"/>
 *         &lt;element ref="{}SubItemPricingUnitRateType"/>
 *         &lt;element ref="{}SubItemPricingUnitRate"/>
 *         &lt;element ref="{}SubItemPricingUOM"/>
 *         &lt;element ref="{}SubItemPricingUOMFactor"/>
 *         &lt;element ref="{}SubItemPricingCurrencyCode"/>
 *         &lt;element ref="{}SubItemPricingAmount"/>
 *         &lt;element ref="{}SubItemExchangeRate" minOccurs="0"/>
 *         &lt;element ref="{}SubItemInvoiceUOM"/>
 *         &lt;element ref="{}SubItemQuantity"/>
 *         &lt;element ref="{}SubItemInvoiceUnitRate"/>
 *         &lt;element ref="{}SubItemInvoiceCurrency" minOccurs="0"/>
 *         &lt;element ref="{}SubItemInvoiceAmount"/>
 *         &lt;element ref="{}SubItemTax" maxOccurs="unbounded" minOccurs="0"/>
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
    "subItemProductID",
    "subItemDescription",
    "subItemPricingUnitRateType",
    "subItemPricingUnitRate",
    "subItemPricingUOM",
    "subItemPricingUOMFactor",
    "subItemPricingCurrencyCode",
    "subItemPricingAmount",
    "subItemExchangeRate",
    "subItemInvoiceUOM",
    "subItemQuantity",
    "subItemInvoiceUnitRate",
    "subItemInvoiceCurrency",
    "subItemInvoiceAmount",
    "subItemTax"
})
@XmlRootElement(name = "SubItemProduct")
public class SubItemProduct {

    @XmlElement(name = "SubItemProductID", required = true)
    protected SubItemProductID subItemProductID;
    @XmlElement(name = "SubItemDescription")
    protected String subItemDescription;
    @XmlElement(name = "SubItemPricingUnitRateType", required = true)
    protected RateTypeBase subItemPricingUnitRateType;
    @XmlElement(name = "SubItemPricingUnitRate", required = true)
    protected BigDecimal subItemPricingUnitRate;
    @XmlElement(name = "SubItemPricingUOM", required = true)
    protected PUOMBase subItemPricingUOM;
    @XmlElement(name = "SubItemPricingUOMFactor", required = true)
    protected BigDecimal subItemPricingUOMFactor;
    @XmlElement(name = "SubItemPricingCurrencyCode", required = true)
    protected CurrencyCodeBase subItemPricingCurrencyCode;
    @XmlElement(name = "SubItemPricingAmount", required = true)
    protected BigDecimal subItemPricingAmount;
    @XmlElement(name = "SubItemExchangeRate")
    protected SubItemExchangeRate subItemExchangeRate;
    @XmlElement(name = "SubItemInvoiceUOM", required = true)
    protected PUOMBase subItemInvoiceUOM;
    @XmlElement(name = "SubItemQuantity", required = true)
    protected SubItemQuantity subItemQuantity;
    @XmlElement(name = "SubItemInvoiceUnitRate", required = true)
    protected BigDecimal subItemInvoiceUnitRate;
    @XmlElement(name = "SubItemInvoiceCurrency")
    protected CurrencyCodeBase subItemInvoiceCurrency;
    @XmlElement(name = "SubItemInvoiceAmount", required = true)
    protected BigDecimal subItemInvoiceAmount;
    @XmlElement(name = "SubItemTax")
    protected List<SubItemTax> subItemTax;

    /**
     * Gets the value of the subItemProductID property.
     * 
     * @return
     *     possible object is
     *     {@link SubItemProductID }
     *     
     */
    public SubItemProductID getSubItemProductID() {
        return subItemProductID;
    }

    /**
     * Sets the value of the subItemProductID property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubItemProductID }
     *     
     */
    public void setSubItemProductID(SubItemProductID value) {
        this.subItemProductID = value;
    }

    /**
     * Gets the value of the subItemDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubItemDescription() {
        return subItemDescription;
    }

    /**
     * Sets the value of the subItemDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubItemDescription(String value) {
        this.subItemDescription = value;
    }

    /**
     * Gets the value of the subItemPricingUnitRateType property.
     * 
     * @return
     *     possible object is
     *     {@link RateTypeBase }
     *     
     */
    public RateTypeBase getSubItemPricingUnitRateType() {
        return subItemPricingUnitRateType;
    }

    /**
     * Sets the value of the subItemPricingUnitRateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RateTypeBase }
     *     
     */
    public void setSubItemPricingUnitRateType(RateTypeBase value) {
        this.subItemPricingUnitRateType = value;
    }

    /**
     * Gets the value of the subItemPricingUnitRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubItemPricingUnitRate() {
        return subItemPricingUnitRate;
    }

    /**
     * Sets the value of the subItemPricingUnitRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubItemPricingUnitRate(BigDecimal value) {
        this.subItemPricingUnitRate = value;
    }

    /**
     * Gets the value of the subItemPricingUOM property.
     * 
     * @return
     *     possible object is
     *     {@link PUOMBase }
     *     
     */
    public PUOMBase getSubItemPricingUOM() {
        return subItemPricingUOM;
    }

    /**
     * Sets the value of the subItemPricingUOM property.
     * 
     * @param value
     *     allowed object is
     *     {@link PUOMBase }
     *     
     */
    public void setSubItemPricingUOM(PUOMBase value) {
        this.subItemPricingUOM = value;
    }

    /**
     * Gets the value of the subItemPricingUOMFactor property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubItemPricingUOMFactor() {
        return subItemPricingUOMFactor;
    }

    /**
     * Sets the value of the subItemPricingUOMFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubItemPricingUOMFactor(BigDecimal value) {
        this.subItemPricingUOMFactor = value;
    }

    /**
     * Gets the value of the subItemPricingCurrencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCodeBase }
     *     
     */
    public CurrencyCodeBase getSubItemPricingCurrencyCode() {
        return subItemPricingCurrencyCode;
    }

    /**
     * Sets the value of the subItemPricingCurrencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCodeBase }
     *     
     */
    public void setSubItemPricingCurrencyCode(CurrencyCodeBase value) {
        this.subItemPricingCurrencyCode = value;
    }

    /**
     * Gets the value of the subItemPricingAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubItemPricingAmount() {
        return subItemPricingAmount;
    }

    /**
     * Sets the value of the subItemPricingAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubItemPricingAmount(BigDecimal value) {
        this.subItemPricingAmount = value;
    }

    /**
     * Gets the value of the subItemExchangeRate property.
     * 
     * @return
     *     possible object is
     *     {@link SubItemExchangeRate }
     *     
     */
    public SubItemExchangeRate getSubItemExchangeRate() {
        return subItemExchangeRate;
    }

    /**
     * Sets the value of the subItemExchangeRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubItemExchangeRate }
     *     
     */
    public void setSubItemExchangeRate(SubItemExchangeRate value) {
        this.subItemExchangeRate = value;
    }

    /**
     * Gets the value of the subItemInvoiceUOM property.
     * 
     * @return
     *     possible object is
     *     {@link PUOMBase }
     *     
     */
    public PUOMBase getSubItemInvoiceUOM() {
        return subItemInvoiceUOM;
    }

    /**
     * Sets the value of the subItemInvoiceUOM property.
     * 
     * @param value
     *     allowed object is
     *     {@link PUOMBase }
     *     
     */
    public void setSubItemInvoiceUOM(PUOMBase value) {
        this.subItemInvoiceUOM = value;
    }

    /**
     * Gets the value of the subItemQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link SubItemQuantity }
     *     
     */
    public SubItemQuantity getSubItemQuantity() {
        return subItemQuantity;
    }

    /**
     * Sets the value of the subItemQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubItemQuantity }
     *     
     */
    public void setSubItemQuantity(SubItemQuantity value) {
        this.subItemQuantity = value;
    }

    /**
     * Gets the value of the subItemInvoiceUnitRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubItemInvoiceUnitRate() {
        return subItemInvoiceUnitRate;
    }

    /**
     * Sets the value of the subItemInvoiceUnitRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubItemInvoiceUnitRate(BigDecimal value) {
        this.subItemInvoiceUnitRate = value;
    }

    /**
     * Gets the value of the subItemInvoiceCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCodeBase }
     *     
     */
    public CurrencyCodeBase getSubItemInvoiceCurrency() {
        return subItemInvoiceCurrency;
    }

    /**
     * Sets the value of the subItemInvoiceCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCodeBase }
     *     
     */
    public void setSubItemInvoiceCurrency(CurrencyCodeBase value) {
        this.subItemInvoiceCurrency = value;
    }

    /**
     * Gets the value of the subItemInvoiceAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubItemInvoiceAmount() {
        return subItemInvoiceAmount;
    }

    /**
     * Sets the value of the subItemInvoiceAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubItemInvoiceAmount(BigDecimal value) {
        this.subItemInvoiceAmount = value;
    }

    /**
     * Gets the value of the subItemTax property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subItemTax property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubItemTax().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubItemTax }
     * 
     * 
     */
    public List<SubItemTax> getSubItemTax() {
        if (subItemTax == null) {
            subItemTax = new ArrayList<SubItemTax>();
        }
        return this.subItemTax;
    }

}