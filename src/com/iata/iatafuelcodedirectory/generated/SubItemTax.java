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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.iata.iatafuelcodedirectory.BaseBasis;
import com.iata.iatafuelcodedirectory.CurrencyCodeBase;
import com.iata.iatafuelcodedirectory.PUOMBase;
import com.iata.iatafuelcodedirectory.RateTypeBase;
import com.iata.iatafuelcodedirectory.TaxCategoryBase;
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
 *         &lt;element ref="{}SubItemTaxDescription" minOccurs="0"/>
 *         &lt;element ref="{}SubItemTaxCategoryCode" minOccurs="0"/>
 *         &lt;element ref="{}SubItemTaxLocalJurisdictionTaxBasis" minOccurs="0"/>
 *         &lt;element ref="{}SubItemTaxJurisdictionCodeQualifier" minOccurs="0"/>
 *         &lt;element ref="{}SubItemTaxJurisdictionCode" minOccurs="0"/>
 *         &lt;element ref="{}SubItemTaxRateType"/>
 *         &lt;element ref="{}SubItemTaxPricingCurrencyCode"/>
 *         &lt;element ref="{}SubItemTaxExchangeRate" minOccurs="0"/>
 *         &lt;element ref="{}SubItemTaxPricingUOM" minOccurs="0"/>
 *         &lt;element ref="{}SubItemTaxPricingUOMFactor" minOccurs="0"/>
 *         &lt;element ref="{}SubItemTaxPricingRate" minOccurs="0"/>
 *         &lt;element ref="{}SubItemTaxPricingAmount"/>
 *         &lt;element ref="{}SubItemTaxInvoiceCurrencyCode"/>
 *         &lt;element ref="{}SubItemTaxInvoiceUOM" minOccurs="0"/>
 *         &lt;element ref="{}SubItemTaxInvoiceUnitRate"/>
 *         &lt;element ref="{}SubItemTaxInvoiceAmount"/>
 *         &lt;element ref="{}SubTax" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="SubItemTaxType" use="required" type="{http://www.IATA.com/IATAFuelCodeDirectory}TaxTypeBase" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "subItemTaxDescription",
    "subItemTaxCategoryCode",
    "subItemTaxLocalJurisdictionTaxBasis",
    "subItemTaxJurisdictionCodeQualifier",
    "subItemTaxJurisdictionCode",
    "subItemTaxRateType",
    "subItemTaxPricingCurrencyCode",
    "subItemTaxExchangeRate",
    "subItemTaxPricingUOM",
    "subItemTaxPricingUOMFactor",
    "subItemTaxPricingRate",
    "subItemTaxPricingAmount",
    "subItemTaxInvoiceCurrencyCode",
    "subItemTaxInvoiceUOM",
    "subItemTaxInvoiceUnitRate",
    "subItemTaxInvoiceAmount",
    "subTax"
})
@XmlRootElement(name = "SubItemTax")
public class SubItemTax {

    @XmlElement(name = "SubItemTaxDescription")
    protected String subItemTaxDescription;
    @XmlElement(name = "SubItemTaxCategoryCode")
    protected TaxCategoryBase subItemTaxCategoryCode;
    @XmlElement(name = "SubItemTaxLocalJurisdictionTaxBasis")
    protected BaseBasis subItemTaxLocalJurisdictionTaxBasis;
    @XmlElement(name = "SubItemTaxJurisdictionCodeQualifier")
    protected String subItemTaxJurisdictionCodeQualifier;
    @XmlElement(name = "SubItemTaxJurisdictionCode")
    protected String subItemTaxJurisdictionCode;
    @XmlElement(name = "SubItemTaxRateType", required = true)
    protected RateTypeBase subItemTaxRateType;
    @XmlElement(name = "SubItemTaxPricingCurrencyCode", required = true)
    protected CurrencyCodeBase subItemTaxPricingCurrencyCode;
    @XmlElement(name = "SubItemTaxExchangeRate")
    protected SubItemTaxExchangeRate subItemTaxExchangeRate;
    @XmlElement(name = "SubItemTaxPricingUOM")
    protected PUOMBase subItemTaxPricingUOM;
    @XmlElement(name = "SubItemTaxPricingUOMFactor")
    protected BigDecimal subItemTaxPricingUOMFactor;
    @XmlElement(name = "SubItemTaxPricingRate")
    protected BigDecimal subItemTaxPricingRate;
    @XmlElement(name = "SubItemTaxPricingAmount", required = true)
    protected BigDecimal subItemTaxPricingAmount;
    @XmlElement(name = "SubItemTaxInvoiceCurrencyCode", required = true)
    protected CurrencyCodeBase subItemTaxInvoiceCurrencyCode;
    @XmlElement(name = "SubItemTaxInvoiceUOM")
    protected PUOMBase subItemTaxInvoiceUOM;
    @XmlElement(name = "SubItemTaxInvoiceUnitRate", required = true)
    protected BigDecimal subItemTaxInvoiceUnitRate;
    @XmlElement(name = "SubItemTaxInvoiceAmount", required = true)
    protected BigDecimal subItemTaxInvoiceAmount;
    @XmlElement(name = "SubTax")
    protected List<SubTax> subTax;
    @XmlAttribute(name = "SubItemTaxType", required = true)
    protected TaxTypeBase subItemTaxType;

    /**
     * Gets the value of the subItemTaxDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubItemTaxDescription() {
        return subItemTaxDescription;
    }

    /**
     * Sets the value of the subItemTaxDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubItemTaxDescription(String value) {
        this.subItemTaxDescription = value;
    }

    /**
     * Gets the value of the subItemTaxCategoryCode property.
     * 
     * @return
     *     possible object is
     *     {@link TaxCategoryBase }
     *     
     */
    public TaxCategoryBase getSubItemTaxCategoryCode() {
        return subItemTaxCategoryCode;
    }

    /**
     * Sets the value of the subItemTaxCategoryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxCategoryBase }
     *     
     */
    public void setSubItemTaxCategoryCode(TaxCategoryBase value) {
        this.subItemTaxCategoryCode = value;
    }

    /**
     * Gets the value of the subItemTaxLocalJurisdictionTaxBasis property.
     * 
     * @return
     *     possible object is
     *     {@link BaseBasis }
     *     
     */
    public BaseBasis getSubItemTaxLocalJurisdictionTaxBasis() {
        return subItemTaxLocalJurisdictionTaxBasis;
    }

    /**
     * Sets the value of the subItemTaxLocalJurisdictionTaxBasis property.
     * 
     * @param value
     *     allowed object is
     *     {@link BaseBasis }
     *     
     */
    public void setSubItemTaxLocalJurisdictionTaxBasis(BaseBasis value) {
        this.subItemTaxLocalJurisdictionTaxBasis = value;
    }

    /**
     * Gets the value of the subItemTaxJurisdictionCodeQualifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubItemTaxJurisdictionCodeQualifier() {
        return subItemTaxJurisdictionCodeQualifier;
    }

    /**
     * Sets the value of the subItemTaxJurisdictionCodeQualifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubItemTaxJurisdictionCodeQualifier(String value) {
        this.subItemTaxJurisdictionCodeQualifier = value;
    }

    /**
     * Gets the value of the subItemTaxJurisdictionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubItemTaxJurisdictionCode() {
        return subItemTaxJurisdictionCode;
    }

    /**
     * Sets the value of the subItemTaxJurisdictionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubItemTaxJurisdictionCode(String value) {
        this.subItemTaxJurisdictionCode = value;
    }

    /**
     * Gets the value of the subItemTaxRateType property.
     * 
     * @return
     *     possible object is
     *     {@link RateTypeBase }
     *     
     */
    public RateTypeBase getSubItemTaxRateType() {
        return subItemTaxRateType;
    }

    /**
     * Sets the value of the subItemTaxRateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RateTypeBase }
     *     
     */
    public void setSubItemTaxRateType(RateTypeBase value) {
        this.subItemTaxRateType = value;
    }

    /**
     * Gets the value of the subItemTaxPricingCurrencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCodeBase }
     *     
     */
    public CurrencyCodeBase getSubItemTaxPricingCurrencyCode() {
        return subItemTaxPricingCurrencyCode;
    }

    /**
     * Sets the value of the subItemTaxPricingCurrencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCodeBase }
     *     
     */
    public void setSubItemTaxPricingCurrencyCode(CurrencyCodeBase value) {
        this.subItemTaxPricingCurrencyCode = value;
    }

    /**
     * Gets the value of the subItemTaxExchangeRate property.
     * 
     * @return
     *     possible object is
     *     {@link SubItemTaxExchangeRate }
     *     
     */
    public SubItemTaxExchangeRate getSubItemTaxExchangeRate() {
        return subItemTaxExchangeRate;
    }

    /**
     * Sets the value of the subItemTaxExchangeRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubItemTaxExchangeRate }
     *     
     */
    public void setSubItemTaxExchangeRate(SubItemTaxExchangeRate value) {
        this.subItemTaxExchangeRate = value;
    }

    /**
     * Gets the value of the subItemTaxPricingUOM property.
     * 
     * @return
     *     possible object is
     *     {@link PUOMBase }
     *     
     */
    public PUOMBase getSubItemTaxPricingUOM() {
        return subItemTaxPricingUOM;
    }

    /**
     * Sets the value of the subItemTaxPricingUOM property.
     * 
     * @param value
     *     allowed object is
     *     {@link PUOMBase }
     *     
     */
    public void setSubItemTaxPricingUOM(PUOMBase value) {
        this.subItemTaxPricingUOM = value;
    }

    /**
     * Gets the value of the subItemTaxPricingUOMFactor property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubItemTaxPricingUOMFactor() {
        return subItemTaxPricingUOMFactor;
    }

    /**
     * Sets the value of the subItemTaxPricingUOMFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubItemTaxPricingUOMFactor(BigDecimal value) {
        this.subItemTaxPricingUOMFactor = value;
    }

    /**
     * Gets the value of the subItemTaxPricingRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubItemTaxPricingRate() {
        return subItemTaxPricingRate;
    }

    /**
     * Sets the value of the subItemTaxPricingRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubItemTaxPricingRate(BigDecimal value) {
        this.subItemTaxPricingRate = value;
    }

    /**
     * Gets the value of the subItemTaxPricingAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubItemTaxPricingAmount() {
        return subItemTaxPricingAmount;
    }

    /**
     * Sets the value of the subItemTaxPricingAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubItemTaxPricingAmount(BigDecimal value) {
        this.subItemTaxPricingAmount = value;
    }

    /**
     * Gets the value of the subItemTaxInvoiceCurrencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCodeBase }
     *     
     */
    public CurrencyCodeBase getSubItemTaxInvoiceCurrencyCode() {
        return subItemTaxInvoiceCurrencyCode;
    }

    /**
     * Sets the value of the subItemTaxInvoiceCurrencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCodeBase }
     *     
     */
    public void setSubItemTaxInvoiceCurrencyCode(CurrencyCodeBase value) {
        this.subItemTaxInvoiceCurrencyCode = value;
    }

    /**
     * Gets the value of the subItemTaxInvoiceUOM property.
     * 
     * @return
     *     possible object is
     *     {@link PUOMBase }
     *     
     */
    public PUOMBase getSubItemTaxInvoiceUOM() {
        return subItemTaxInvoiceUOM;
    }

    /**
     * Sets the value of the subItemTaxInvoiceUOM property.
     * 
     * @param value
     *     allowed object is
     *     {@link PUOMBase }
     *     
     */
    public void setSubItemTaxInvoiceUOM(PUOMBase value) {
        this.subItemTaxInvoiceUOM = value;
    }

    /**
     * Gets the value of the subItemTaxInvoiceUnitRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubItemTaxInvoiceUnitRate() {
        return subItemTaxInvoiceUnitRate;
    }

    /**
     * Sets the value of the subItemTaxInvoiceUnitRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubItemTaxInvoiceUnitRate(BigDecimal value) {
        this.subItemTaxInvoiceUnitRate = value;
    }

    /**
     * Gets the value of the subItemTaxInvoiceAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubItemTaxInvoiceAmount() {
        return subItemTaxInvoiceAmount;
    }

    /**
     * Sets the value of the subItemTaxInvoiceAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubItemTaxInvoiceAmount(BigDecimal value) {
        this.subItemTaxInvoiceAmount = value;
    }

    /**
     * Gets the value of the subTax property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subTax property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubTax().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubTax }
     * 
     * 
     */
    public List<SubTax> getSubTax() {
        if (subTax == null) {
            subTax = new ArrayList<SubTax>();
        }
        return this.subTax;
    }

    /**
     * Gets the value of the subItemTaxType property.
     * 
     * @return
     *     possible object is
     *     {@link TaxTypeBase }
     *     
     */
    public TaxTypeBase getSubItemTaxType() {
        return subItemTaxType;
    }

    /**
     * Sets the value of the subItemTaxType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxTypeBase }
     *     
     */
    public void setSubItemTaxType(TaxTypeBase value) {
        this.subItemTaxType = value;
    }

}